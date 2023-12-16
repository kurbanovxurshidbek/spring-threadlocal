package com.thread.local;

import java.util.UUID;

public class UserRepository {
    public String getUserNameForUserId(Integer userId) {
        return UUID.randomUUID().toString();
    }
}
