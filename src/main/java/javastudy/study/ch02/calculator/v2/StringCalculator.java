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
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String subText = matcher.group(2);
            String[] tokens = subText.split(customDelimiter);
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }else {
            String[] tokens = text.split(DELIMITER);
            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
    }
}
