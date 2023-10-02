package com.example.DBMSPro.Service;
import com.example.DBMSPro.Models.User;
import com.example.DBMSPro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int addUser(User user) {
        //write conditions for errors if users are present*************
        if (user.getPassword() != null) {
            String password=user.getPassword();
            password= passwordEncoder.encode(password);
            user.setPassword(password);
            userRepository.save(user);
        }else System.out.println("User Password is null");
        return 1;
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