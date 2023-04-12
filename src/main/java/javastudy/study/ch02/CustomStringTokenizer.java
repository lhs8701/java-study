package javastudy.study.ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CustomStringTokenizer {
    public List<String> split(String str, String token) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, token);
        List<String> result = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String elem = stringTokenizer.nextToken();
            result.add(elem);
        }
        return result;
    }
}
