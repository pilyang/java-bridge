package bridge.view;

import bridge.domain.GameCommand;
import bridge.domain.InputFormat;
import bridge.domain.Tile;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String BRIDGE_SIZE_INPUT_INFO_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_DIRECTION_INPUT_INFO_MESSAGE_FORMAT = "이동할 칸을 선택해 주세요. %s";
    private static final String GAME_COMMAND_INPUT_INFO_MESSAGE_FORMAT = "게임을 다시 시도할지 여부를 입력해주세요. %s";
    private static final String INPUT_GUIDE_START_SIGN = "(";
    private static final String INPUT_GUIDE_END_SIGN = ")";
    private static final String INPUT_GUIDE_DIVIDE_SIGN = ", ";

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_INFO_MESSAGE);
        String sizeInput = Console.readLine();
        inputValidator.validateIsInt(sizeInput);
        return Integer.parseInt(sizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Tile readMoving() {
        String inputGuide = makeInputGuide(List.of(Tile.values()));
        System.out.println(String.format(MOVING_DIRECTION_INPUT_INFO_MESSAGE_FORMAT,inputGuide));

        String directionInput = Console.readLine();
        return Tile.findByDirection(directionInput);
    }

    private String makeInputGuide(List<InputFormat> inputDataPool) {
        StringBuilder inputGuideBuilder = new StringBuilder(INPUT_GUIDE_START_SIGN);
        for (InputFormat inputData : inputDataPool) {
            inputGuideBuilder.append(inputData.getInputGuide());
            inputGuideBuilder.append(INPUT_GUIDE_DIVIDE_SIGN);
        }
        inputGuideBuilder.replace(inputGuideBuilder.length()-INPUT_GUIDE_DIVIDE_SIGN.length(),
                inputGuideBuilder.length(), INPUT_GUIDE_END_SIGN);
        return inputGuideBuilder.toString();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        String inputGuide = makeInputGuide(List.of(GameCommand.values()));
        System.out.println(String.format(GAME_COMMAND_INPUT_INFO_MESSAGE_FORMAT, inputGuide));

        String commandInput = Console.readLine();
        return GameCommand.findByCommand(commandInput);
    }
}
