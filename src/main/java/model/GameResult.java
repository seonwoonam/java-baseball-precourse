package model;

public class GameResult {
    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        String result = "";
        if (ball > 0) {
            result += ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }
        return result.trim();
    }
}
