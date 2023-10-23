package com.example.DBMSPro.Service;
import com.example.DBMSPro.Models.Role;
import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.RoleRepository;
import com.example.DBMSPro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("userDetailsService")
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public com.example.DBMSPro.Service.MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        System.out.println("IN USER SERVICE LOAD");
        System.out.println(user);
        System.out.println(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        return new com.example.DBMSPro.Service.MyUserDetails(user);
    }
}