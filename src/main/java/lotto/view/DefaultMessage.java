package lotto.view;

public enum DefaultMessage {
    ASK_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    ASK_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_LOTTO_BONUS("보너스 번호를 입력해 주세요."),
    PURCHAS_NUMBER_MESSAGE("개를 구매했습니다."),
    NEWLINE_MESSAGE("---"),
    DEFAULT_RESULT("일치"),
    BONUS_RESULT("일치, 보너스 볼 일치"),
    NUMBER_MESSAGE("개"),
    LOTTO_RESULT_MESSAGE("당첨 통계");

    private String message;

    DefaultMessage (String message) {
        this.message = message;
    }

    public String getMessage () {
        return message;
    }

}
