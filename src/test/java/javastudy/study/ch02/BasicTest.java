package javastudy.study.ch02;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BasicTest {
    @Test
    @DisplayName("첫 문자가 숫자이면 True를 리턴한다.")
    void test1() {
        // given
        NumberChecker numberChecker = new NumberChecker();
        String str = "1,2,3";

        // when
        boolean result = numberChecker.checkFirstChar(str);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("첫 문자가 숫자가 아니면 False를 리턴한다.")
    void test2() {
        // given
        NumberChecker numberChecker = new NumberChecker();
        String str = "//;\n1;2;3";

        // when
        boolean result = numberChecker.checkFirstChar(str);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("//와 \n 사이의 문자를 인식한다.")
    void test3() {
        // given
        String str = "//;\n1;2;3";
        DelimiterVerifier delimiterVerifier = new DelimiterVerifier();

        // when
        String result = delimiterVerifier.verifyToken(str);

        // then
        assertThat(result).isEqualTo(";");
    }
}