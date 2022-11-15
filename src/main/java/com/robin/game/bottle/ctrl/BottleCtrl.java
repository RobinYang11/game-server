package com.robin.game.bottle.ctrl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.BottleEntity;
import com.robin.game.bottle.service.BottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BottleCtrl {

    @Autowired
    private BottleService bottleService;

    @PostMapping("/api/bottle/add")
    BottleEntity add(@RequestBody BottleEntity bottle) {
        return this.bottleService.add(bottle);
    }

    @GetMapping("/api/bottle/queryByPage")
    EntityPageResultDto<BottleEntity> queryBottleByPage(int page, int pageSize) {
        return this.bottleService.findByPage(page, pageSize);
    }
}
