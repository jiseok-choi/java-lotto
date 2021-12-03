package lotto.domain;

import lotto.exception.LottoNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private static final String ERR_MESSAGE_RANGE = "로또 숫자 범위를 확인해주세요 (입력범위 1 ~ 45)";
    private static final int END_NUMBER = 45;
    private static final int START_NUMBER = 1;
    public static final int MARKED_RANGE = 6;

    private static final List<Integer> numbers;

    static {
        numbers = new ArrayList<>();
        IntStream.range(START_NUMBER, END_NUMBER).forEach(numbers::add);
    }

    public static List<Integer> getAutoNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(MARKED_RANGE)
                .collect(Collectors.toList());
    }

    public static void valid(List<Integer> defaultNumbers) {
        defaultNumbers.forEach(num -> {
            if (num < START_NUMBER || num > END_NUMBER) {
                throw new LottoNumberException(ERR_MESSAGE_RANGE);
            }
        });
    }

}
