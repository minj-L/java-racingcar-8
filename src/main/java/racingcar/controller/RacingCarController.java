package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.common.ConsoleMessage;
import racingcar.dto.RacingCarDTO;
import racingcar.service.GamePerformService;
import racingcar.service.GameResultService;
import racingcar.service.GamerManageService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final static GamerManageService gamerManageService = new GamerManageService();
    private final static RacingCarView racingCarView = new RacingCarView();
    private final static GamePerformService gamePerformService = new GamePerformService();
    private final static GameResultService gameResultService = new GameResultService();

    public void run() {
        System.out.println(ConsoleMessage.INPUT_CARS);
        String inputCars = readLine();
        String[] cars = gamerManageService.splitCars(inputCars);

        System.out.println(ConsoleMessage.INPUT_TRY_CNT);
        String tryCnt = readLine();
        int tryCntToInt = gamePerformService.convertTryCnt(tryCnt);

        System.out.println(ConsoleMessage.OUTPUT_EXECUTE_RESULT);
        List<RacingCarDTO> playGame = gamePerformService.playersResult(cars, tryCntToInt);

        List<String> winnerList = gameResultService.searchWinner(playGame, 3);
        String fianlWinner = gameResultService.finalWinner(winnerList);
        racingCarView.fianlWinnerResult(fianlWinner);
    }
}
