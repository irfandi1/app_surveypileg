package com.irfandi.surveypileg.responses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfandi.surveypileg.models.KabKota;

public class ResponseKabkota {

    @SerializedName("master")
    @Expose
    private List<KabKota> master = null;

    public List<KabKota> getMaster() {
        return master;
    }

    public void setMaster(List<KabKota> master) {
        this.master = master;
    }

}