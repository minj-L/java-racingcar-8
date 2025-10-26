package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import racingcar.dto.RacingCarDTO;
import racingcar.view.RacingCarView;

public class GamePerformService {
    private static final RacingCarView racingCarView = new RacingCarView();

    public List<RacingCarDTO> playersResult(String[] carsList, int tryCnt) {
        List<RacingCarDTO> users = new ArrayList<>();
        for (String name : carsList) {
            users.add(new RacingCarDTO(name, ""));
        }

        int i = 0;
        while (i < tryCnt) {
            carMoving(users);
            System.out.println();
            i++;
        }

        return users;
    }

    public void carMoving(List<RacingCarDTO> carsList) {
        ListIterator<RacingCarDTO> it = carsList.listIterator();

        while (it.hasNext()) {
            RacingCarDTO user = it.next();
            String move = checkGoStop();
            String newMoveResult = user.moveResult() + move;

            racingCarView.carMovingResult(user.carName(), newMoveResult);

            it.set(new RacingCarDTO(user.carName(), newMoveResult));
        }
    }

    public String checkGoStop() {
        int randomNum = createRandomNum();

        if (randomNum < 4) {
            return "";
        } else {
            return "-";
        }
    }

    public int createRandomNum() {
        return pickNumberInRange(0, 9);
    }

    public int convertTryCnt(String tryCnt) {
        try {
            return Integer.parseInt(tryCnt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 값입니다.");
        }
    }
}
