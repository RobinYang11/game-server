package com.robin.game.bottle.ctrl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.ReplyEntity;
import com.robin.game.bottle.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyCtrl {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/api/reply/add")
    ReplyEntity add(@RequestBody ReplyEntity reply) {
        return this.replyService.add(reply);
    }

    @GetMapping("/api/reply/queryByPage")
    EntityPageResultDto<ReplyEntity> queryByPage(int page, int pageSize) {
        return this.replyService.queryByPage(page, pageSize);
    }

    @GetMapping("/api/reply/queryByBottleId")
    ReplyEntity queryByBottleByBottleId(String bottleId) {
        return this.replyService.queryByBottleId(bottleId);
    }
}
