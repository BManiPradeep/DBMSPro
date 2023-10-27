package com.example.DBMSPro.Controller;


import com.example.DBMSPro.Models.OfflineUser;
import com.example.DBMSPro.Repository.OfflineUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OfflineUserController {

    @Autowired
    OfflineUserRepository offlineUserRepository;

    @GetMapping("/admin/offline")
    public String offline(Model model){
        model.addAttribute("offlineUser", new OfflineUser());
        return "offline";
    }

    @PostMapping("/admin/offline")
    public String offline(OfflineUser offlineUser, Model model){
        System.out.println(offlineUser.toString());
        int e= offlineUserRepository.addOfflineUser(offlineUser);
        return "redirect:/admin";
    }

    @GetMapping("/admin/offlineUser")
    public String offlineUser(Model model){
        List<OfflineUser> offlineUsers= offlineUserRepository.getallofflineUser();
        model.addAttribute("offlineUser",offlineUsers);
        return "offlineUser";
    }
}
