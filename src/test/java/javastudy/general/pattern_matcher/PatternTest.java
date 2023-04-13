package javastudy.general.pattern_matcher;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PatternTest {

    @Test
    @DisplayName("정규표현식과 일치하는지 확인한다1")
    void test1() {
        // given
        String text = "//;\n1;2;3";
        String regex = "//(.)\n(.*)";

        // when
        boolean result = Pattern.matches(regex, text);

        // then
        assertThat(result).isTrue();
    }


    @Test
    @DisplayName("정규표현식과 일치하는지 확인한다2")
    void test2() {
        // given
        String text = "//;\n1;2;3";
        String regex = "//(.)\n(.*)";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean result = matcher.matches();

        // then
        assertThat(result).isTrue();
    }


    @Test
    @DisplayName("패턴과 일치하는 부분(괄호로 묶은 부분)을 확인한다.")
    void test3() {
        // given
        String text = "//;\n1;2;3";
        String regex = "//(.)\n(.*)";

        // when
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        boolean find = matcher.find();

        // then
        assertThat(find).isTrue();
        assertThat(matcher.group(0)).isEqualTo("//;\n1;2;3");
        assertThat(matcher.group(1)).isEqualTo(";");
        assertThat(matcher.group(2)).isEqualTo("1;2;3");
    }
}
