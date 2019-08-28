package tech.qijin.satellites.item.server.vo;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class ItemVo {

    private String title;

    private String introduction;

    private BigDecimal originalPrice;

    private BigDecimal memberPrice;

    private BigDecimal discountPrice;

}
