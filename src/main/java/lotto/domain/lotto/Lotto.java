package lotto.domain.lotto;

import lotto.domain.AutoLottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        numbers = AutoLottoNumbers.autoNumbers();
    }

    public Lotto(List<Integer> answer) {
        AutoLottoNumbers.valid(answer);
        numbers = new ArrayList<>(answer);
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }

}
