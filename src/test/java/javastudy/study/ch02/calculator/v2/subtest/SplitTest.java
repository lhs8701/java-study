package javastudy.study.ch02.calculator.v2.subtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {
    @Test
    @DisplayName("쉼표를 기준으로 두 수를 구분한다.")
    void test() {
        // given
        String text = "1,2";
        // when
        String[] token = text.split(",");
        // then
        assertThat(token).isNotNull();
        assertThat(token[0]).isEqualTo("1");
        assertThat(token[1]).isEqualTo("2");
    }
}
