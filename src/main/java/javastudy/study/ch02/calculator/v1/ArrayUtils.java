package javastudy.study.ch02.calculator.v1;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

    public int[] from(List<String> stringList) {
        int[] intArray = stringList.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        validatePositive(intArray);
        return intArray;
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
