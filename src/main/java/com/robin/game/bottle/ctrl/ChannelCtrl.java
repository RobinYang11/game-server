package com.robin.game.bottle.ctrl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.ChannelEntity;
import com.robin.game.bottle.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelCtrl {

    @Autowired
    private ChannelService channelService;

    @PostMapping("/api/channel/add")
    ChannelEntity add(@RequestBody ChannelEntity channel) {
        return this.channelService.addChannel(channel);
    }

    @GetMapping("/api/channel/queryByPage")
    EntityPageResultDto<ChannelEntity> queryUserByPage(int page, int pageSize) {
        return this.channelService.queryByPage(page, pageSize);
    }

}
