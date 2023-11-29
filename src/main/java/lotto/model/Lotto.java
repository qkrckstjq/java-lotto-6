package lotto.model;

import lotto.view.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_LENGTH.getMessage());
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < ConditionValues.MIN_LOTTO_NUMBER.getNumber() || number > ConditionValues.MAX_LOTTO_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
            }
        }
    }


}
