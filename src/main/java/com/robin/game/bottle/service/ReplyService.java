package com.robin.game.bottle.service;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.ReplyEntity;

public interface ReplyService {

    ReplyEntity add(ReplyEntity reply) ;

    EntityPageResultDto<ReplyEntity> queryByPage(int page ,int pageSize);

    ReplyEntity queryByBottleId(String bottleId);
}
