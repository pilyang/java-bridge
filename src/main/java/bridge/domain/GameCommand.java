package bridge.domain;

import java.util.Arrays;

public enum GameCommand implements InputFormat {
    RETRY("재시도", "R", true),
    QUIT("종료", "Q", false);

    private static final String COMMAND_NOT_FOUND_EXCEPTION_MESSAGE = "[ERROR] 잘못된 커맨드를 입력하였습니다.";

    private final String meaning;
    private final String command;
    private final boolean isTryAgain;

    GameCommand(String meaning, String command, boolean isTryAgain) {
        this.meaning = meaning;
        this.command = command;
        this.isTryAgain = isTryAgain;
    }

    public static GameCommand findByCommand(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COMMAND_NOT_FOUND_EXCEPTION_MESSAGE));
    }

    public boolean isTryAgain() {
        return isTryAgain;
    }

    @Override
    public String getInputGuide() {
        return meaning + ": " + command;
    }
}
