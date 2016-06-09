package com.example;

import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@RequestMapping("/users")
class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "list";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editUser(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "list";
    }

}
