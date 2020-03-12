package com.irfandi.surveypileg.activities;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.irfandi.surveypileg.responses.ResponseLogin;
import com.irfandi.surveypileg.rests.ApiClient;
import com.irfandi.surveypileg.rests.ApiInterface;
import com.irfandi.surveypileg.utils.AbsRuntimePermission;
import com.irfandi.surveypileg.utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.irfandi.surveypileg.R;

public class LoginActivity extends AbsRuntimePermission {

    EditText etusername;

    EditText etpassword;

    Button btlogin, btndaftar;

    SessionManager sessionManager;
    ApiInterface apiService;

    String username, password;

    final String status = "aktif";

    public final String TAG = LoginActivity.class.getSimpleName();
    private static final int REQUEST_PERMISSION = 10;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etpassword = findViewById(R.id.etpassword);
        etusername = findViewById(R.id.etusername);
        btlogin = findViewById(R.id.btlogin);
        btndaftar = findViewById(R.id.btdaftar);

        // do runtime permission
        //request permission here
        requestAppPermissions(new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.RECORD_AUDIO},
                R.string.msg,REQUEST_PERMISSION);

        //init

        apiService = ApiClient.getClient().create(ApiInterface.class);
        sessionManager = new SessionManager(this);

        if(sessionManager.isLoggedIn()){
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            // agar tidak balik ke activity ini lagi
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(i);
            finish();
        }

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (LoginActivity.this, RegistrasiActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onPermissionGranted(int requestcode) {
        Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_LONG).show();
    }

    private void loginUser() {
        username = etusername.getText().toString();
        password = etpassword.getText().toString();


        Log.d(TAG, "loginUser: " + username +" "+password);
        apiService.surveyorLogin(username, password, status).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: Dapat terhubung ke server");
                    Log.d(TAG, "onResponse: " +response.body().toString());

                    if (response.body().getCode().equalsIgnoreCase("200")){
                        String id_surveyor= response.body().getSurveyor().getIdSurveyor();
                        String nama_petugas = response.body().getSurveyor().getNamaPetugas();
                        String username = response.body().getSurveyor().getUsername();
                        String jenis_kelamin = response.body().getSurveyor().getJenisKelamin();
                        String no_hp = response.body().getSurveyor().getNoHp();
                        String alamat = response.body().getSurveyor().getAlamat();
                        String status = response.body().getSurveyor().getStatus();

                        sessionManager.createLoginSession(id_surveyor,
                                nama_petugas,
                                username,
                                jenis_kelamin,
                                no_hp,
                                alamat, status);

                        Log.d(TAG, "onResponse: Dapat data dosen");

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Toast.makeText(getApplicationContext(), response.body().getMessage().toString(), Toast.LENGTH_LONG).show();
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Gagal login : "+response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal konek ke server", Toast.LENGTH_LONG).show();
                Log.e(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }
}
