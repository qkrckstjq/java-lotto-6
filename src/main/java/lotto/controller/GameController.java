package lotto.controller;

import lotto.model.Domain.AnswerValue;
import lotto.model.Domain.ConditionValues;
import lotto.model.Domain.Lotto;
import lotto.model.Service.LottoService;
import lotto.model.Service.Utils;
import lotto.model.Service.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class GameController {
    /*private Lotto answer;
    private Lotto[] lottos;*/
    public void run () {
        InputController inputController = new InputController();
        LottoService lottoService = new LottoService();

        int buyPrice = inputController.inputBuyPrice();
        Lotto[] lottos = lottoService.initLottos(buyPrice);
        printLottos(lottos);

        Lotto answer = inputController.inputAnswer();
        inputController.inputBonus(answer);

        lottoService.updateResult(lottos, answer);
        printResult(answer);
        printBenefit(lottoService.returnRate(buyPrice, answer.getResult()));
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
    private void printLottos (Lotto[] lottos) {
        OutputView.printBuyLotto(lottos.length);
        for(Lotto lotto : lottos) {
            OutputView.printContent(Utils.listToString(lotto.getLotto()));
        }
        System.out.println();
    }
    private Lotto inputAnswer () {
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
    private void inputBonus (Lotto answer) {
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
    private void printResult (Lotto answer) {
        OutputView.printResultMessage();
        OutputView.printNewLine();
        printStepResult(answer);
    }
    private void printStepResult (Lotto answer) {
        HashMap<Integer, Integer> temp = answer.getResult();
        for(int number : temp.keySet()) {
            if(number != -1) {
                OutputView.printNormalResult(number, Utils.numberFormat(AnswerValue.findValue(number)), temp.get(number));
            } else {
                OutputView.printBonusResult(ConditionValues.SAME_FIVE.getNumber(), Utils.numberFormat(AnswerValue.findValue(number)), temp.get(number));
            }
        }
    }
    private void printBenefit (Double benefit) {
        OutputView.printWinningRate(benefit);
    }
}
