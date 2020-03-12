package com.irfandi.surveypileg.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfandi.surveypileg.models.Kelurahan;

import java.util.List;

public class ResponseKelurahan {

    @SerializedName("master")
    @Expose
    private List<Kelurahan> master = null;

    public List<Kelurahan> getMaster() {
        return master;
    }

    public void setMaster(List<Kelurahan> master) {
        this.master = master;
    }

}
