package lotto.view;

public enum ErrorMessage {
    MIN_MONEY("[ERROR] 1000원 이상 금액을 입력해주세요."),
    FORMAT_MONEY("[ERROR] 1000원 단위 금액을 입력해주세요."),
    INTEGER("[ERROR] 숫자만 입력 가능합니다."),
    FORMAT_NUMBERS("[ERROR] 올바른 형태의 로또 번호를 입력해주세요"),
    NUMBERS_LENGTH("[ERROR] 로또 번호는 6개를 입력해주세요.");

    private String message;

    ErrorMessage (String message) {
        this.message = message;
    }

    public String getMessage () {
        return message;
    }
}
