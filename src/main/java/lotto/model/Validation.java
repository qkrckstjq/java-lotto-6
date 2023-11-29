package lotto.model;

import lotto.view.DefaultMessage;
import lotto.view.ErrorMessage;

import java.util.Set;

public class Validation {
    public static int isInteger (String number) throws IllegalArgumentException {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER.getMessage());
        }
    }

    public static void isUnitNumber (int number) {
        if(number <= ConditionValues.MIN_PRICE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.MIN_MONEY.getMessage());
        }
        if(number % ConditionValues.NUMBER_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_MONEY.getMessage());
        }
    }
    public static void isDuplicate(Set<Integer> temp, int number) {
        if(!temp.add(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }
    public static void isNumberRange(int number) {
        if(number < ConditionValues.MIN_LOTTO_NUMBER.getNumber() || number > ConditionValues.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }



}
