package bridge;

import bridge.domain.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현
     */
    public List<String> makeBridge(int size) {
        List<String> tileDirections = new ArrayList<>();
        while (tileDirections.size() < size) {
            Tile tile = Tile.findByCode(bridgeNumberGenerator.generate());
            tileDirections.add(tile.getDirection());
        }
        return tileDirections;
    }
}
