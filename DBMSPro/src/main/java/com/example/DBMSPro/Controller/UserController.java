package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.UserRepository;
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
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers(){
//        return "All Students";
        return userRepository.getAllUsers();
    }

    @GetMapping("/register")
    public String getRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register/save")
//    @ResponseBody
    public String registration(User user,
                               Model model){
        user.setUser_type("USER");
        userRepository.createUser(user);
        System.out.println(user.toString());
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model,HttpSession session){
        return "dashboard";
    }

}
