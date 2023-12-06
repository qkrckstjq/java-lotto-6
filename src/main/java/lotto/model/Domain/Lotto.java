package lotto.model.Domain;

import lotto.model.Service.Validation;
import lotto.view.ErrorMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int bonus;
    private final Set<Integer> setMap = new HashSet<>();
    private HashMap<Integer, Integer> result = new HashMap<>();
    private int totalRate = 0;
    private double returnRate;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        initResult();
        this.numbers = numbers;
    }
    private void initResult () {
        for(AnswerValue value : AnswerValue.values()) {
            result.put(value.getNumber(), 0);
        }
    }
    public List<Integer> getLotto () {
        return numbers;
    }
    public HashMap<Integer, Integer> getResult () {
        return result;
    }
    public double getReturnRate () {
        return returnRate;
    }
    public static List<Integer> makeNumbers () {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
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
    public void setBonus (int number) {
        Validation.isDuplicate(setMap, number);
        bonus = number;
    }

    public int countEqual (List<Integer> answer) {
        int result = 0;
        for(int number : numbers) {
            if(answer.contains(number)) {
                result++;
            }
        }
        if(result == ConditionValues.SAME_FIVE.getNumber() && answer.contains(bonus)) {
            result = ConditionValues.SAME_BONUS.getNumber();
        }
        return result;
    }
    public void updateResult (int number) {
        boolean min = number >= ConditionValues.SAME_THREE.getNumber();
        boolean isBonus = number == ConditionValues.SAME_BONUS.getNumber();
        if(min || isBonus) {
            result.put(number, result.get(number)+1);
        }
    }
    public void calculateRate (int number) {
        totalRate+=AnswerValue.findValue(number);
    }
    public void updateBenefit (int money) {
        double temp = (double) totalRate / (double) money;
        returnRate = temp*100;
    }

    
}
