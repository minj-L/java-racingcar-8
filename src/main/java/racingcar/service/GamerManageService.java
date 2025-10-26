package racingcar.service;

import static java.util.Objects.isNull;

public class GamerManageService {
    public String[] splitCars(String inputCars) {
        checkIsNull(inputCars);
        checkDelimiter(inputCars);

        String cleanedInput = inputCars.replace(" ", "");

        String[] cars = cleanedInput.split(",");
        checkCarNames(cars);

        return cars;
    }

    private void checkIsNull(String inputCars) {
        if (isNull(inputCars) || inputCars.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력 형식: 자동차 이름을 입력하지 않았습니다.");
        }
    }

    private void checkDelimiter(String inputCars) {
        if (!inputCars.contains(",")) {
            throw new IllegalArgumentException("잘못된 입력 형식: 자동차 이름을 ','로 구분해주세요");
        }
    }

    private void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 6) {
                throw new IllegalArgumentException(
                        "이름이 5자 초과된 차가 있어 경주를 시작 할 수 없습니다.: " + carName);
            }
        }
    }
}
