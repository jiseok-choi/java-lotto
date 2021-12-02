package lotto.view;

import lotto.domain.Numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputInfo {

    public static final int TICKET_PRICE = 1000;
    private static final String ERR_MESSAGE_NUMBER_FORMAT = "숫자형식 입력값이 아닙니다.";
    private static final String ERR_MESSAGE_LOTTO_SIZE = "입력 숫자는 6개 입니다.";
    private static final String MESSAGE_TICKET_COUNT = "%d개를 구입하였습니다.";
    private static final String SPLIT_REGEX = ",";
    private static final String ANSWER_BLANK = " ";
    private static final String ANSWER_EMPTY = "";

    private final int ticketCount;

    public InputInfo(String price) {

        try {
            int ticketPrice = Integer.parseInt(price);
            this.ticketCount = ticketPrice / TICKET_PRICE;
            System.out.println(String.format(MESSAGE_TICKET_COUNT, this.ticketCount));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERR_MESSAGE_NUMBER_FORMAT);
        }
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<Integer> getAnswer(String answer) {
        List<Integer> answers;
        try {
            String answerLump = answer.replace(ANSWER_BLANK, ANSWER_EMPTY);
            String[] answerSplit = answerLump.split(SPLIT_REGEX);
            List<String> answerNumbers = Arrays.asList(answerSplit);
            answers = answerNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new NumberFormatException(ERR_MESSAGE_NUMBER_FORMAT);
        }
        valid(answers);
        return answers;
    }

    public void valid(List<Integer> answer) {
        if (answer.size() != Numbers.MARKED_RANGE) {
            throw new NumberFormatException(ERR_MESSAGE_LOTTO_SIZE);
        }
    }
}
