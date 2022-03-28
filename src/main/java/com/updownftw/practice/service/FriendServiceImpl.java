package com.updownftw.practice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.updownftw.practice.model.Friend;

import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {

    private static List<Friend> friends = new ArrayList<>(Arrays.asList(new Friend(1L, "Sanket", "Java"),
            new Friend(2L, "Martin", "DevOps"),
            new Friend(3L, "Ashok", "Doctor")));

    @Override
    public Friend getFriendById(Long id) {
        // TODO Auto-generated method stub

        Optional<Friend> opFriend = friends.stream().filter(f -> f.getId().equals(id)).findAny();

        if (!opFriend.isPresent())
            throw new RuntimeException();
        // throw new NoSuchFriendExistsException("No friend exists with this id");

        return opFriend.get();

    }

}
