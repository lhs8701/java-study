package javastudy.study.ch02;

import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public int[] convertToIntegerList(List<String> stringList) {
        return stringList.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
