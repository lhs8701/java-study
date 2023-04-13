package javastudy.study.ch02.calculator.v2.subtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionalInterfaceTest {
    @Test
    @DisplayName("Function<>을 사용해 문자열을 정수로 변환한다.")
    void test1() {
        // given
        String str = "1";
        Function<String, Integer> mapToInt = Integer::parseInt;

        // when
        Integer result = mapToInt.apply(str);

        // then
        assertThat(result).isEqualTo(1);
    }
}
