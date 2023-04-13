package javastudy.study.ch02.calculator.v2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final static String DELIMITER = ",|:";
    private final static String REGEX = "//(.)\n(.*)";

    public int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] tokens = split(text);
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String[] split(String text) {
        Matcher matcher = Pattern.compile(REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String subText = matcher.group(2);
            return subText.split(customDelimiter);
        }
        return text.split(DELIMITER);
    }
}
