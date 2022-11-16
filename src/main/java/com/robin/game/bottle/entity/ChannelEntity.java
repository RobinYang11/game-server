package com.robin.game.bottle.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("channel")
public class ChannelEntity extends BaseEntity {

    @Id
    private String id;

    private String name;

    private String location;

    private String authorId;

    /**
     * 频道等级
     */
    private String level;

}



