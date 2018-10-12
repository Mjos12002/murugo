package com.murugoapp.murugo_app.model;

import com.murugoapp.murugo_app.entity.PopularLocationEntity;
import com.murugoapp.murugo_app.entity.PropertySubTypeEntity;
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
public class PropertySubTypeModel {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public GenericServerResponse addPropertySubType(PropertySubTypeEntity propertySubType){
        String response;
        String sql = "INSERT INTO property_sub_type VALUES (?, ?, ?, ?)";
        GenericServerResponse genericServerResponse;
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                    java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, null);
                    preparedStatement.setInt(2, propertySubType.getId());
                    preparedStatement.setString(3, propertySubType.getPropertySubTypeName());
                    preparedStatement.setString(4, propertySubType.getPropertyClass());
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

    public List<PropertySubTypeEntity> getAllPropertySubType(){
        List<PropertySubTypeEntity> result;
        try {
            result = jdbcTemplate.query(

                    "SELECT id, property_sub_type_name, parent_id, label FROM property_sub_type ORDER BY property_sub_type_name DESC",
                    (rs, rowNum) -> new PropertySubTypeEntity(rs.getInt("id"), rs.getString("property_sub_type_name"), rs.getInt("parent_id"), rs.getString("label"))
//                    new Object[]{String.valueOf(from), String.valueOf(to)}
            );
        }catch (Exception ex){
            result = new ArrayList<PropertySubTypeEntity>(){
                {
                    add(new PropertySubTypeEntity(0, ex.getMessage(), 0, "None"));
                }
            };
        }
        return result;
    }
}
