package javastudy.study.ch02.calculator;

import javastudy.study.ch02.ArrayUtils;
import javastudy.study.ch02.CustomStringTokenizer;
import javastudy.study.ch02.TokenDecider;

import java.util.List;

public class StringCalculator {
    public int add(String text){
        TokenDecider tokenDecider = new TokenDecider();
        String token = tokenDecider.produceToken(text);
        CustomStringTokenizer customStringTokenizer = new CustomStringTokenizer();
        List<String> stringNumbers = customStringTokenizer.split(text, token);
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] intArray = arrayUtils.from(stringNumbers);
        return arrayUtils.sum(intArray);
    }
}
