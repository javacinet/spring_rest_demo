package net.javaci.rest.repository;

import net.javaci.rest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User getUsersById(String id) {
        Optional<User> optional = findUserById(id);
        return optional.orElse(null);
    }

    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        users.add(user);
        return user;
    }

    public User updateUser(String id, User user) {
        Optional<User> optional = findUserById(id);
        if (optional.isEmpty()) {
            return null;
        }
        User userInDB = optional.get();
        userInDB.setName(user.getName());
        return userInDB;
    }

    public Boolean deleteUser(String id) {
        Optional<User> optional = findUserById(id);
        if (optional.isEmpty()) {
            return false;
        }
        users.remove(optional.get());
        return true;
    }

    private Optional<User> findUserById(String id) {
       return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }
}
