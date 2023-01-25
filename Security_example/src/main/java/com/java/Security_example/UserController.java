package com.java.Security_example;

import com.java.Security_example.User;
import com.java.Security_example.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    private PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    /**
     * Any user can access this API - No Authentication required
     *
     * @param user
     * @return
     */

    @PostMapping("/register")
    public User registerStudent(@RequestBody User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(encoder.encode(user.getPassword()));
        user1.setRole(user.getRole());
        return UserService.register(user1);
    }

    /**
     * User who has logged in successfully can access this API
     *
     * @param username
     * @return
     */
    @GetMapping("/userInfo")
    public User getUserInfo(@RequestParam("username") String username) {
        return userService.getDetails(username);
    }

    /**
     * User who has the role ROLE_WRITE can only acess this API
     *
     * @param username
     * @return
     */
    @GetMapping("/getUserRoles")
    public String getSUserRoles(@RequestParam("username") String username) {
        return userService.getUserRoles(username);
    }
}
