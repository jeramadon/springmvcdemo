/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ebf.springmvcdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jerryamadon
 */
@Component("usersDao")
public class UsersDao {
    
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional
    public boolean create(User user) {
        BeanPropertySqlParameterSource beanSqlParameter = new BeanPropertySqlParameterSource(user);
        jdbcTemplate.update("insert into users (username, password, email, enabled) values (:username, :password, :email, :enabled)", beanSqlParameter);
        return jdbcTemplate.update("insert into authorities (username, authority) values (:username, :authority)", beanSqlParameter) == 1;
    }
    
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from users", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEnabled(rs.getInt("enabled") != 0);
                return user;
            }
        });
    }    

    public boolean exists(String username) {
        return jdbcTemplate.queryForObject("select count(*) from users where username=:username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;        
    }
  /*    
    public User getUser(String username) {
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource("searchId", username);
        return jdbcTemplate.queryForObject("select * from users where id = :searchId", sqlParameter, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEnabled(rs.getInt("enabled") != 0);
                return user;
            }
        });
    }
    
    @Transactional
    public int[] create(List<User> users) {
        SqlParameterSource[] beanSqlParameters = SqlParameterSourceUtils.createBatch(users.toArray());
        jdbcTemplate.batchUpdate("insert into users (username, password, enabled) values (:username, :password, :enabled)", beanSqlParameters);
        return jdbcTemplate.batchUpdate("insert into authorities (username, authority) values (:username, :authority)", beanSqlParameters);
    }
    
    public boolean delete(String username) {
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource("searchId", username);
        jdbcTemplate.update("delete from users where username =:searchId", sqlParameter);
        return jdbcTemplate.update("delete from authorities where username =:searchId", sqlParameter) == 1;
    }
    
    public boolean update(User user) {
        BeanPropertySqlParameterSource beanSqlParameter = new BeanPropertySqlParameterSource(user);
        jdbcTemplate.update("update users set username=:username, password=:password, enabled=:enabled where username=:username", beanSqlParameter);
        return jdbcTemplate.update("update authorities set username=:username, authority=:authority where username=:username", beanSqlParameter) == 1;
    }
//  */    
}
