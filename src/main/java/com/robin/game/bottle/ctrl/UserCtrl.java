package com.robin.game.bottle.ctrl;

import com.robin.game.bottle.dto.EntityPageResultDto;
import com.robin.game.bottle.entity.UserEntity;
import com.robin.game.bottle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCtrl {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/add")
    UserEntity addUser(@RequestBody UserEntity user) {
        this.userService.addUser(user);
        return user;
    }

    @GetMapping("/api/user/queryUserByPage")
    EntityPageResultDto<UserEntity> queryUserByPage(int page, int pageSize) {
        return this.userService.queryUserByPage(page, pageSize);
    }

}
