package com.murugoapp.murugo_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebGateway {
    @RequestMapping("home")
    public String home(){
        return "index";
    }
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("offer_property")
    public String offerProperty(){
        return "offer_property";
    }
    @RequestMapping("house")
    public String house(){
        return "property_type/house";
    }
    @RequestMapping("annex")
    public String annex() {
        return "property_type/annex";
    }
    @RequestMapping("accommodation")
    public String accommodation(){
        return "property_type/accomodation";
    }
    @RequestMapping("land")
    public String land(){
        return "property_type/land";
    }
    @RequestMapping("commercial")
    public String commercial(){
        return "property_type/commercial";
    }
    @RequestMapping("property_feature")
    public String propertyFeature(){
        return "property_feature";
    }
    @RequestMapping("property_location")
    public String propertyLocation(){
        return "property_location";
    }
    @RequestMapping("contact_info")
    public String contactInfo(){
        return "contact_info";
    }
    @RequestMapping("property_picture")
    public String propertyPicture(){
        return "property_picture";
    }
    @RequestMapping("province")
    public String province(){
        return "province";
    }
    @RequestMapping("district")
    public String district(){
        return "district";
    }
    @RequestMapping("sector")
    public String sector() {
        return "sector";
    }
    @RequestMapping("cell")
    public String cell(){
        return "cell";
    }
    @RequestMapping("popular_location")
    public String popular_location(){
        return "popular_location";
    }
    @RequestMapping("admin")
    public String admin(){
        return "administrator";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("property_data")
    public String propertyData(){
        return "property_data";
    }
    @RequestMapping("listing_type")
    public String listingType(){return "listing_type";}
    @RequestMapping("sign_up")
    public String signUp(){
        return "sign_up";
    }

}
