package com.irfandi.surveypileg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kelurahan {

    @SerializedName("id_kelurahan")
    @Expose
    private Integer idKelurahan;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_kec")
    @Expose
    private Integer idKec;

    public Integer getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(Integer idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getIdKec() {
        return idKec;
    }

    public void setIdKec(Integer idKec) {
        this.idKec = idKec;
    }

}