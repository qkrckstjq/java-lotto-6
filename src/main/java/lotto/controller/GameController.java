package lotto.controller;

import lotto.model.Domain.Lotto;
import lotto.model.Service.LottoService;
public class GameController {
    public void run () {
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();
        LottoService lottoService = new LottoService();

        int buyPrice = inputController.inputBuyPrice();
        Lotto[] lottos = lottoService.initLottos(buyPrice);
        outputController.printLottos(lottos);

        Lotto answer = inputController.inputAnswer();
        inputController.inputBonus(answer);

        lottoService.updateResult(lottos, answer);
        outputController.printResult(answer);
        outputController.printBenefit(lottoService.returnRate(buyPrice, answer.getResult()));
    }
}
