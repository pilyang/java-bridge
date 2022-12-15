package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Tile> movingLog;
    private int tryCount;
    private boolean isAlive;

    public Player() {
        movingLog = new ArrayList<>();
        tryCount = 1;
        isAlive = true;
    }

    public void moveTo(Tile target) {
        movingLog.add(target);
    }

    public Tile getCurrentTile() {
        return movingLog.get(getCurrentPosition() - 1);
    }

    public int getCurrentPosition() {
        return movingLog.size();
    }

    public void die() {
        isAlive = false;
    }
}
