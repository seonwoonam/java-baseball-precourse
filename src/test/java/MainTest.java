import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    void 예외_테스트_길이오류(){
        List<Integer> numbers = Main.getRandomNumbers();
        assertEquals(3, numbers.size(), "생성된 숫자 배열의 길이가 3이어야 합니다.");
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 9, "숫자 범위 확인");
        }
    }
}
