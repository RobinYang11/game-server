package com.robin.game.bottle.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reply")
@Data
public class ReplyEntity extends BaseEntity {

    @Id
    private String id;

    private String bottleId;

    private String replyContent;

    private String authorId;

}
