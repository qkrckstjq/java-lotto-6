package lotto.model.Domain;

public enum ConditionValues {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    MIN_PRICE(0),
    SAME_THREE(3),
    SAME_FOUR(4),
    SAME_FIVE(5),
    SAME_SIX(6),
    SAME_BONUS(-1),
    NUMBER_UNIT(1000);

    private int number;

    ConditionValues(int number) {
        this.number = number;
    }

    public int getNumber () {
        return number;
    }
}
