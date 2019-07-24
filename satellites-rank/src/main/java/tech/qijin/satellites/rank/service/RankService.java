package tech.qijin.satellites.rank.service;

import tech.qijin.satellites.rank.service.bo.RankingBo;

import java.util.List;
import java.util.Set;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface RankService {
    /**
     * 上榜操作
     *
     * <p>默认填充日榜、周榜、月榜和年榜</p>
     *
     * @param field
     * @param score
     */
    void fire(String field, Long score);

    void fire(String field, Long score, Set<Dimension> dimensions);

    /**
     * 日榜
     *
     * @return
     */
    List<RankingBo> dailyRank();

    /**
     * 周榜
     *
     * @return
     */
    List<RankingBo> weeklyRank();

    /**
     * 月榜
     *
     * @return
     */
    List<RankingBo> monthlyRank();

    /**
     * 年榜
     *
     * @return
     */
    List<RankingBo> yearlyRank();

    enum Dimension {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY;
    }
}
