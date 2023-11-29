package lotto.model;

import lotto.view.DefaultMessage;
import lotto.view.ErrorMessage;

public class Validation {
    public static int isInteger (String number) throws IllegalArgumentException {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER.getMessage());
        }
    }


}
