package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping(path={"/","/home"})
    public String home(Model model, HttpSession session){
//        User user=(User) session.getAttribute("user");
//        model.addAttribute("user",user);
        return "home";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "HelloAdmin";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/shop")
    public String shop(){
        return "shop";
    }


}
