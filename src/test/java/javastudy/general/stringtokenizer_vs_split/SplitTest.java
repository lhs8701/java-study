package javastudy.general.stringtokenizer_vs_split;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SplitTest {

    @Test
    @DisplayName("default 구분자가 없고, 정규표현식으로 구분자를 설정한다.")
    void test1() {
        // given
        String str = "a b";

        // when
        String[] result = str.split(" ");

        // then
        assertThat(result).containsExactly("a", "b");
    }

    @Test
    @DisplayName("default 구분자가 없고, 정규표현식으로 구분자를 설정한다2.")
    void test2() {
        //given
        String str = "a,b";

        // when
        String[] result = str.split(",");

        // then
        assertThat(result).containsExactly("a", "b");
    }

    @Test
    @DisplayName("구분자가 여러 개일 수 있다.")
    void test3() {
        //given
        String str = "a,b:c/d e";

        // when
        String[] result = str.split(",|:|/| ");

        // then
        assertThat(result).containsExactly("a", "b", "c", "d", "e");
    }

    @Test
    @DisplayName("구분자 사이에 데이터가 없으면 인식하지 못한다. ")
    void test4() {
        //given
        String str = "a,:b/c";

        // when
        String[] result = str.split(",:|/");

        // then
        assertThat(result).containsExactly("a", "b", "c");
    }

    @Test
    @DisplayName("정규 표현식으로 작동할 수 있다. ")
    void test5() {
        //given
        String str = "a,:b/c";

        // when
        String[] result = str.split(",:|/");

        // then
        assertThat(result).containsExactly("a", "b", "c");
    }

}
