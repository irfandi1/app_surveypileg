package com.irfandi.surveypileg.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfandi.surveypileg.models.Registrasi;

public class ResponseRegistrasi {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Registrasi data;

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

    public Registrasi getSurveyor() {
        return data;
    }

    public void setData(Registrasi data) {
        this.data = data;
    }
}
