package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamerManageServiceTest {
    private GamerManageService service;

    @BeforeEach
    void setUp() {
        service = new GamerManageService();
    }

    @Test
    void splitCars_for_delimiter() {
        String input = "minjj,huu,moon,teami";
        String[] result = service.splitCars(input);

        assertThat(result).containsExactly("minjj", "huu", "moon", "teami");
    }

    @Test
    void nullInput_expTest() {
        assertThatThrownBy(() -> service.splitCars(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력하지 않았습니다.");
    }

    @Test
    void blankInput_expTest() {
        assertThatThrownBy(() -> service.splitCars(" ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름을 입력하지 않았습니다.");
    }

    @Test
    void noComma_expTest() {
        assertThatThrownBy(() -> service.splitCars("minjj.huuuii,moon,teami")).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("','로 구분");
    }

    @Test
    void longName_expTest() {
        assertThatThrownBy(() -> service.splitCars("minjjjjjj,huu,moon,teami")).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("5자 초과");
    }

    @Test
    void makeInputClean() {
        String input = "minjj, hui , teami,mooon";
        String[] result = service.splitCars(input);

        assertThat(result).containsExactly("minjj", "hui", "teami", "mooon");
    }
}
