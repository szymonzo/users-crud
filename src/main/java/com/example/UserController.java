package com.example;

import com.example.entity.Address;
import com.example.entity.Users;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/view/add", method = RequestMethod.GET)
    public String addUserView(Model model) {
        Address address = new Address();
        Users user = new Users();
        user.setAddress(address);
        model.addAttribute("user", user);
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String adduser(@ModelAttribute(value = "newUser") Users user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/view/edit/{id}", method = RequestMethod.GET)
    public String editUserView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userRepository.findOne(id));
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute(value = "editedUser") Users user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return "redirect:/users";
    }

}
