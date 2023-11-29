package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;

public class InputView {
    public static String InputBuyPrice() {
        System.out.println(DefaultMessage.ASK_PRICE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String InputLottoNumbers () {
        System.out.println(DefaultMessage.ASK_LOTTO_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String InputBonusNumber () {
        System.out.println(DefaultMessage.ASK_LOTTO_BONUS.getMessage());
        return Console.readLine();
    }
}