package com.robin.game.bottle.service;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.UserEntity;

public interface UserService {
    UserEntity addUser(UserEntity user);

    EntityPageResultDto<UserEntity> queryUserByPage(int page ,int pageSize);
}
