package javastudy.study.ch02;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputString = inputView.input();
        NumberChecker numberChecker = new NumberChecker();

        DelimiterVerifier delimiterVerifier = new DelimiterVerifier();
        String token = delimiterVerifier.verifyToken(inputString);


    }
}
