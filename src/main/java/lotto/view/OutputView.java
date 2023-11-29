package lotto.view;

import java.util.Arrays;

public class OutputView {
    public static void printBuyLotto (int number) {
        System.out.println(number+DefaultMessage.PURCHAS_NUMBER_MESSAGE.getMessage());
    }
    public static void printContent (String string) {
        System.out.println(string);
    }
    public static void printResultMessage () {
        System.out.println(DefaultMessage.LOTTO_RESULT_MESSAGE.getMessage());
    }
    public static void printNewLine () {
        System.out.println(DefaultMessage.NEWLINE_MESSAGE.getMessage());
    }
    public static void printNormalResult (int winningNumber, String price, int sameResult) {
        System.out.printf("%d개 일치 (%s원) - %d개\n",winningNumber, price, sameResult);
    }
    public static void printBonusResult (int winningNumber, String price, int sameResult) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",winningNumber, price, sameResult);
    }
    public static void printWinningRate (double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.",rate);
    }
}
