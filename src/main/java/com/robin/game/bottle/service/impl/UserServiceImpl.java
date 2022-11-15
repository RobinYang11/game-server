package com.robin.game.bottle.service.impl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.BottleEntity;
import com.robin.game.bottle.entity.UserEntity;
import com.robin.game.bottle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserEntity addUser(UserEntity user) {
        return this.mongoTemplate.save(user);
    }

    @Override
    public EntityPageResultDto<UserEntity> queryUserByPage(int page, int pageSize) {
        Query query = Query.query(new Criteria());
        long totalCount = mongoTemplate.count(query, UserEntity.class);
        Iterable<UserEntity> users = this.mongoTemplate.find(query.skip((page - 1) * pageSize).limit(pageSize), UserEntity.class, "user");
        EntityPageResultDto<UserEntity> result = new EntityPageResultDto<>();
        result.setEntities(users);
        result.setTotal(totalCount);
        return result;
    }
}
