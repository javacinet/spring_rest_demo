package net.javaci.rest.controller;

import net.javaci.rest.model.User;
import net.javaci.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/users")
public class UserControllerV4 {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.accepted().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable String id) {
        User user = userService.getUsersById(id);
        return user != null ?
                ResponseEntity.accepted().body(user) :
                ResponseEntity.badRequest().body(null);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity
                .accepted()
                .body(userService.addUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        user = userService.updateUser(id, user);
        return user != null ?
                ResponseEntity.accepted().body(user) :
                ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id) ?
                ResponseEntity.accepted().body(true) :
                ResponseEntity.badRequest().body(false);
    }
}
