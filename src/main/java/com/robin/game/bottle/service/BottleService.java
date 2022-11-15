package com.robin.game.bottle.service;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.BottleEntity;

public interface BottleService {

    BottleEntity add(BottleEntity bottle);

    EntityPageResultDto<BottleEntity> findByPage(int page, int pageSize);

}
