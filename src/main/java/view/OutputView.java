package view;

import model.GameResult;

public class OutputView {
    public void printResult(GameResult result) {
        System.out.println(result.toString());
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
