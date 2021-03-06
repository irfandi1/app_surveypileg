package com.irfandi.surveypileg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kecamatan {

    @SerializedName("id_kecamatan")
    @Expose
    private Integer idKecamatan;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_kabkota")
    @Expose
    private Integer idKabkota;
    @SerializedName("dapil")
    @Expose
    private Object dapil;

    public Integer getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(Integer idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getIdKabkota() {
        return idKabkota;
    }

    public void setIdKabkota(Integer idKabkota) {
        this.idKabkota = idKabkota;
    }

    public Object getDapil() {
        return dapil;
    }

    public void setDapil(Object dapil) {
        this.dapil = dapil;
    }

}