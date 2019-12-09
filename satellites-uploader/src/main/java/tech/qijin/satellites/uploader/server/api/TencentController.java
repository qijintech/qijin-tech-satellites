package tech.qijin.satellites.uploader.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.sdk.tencent.pojo.CredentialVo;
import tech.qijin.sdk.tencent.service.TxCosService;

/**
 * @author michealyang
 * @date 2019-12-06
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@RestController
@RequestMapping("/api/v1/base/upload/tx/")
public class TencentController {
    @Autowired
    private TxCosService txCosService;

    @GetMapping("/token")
    public CredentialVo getSts() {
        return txCosService.getCredential();
    }
}
