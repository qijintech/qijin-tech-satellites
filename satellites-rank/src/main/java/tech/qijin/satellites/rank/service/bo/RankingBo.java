package tech.qijin.satellites.rank.service.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author michealyang
 * @date 2019/7/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
@NoArgsConstructor
public class RankingBo {
    private String member;
    private Long score;

    public RankingBo(String member, Long score) {
        this.member = member;
        this.score = score;
    }
}
