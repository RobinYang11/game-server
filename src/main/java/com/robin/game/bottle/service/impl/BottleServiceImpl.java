package com.robin.game.bottle.service.impl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.BottleEntity;
import com.robin.game.bottle.service.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class BottleServiceImpl implements BottleService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public BottleEntity add(BottleEntity bottle) {
        bottle.setTmCreate(System.currentTimeMillis());
        return this.mongoTemplate.save(bottle);
    }

    @Override
    public EntityPageResultDto<BottleEntity> findByPage(int page, int pageSize) {
        Query query = Query.query(new Criteria());
        long totalCount = mongoTemplate.count(query, BottleEntity.class);
        Iterable<BottleEntity> bottles = this.mongoTemplate.find(query.skip((page - 1) * pageSize).limit(pageSize), BottleEntity.class, "bottle");
        EntityPageResultDto<BottleEntity> result = new EntityPageResultDto<>();
        result.setEntities(bottles);
        result.setTotal(totalCount);
        return result;
    }
}
