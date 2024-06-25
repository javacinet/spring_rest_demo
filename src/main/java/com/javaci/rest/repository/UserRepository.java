package com.javaci.rest.repository;

import com.javaci.rest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }
}
