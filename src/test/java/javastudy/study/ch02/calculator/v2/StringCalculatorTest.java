package javastudy.study.ch02.calculator.v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    @DisplayName("빈 문자열인 경우 0을 출력한다.")
    void test1() {
        // given
        String text = "";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(text);
        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("피연산자가 하나인 경우 그 피연산자를 출력한다.")
    void test2() {
        // given
        String text = "1";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(text);
        // then
        assertThat(result).isEqualTo(1);
    }
}