package lotto.service;

import lotto.utils.LottoNumberRange;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreateShuffledLottoNumbers {
    private static final int LOTTO_NUMBER_MAX_COUNT = 6;

    public static List<String> createLottoNumbers() {
        List<Integer> lottoNumberRange = LottoNumberRange.getLottoNumberRange();
        Collections.shuffle(lottoNumberRange);
        return lottoNumberRange
                .stream()
                .limit(LOTTO_NUMBER_MAX_COUNT)
                .sorted()
                .map(l -> Integer.toString(l))
                .collect(Collectors.toList());
    }
}