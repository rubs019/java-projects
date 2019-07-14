package com.javaschoolproject.demo.Controller;

import com.javaschoolproject.demo.models.Administrator;
import com.javaschoolproject.demo.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/administrator")
public class AdministratorController {
    @Autowired
    private AdministratorRepository administratorRepository;

    @PostMapping()
    public String addNewAdministrator (@RequestBody Administrator administrator) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Administrator n = new Administrator();
        n.setLogin(administrator.getLogin());
        n.setPassword(administrator.getPassword());
        administratorRepository.save(n);
        return "Saved";
    }

    @GetMapping()
    public Iterable<Administrator> getAllAdministrator(){
        return administratorRepository.findAll();
    }
}