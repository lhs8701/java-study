package javastudy.study.ch02.calculator.v1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class StringCalculatorTest {
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

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3.//;\\n", "//a\\n1;2;3.//a\\n"}, delimiter = '.')
    @DisplayName("//와 \n 사이의 문자를 인식한다.")
    void test3(String str, String expected) {
        // given
        DelimiterVerifier delimiterVerifier = new DelimiterVerifier();

        // when
        String result = delimiterVerifier.verifyToken(str);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("1,2:3", ",:", List.of("1", "2", "3")),
                Arguments.of("//;\\n1;2;3", "//;\\n", List.of("1", "2", "3"))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("문자열을 구분자로 분리한 서브 리스트를 반환한다. ")
    void test4(String str, String token, List<String> expected) {
        // given
        CustomStringTokenizer customStringTokenizer = new CustomStringTokenizer();

        // when
        List<String> result = customStringTokenizer.split(str, token);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 리스트 내의 원소를 숫자로 변환한다. ")
    void test5() {
        // given
        List<String> stringList = List.of("1", "2", "3");
        ArrayUtils arrayUtils = new ArrayUtils();
        // when
        int[] integerArray = arrayUtils.from(stringList);

        // then
        assertThat(integerArray).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("배열 내의 숫자가 음수이면 예외가 발생한다. ")
    void test6() {
        // given
        int[] integerArray = new int[]{1, -2, 3};
        ArrayUtils arrayUtils = new ArrayUtils();
        // when

        // then
        assertThatThrownBy(() -> {
            arrayUtils.validatePositive(integerArray);
        }).isInstanceOf(RuntimeException.class);
    }


    @Test
    @DisplayName("배열의 모든 수를 더한다.")
    void test7() {
        // given
        int[] integerArray = new int[]{1, 2, 3};
        ArrayUtils arrayUtils = new ArrayUtils();

        // when
        int result = arrayUtils.sum(integerArray);

        // then
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest()
    @CsvSource(value = {"1,2,3.,:", "//;\\n1;2;3.//;\\n"}, delimiter = '.')
    @DisplayName("첫번째 문자가 숫자면, ,;를 토큰으로 하고, 그렇지 않으면 커스텀 구분자를 토큰으로 한다.")
    void test8(String str, String expected) {
        // given
        TokenDecider tokenDecider = new TokenDecider();

        // when
        String result = tokenDecider.produceToken(str);

        // then
        assertThat(result).isEqualTo(expected);
    }
}