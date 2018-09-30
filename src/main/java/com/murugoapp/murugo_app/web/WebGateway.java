package com.murugoapp.murugo_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebGateway {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/offer_property")
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

}
