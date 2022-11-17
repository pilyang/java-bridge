package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NUMBER_INPUT_ERROR_MESSAGE = "[ERROR] 숫자를 입력하여야 합니다.";

    private static final String NUMBER_REGEX = "^\\d*[1-9]$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        validateIsPositiveNumber(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateIsPositiveNumber(String input){
        if(input.matches(NUMBER_REGEX)){
            return;
        }
        throw new IllegalArgumentException(NUMBER_INPUT_ERROR_MESSAGE);
    }
}
