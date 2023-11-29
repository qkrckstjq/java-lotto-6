package lotto.model;

public enum ConditionValues {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    MIN_PRICE(0),
    NUMBER_UNIT(1000);

    private int number;

    ConditionValues(int number) {
        this.number = number;
    }

    public int getNumber () {
        return number;
    }
}
