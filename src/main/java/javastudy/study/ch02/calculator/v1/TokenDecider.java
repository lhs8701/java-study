package javastudy.study.ch02.calculator.v1;

public class TokenDecider {
    private final static String DEFAULT_TOKEN = ",:";

    public String produceToken(String str) {
        NumberChecker numberChecker = new NumberChecker();
        if (numberChecker.checkFirstChar(str)) {
            return DEFAULT_TOKEN;
        }
        DelimiterVerifier delimiterVerifier = new DelimiterVerifier();
        return delimiterVerifier.verifyToken(str);
    }
}
