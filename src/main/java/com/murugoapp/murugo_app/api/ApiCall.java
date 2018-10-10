package com.murugoapp.murugo_app.api;

import com.murugoapp.murugo_app.entity.*;
import com.murugoapp.murugo_app.model.*;
import com.murugoapp.murugo_app.utility.GenericServerResponse;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiCall {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ProvinceModel provinceModel;
    @Autowired
    DistrictModel districtModel;
    @Autowired
    SectorModel sectorModel;
    @Autowired
    LocationModel locationModel;
    @Autowired
    CellModel cellModel;
    @Autowired
    PropertyTypeModel propertyTypeModel;
    @Autowired
    ListingTypeModel listingTypeModel;


    @RequestMapping(value = "/addProvince", method = RequestMethod.POST, produces = "application/json")
    public GenericServerResponse addProvince(@ModelAttribute ProvinceEntity provinceEntity){
        String response;
        String sql = "INSERT INTO province VALUES (?, ?)";
        GenericServerResponse genericServerResponse;
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection connection) throws SQLException {
                    java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, null);
                    preparedStatement.setString(2, provinceEntity.getProvinceName());
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

    @RequestMapping(value = "get_all_popular_location", produces = "application/json")
    public List<PopularLocationEntity> getAllPopularLocation(){
        return locationModel.getAllLocation();
    }

    @RequestMapping(value = "/get_all_province", produces = "application/json")
    public List<ProvinceEntity> getAllProvince(){
        return provinceModel.getAllProvince();
    }

    @RequestMapping(value = "/add_district", produces = "application/json")
    public GenericServerResponse addDistrict(@ModelAttribute DistrictEntity districtEntity){
        return districtModel.addProvince(districtEntity);
    }

    @RequestMapping(value = "add_property_type", produces = "application/json")
    public GenericServerResponse addPropertyType(@ModelAttribute PropertyTypeEntity propertyTypeEntity){
        return propertyTypeModel.addPropertyType(propertyTypeEntity);
    }

    @RequestMapping(value = "add_listing_type", produces = "application/json")
    public GenericServerResponse addListingType(@ModelAttribute ListingTypeEntity listingTypeEntity){
        return listingTypeModel.addListingType(listingTypeEntity);
    }

    @RequestMapping(value = "get_all_listing_type", produces = "application/json")
    public List<ListingTypeEntity> getAllListingType(){
        return listingTypeModel.getAllListingType();
    }

    @RequestMapping(value = "get_all_property_type", produces = "application/json")
    public List<PropertyTypeEntity> getAllPropertyType(){
        return propertyTypeModel.getAllPropertyType();
    }

    @RequestMapping(value = "/get_all_district", produces = "application/json")
    public List<DistrictEntity> getAllDistrict(){
        return districtModel.getAllDistrict();
    }

    @RequestMapping(value = "/add_sector", produces = "application/json")
    public GenericServerResponse addSector(@ModelAttribute SectorEntity sectorEntity){
        return sectorModel.addSector(sectorEntity);
    }

    @RequestMapping(value = "/get_all_sector", produces = "application/json")
    public List<SectorEntity> getAllSector(){
        return sectorModel.getAllSector();
    }

    @RequestMapping(value = "/get_all_cell", produces = "application/json")
    public List<CellEntity> getAllCell(){
        return cellModel.getAllCell();
    }

    @RequestMapping(value = "/add_cell", produces = "application/json")
    public GenericServerResponse addCell(@ModelAttribute CellEntity cellEntity){
        return cellModel.addCell(cellEntity);
    }

    @RequestMapping(value = "/get_all_location", produces = "application/json")
    public List<PopularLocationEntity> getAllLocation(){
        return locationModel.getAllLocation();
    }

    @RequestMapping(value = "add_location", produces = "application/json")
    public GenericServerResponse addLocation(@ModelAttribute PopularLocationEntity popularLocationEntity){
        return locationModel.addLocation(popularLocationEntity);
    }


}
