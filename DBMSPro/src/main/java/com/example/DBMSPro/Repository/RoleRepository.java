package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class RoleRepository{
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public RoleRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    private final RowMapper<Role> cartRowMapper = (rs, rowNum) -> {
        Role role = new Role();
        role.setRoleId(rs.getLong("roleId"));
        role.setRoleName(rs.getString("roleName"));
        return role;
    };

    private HashMap<String, Object> getRoleMap(Role role) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roleId", role.getRoleId());
        map.put("roleName", role.getRoleName());
        return map;
    }

    public Role getRoleById(long id){
        String sql = "SELECT * FROM Role WHERE RoleId = :RoleId";
        return namedParameterJdbcTemplate.queryForObject(sql, new HashMap<String, Object>(){{put("RoleId", id);}}, cartRowMapper);
    }

    public Role getRoleByName(String name){
        String sql = "SELECT * FROM Role WHERE RoleName = :RoleName";
        return namedParameterJdbcTemplate.queryForObject(sql, new HashMap<String, Object>(){{put("RoleName", name);}}, cartRowMapper);
    }

    public void createRole(Role role) {
        if(role.getRoleId()==0) role.setRoleId(0);// sets it to a random val.
        String sql = "INSERT INTO Roles (roleId, roleName) VALUES (:RoleId,:RoleName)";
        HashMap<String, Object> params = getRoleMap(role);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
