package lotto.model;

public enum Winnings {
    SAME_THREE(5000),
    SAME_FOUR(50000),
    SAME_FIVE(1500000),
    BONUS(30000000),
    SAME_SIX(2000000000);
    private int money;
    Winnings(int money) {
        this.money = money;
    }

    public int getMoney () {
        return money;
    }

}
