package com.nikita_osia.spring_boot.kataspringboot.controller;

import com.nikita_osia.spring_boot.kataspringboot.model.User;
import com.nikita_osia.spring_boot.kataspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/new")
    public String showFormAddUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user.getFirstName(), user.getLastname(), user.getEmail());
        return "redirect:/user";
    }

    @GetMapping("/show")
    public String showUserById(@RequestParam("id") int id, Model model) {
        User user = userService.showUserById(id);
        if (user == null) {
            return "redirect:/user";
        } else {
            model.addAttribute("user", user);
            return "selected_user";
        }
    }

    @GetMapping("/show/edit")
    public String editUser(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.showUserById(id));
        return "edit_user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.updateUserById(id, user);
        return "redirect:/user";
    }

    @PostMapping("/show/delete")
    public String deleteUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.removeUserById(id);
        return "redirect:/user";
    }
}
