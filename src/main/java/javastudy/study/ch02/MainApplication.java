package javastudy.study.ch02;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputString = inputView.input();
        System.out.println("inputString = " + inputString);
        TokenDecider tokenDecider = new TokenDecider();
        String token = tokenDecider.produceToken(inputString);
        System.out.println("token = " + token);
        CustomStringTokenizer customStringTokenizer = new CustomStringTokenizer();
        List<String> stringNumbers = customStringTokenizer.split(inputString, token);
        System.out.println("stringNumbers = " + stringNumbers);
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] intArray = arrayUtils.from(stringNumbers);
        OutputView outputView = new OutputView();
        outputView.output(arrayUtils.sum(intArray));
    }
}
