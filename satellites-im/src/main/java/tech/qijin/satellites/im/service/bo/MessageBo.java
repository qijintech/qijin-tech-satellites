package tech.qijin.satellites.im.service.bo;

import lombok.Builder;
import lombok.Data;
import tech.qijin.cell.im.base.CellImMessageBo;

@Data
@Builder
public class MessageBo {
    private CellImMessageBo cellImMessageBo;
}
