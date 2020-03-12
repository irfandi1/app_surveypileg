package com.irfandi.surveypileg.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfandi.surveypileg.models.Surveyor;

public class ResponseLogin {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Surveyor data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Surveyor getSurveyor() {
        return data;
    }

    public void setData(Surveyor data) {
        this.data = data;
    }

}