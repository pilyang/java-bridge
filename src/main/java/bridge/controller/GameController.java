package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.domain.Tile;
import bridge.util.RepeatValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void playBridgeGame() {
        initBridgeGame();
        Player player = new Player();
        playOneTurn(player);
    }

    private void initBridgeGame() {
        outputView.printGameStartInfo();
        bridgeGame = makeBridgeGame();
    }

    private BridgeGame makeBridgeGame() {
        return RepeatValidator.readUntilValidate(() -> {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> directions = bridgeMaker.makeBridge(bridgeSize);
            return BridgeGame.from(directions);
        });
    }

    private void playOneTurn(Player player){
        Tile moveTarget = readMovingTargetTile();
        bridgeGame.move(player, moveTarget);
        outputView.printMap(bridgeGame.getGameMap(), player);
    }

    private Tile readMovingTargetTile() {
        return RepeatValidator.readUntilValidate(() -> {
            return inputView.readMoving();
        });
    }
}
