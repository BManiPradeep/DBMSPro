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
    private final RoleRepository roleRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public boolean authenticate(String email, String password) {
        // Find the user by their email address
        User user = userRepository.loadUserByUsername(email);
        System.out.println(user);

        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Incorrect Password in service");
            return false;
        }
        return true;
    }


    public User checkUsernameExists(String username) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user WHERE username=?",
                    new BeanPropertyRowMapper<User>(User.class), username);
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(email);
        return new MyUserDetails(userRepository.loadUserByUsername(email));
    }
}