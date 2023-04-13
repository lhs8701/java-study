package javastudy.study.ch02.calculator.v2.subtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {
    @Test
    @DisplayName("쉼표를 기준으로 두 수를 구분한다.")
    void test1() {
        // given
        String text = "1,2";
        // when
        String[] token = text.split(",");
        // then
        assertThat(token).isNotNull();
        assertThat(token[0]).isEqualTo("1");
        assertThat(token[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("정규표현식을 사용해 그룹을 추출한다.")
    void test2() {
        // given
        String text = "//;\n1;2;3";
        String regex = "//(.)\n(.*)";
        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String first = "";
        String second = "";
        if (matcher.find()) {
            first = matcher.group(1);
            second = matcher.group(2);
        }
        // then
        assertThat(first).isEqualTo(";");
        assertThat(second).isEqualTo("1;2;3");
    }
}
