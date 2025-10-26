package racingcar.view;

import racingcar.common.ConsoleMessage;

public class RacingCarView {
    public void carMovingResult(String car, String goResult) {
        System.out.println(car + ":" + goResult);
    }

    public void fianlWinnerResult(String winner) {
        System.out.println(ConsoleMessage.OUTPUT_FINAL_WINNER + winner);
    }
}
