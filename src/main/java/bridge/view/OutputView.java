package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.domain.Tile;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String FINISH_GAME_INFO_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_NOT_MESSAGE_FORMAT = "게임 성공 여부: %s";
    private static final String GAME_TRY_COUNT_MESSAGE_FORMAT = "총 시도한 횟수: %d";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";

    private static final String BRIDGE_START_SIGN = "[";
    private static final String BRIDGE_END_SIGN = "]\n";
    private static final String BRIDGE_DIVIDE_SIGN = "|";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, Player player) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Tile tile : Tile.values()) {
            stringBuilder.append(generateTileMap(player, bridge, tile));
        }

        System.out.println(stringBuilder.toString());
    }

    // todo: refactor -> bridge는 안받고 player와 승리여부로 출력하는 방법이 있을 것 같음...!!! isPassedPosition도 지울 수 있이면 지우는거로
    private String generateTileMap(Player player, Bridge bridge, Tile tile) {
        StringBuilder bridgeMapBuilder = new StringBuilder();
        bridgeMapBuilder.append(BRIDGE_START_SIGN);
        int index = 0;
        while (!player.isPassedPosition(index)) {
            bridgeMapBuilder.append(tile.toString(bridge.getTileOf(index), player.getMovingLogOf(index)));
            bridgeMapBuilder.append(BRIDGE_DIVIDE_SIGN);
            index++;
        }
        bridgeMapBuilder.replace(bridgeMapBuilder.length() - 1, bridgeMapBuilder.length(), BRIDGE_END_SIGN);
        return bridgeMapBuilder.toString();
    }


    public void printFinishGameInfoMessage() {
        System.out.println(FINISH_GAME_INFO_MESSAGE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isWin, int playerTryCount) {
        System.out.println(getSuccessOrNotMessage(isWin));
        System.out.println(String.format(GAME_TRY_COUNT_MESSAGE_FORMAT, playerTryCount));
    }

    private String getSuccessOrNotMessage(boolean isWin) {
        if (isWin) {
            return String.format(GAME_SUCCESS_OR_NOT_MESSAGE_FORMAT, SUCCESS_MESSAGE);
        }
        return String.format(GAME_SUCCESS_OR_NOT_MESSAGE_FORMAT, FAIL_MESSAGE);
    }
}
