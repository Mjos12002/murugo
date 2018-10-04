package com.murugoapp.murugo_app.model;

import com.murugoapp.murugo_app.entity.DistrictEntity;
import com.murugoapp.murugo_app.entity.SectorEntity;
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
public class SectorModel {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public GenericServerResponse addSector(SectorEntity sectorEntity){
        String response;
        String sql = "INSERT INTO sector VALUES (?, ?, ?)";
        GenericServerResponse genericServerResponse;
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                    java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, null);
                    preparedStatement.setInt(2, sectorEntity.getDistrictID());
                    preparedStatement.setString(3, sectorEntity.getSectorName());
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

    public List<SectorEntity> getAllSector(){
        List<SectorEntity> result;
        try {
            result = jdbcTemplate.query(

                    "SELECT id, sector_name, district_id FROM sector ORDER BY sector_name DESC",
                    (rs, rowNum) -> new SectorEntity(rs.getInt("id"), rs.getInt("district_id"), rs.getString("sector_name"))
//                    new Object[]{String.valueOf(from), String.valueOf(to)}
            );
        }catch (Exception ex){
            result = new ArrayList<SectorEntity>(){
                {
                    add(new SectorEntity(0, 0, ex.getMessage()));
                }
            };
        }
        return result;
    }
}
