package lotto.controller;

import lotto.model.Domain.AnswerValue;
import lotto.model.Domain.ConditionValues;
import lotto.model.Domain.Lotto;
import lotto.model.Service.Utils;
import lotto.view.OutputView;

import java.util.HashMap;

public class OutputController {
    public void printLottos (Lotto[] lottos) {
        OutputView.printBuyLotto(lottos.length);
        for(Lotto lotto : lottos) {
            OutputView.printContent(Utils.listToString(lotto.getLotto()));
        }
        System.out.println();
    }
    public void printResult (Lotto answer) {
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
    public void printBenefit (Double benefit) {
        OutputView.printWinningRate(benefit);
    }
}
