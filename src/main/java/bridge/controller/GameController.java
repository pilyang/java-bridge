package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.util.RepeatValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void initBridgeGame() {
        outputView.printGameStartInfo();
    }

    private Bridge makeBridge() {
        return RepeatValidator.readUntilValidate(() -> {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> directions = bridgeMaker.makeBridge(bridgeSize);
            return Bridge.from(directions);
        });
    }
}
