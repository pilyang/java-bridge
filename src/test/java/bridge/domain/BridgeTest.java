package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @ParameterizedTest(name = "다리 사이즈 입력 예외 테스트 - 입력 다리 사이즈: {0}")
    @ValueSource(ints = {2, 21})
    public void bridgeSizeExceptionTest(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> directions = bridgeMaker.makeBridge(bridgeSize);

        assertThatThrownBy(() -> Bridge.from(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @DisplayName(value = "다리 방향 리스트 문자 예외 테스트")
    @Test
    public void directionListExceptionTest() {
        List<String> directions = List.of("U", "D", "D", "L");

        assertThatThrownBy(() -> Bridge.from(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

}