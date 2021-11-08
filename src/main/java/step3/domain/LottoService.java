package step3.domain;

import step3.domain.strategy.numbers.NumbersStrategy;
import step3.dto.LottoBonusNumberRequestDto;
import step3.dto.LottoBuyRequestDto;
import step3.dto.LottoBuyResponseDto;
import step3.dto.LottoStatisticsResponseDto;
import step3.dto.LottoWinNumbersRequestDto;

public interface LottoService {
    LottoBuyResponseDto buyLotto(LottoBuyRequestDto lottoBuyRequestDto, NumbersStrategy numbersStrategy);

    LottoStatisticsResponseDto getResultStatistics(LottoWinNumbersRequestDto lottoWinNumbersRequestDto,
        LottoBonusNumberRequestDto lottoBonusNumberRequestDto);
}