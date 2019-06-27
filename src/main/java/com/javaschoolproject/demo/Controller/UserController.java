package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.User;
import com.javaschoolproject.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public String addNewTerrain (@RequestBody User administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setNom("Nom");
        user.setPrenom("test");
        user.setUsername("user");
        user.setPassword("mdp");
        user.setEmail("camarche@camarche.com");
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping()
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
}