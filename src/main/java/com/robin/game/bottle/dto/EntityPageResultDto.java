package com.robin.game.bottle.dto;

import lombok.Data;

@Data
public class EntityPageResultDto<T> {
   private   long total ;
   private  Iterable<T> entities;
}
