package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Role;
import com.example.DBMSPro.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Component
public class UserRepository{
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private RoleRepository roleRepository;


    @Autowired
    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, RoleRepository roleRepository) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.roleRepository = roleRepository;
    }

//    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
//        User user = new User();
//        user.setId(rs.getLong("id"));
//        user.setFname(rs.getString("fname"));
//        user.setLname(rs.getString("lname"));
//        user.setUsername("username");
//        user.setEmail(rs.getString("email"));
//        user.setPassword(rs.getString("password"));
//        user.setCity("city");
//        user.setStreet("street");
//        user.setPin(Long.valueOf("pin"));
//        user.setUser_type("user_type");
//        user.setRole(roleRepository.getRoleById(rs.getLong("roleId")));
//        System.out.println(user);
//        return user;
//    };


    private HashMap<String, Object> getUserMap(User user) {
        System.out.println("Hello in get User Map");
        System.out.println(user);
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("fname", user.getFname());
        map.put("lname", user.getLname());
        map.put("username", user.getUsername());
        map.put("email", user.getEmail());
        map.put("password", user.getPassword());
        map.put("city", user.getCity());
        map.put("street", user.getStreet());
        map.put("pin", user.getPin());
        map.put("user_type", user.getUser_type());
        map.put("dob", user.getDob());
        Role role = roleRepository.getRoleById(2L);
        map.put("roleId", role.getRoleId());
        System.out.println("MAP");
        System.out.println(map);
        return map;
    }

    public User createUser(User user) {
        if (user.getId()==0) user.setId(0L);// sets it to a random val.
        //set to USER Role
        String sql = "INSERT INTO User (id,fname, lname,username, email, password, roleId,city,street,pin,user_type,dob) VALUES " +
                "(:id,:fname, :lname,:username, :email, :password, :roleId,:city,:street,:pin,:user_type,:dob)";

        HashMap<String, Object> params = getUserMap(user);
        System.out.println("MAPS");
        System.out.println(params);
        namedParameterJdbcTemplate.update(sql, params);
        return user;
    }

    public User getUserById(long id){
        String sql = "SELECT * FROM user WHERE UserId = :UserId";
        HashMap<String, Object> params = new HashMap<>();
        params.put("UserId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, new UserRowMapper());
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return namedParameterJdbcTemplate.query(sql, new UserRowMapper());
    }

    public User getUserByEmail(String email){
        String sql = "SELECT * FROM user WHERE Email = :Email";
        System.out.println(email+ " : Email in User Repository");
        HashMap<String, Object> params = new HashMap<>();
        params.put("Email", email);
        return namedParameterJdbcTemplate.queryForObject(sql, params, new UserRowMapper());
    }

    public User getUserByUsername(String email){
        String sql = "SELECT * FROM user WHERE Email = :Email";
        HashMap<String, Object> params = new HashMap<>();
        params.put("Email", email);
        User user=namedParameterJdbcTemplate.queryForObject(sql, params,new UserRowMapper());
        return user;
    }
}
