package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {


    MovableStrategy movableStrategy = new RandomNumMovableStrategy();

    @Test
    @DisplayName("4이상의 숫자가 전달되면 한번 전진한다.")
    void 움직임_테스트() {
        Car car = new Car(movableStrategy);

        assertThat(car.move(5)).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하 숫자가 전달되면 움직이지 않는다.")
    void 멈춤_테스트() {
        Car car = new Car(movableStrategy);

        assertThat(car.move(0)).isEqualTo(0);

        assertThat(car.move(3)).isEqualTo(0);
    }

    @Test
    @DisplayName("0~9 사이의 숫자가 아니라면 예외발생")
    void 움직임_숫자범위예외발생_테스트() {
        Car car = new Car(movableStrategy);
        assertThatThrownBy(() -> {
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

