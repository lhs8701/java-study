package javastudy.study.ch02;

public class DelimiterVerifier {
    public String verifyToken(String str){
        int i = str.indexOf("//");
        int j = str.indexOf("\\n");
        return str.substring(i + 2, j);
    }
}
