package com.murugoapp.murugo_app.model;

import com.murugoapp.murugo_app.entity.CellEntity;
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
public class CellModel {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public GenericServerResponse addCell(CellEntity cellEntity){
        String response;
        String sql = "INSERT INTO cell VALUES (?, ?, ?)";
        GenericServerResponse genericServerResponse;
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                    java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, null);
                    preparedStatement.setInt(2, cellEntity.getSectorID());
                    preparedStatement.setString(3, cellEntity.getSectorName());
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

    public List<CellEntity> getAllCell(){
        List<CellEntity> result;
        try {
            result = jdbcTemplate.query(

                    "SELECT id, cell_name, sector_id FROM sector ORDER BY cell_name DESC",
                    (rs, rowNum) -> new CellEntity(rs.getInt("id"), rs.getInt("sector_id"), rs.getString("cell_name"))
//                    new Object[]{String.valueOf(from), String.valueOf(to)}
            );
        }catch (Exception ex){
            result = new ArrayList<CellEntity>(){
                {
                    add(new CellEntity(0, 0, ex.getMessage()));
                }
            };
        }
        return result;
    }

}
