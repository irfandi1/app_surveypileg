package com.irfandi.surveypileg.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfandi.surveypileg.models.Responden;

public class ResponseResponden {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Responden data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Responden getResponden() {
        return data;
    }

    public void setData(Responden data) {
        this.data = data;
    }

}