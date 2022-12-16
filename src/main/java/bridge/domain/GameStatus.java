package bridge.domain;

public enum GameStatus {
    PROGRESS(true, "진행중"),
    SUCCESS(false, "성공"),
    FAIL(false, "실패");

    private final boolean isPlayable;
    private final String status;

    GameStatus(boolean isPlayable, String status) {
        this.isPlayable = isPlayable;
        this.status = status;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    @Override
    public String toString() {
        return status;
    }
}
