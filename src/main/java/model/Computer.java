package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public Numbers generate() {
        Random random = new Random();
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new Numbers(computer);
    }
}
