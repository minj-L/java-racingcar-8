package racingcar.service;

import java.util.List;
import java.util.Optional;
import racingcar.common.ConsoleMessage;
import racingcar.dto.RacingCarDTO;

public class GameResultService {
    public String finalWinner(List<String> winnerList) {
        return Optional.ofNullable(winnerList)
                .filter(list -> !list.isEmpty())
                .map(list
                        -> String.join(", ", list))
                .orElse(ConsoleMessage.NO_WINNER);
    }

    public List<String> searchWinner(List<RacingCarDTO> userList, int tryCnt) {
        return userList.stream()
                .filter(userDto
                        -> userDto.moveResult() != null
                        && userDto.moveResult().length() == tryCnt)
                .map(RacingCarDTO::carName)
                .toList();
    }
}
