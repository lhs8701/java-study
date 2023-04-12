package javastudy.study.ch02;

import java.util.List;

public class ListUtils {

    public List<Integer> convertToIntegerList(List<String> stringList) {
        return stringList.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public void validatePositive(List<Integer> integerList) {
        boolean allPositive = integerList.stream()
                .allMatch(e -> e >= 0);

        if (!allPositive) {
            throw new RuntimeException();
        }
    }
}
