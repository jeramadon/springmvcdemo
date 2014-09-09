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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jerryamadon
 */
@Component("offersDao")
public class OffersDao {
    
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Offer getOffer(int id) {
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource("searchId", id);
        return jdbcTemplate.queryForObject("select * from offers where id = :searchId", sqlParameter, new RowMapper<Offer>() {

            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                Offer offer = new Offer();
                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setText(rs.getString("text"));
                offer.setEmail(rs.getString("email"));
                return offer;
            }
        });
    }
    
    public List<Offer> getOffers() {
        return jdbcTemplate.query("select * from offers", new RowMapper<Offer>() {

            public Offer mapRow(ResultSet rs, int i) throws SQLException {
                Offer offer = new Offer();
                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setText(rs.getString("text"));
                offer.setEmail(rs.getString("email"));
                return offer;
            }
        });
    }
    
    public boolean create(Offer offer) {
        BeanPropertySqlParameterSource beanSqlParameter = new BeanPropertySqlParameterSource(offer);
        return jdbcTemplate.update("insert into offers (name, email, text) values (:name, :email, :text)", beanSqlParameter) == 1;
    }
    
    @Transactional
    public int[] create(List<Offer> offers) {
        SqlParameterSource[] beanSqlParameters = SqlParameterSourceUtils.createBatch(offers.toArray());
        return jdbcTemplate.batchUpdate("insert into offers (id, name, email, text) values (:id, :name, :email, :text)", beanSqlParameters);
    }
    
    public boolean delete(int id) {
        MapSqlParameterSource sqlParameter = new MapSqlParameterSource("searchId", id);
        return jdbcTemplate.update("delete from offers where id =:searchId", sqlParameter) == 1;
    }
    
    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource beanSqlParameter = new BeanPropertySqlParameterSource(offer);
        return jdbcTemplate.update("update offers set name=:name, email=:email, text=:text where id=:id", beanSqlParameter) == 1;
    }
}
