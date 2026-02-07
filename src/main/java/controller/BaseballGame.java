package controller;

import model.Computer;
import model.GameResult;
import model.Numbers;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public BaseballGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.computer = new Computer();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            playRound();
            isRunning = checkRestart();
        }
    }

    private void playRound() {
        Numbers target = computer.generate();
        boolean isCorrect = false;
        while (!isCorrect) {
            isCorrect = playTurn(target);
        }
        outputView.printGameEnd();
    }

    private boolean playTurn(Numbers target) {
        try {
            Numbers userNumbers = getUserInput();
            GameResult result = calculateResult(target, userNumbers);
            outputView.printResult(result);
            return result.isThreeStrike();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return false;
        }
    }

    private Numbers getUserInput() {
        String input = inputView.inputNumber();
        return new Numbers(parse(input));
    }

    private List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(c - '0');
        }
        return numbers;
    }

    private GameResult calculateResult(Numbers target, Numbers user) {
        int strike = target.countStrikes(user);
        int ball = target.countBalls(user);
        return new GameResult(strike, ball);
    }

    private boolean checkRestart() {
        while (true) {
            String input = inputView.askRestart();
            if (input.equals("1")) {
                return true;
            }
            if (input.equals("2")) {
                return false;
            }
            outputView.printError("[ERROR] 1 또는 2만 입력 가능합니다.");
        }
    }
}
