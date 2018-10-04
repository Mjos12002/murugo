package com.murugoapp.murugo_app.model;

import com.murugoapp.murugo_app.entity.ProvinceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProvinceModel {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ProvinceEntity> getAllProvince(){
        List<ProvinceEntity> result;
        try {
            result = jdbcTemplate.query(

                    "SELECT id, province_name FROM province ORDER BY province_name DESC",
                    (rs, rowNum) -> new ProvinceEntity(rs.getInt("id"), rs.getString("province_name"))
//                    new Object[]{String.valueOf(from), String.valueOf(to)}
            );
        }catch (Exception ex){
            result = new ArrayList<ProvinceEntity>(){
                {
                    add(new ProvinceEntity(0, ex.getMessage()));
                }
            };
        }
        return result;
    }

}
