package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers(){
//        return "All Students";
        return userService.getAllUsers();
    }

    @GetMapping("/register")
    public String getRegistrationForm(){
        return "register";
    }

    @PostMapping("/register/save")
//    @ResponseBody
    public String registration(@ModelAttribute("user") User userDto,
                               HttpSession session){
        int u=userService.addUser(userDto);
        System.out.println("U : ");
        System.out.println(u);
        if(u==0)
        {
            return "redirect:/register?error=true";
        } else if (u==-1) {
            return "error";
        }
        session.setAttribute("registrationSuccess", true);
        session.setAttribute("user",userDto);
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String UserIndex(Model model,HttpSession session){
        User user=(User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model,HttpSession session){
        return "dashboard";
    }


}
