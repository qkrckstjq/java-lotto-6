package lotto.model;

import lotto.view.DefaultMessage;
import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final Set<Integer> setMap = new HashSet<>();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_LENGTH.getMessage());
        }
        validateNumbers(numbers);
    }
    private void validateNumbers (List<Integer> numbers) {
        for(int number : numbers) {
            Validation.isDuplicate(setMap, number);
            Validation.isNumberRange(number);
        }
    }

    private void validateBonus (int number) {
        Validation.isDuplicate(setMap, number);
    }
}
