package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.domain.Tile;
import bridge.util.ValidateReader;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임의 플래이어와 맵 등록, 입력등을 관리하는 클래스
 */
public class GameController {

    public static final String GAME_RETRY_INPUT = "R";
    public static final String GAME_QUIT_INPUT = "Q";

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();

        initGame();
    }

    private void initGame() {
        outputView.printGameStartMessage();
        bridgeGame = BridgeGame.from(generateRandomBridge());
    }

    private Bridge generateRandomBridge() {
        return ValidateReader.readUntilValidate(() -> {
            int bridgeSize = inputView.readBridgeSize();
            List<String> bridgePositions = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
            return Bridge.from(bridgePositions);
        });
    }


    public void startGame() {
        Player player = new Player();

        playUntilEnd(player);
        showResult(player);
    }

    /**
     * player가 죽은 후 종료를 선택하거나, 클리어를 할 때 까지 플래이
     *
     * @param player 게임 플래이어
     */
    private void playUntilEnd(Player player) {
        do {
            playOneTurn(player);
            outputView.printMap(bridgeGame, player);
        } while (isContinueGame(player));
    }

    private void playOneTurn(Player player) {
        Tile movingTargetTile = ValidateReader.readUntilValidate(() ->
                Tile.findByPositionSign(inputView.readMoving()));

        bridgeGame.move(player, movingTargetTile);
    }

    private boolean isContinueGame(Player player) {
        if (player.isAlive()) {
            return !bridgeGame.isWin(player);
        }
        return askForTryAgain(player);
    }

    private boolean askForTryAgain(Player player) {
        String input = ValidateReader.readUntilValidate(() ->
                inputView.readGameCommand(GAME_RETRY_INPUT, GAME_QUIT_INPUT));

        if (input.equals(GAME_RETRY_INPUT)) {
            bridgeGame.retry(player);
            return true;
        }
        return false;
    }

    private void showResult(Player player) {
        outputView.printFinishGameInfoMessage();
        outputView.printMap(bridgeGame, player);
        outputView.printResult(bridgeGame.isWin(player), player.getTryCount());
    }

}
