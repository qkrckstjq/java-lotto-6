package lotto.model;

import org.mockito.stubbing.Answer;

public enum AnswerValue {
    SAME_THREE(3, 5000),
    SAME_FOUR(4, 50000),
    SAME_FIVE(5, 1500000),
    SAME_BONUS(-1, 30000000),
    SAME_SIX(6, 2000000000);

    private int number;
    private int price;
    AnswerValue(int number,int price) {
        this.number = number;
        this.price = price;
    }
    public static int findValue(int number) {
        for(AnswerValue value : AnswerValue.values()) {
            if(value.getNumber() == number) {
                return value.getPrice();
            }
        }
        return 0;
    }
    public int getNumber () {
        return number;
    }
    public int getPrice () {
        return price;
    }
}
