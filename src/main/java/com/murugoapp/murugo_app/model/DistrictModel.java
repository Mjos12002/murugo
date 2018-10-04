package com.murugoapp.murugo_app.model;

import com.murugoapp.murugo_app.entity.DistrictEntity;
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
public class DistrictModel {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public GenericServerResponse addProvince(DistrictEntity districtEntity){
        String response;
        String sql = "INSERT INTO district VALUES (?, ?, ?)";
        GenericServerResponse genericServerResponse;
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                    java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, null);
                    preparedStatement.setInt(2, districtEntity.getProvinceID());
                    preparedStatement.setString(3, districtEntity.getDistrictName());

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

    public List<DistrictEntity> getAllDistrict(){
        List<DistrictEntity> result;
        try {
            result = jdbcTemplate.query(

                    "SELECT id, district_name, province_id FROM district ORDER BY district_name DESC",
                    (rs, rowNum) -> new DistrictEntity(rs.getInt("id"), rs.getInt("province_id"), rs.getString("district_name"))
//                    new Object[]{String.valueOf(from), String.valueOf(to)}
            );
        }catch (Exception ex){
            result = new ArrayList<DistrictEntity>(){
                {
                    add(new DistrictEntity(0, 0, ex.getMessage()));
                }
            };
        }
        return result;
    }

}
