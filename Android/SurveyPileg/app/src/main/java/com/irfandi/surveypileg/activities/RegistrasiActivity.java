package com.irfandi.surveypileg.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.irfandi.surveypileg.R;
import com.irfandi.surveypileg.responses.ResponseRegistrasi;
import com.irfandi.surveypileg.rests.ApiClient;
import com.irfandi.surveypileg.rests.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrasiActivity extends AppCompatActivity {

    ApiInterface apiService;

    private static final String TAG = RegistrasiActivity.class.getSimpleName();

    EditText etnama_petugas, etusername, etpassword, etno_hp, etalamat;
    RadioGroup radiogroupjenis_kelamin;
    RadioButton rblaki, rbperempuan;
    String rgjeniskelamin;
    Button btnregistrasi, btnbatal;

    String nama_petugas, username, password, no_hp, alamat, jenis_kelamin, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        Log.d("kantau","ini activity register");

        apiService = ApiClient.getClient().create(ApiInterface.class);

        etnama_petugas = findViewById(R.id.etnama_petugas);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        etno_hp = findViewById(R.id.etno_hp);
        etalamat = findViewById(R.id.etalamat);
        radiogroupjenis_kelamin = findViewById(R.id.radiogroupjenis_kelamin);
        rblaki = findViewById(R.id.rblaki_laki);
        rbperempuan = findViewById(R.id.rbperempuan);
        btnregistrasi = findViewById(R.id.btnregistrasi);
        btnbatal = findViewById(R.id.btnbatal);

        radiogroupjenis_kelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rblaki = findViewById(R.id.rblaki_laki);
                if (rblaki.isChecked()){
                    rgjeniskelamin = "Laki-Laki";
                }else {
                    rgjeniskelamin = "Perempuan";
                }
            }
        });

        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (RegistrasiActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btnregistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrasi();
            }
        });
    }

    private void registrasi() {

        nama_petugas = etnama_petugas.getText().toString();
        username = etusername.getText().toString();
        password = etpassword.getText().toString();
        no_hp = etno_hp.getText().toString();
        alamat = etalamat.getText().toString();
        jenis_kelamin = rgjeniskelamin;
        status = "non-aktif";

        apiService.surveyorRegistrasi(nama_petugas, username, password, jenis_kelamin, no_hp, alamat, status).enqueue(new Callback<ResponseRegistrasi>() {
            @Override
            public void onResponse(Call<ResponseRegistrasi> call, Response<ResponseRegistrasi> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode().equals("200")) {
                        String nama_petugas = response.body().getSurveyor().getNamaPetugas();
                        String username = response.body().getSurveyor().getUsername();
                        String password = response.body().getSurveyor().getPassword();
                        String no_hp = response.body().getSurveyor().getNoHp();
                        String alamat = response.body().getSurveyor().getAlamat();
                        String jenis_kelamin = response.body().getSurveyor().getJenisKelamin();
                        String status = response.body().getSurveyor().getStatus();

                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(RegistrasiActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseRegistrasi> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal konek ke server", Toast.LENGTH_LONG).show();
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }
}
