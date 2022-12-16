package bridge.domain;

public enum GameStatus {
    PROGRESS(true),
    SUCCESS(false),
    FAIL(false);

    private final boolean isPlayable;

    GameStatus(boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

    public boolean isPlayable() {
        return isPlayable;
    }
}
