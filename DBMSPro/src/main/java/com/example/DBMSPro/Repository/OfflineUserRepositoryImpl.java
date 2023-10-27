package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.OfflineUser;
import com.example.DBMSPro.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfflineUserRepositoryImpl implements OfflineUserRepository{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public OfflineUserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addOfflineUser(OfflineUser offlineUser) {
        String sql="INSERT INTO offlineuser(Date_purchased,Time_purchased,PhoneNumber,TabletDescription) VALUES(?,?,?,?)";
        try{
            jdbcTemplate.update(sql,offlineUser.getDate_purchased(),offlineUser.getTime_purchased(),offlineUser.getPhoneNumber(),offlineUser.getTabletDescription());
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public List<OfflineUser> getallofflineUser() {
        String sql = "SELECT * FROM offlineuser";
        List<OfflineUser> offlineUsers = jdbcTemplate.query(sql,new BeanPropertyRowMapper<OfflineUser>(OfflineUser.class));
        return offlineUsers;
    }
}
