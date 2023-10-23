package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Service.MyUserDetails;
import com.example.DBMSPro.Service.UserService;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path={"/","/home"})
    public String home(Authentication authentication){
        System.out.println("In HOME");
        if(authentication != null && authentication.isAuthenticated()){
            MyUserDetails myUserDetails= (MyUserDetails) authentication.getPrincipal();
            User user=myUserDetails.getUser();
            System.out.println("This is Home");
            String username = user.getUsername();
            String userType = user.getUser_type();
            System.out.println(user);
        }//get authentication details of user logged in *************
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
