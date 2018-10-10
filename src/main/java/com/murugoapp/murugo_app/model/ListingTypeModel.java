package com.murugoapp.murugo_app.model;

import com.murugoapp.murugo_app.entity.ListingTypeEntity;
import com.murugoapp.murugo_app.entity.PropertyTypeEntity;
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
public class ListingTypeModel {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public GenericServerResponse addListingType(ListingTypeEntity listingTypeEntity){
        String response;
        String sql = "INSERT INTO listing_type VALUES (?, ?)";
        GenericServerResponse genericServerResponse;
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                    java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, null);
                    preparedStatement.setString(2, listingTypeEntity.getListingTypeName());

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

    public List<ListingTypeEntity> getAllListingType(){
        List<ListingTypeEntity> result;
        try {
            result = jdbcTemplate.query(

                    "SELECT id, listing_type_name FROM listing_type ORDER BY listing_type_name DESC",
                    (rs, rowNum) -> new ListingTypeEntity(rs.getInt("id"), rs.getString("listing_type_name"))
//                    new Object[]{String.valueOf(from), String.valueOf(to)}
            );
        }catch (Exception ex){
            result = new ArrayList<ListingTypeEntity>(){
                {
                    add(new ListingTypeEntity(0, ex.getMessage()));
                }
            };
        }
        return result;
    }


}
