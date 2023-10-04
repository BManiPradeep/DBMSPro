package com.example.DBMSPro.Service;
import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private final UserRepository userRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    public int addUser(User user) {
//        //write conditions for errors if users are present*************
//        if (user.getPassword() != null) {
//            String password=user.getPassword();
//            password= passwordEncoder.encode(password);
//            user.setPassword(password);
//            userRepository.save(user);
//        }else System.out.println("User Password is null");
//        return 1;
//    }

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
        password = passwordEncoder.encode(password);
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
        if (user!=null&&user.getEmail().equals(email) && passwordEncoder.matches(password, user.getPassword())) {
            return user; // Authentication successful, return the user object
        }
        System.out.println("No user found");
        return null;
    }
}