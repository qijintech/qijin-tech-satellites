package tech.qijin.satellites.im.service.bo;

import lombok.Builder;
import lombok.Data;
import tech.qijin.cell.im.db.model.ImConversation;

@Data
@Builder
public class ConversationBo {
    // TODO user
    private ImConversation imConversation;
}
