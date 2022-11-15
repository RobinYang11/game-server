package com.robin.game.bottle.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("bottle")
@Data
public class BottleEntity {

    @Id
    String id;

    String name;

    String creatorId;

}
