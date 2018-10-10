package com.murugoapp.murugo_app.model;

import com.murugoapp.murugo_app.entity.PropertyTypeEntity;
import com.murugoapp.murugo_app.entity.ProvinceEntity;
import com.murugoapp.murugo_app.utility.GenericServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyTypeModel {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public GenericServerResponse addPropertyType(PropertyTypeEntity propertyTypeEntity){
        String response;
        String sql = "INSERT INTO property_type VALUES (?, ?)";
        GenericServerResponse genericServerResponse;
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                    java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, null);
                    preparedStatement.setString(2, propertyTypeEntity.getPropertyTypeName());

                    return preparedStatement;
                }
            }, keyHolder);
            response = String.valueOf(keyHolder.getKey().intValue());
            genericServerResponse = new GenericServerResponse(200, "Record saved successfully", "Success");
        }catch (Exception ex){
            response = ex.toString();
            genericServerResponse = new GenericServerResponse(300, ex.getMessage(), "Fail");
        }
        return  genericServerResponse;
    }

    public List<PropertyTypeEntity> getAllPropertyType(){
        List<PropertyTypeEntity> result;
        try {
            result = jdbcTemplate.query(

                    "SELECT id, property_type_name FROM property_type ORDER BY property_type_name DESC",
                    (rs, rowNum) -> new PropertyTypeEntity(rs.getInt("id"), rs.getString("property_type_name"))
//                    new Object[]{String.valueOf(from), String.valueOf(to)}
            );
        }catch (Exception ex){
            result = new ArrayList<PropertyTypeEntity>(){
                {
                    add(new PropertyTypeEntity(0, ex.getMessage()));
                }
            };
        }
        return result;
    }

}
