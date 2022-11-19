package bridge.util;

public class ValidateReader {

    /**
     * 사용자 입력을 받는 expression 실행 중 예외 발생시 예외가 발생하지 않을때까지 expression을 반복하여 다시 실행
     *
     * @param expression Input을 받는 함수 작성
     * @return expression의 반환 데이터 그대로 return
     */
    public static <T> T readUntilValidate(InputFunction<T> expression) {
        T input = null;
        do {
            try {
                input = expression.read();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while (input == null);

        return input;
    }
}
