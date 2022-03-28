package com.updownftw.practice.controller;

import com.updownftw.practice.model.Friend;
import com.updownftw.practice.service.FriendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/friends/{id}")
    public Friend getFriendById(@PathVariable Long id) {
        return friendService.getFriendById(id);
    }

}
