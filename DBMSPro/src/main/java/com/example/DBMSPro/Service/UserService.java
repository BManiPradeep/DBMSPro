package com.example.DBMSPro.Service;
import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
    public User checkUsernameExists(String username) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user WHERE username=?",
                    new BeanPropertyRowMapper<User>(User.class), username);
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

//    @Override
    public int addUser(User user) {

        String password = user.getPassword();
        user.setPassword(password);
        if (user.getUser_type() == null) {
            user.setUser_type("USER");
        }
        System.out.println(user);
        if (checkUsernameExists(user.getUsername()) == null) {
            try
            {
                 userRepository.save(user);
                 return 1;
            } catch (Exception e) {
                return -1;
            }
        }
        else
        {
            //give message username already exists
            System.out.println("Username already exist");
            return 0;
        }
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }


    public User authenticate(String email, String password) {
        System.out.println(email);
        User user=userRepository.findUserByEmail(email);
        if (user!=null&&user.getEmail().equals(email) && password==user.getPassword()) {
            return user; // Authentication successful, return the user object
        }
        System.out.println("No user found");
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new MyUserDetails(userRepository.findUserByEmail(email));
    }
}