package com.irfandi.surveypileg.responses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.irfandi.surveypileg.models.Kecamatan;

public class ResponseKecamatan {

    @SerializedName("master")
    @Expose
    private List<Kecamatan> master = null;

    public List<Kecamatan> getMaster() {
        return master;
    }

    public void setMaster(List<Kecamatan> master) {
        this.master = master;
    }

}
