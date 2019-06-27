package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.User_partie;
import com.javaschoolproject.demo.repository.User_partieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user_partie")
public class User_partieController {
    @Autowired
    private User_partieRepository user_partieRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewUser_partie (@RequestBody User_partie administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User_partie u = new User_partie();
        u.setId_partie(1);
        u.setId_user(1);
        user_partieRepository.save(u);
        return "Saved";
    }

    @GetMapping()
    public @ResponseBody Iterable<User_partie> getAllUser_partie(){
        return user_partieRepository.findAll();
    }
}