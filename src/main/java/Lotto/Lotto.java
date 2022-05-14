package Lotto;

import Lotto.enums.CompareEnum;
import Lotto.utils.StringSplitUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final ArrayList<Integer> rangeNumbers = RangeNumbers.getRangeNumbers();
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto() {
        Collections.shuffle(rangeNumbers);
        this.numbers = generate();
        Collections.sort(numbers);
    }

    public Lotto(String customNumbers) {
        List<Integer> customNumbersToInt = StringSplitUtils.basicDetermiterSplit(customNumbers);
        Collections.sort(customNumbersToInt);
        this.numbers = customNumbersToInt;
    }

    private List<Integer> generate() {
        return new ArrayList<>(rangeNumbers.subList(0, 6));
    }

    public CompareEnum compare(Lotto lotto) {
        long hitCount = lotto.getNumbers()
                        .stream()
                        .filter(num -> this.numbers.contains(num))
                        .count();

        if(hitCount == 6)
            return CompareEnum.First;

        if(hitCount == 5)
            return CompareEnum.Second;

        if(hitCount == 4)
            return CompareEnum.Third;

        if(hitCount == 3)
            return CompareEnum.Fourth;

        return CompareEnum.Fail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int number : numbers) {
            sb.append(number + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return "[" + sb + "]";
    }
}
