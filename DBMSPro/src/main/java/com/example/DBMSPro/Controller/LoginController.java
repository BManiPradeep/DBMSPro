package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.UserRepository;
import com.example.DBMSPro.Repository.UserRowMapper;
import com.example.DBMSPro.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserService userService,UserRepository userRepository) {
        this.userService = userService;
        this.userRepository=userRepository;
    }

    @GetMapping(value={"/signin","/login"})
    public String login(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @GetMapping("/user")
    public String userpage(Model model, @AuthenticationPrincipal UserDetails userDetails){
        User user= userService.loadUserByUsername(userDetails.getUsername()).getUser();
        model.addAttribute(user);
        return "user";
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
