package javastudy.study.ch02.calculator.v2;

import java.util.Arrays;

public class StringCalculator {
    private final static String DELIMITER = ",|:";
    public int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] token = text.split(DELIMITER);
        return Arrays.stream(token)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
