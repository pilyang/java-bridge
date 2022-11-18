package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    // todo: bridge를 controller가 아닌 game에서 관리할 수 있도록 refactor
    private final Bridge bridge;

    private BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public static BridgeGame from(Bridge bridge) {
        return new BridgeGame(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param player     이동할 플래이어 입력
     * @param targetTile 이동할 방향 타일 입력
     * @return 이동 결과 생존했는지 아닌지 반환 true false로 반환
     */
    public boolean move(Player player, Tile targetTile) {
        int movedPosition = player.moveForward(targetTile);
        return bridge.checkBridgeTileAt(movedPosition, targetTile);
    }

    /**
     * 게임 성공 여부 (다리를 끝까지 건넜나) 확인
     *
     * @param player 승리를 확인할 플래이어 입력
     * @return 다리 건너기 성공시 true, 실패시 false
     */
    public boolean isWin(Player player) {
        return player.isCurrentPosition(bridge.getBridgeSize());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     * @param player 게임을 재시도 할 player 입력
     */
    public void retry(Player player) {
        player.die();
    }

    /**
     * bridge의 checkBridgeTileAt 대신 호출, 해당 위치에 타일이 입력된 타일과 같은지 확인
     *
     * @param positionIndex 다리의 확인할 위치 index
     * @param tile          확인할 위치의 tile
     * @return positionIndex의 타일이 tile과 같으면 true, 아니면 false
     */
    public boolean checkBridgeTileAt(int positionIndex, Tile tile) {
        return bridge.checkBridgeTileAt(positionIndex, tile);
    }
}
