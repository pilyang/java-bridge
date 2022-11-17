package bridge.domain;

public class Player {

    private int tryCount;
    private int positionIndex;

    public Player() {
        this.tryCount = 0;
        initPosition();
    }

    public void moveForward() {
        positionIndex++;
    }

    public void die() {
        initPosition();
        tryCount++;
    }

    private void initPosition() {
        this.positionIndex = 0;
    }
}
