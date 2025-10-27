package racingcar.service;

import static java.util.Objects.isNull;

public class GamerManageService {
    public String[] splitCars(String inputCars) {
        checkIsNull(inputCars);

        String cleanedInput = cleanInput(inputCars);

        checkDelimiter(cleanedInput);

        String[] cars = cleanedInput.split(",");
        checkCarNamesLength(cars);

        return cars;
    }

    private void checkIsNull(String inputCars) {
        if (isNull(inputCars) || inputCars.isBlank()) {
            throw new IllegalArgumentException(
                    "잘못된 입력 형식: 자동차 이름을 입력하지 않았습니다.");
        }
    }

    private void checkDelimiter(String inputCars) {
        String[] cars = inputCars.split(",");
        for (String car : cars) {
            if (!car.matches("[가-힣a-zA-Z0-9]+")) {
                throw new IllegalArgumentException(
                        "잘못된 입력 형식: 자동차 이름은 한글/영문만 가능하며 ','로 구분해야 합니다.");
            }
        }
    }

    private String cleanInput(String inputCars) {
        return inputCars.replace(" ", "");
    }

    private void checkCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(
                        "이름이 5자 초과된 차가 있어 경주를 시작 할 수 없습니다.: " + carName);
            }
        }
    }
}
