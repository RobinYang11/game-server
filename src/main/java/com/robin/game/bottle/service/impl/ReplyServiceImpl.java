package com.robin.game.bottle.service.impl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.ReplyEntity;
import com.robin.game.bottle.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ReplyEntity add(ReplyEntity reply) {
        reply.setTmCreate(System.currentTimeMillis());
        reply.setTmModify(System.currentTimeMillis());
        return mongoTemplate.save(reply);
    }

    @Override
    public EntityPageResultDto<ReplyEntity> queryByPage(int page, int pageSize) {
        Query query = Query.query(new Criteria());
        long totalCount = mongoTemplate.count(query, ReplyEntity.class);
        Iterable<ReplyEntity> bottles = this.mongoTemplate.find(query.skip((page - 1) * pageSize).limit(pageSize), ReplyEntity.class, "reply");
        EntityPageResultDto<ReplyEntity> result = new EntityPageResultDto<>();
        result.setEntities(bottles);
        result.setTotal(totalCount);
        return result;
    }

    @Override
    public ReplyEntity queryByBottleId(String bottleId) {
        Query query = Query.query(Criteria.where("bottleId").is(bottleId));
        return mongoTemplate.findOne(query,ReplyEntity.class);
    }
}
