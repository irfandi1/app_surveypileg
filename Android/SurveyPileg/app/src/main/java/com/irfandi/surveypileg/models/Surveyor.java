package com.irfandi.surveypileg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Surveyor {

    @SerializedName("id_surveyor")
    @Expose
    private String idSurveyor;
    @SerializedName("nama_petugas")
    @Expose
    private String namaPetugas;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("no_hp")
    @Expose
    private String noHp;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("created_update")
    @Expose
    private String createdUpdate;

    public String getIdSurveyor() {
        return idSurveyor;
    }

    public void setIdSurveyor(String idSurveyor) {
        this.idSurveyor = idSurveyor;
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }

    public void setNamaPetugas(String namaPetugas) {
        this.namaPetugas = namaPetugas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedUpdate() {
        return createdUpdate;
    }

    public void setCreatedUpdate(String createdUpdate) {
        this.createdUpdate = createdUpdate;
    }

}