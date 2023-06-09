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

    @Test
    @DisplayName("쉼표를 구분자로 두 피연산자가 주어진 경우 두 수의 합을 출력한다.")
    void tes3() {
        // given
        String text = "1,2";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(text);
        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자가 두 개 이상일 때, 세 수의 합을 출력한다.")
    void tes4() {
        // given
        String text = "1,2:3";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(text);
        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열 수식의 합을 구한다.")
    void tes5() {
        // given
        String text = "//;\n1;2;3";
        // when
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(text);
        // then
        assertThat(result).isEqualTo(6);
    }
}