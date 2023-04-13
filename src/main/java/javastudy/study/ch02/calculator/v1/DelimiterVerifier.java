package javastudy.study.ch02.calculator.v1;

public class DelimiterVerifier {
    public String verifyToken(String str) {
        int i = str.indexOf("//");
        int j = str.indexOf("\\n");
        return str.substring(i, j + 2);
    }
}
