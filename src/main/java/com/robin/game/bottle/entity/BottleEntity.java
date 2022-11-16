package com.robin.game.bottle.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("bottle")
@Data
public class BottleEntity extends BaseEntity {

    @Id
    String id;

    String name;

    String creatorId;

    String content;

    String channelId;

    /**
     * 是否已读  1 未读   2 已读
     */
    short read;

}
