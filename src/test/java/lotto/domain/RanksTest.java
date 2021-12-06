package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {


    private static final List<Lotto> lottoList = Arrays.asList(
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 20, 6))),
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10))),
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 12, 13, 14))));
    private static final List<Integer> winningList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void setWinningStatsMapTest() {

        Lottos lottos = new Lottos(lottoList);

        Ranks ranks = new Ranks();
        List<Rank> rankList = ranks.getRankList(lottos, new WinningLotto(winningList, 20));
        RankCount rankCount = new RankCount(rankList);

        assertThat(rankCount.getRankCountMap().get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCount.getRankCountMap().get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCount.getRankCountMap().get(Rank.THIRD)).isEqualTo(1);

    }

    @Test
    void profitPercentTest() {

        Lottos lottos = new Lottos(lottoList);
        Ranks ranks = new Ranks();
        List<Rank> rankList = ranks.getRankList(lottos, new WinningLotto(winningList, 20));
        RankCount rankCount = new RankCount(rankList);

        assertThat(rankCount.getProfitPercent(4000)).isEqualTo("507875.00");

    }
}
