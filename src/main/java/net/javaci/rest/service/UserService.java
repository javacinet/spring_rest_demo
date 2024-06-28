package net.javaci.rest.service;

import net.javaci.rest.model.User;
import net.javaci.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUsersById(String id) {
        return userRepository.getUsersById(id);
    }

    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    public User updateUser(String id, User user) {
        return userRepository.updateUser(id, user);
    }

    public Boolean deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

}
