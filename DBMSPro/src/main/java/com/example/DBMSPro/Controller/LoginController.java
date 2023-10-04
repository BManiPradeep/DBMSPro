package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model, HttpSession session){
        Boolean registrationSuccess = (Boolean) session.getAttribute("registrationSuccess");

        if (registrationSuccess != null && registrationSuccess) {
            model.addAttribute("registrationSuccess", true);
            session.removeAttribute("registrationSuccess");
        }
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        // Perform authentication logic using email and password
        User user=userService.authenticate(email,password);
        System.out.println("Login called");
        if(user==null){
            session.setAttribute("loginUnSuccess",true);
            return "login";
        }else{
            System.out.println(user);
            session.setAttribute("loginUnSuccess",false);
            session.setAttribute("user",user);
            return "redirect:/user";
        }
    }

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/home";
    }

}
