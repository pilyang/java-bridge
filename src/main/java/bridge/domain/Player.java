package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Tile> movingLog;
    private int tryCount;

    public Player() {
        movingLog = new ArrayList<>();
        tryCount = 1;
    }

    public void moveTo(Tile target) {
        movingLog.add(target);
    }
}
