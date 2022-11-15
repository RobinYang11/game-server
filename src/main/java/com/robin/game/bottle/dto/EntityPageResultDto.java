package com.robin.game.bottle.dto;

import com.robin.game.bottle.entity.BottleEntity;
import lombok.Data;

@Data
public class EntityPageResultDto<T> {
   private   long total ;
   private  Iterable<T> entities;
}
