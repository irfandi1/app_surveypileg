package com.irfandi.surveypileg.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.irfandi.surveypileg.R;
import com.irfandi.surveypileg.responses.ResponseKabkota;
import com.irfandi.surveypileg.responses.ResponseKecamatan;
import com.irfandi.surveypileg.responses.ResponseKelurahan;
import com.irfandi.surveypileg.rests.ApiClient;
import com.irfandi.surveypileg.rests.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProvinsiActivity extends AppCompatActivity{

    ApiInterface apiService;

    static int m=0;

    CheckBox checkBox,checkBox1;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        setContentView(R.layout.activity_provinsi);

        checkBox = findViewById(R.id.autosave);
        checkBox1 = findViewById(R.id.star);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()){
                    m++;
                }if (checkBox1.isChecked()){
                    m++;
                }
                Toast.makeText(getBaseContext(), "CheckBox is Cheked"+m, Toast.LENGTH_LONG).show();
            }
        });



    }
}
