package com.example.DBMSPro.Controller;

import com.example.DBMSPro.Models.Role;
import com.example.DBMSPro.Repository.UserRepository;
import com.example.DBMSPro.Service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    SecurityServices securityServices;
    @Autowired
    UserRepository userRepository;



    @GetMapping("/admin")
    public String adminHome()
    {
        System.out.println("CAME TO ADMIN");
        long roleId=securityServices.findLoggedInUser().getRole().getRoleId();
        System.out.println(roleId);
        if(roleId!=1)
        {      return "login";  }


        return "Admin";
    }


}
