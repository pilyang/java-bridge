package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private static final String BRIDGE_SIZE_EXCEPTION_MESSAGE_FORMAT = "[ERROR] 다리의 크기는 %d이상 %d이하 여야 합니다.";

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    private final List<Tile> tiles;

    private Bridge(List<String> bridgeDirections) {
        List<Tile> bridgeTiles = bridgeDirections.stream()
                .map(direction -> Tile.findByDirection(direction))
                .collect(Collectors.toList());
        this.tiles = List.copyOf(bridgeTiles);
    }

    public static Bridge from(List<String> bridgeDirections) {
        validateBridgeSize(bridgeDirections.size());
        return new Bridge(bridgeDirections);
    }

    private static void validateBridgeSize(int size) {
        if(size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(String
                    .format(BRIDGE_SIZE_EXCEPTION_MESSAGE_FORMAT, MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE));
        }
    }


}
