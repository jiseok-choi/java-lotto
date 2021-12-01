package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Ticket {

    private Numbers numbers;

    public Ticket() {
        numbers = new Numbers();
        numbers.marked();
    }

    public Ticket(List<Integer> answer) {
        numbers = new Numbers(answer);
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = this.numbers.getNumbers();
        Collections.sort(numbers);
        return numbers;
    }
}
