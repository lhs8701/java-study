package javastudy.study.ch02;

import java.util.List;

public class ListUtils {

    public List<Integer> convertToIntegerList(List<String> stringList){
        return stringList.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
