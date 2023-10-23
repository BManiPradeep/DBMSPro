package com.example.DBMSPro.Service;

import com.example.DBMSPro.Models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SecurityServices {

    public String findLoggedInUsername() {
        Object myUserDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (myUserDetails instanceof MyUserDetails) {
            return ((MyUserDetails) myUserDetails).getUser().getUsername();
        }

        return null;
    }

    public User findLoggedInUser() {
        Object myUserDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (myUserDetails instanceof MyUserDetails) {
            User user = ((MyUserDetails) myUserDetails).getUser();
            return user;
        }
        return null;
    }

}