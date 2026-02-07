package model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumbersTest {
    @Test
    void 숫자_리스트_생성_정상() {
        assertDoesNotThrow(() -> new Numbers(Arrays.asList(1, 2, 3)));
    }

    @Test
    void 예외_테스트_숫자_길이오류() {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(Arrays.asList(1, 2)));
        assertThrows(IllegalArgumentException.class, () -> new Numbers(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    void 예외_테스트_숫자_범위오류() {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(Arrays.asList(1, 0, 3)));
    }

    @Test
    void 예외_테스트_숫자_중복오류() {
        assertThrows(IllegalArgumentException.class, () -> new Numbers(Arrays.asList(1, 2, 1)));
    }

    @Test
    void 스트라이크_계산_3스트라이크() {
        Numbers computer = new Numbers(Arrays.asList(1, 2, 3));
        Numbers user = new Numbers(Arrays.asList(1, 2, 3));
        assertEquals(3, computer.countStrikes(user));
        assertEquals(0, computer.countBalls(user));
    }

    @Test
    void 볼_계산_3볼() {
        Numbers computer = new Numbers(Arrays.asList(1, 2, 3));
        Numbers user = new Numbers(Arrays.asList(2, 3, 1));
        assertEquals(0, computer.countStrikes(user));
        assertEquals(3, computer.countBalls(user));
    }

    @Test
    void 낫싱_계산() {
        Numbers computer = new Numbers(Arrays.asList(1, 2, 3));
        Numbers user = new Numbers(Arrays.asList(4, 5, 6));
        assertEquals(0, computer.countStrikes(user));
        assertEquals(0, computer.countBalls(user));
    }

    @Test
    void 스트라이크_1_볼_1_계산() {
        Numbers computer = new Numbers(Arrays.asList(1, 2, 3));
        Numbers user = new Numbers(Arrays.asList(1, 3, 4));
        assertEquals(1, computer.countStrikes(user));
        assertEquals(1, computer.countBalls(user));
    }
}
