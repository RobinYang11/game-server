package com.robin.game.bottle.service;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.ChannelEntity;

public interface ChannelService {

    ChannelEntity addChannel(ChannelEntity channel);

    EntityPageResultDto<ChannelEntity> queryByPage(int page ,int pageSize);

    ChannelEntity queryById(String id);

}
