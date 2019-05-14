package com.javaschoolproject.demo.Administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/administrator")
public class AdministratorController {
    @Autowired
    private AdministratorRepository administratorRepository;

    @PostMapping(path = "/")
    public @ResponseBody String addNewAdministrator (@RequestBody LoginForm loginForm) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Administrator n = new Administrator();
        n.setLogin(loginForm.getName());
        n.setPassword(loginForm.getPassword());
        administratorRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Administrator> getAllAdministrator(){
        return administratorRepository.findAll();
    }
}

class LoginForm {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}