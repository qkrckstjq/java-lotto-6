package lotto.controller;

import jdk.jshell.execution.Util;
import lotto.model.*;
import lotto.view.DefaultMessage;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.mockito.stubbing.Answer;

import java.util.*;

public class GameController {
    private Lotto answer;
    private Lotto[] lottos;
    public void run () {
        int buyPrice = inputBuyPrice();
        initLottos(buyPrice);
        printLottos();
        inputAnswer();
        inputBonus();
        printResult();
        printBenefit(buyPrice);
    }

    private int inputBuyPrice () {
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
    private void initLottos (int number) {
        int ticket = number / ConditionValues.NUMBER_UNIT.getNumber();
        lottos = new Lotto[ticket];
        for(int i = 0; i < ticket; i++) {
            lottos[i] = new Lotto(Lotto.makeNumbers());
        }
    }
    private void printLottos () {
        OutputView.printBuyLotto(lottos.length);
        for(Lotto lotto : lottos) {
            OutputView.printContent(Utils.listToString(lotto.getLotto()));
        }
        System.out.println();
    }
    private void inputAnswer () {
        while(true) {
            try {
                int[] arr = translateAnswer(InputView.InputLottoNumbers());
                answer = new Lotto(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
                break;
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
    private void inputBonus () {
        while(true) {
            try {
                translateBonus(InputView.InputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private int translateBonus (String number) {
        int bonus = Validation.isInteger(number);
        Validation.isNumberRange(bonus);
        answer.setBonus(bonus);
        return bonus;
    }
    private void updateResult () {
        for(Lotto lotto : lottos) {
            int sameNumber = answer.countEqual(lotto.getLotto());
            answer.updateResult(sameNumber);
            answer.calculateRate(sameNumber);
        }
    }
    private void printResult () {
        updateResult();
        OutputView.printResultMessage();
        OutputView.printNewLine();
        printStepResult();
    }
    private void printStepResult () {
        HashMap<Integer, Integer> temp = answer.getResult();
        for(int number : temp.keySet()) {
            if(number != -1) {
                OutputView.printNormalResult(number, Utils.numberFormat(AnswerValue.findValue(number)), temp.get(number));
            } else {
                OutputView.printBonusResult(ConditionValues.SAME_FIVE.getNumber(), Utils.numberFormat(AnswerValue.findValue(number)), temp.get(number));
            }
        }
    }
    private void printBenefit (int money) {
        answer.updateBenefit(money);
        OutputView.printWinningRate(answer.getReturnRate());
    }
}
