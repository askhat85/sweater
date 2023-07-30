package com.example.secondattempt.sweater.controller;

import com.example.secondattempt.sweater.domain.Role;
import com.example.secondattempt.sweater.domain.User;
import com.example.secondattempt.sweater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        User userfromDB = userRepository.findByUsername(user.getUsername());

        if(userfromDB != null) {
            model.put("message", "User already exist");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
