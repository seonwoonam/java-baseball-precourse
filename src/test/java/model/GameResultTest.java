package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultTest {

    @Test
    void 결과_출력_형식_확인() {
        GameResult result = new GameResult(1, 1);
        assertEquals("1볼 1스트라이크", result.toString());

        result = new GameResult(3, 0);
        assertEquals("3스트라이크", result.toString());

        result = new GameResult(0, 3);
        assertEquals("3볼", result.toString());

        result = new GameResult(0, 0);
        assertEquals("낫싱", result.toString());
    }
}
