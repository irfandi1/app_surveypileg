package com.irfandi.surveypileg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KabKota {

    @SerializedName("id_kecamatan")
    @Expose
    private String idKecamatan;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_kabkota")
    @Expose
    private String idKabkota;
    @SerializedName("dapil")
    @Expose
    private Object dapil;

    public String getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdKabkota() {
        return idKabkota;
    }

    public void setIdKabkota(String idKabkota) {
        this.idKabkota = idKabkota;
    }

    public Object getDapil() {
        return dapil;
    }

    public void setDapil(Object dapil) {
        this.dapil = dapil;
    }

}