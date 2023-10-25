package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Service.MyUserDetails;
import com.example.DBMSPro.Service.SecurityServices;
import com.example.DBMSPro.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    private UserService userService;
    private SecurityServices securityServices;

    @Autowired
    public HomeController(UserService userService, SecurityServices securityServices) {
        this.userService = userService;
        this.securityServices=securityServices;
    }

    @GetMapping(path={"/","/home"})
    public String home(Model model){
        User user=securityServices.findLoggedInUser();
        model.addAttribute("user",user);
        //get authentication details of user logged in *************
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
