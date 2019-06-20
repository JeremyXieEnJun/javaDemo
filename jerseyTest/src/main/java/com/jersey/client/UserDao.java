package com.jersey.client;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "zhangfei", "student"));
        users.add(new User(2, "zhugeliang", "teacher"));
        users.add(new User(3, "kongming", "teacher"));
        users.add(new User(4, "likui", "student"));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        if (users.isEmpty() || id <= 0) {
            return null;
        }
        return users.get(id - 1);
    }

    public void deleteUserById(int id) {
        if (users.isEmpty() || id <= 0) {
            return;
        }
        users.remove(id - 1);
    }

    public void addUser(User user) {
        if (user == null) {
            return;
        }
        users.add(user);
    }
}