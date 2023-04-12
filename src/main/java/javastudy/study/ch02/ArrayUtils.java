package javastudy.study.ch02;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

    public static int[] from(List<String> stringList) {
        return stringList.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }
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
