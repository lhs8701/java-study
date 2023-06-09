package javastudy.study.ch02;

import javastudy.study.ch02.calculator.v1.InputView;
import javastudy.study.ch02.calculator.v1.OutputView;
import javastudy.study.ch02.calculator.v1.StringCalculator;

public class MainApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputString = inputView.input();
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(inputString);
        OutputView outputView = new OutputView();
        outputView.output(result);
    }
}
