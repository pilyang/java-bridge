package bridge.domain;

import java.util.Arrays;

public enum Tile implements InputFormat{
    UP("U", 1, "위"),
    DOWN("D", 0, "아래");

    private static final String CODE_EXCEPTION_MESSAGE = "[ERROR] 해당되는 코드의 다리타일 정보가 없습니다.";
    private static final String DIRECTION_EXCEPTION_MESSAGE = "[ERROR] 해당되는 방향의 다리 정보가 없습니다.";

    private final String direction;
    private final int code;
    private final String meaning;

    Tile(String direction, int code, String meaning) {
        this.direction = direction;
        this.code = code;
        this.meaning = meaning;
    }

    public static Tile findByCode(int code) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(CODE_EXCEPTION_MESSAGE));
    }

    public static Tile findByDirection(String direction) {
        return Arrays.stream(Tile.values())
                .filter(tile -> tile.direction.equals(direction))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(DIRECTION_EXCEPTION_MESSAGE));
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String getInputGuide() {
        return meaning + ": " + direction;
    }
}
