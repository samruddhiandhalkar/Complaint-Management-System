package com.example.ComplentManagmentSystem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
//@CrossOrigin(origins = "http://localhost:3200")
public class UserController {

    @Autowired
    private UserService userSer;

    @Autowired
    private UserRepository userRepository; // ✅ inject repository properly

    @PostMapping
    @ResponseBody // To return JSON directly
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userSer.saveUser(user);
    }

    @GetMapping
    @ResponseBody
    public List<UserEntity> getAllUsers() {
        return userSer.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<UserEntity> getUserById(@PathVariable Long id) {
        return userSer.getUserById(id);
    }

    @PostMapping("/register")
    public String handleUserRegister(@ModelAttribute("user") UserEntity user) {
        userRepository.save(user);
        return "registration_success"; // Create this HTML page in templates
    }



    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id) {
        boolean deleted = userSer.deleteUser(id);
        return deleted ? "User deleted successfully" : "User not found";
    }
}
