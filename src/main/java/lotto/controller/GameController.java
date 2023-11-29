package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Validation;
import lotto.view.InputView;

public class GameController {
    private Lotto answer;
    private Lotto[] lottos;
    public void run () {
        buyPrice();
    }

    private int buyPrice () {
        while(true) {
            return Validation.isInteger(InputView.InputBuyPrice());
        }
    }



}
