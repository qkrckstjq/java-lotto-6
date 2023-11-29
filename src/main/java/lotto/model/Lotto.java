package lotto.model;

import lotto.view.ErrorMessage;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.stubbing.Answer;

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
    private float returnRate;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public void makeNumbers () {
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(1,45,6);
        for(int i = 0; i < temp.size(); i++) {
            numbers.set(i, temp.get(i));
        }
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
    private void setBonus (int number) {
        Validation.isDuplicate(setMap, number);
        bonus = number;
    }

    public int countEqual (List<Integer> answer, int bonus) {
        int result = 0;
        for(int number : numbers) {
            if(answer.contains(number)) {
                result++;
            }
        }
        if(result == ConditionValues.SAME_FIVE.getNumber() && bonus == this.bonus) {
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
    
}
