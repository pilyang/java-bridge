package bridge.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TileTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @ParameterizedTest(name = "코드로 타일 검색 예외 테스트 - 입력값 : {0}")
    @ValueSource(ints = {-1, 3, 2})
    public void findByCodeException(int code) {
        assertThatThrownBy(() -> Tile.findByCode(code))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

}