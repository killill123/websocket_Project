package com.example.demo.controller;

import com.example.demo.CustomExeption.UserLoginException;
import com.example.demo.CustomExeption.UserSignupException;
import com.example.demo.DTO.UserLoginDto;
import com.example.demo.DTO.UserSignupDto;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/user/login")
    public String Login(){
        return "LoginForm";
    }


    @GetMapping("/user/signup")
    public String Signup(){
        return "SignupForm";
    }
    @PostMapping("/user/signup")
    public String Signup(UserSignupDto dto, Model model){
        try {
            userService.signup(dto);
            return "redirect:/";
        }catch (UserSignupException e){
            model.addAttribute("errorMassage", e.getMessage());
            return "SignupForm";
        }
    }


    @GetMapping("/user")
    public String userpage(){
        return "UserForm";
    }
}


