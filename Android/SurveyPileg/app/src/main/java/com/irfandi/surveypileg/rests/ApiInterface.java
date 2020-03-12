package com.irfandi.surveypileg.rests;

import android.widget.Spinner;

import com.irfandi.surveypileg.responses.ResponseKabkota;
import com.irfandi.surveypileg.responses.ResponseKecamatan;
import com.irfandi.surveypileg.responses.ResponseKelurahan;
import com.irfandi.surveypileg.responses.ResponseLogin;
import com.irfandi.surveypileg.responses.ResponseRegistrasi;
import com.irfandi.surveypileg.responses.ResponseResponden;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by radinaldn on 06/07/18.
 */

public interface ApiInterface {
    // untuk menerima presensi dan mengurangi poin tidak hadir
    @FormUrlEncoded
    @POST("surveyor/login")
    Call<ResponseLogin> surveyorLogin(
            @Field("username") String username,
            @Field("password") String password,
            @Field("status") String status
    );

    @FormUrlEncoded
    @POST("surveyor/add")
    Call<ResponseRegistrasi> surveyorRegistrasi(
            @Field("nama_petugas") String nama_petugas,
            @Field("username") String username,
            @Field("password") String password,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("no_hp") String no_hp,
            @Field("alamat") String alamat,
            @Field("status") String status
    );

    @FormUrlEncoded
    @POST("responden/add")
    Call<ResponseResponden> surveyorAdd(
            @Field("id_surveyor") String id_surveyor,
            @Field("nama_responden") String nama_responden,
            @Field("alamat") String alamat,
            @Field("provinsi") String provinsi,
            @Field("kab_kota") String kab_kota,
            @Field("kecamatan") String kecamatan,
            @Field("kel_desa") String kel_desa,
            @Field("rt") String rt,
            @Field("rw") String rw,
            @Field("no_hp") String no_hp,
            @Field("pertanyaan_12") String pertanyaan_12,
            @Field("pertanyaan_13") String pertanyaan_13,
            @Field("pertanyaan_14") String pertanyaan_14,
            @Field("pertanyaan_15") String pertanyaan_15,
            @Field("pertanyaan_16") String pertanyaan_16,
            @Field("pertanyaan_17") String pertanyaan_17,
            @Field("pertanyaan_18") String pertanyaan_18,
            @Field("pertanyaan_19") String pertanyaan_19,
            @Field("pertanyaan_20") String pertanyaan_20,
            @Field("pertanyaan_21") String pertanyaan_21,
            @Field("pertanyaan_22") String pertanyaan_22,
            @Field("pertanyaan_23") String pertanyaan_23,
            @Field("pertanyaan_24") String pertanyaan_24,
            @Field("pertanyaan_25") String pertanyaan_25,
            @Field("pertanyaan_26") String pertanyaan_26,
            @Field("pertanyaan_27") String pertanyaan_27,
            @Field("pertanyaan_28") String pertanyaan_28,
            @Field("pertanyaan_29") String pertanyaan_29,
            @Field("pertanyaan_30") String pertanyaan_30,
            @Field("pertanyaan_31") String pertanyaan_31,
            @Field("pertanyaan_32") String pertanyaan_32,
            @Field("pertanyaan_33") String pertanyaan_33,
            @Field("pertanyaan_34") String pertanyaan_34,
            @Field("pertanyaan_35") String pertanyaan_35,
            @Field("pertanyaan_36") String pertanyaan_36,
            @Field("pertanyaan_37") String pertanyaan_37,
            @Field("pertanyaan_38") String pertanyaan_38,
            @Field("pertanyaan_39") String pertanyaan_39,
            @Field("pertanyaan_40") String pertanyaan_40,
            @Field("lat") String lat,
            @Field("lang") String lang

    );

    @GET("kab-kota/view-by-id-kabkota")
    Call<ResponseKabkota> GetAllByIdKabKota(
            @Query("id_kabkota") String id_kabkota
    );

    @GET("kecamatan/view-by-id-kabkota")
    Call<ResponseKecamatan> GetAllByIdKecamatan(
            @Query("id_kecamatan") String id_kecamatan
    );

    @GET("kelurahan/view-by-id-kecamatan")
    Call<ResponseKelurahan> GetAllByIdKelurahan(
            @Query("id_kelurahan") String id_kelurahan
    );


}