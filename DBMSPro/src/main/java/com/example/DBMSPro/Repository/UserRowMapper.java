package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Role;
import com.example.DBMSPro.Models.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFname(resultSet.getString("fname"));
        user.setLname(resultSet.getString("lname"));
        user.setUsername(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        // Assuming Role is mapped as a foreign key in the database
        Role role = new Role();
        role.setRoleId(resultSet.getLong("roleId")); // Assuming role_id is the column name
        user.setRole(role);
        user.setCity(resultSet.getString("city"));
        user.setStreet(resultSet.getString("street"));
        user.setPin(resultSet.getLong("pin"));
        user.setUser_type(resultSet.getString("user_type"));
        user.setDob(resultSet.getDate("dob").toLocalDate());
        return user;
    }
}
