package com.example.controller;

import com.example.entity.Address;
import com.example.entity.Users;
import com.example.repository.UserRepository;
import com.example.repository.UsersSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

@RequestMapping("/users")
class UserController {

    private final String FILTER = "/filter";
    private final String VIEW_ADD = "/view/add";
    private final String ADD = "/add";
    private final String VIEW_EDIT_ID = "/view/edit/{id}";
    private final String EDIT = "/edit";
    private final String DELETE_ID = "/delete/{id}";
    private final String LIST = "list";

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(Model model) {
        addUserFilterToModel(model, new Users());
        model.addAttribute("users", userRepository.findAll());
        return LIST;
    }

    @RequestMapping(value = FILTER, method = RequestMethod.POST)
    public String findUsers(Model model, Users user) {
        Specification<Users> spec = new UsersSpecification(user);
        List<Users> filtered = userRepository.findAll(spec);
        model.addAttribute("users", filtered);
        addUserFilterToModel(model, user);
        return LIST;
    }


    @RequestMapping(value = VIEW_ADD, method = RequestMethod.GET)
    public String addUserView(Model model) {
        Address address = new Address();
        Users user = new Users();
        user.setAddress(address);
        model.addAttribute("user", user);
        return ADD;
    }

    @RequestMapping(value = ADD, method = RequestMethod.POST)
    public String adduser(@ModelAttribute(value = "newUser") Users user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = VIEW_EDIT_ID, method = RequestMethod.GET)
    public String editUserView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userRepository.findOne(id));
        return EDIT;
    }

    @RequestMapping(value = EDIT, method = RequestMethod.POST)
    public String editUser(@ModelAttribute(value = "editedUser") Users user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = DELETE_ID, method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return "redirect:/users";
    }

    private void addUserFilterToModel(Model model, Users users) {
        model.addAttribute("userFilter", users);
    }

}
