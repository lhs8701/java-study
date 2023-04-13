package javastudy.study.ch02.calculator.v2;

import java.util.Arrays;

public class StringCalculator {
    public int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] token = text.split(",|:");
        return Arrays.stream(token)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
