package lotto.model.Domain;

import lotto.model.Service.Validation;
import lotto.view.ErrorMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private int bonus;
    private final Set<Integer> setMap = new HashSet<>();
    private HashMap<Integer, Integer> result = new HashMap<>();
    private double returnRate;
    public static List<Integer> makeNumbers () {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
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
    public void setResult (HashMap<Integer, Integer> result) {
        this.result = result;
    }
    public double getReturnRate () {
        return returnRate;
    }
    public void setReturnRate (double returnRate) {
        this.returnRate = returnRate;
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
    public int getBonus () {
        return this.bonus;
    }
}
