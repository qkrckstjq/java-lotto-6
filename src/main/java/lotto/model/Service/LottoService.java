package lotto.model.Service;

import lotto.model.Domain.AnswerValue;
import lotto.model.Domain.ConditionValues;
import lotto.model.Domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class LottoService {
    public void initLottos (int money, Lotto[] lottos) {
        int tickets = money / ConditionValues.NUMBER_UNIT.getNumber();
        lottos = new Lotto[tickets];
        for(int i = 0; i < tickets; i++) {
            lottos[i] = new Lotto(Lotto.makeNumbers());
        }
    }
    public int countEqual (List<Integer> lotto, List<Integer> answer, int bonus) {
        int result = 0;
        for(int number : answer) {
            if(lotto.contains(number)) {
                result++;
            }
        }
        if(result == ConditionValues.SAME_FIVE.getNumber() && lotto.contains(bonus)) {
            result = -1;
        }
        return result;
    }
    public HashMap<Integer, Integer> updateResult (Lotto[] lottos, List<Integer> answer, int bonus) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for(Lotto lotto : lottos) {
            int equalNumber = countEqual(lotto.getLotto(), answer, bonus);
            if(equalNumber >= ConditionValues.SAME_THREE.getNumber() || equalNumber == ConditionValues.SAME_BONUS.getNumber()) {
                result.put(equalNumber, result.get(equalNumber) + 1);
            }
        }
        return result;
    }
    public double returnRate (int money, HashMap<Integer, Integer> result) {
        int total = 0;
        for(int same : result.keySet()) {
            total+=result.get(same)*AnswerValue.findValue(same);
        }
        return (double) total / (double) money * 100;
    }
}
