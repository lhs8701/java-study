package javastudy.study.ch02;

import java.util.Arrays;

public class ArrayUtils {
    public void validatePositive(int[] integerList) {
        boolean allPositive = Arrays.stream(integerList)
                .allMatch(e -> e >= 0);

        if (!allPositive) {
            throw new RuntimeException();
        }
    }

    public int sum(int[] integerArray){
        return Arrays.stream(integerArray)
                .sum();
    }
}
