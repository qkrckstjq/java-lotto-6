package lotto.view;

import java.util.Arrays;

public class OutputView {
    public static void printBuyLotto (int number) {
        System.out.println(number+DefaultMessage.PURCHAS_NUMBER_MESSAGE.getMessage());
    }
    public static void printArrayToString (int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    public static void printResultMessage () {
        System.out.println(DefaultMessage.LOTTO_RESULT_MESSAGE.getMessage());
    }
    public static void printNewLine () {
        System.out.println(DefaultMessage.NEWLINE_MESSAGE.getMessage());
    }
    public static void printNormalResult (int winningNumber, String price, int sameResult) {
        System.out.printf("%d개 일치 (%s) - %d개",winningNumber, price, sameResult);
    }
    public static void printBonusResult (int winningNumber, String price, int sameResult) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개",winningNumber, price, sameResult);
    }
    public static void printWinningRate (float rate) {
        System.out.printf("총 수익률은 %f%%입니다.",rate);
    }
}
