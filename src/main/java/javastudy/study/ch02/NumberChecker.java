package javastudy.study.ch02;

public class NumberChecker {
    public boolean checkFirstChar(String str){
        char firstChar = str.charAt(0);
        return Character.isDigit(firstChar);
    }
}
