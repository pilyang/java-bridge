package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.domain.Tile;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_INFO_MESSAGE = "다리 건너기 게임을 시작합니다.\n";

    private static final String BRIDGE_START_SIGN = "[";
    private static final String BRIDGE_END_SIGN = "]";
    private static final String BRIDGE_DIVIDE_SIGN = "|";
    private static final String MOVE_SUCCESS_SIGN = " O ";
    private static final String MOVE_FAIL_SIGN = " X ";
    private static final String EMPTY_SIGN = "   ";

    public void printGameStartInfo() {
        System.out.println(GAME_START_INFO_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(Bridge bridge, Player player) {
        StringBuilder mapStringBuilder = new StringBuilder();
        for (Tile baseTile : Tile.values()) {
            mapStringBuilder.append(getMapOfBaseTile(baseTile, bridge, player));
        }
        System.out.println(mapStringBuilder.toString());
    }

    private String getMapOfBaseTile(Tile baseTile, Bridge bridge, Player player) {
        StringBuilder stringBuilder = new StringBuilder(BRIDGE_START_SIGN);
        for (int position = 1; position < player.getCurrentPosition(); position++) {
            Tile passedTile = player.getPassedTileAt(position);
            stringBuilder.append(getTileSign(baseTile, passedTile, bridge.isTileOn(position, passedTile)));
            stringBuilder.append(BRIDGE_DIVIDE_SIGN);
        }
        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), BRIDGE_END_SIGN);
        return stringBuilder.toString();
    }

    private String getTileSign(Tile baseTile, Tile passedTile, boolean isSuccess) {
        if (baseTile.equals(passedTile)) {
            if (isSuccess) {
                return MOVE_SUCCESS_SIGN;
            }
            return MOVE_FAIL_SIGN;
        }
        return EMPTY_SIGN;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
