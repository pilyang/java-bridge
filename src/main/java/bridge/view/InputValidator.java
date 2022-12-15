package bridge.view;

public class InputValidator {

    private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "[ERROR] 정수를 입려하여 주세요.";

    public void validateIsInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
        }
    }
}
