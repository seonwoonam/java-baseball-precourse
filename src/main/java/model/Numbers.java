package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 3자리의 숫자를 입력해야 합니다.");
        }
        for (int number : numbers) {
            validateRange(number);
        }
        validateUnique(numbers);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("[ERROR] 1~9 사이의 숫자만 입력 가능합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public int countStrikes(Numbers other) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(other.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countBalls(Numbers other) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (!numbers.get(i).equals(other.get(i)) && numbers.contains(other.get(i))) {
                count++;
            }
        }
        return count;
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
