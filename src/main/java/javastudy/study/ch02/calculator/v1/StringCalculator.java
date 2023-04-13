package javastudy.study.ch02.calculator.v1;

import java.util.List;

public class StringCalculator {
    public int add(String text){
        if (text == null || text.isEmpty()){
            return 0;
        }
        TokenDecider tokenDecider = new TokenDecider();
        String token = tokenDecider.produceToken(text);
        CustomStringTokenizer customStringTokenizer = new CustomStringTokenizer();
        List<String> stringNumbers = customStringTokenizer.split(text, token);
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] intArray = arrayUtils.from(stringNumbers);
        return arrayUtils.sum(intArray);
    }
}
