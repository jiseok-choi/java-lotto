package lotto.domain.factory;

import lotto.domain.LottoCount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoAnswer;
import lotto.domain.lotto.LottoAuto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static LottoAuto newInstance() {
        return new LottoAuto();
    }

    public static LottoAnswer newInstance(String numbers) {
        return new LottoAnswer(numbers);
    }

    public static List<Lotto> autoLottos(LottoCount autoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < autoCount.getCount(); i++) {
            lottos.add(newInstance());
        }
        return lottos;
    }

    public static List<Lotto> manualLottos(List<String> inputManualLottos) {
        return inputManualLottos.stream()
                .map(LottoFactory::newInstance)
                .collect(Collectors.toList());
    }

}
