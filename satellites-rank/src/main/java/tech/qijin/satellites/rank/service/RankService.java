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
     * @param member
     * @param score
     */
    void fire(String member, Long score);

    void fire(String member, Long score, Set<Dimension> dimensions);

    /**
     * 排行榜信息
     *
     * @param start
     * @param offset
     * @param dimension 选择排行榜的维度，即日榜、周榜、月榜
     * @return
     */
    List<RankingBo> pageRank(Integer start, Integer offset, Dimension dimension);


    enum Dimension {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY;
    }
}
