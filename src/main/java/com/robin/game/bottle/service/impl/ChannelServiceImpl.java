package com.robin.game.bottle.service.impl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.BottleEntity;
import com.robin.game.bottle.entity.ChannelEntity;
import com.robin.game.bottle.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ChannelEntity addChannel(ChannelEntity channel) {
        channel.setTmCreate(System.currentTimeMillis());
        return mongoTemplate.save(channel);
    }

    @Override
    public EntityPageResultDto<ChannelEntity> queryByPage(int page, int pageSize) {
        Query query = Query.query(new Criteria());
        long totalCount = mongoTemplate.count(query, BottleEntity.class);
        Iterable<ChannelEntity> bottles = this.mongoTemplate.find(query.skip((page - 1) * pageSize).limit(pageSize), ChannelEntity.class, "bottle");
        EntityPageResultDto<ChannelEntity> result = new EntityPageResultDto<>();
        result.setEntities(bottles);
        result.setTotal(totalCount);
        return result;
    }

    @Override
    public ChannelEntity queryById(String id) {
        return this.mongoTemplate.findById(id,ChannelEntity.class);
    }
}
