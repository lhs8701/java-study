package javastudy.general.stringtokenizer_vs_split;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StringTokenizerTest {

    @Test
    @DisplayName("default 구분자는 공백이다.")
    void test1() {
        // given
        String str = "a b";
        List<String> result = new ArrayList<>();

        // when
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }

        // then
        assertThat(result).containsExactly("a", "b");
    }

    @Test
    @DisplayName("공백 이외의 구분자를 설정할 수 있다.")
    void test2() {
        //given
        String str = "a,b";
        List<String> result = new ArrayList<>();

        // when
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }

        // then
        assertThat(result).containsExactly("a", "b");
    }

    @Test
    @DisplayName("구분자가 여러 개일 수 있다.")
    void test3() {
        //given
        String str = "a,b:c/d e";
        List<String> result = new ArrayList<>();

        // when
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",:/ ");
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }

        // then
        assertThat(result).containsExactly("a", "b", "c", "d", "e");
    }

    @Test
    @DisplayName("구분자 사이에 데이터가 없더라도 정상 동작한다. ")
    void test4() {
        //given
        String str = "a,:b/c";
        List<String> result = new ArrayList<>();

        // when
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",:/ ");
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }

        // then
        assertThat(result).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("StringTokenizer.hasMoreTokens()를 활용해 토큰을 조회한다.")
    void test5() {
        //given
        String str = "a b c";
        List<String> result = new ArrayList<>();

        // when
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }

        // then
        assertThat(result).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("StringTokenizer.asIterator()를 활용해 토큰을 조회한다.")
    void test6() {
        //given
        String str = "a,b,c";
        List<String> result = new ArrayList<>();

        // when
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        stringTokenizer.asIterator()
                .forEachRemaining(token -> result.add((String) token));
        // then
        assertThat(result).containsExactly("a", "b", "c");
    }
}
