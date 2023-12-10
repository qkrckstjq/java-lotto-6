package lotto.controller;

import lotto.model.Domain.Lotto;
import lotto.model.Service.Validation;
import lotto.view.InputView;

import java.util.Arrays;

public class InputController {
    public int inputBuyPrice () {
        while(true) {
            try {
                return translatePrice(InputView.InputBuyPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int translatePrice (String input) {
        int buyPrice = Validation.isInteger(input);
        Validation.isUnitNumber(buyPrice);
        return buyPrice;
    }
    public Lotto inputAnswer () {
        while(true) {
            try {
                int[] arr = translateAnswer(InputView.InputLottoNumbers());
                return new Lotto(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int[] translateAnswer (String string) {
        String[] arr = string.split(",");
        int[] result = new int[arr.length];
        for(int i = 0; i < result.length; i++) {
            int number = Validation.isInteger(arr[i]);
            Validation.isNumberRange(number);
            result[i] = number;
        }
        return result;
    }
    public void inputBonus (Lotto answer) {
        while(true) {
            try {
                translateBonus(InputView.InputBonusNumber(), answer);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void translateBonus (String number, Lotto answer) {
        int bonus = Validation.isInteger(number);
        Validation.isNumberRange(bonus);
        answer.setBonus(bonus);
    }
}
