package com.murugoapp.murugo_app.utility;

public class GenericServerResponse {

    public int responseCode;
    public String responseDescription;
    public String responseStatus;

    public GenericServerResponse(int responseCode, String responseDescription, String responseStatus) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.responseStatus = responseStatus;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}
