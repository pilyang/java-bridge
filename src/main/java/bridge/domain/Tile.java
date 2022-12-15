package bridge.domain;

import java.util.Arrays;

public enum Tile {
    UP("U", 1),
    DOWN("D", 0);

    private static final String CODE_EXCEPTION_MESSAGE = "[ERROR] 해당되는 코드의 다리타일 정보가 없습니다.";
    private static final String DIRECTION_EXCEPTION_MESSAGE = "[ERROR] 해당되는 방향의 다리 정보가 없습니다.";

    private final String direction;
    private final int code;

    Tile(String direction, int code) {
        this.direction = direction;
        this.code = code;
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
}
