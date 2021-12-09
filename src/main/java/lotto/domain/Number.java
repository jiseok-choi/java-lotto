package lotto.domain;

import lotto.exception.LottoNumberException;

import java.util.Objects;

public class Number {

    private static final String ERR_NUMBER_FORMAT = "숫자 형식 데이터가 아닙니다";

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoNumberException(ERR_NUMBER_FORMAT);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
