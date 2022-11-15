package com.robin.game.bottle.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class UserEntity {

    @Id
    String id ;

    String name ;

}
