package com.thread.local;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable {
    final static Map<Integer, User> userContextPerUserId = new ConcurrentHashMap<>();
    private final Integer userId;
    private UserRepository userRepository = new UserRepository();

    SharedMapWithUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContextPerUserId.put(userId, new User(userName));
    }
}