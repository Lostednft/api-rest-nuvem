package com.project_railway.Controller;

import com.project_railway.domain.model.User;
import com.project_railway.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable String id)
    {
        if(userService.findById(id) == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user)
    {
        userService.create(user);
        return ResponseEntity.ok("Created user successfully!");
    }

    @GetMapping
    public ResponseEntity getAllUsers()
    {
        return ResponseEntity.ok(userService.findAllUsers());
    }

}
