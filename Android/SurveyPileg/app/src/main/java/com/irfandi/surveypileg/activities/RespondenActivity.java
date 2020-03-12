package com.irfandi.surveypileg.activities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.irfandi.surveypileg.R;
import com.irfandi.surveypileg.responses.ResponseKabkota;
import com.irfandi.surveypileg.responses.ResponseKecamatan;
import com.irfandi.surveypileg.responses.ResponseKelurahan;
import com.irfandi.surveypileg.responses.ResponseResponden;
import com.irfandi.surveypileg.rests.ApiClient;
import com.irfandi.surveypileg.rests.ApiInterface;
import com.irfandi.surveypileg.utils.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.irfandi.surveypileg.R;

public class RespondenActivity extends AppCompatActivity {

    private static String SESSION_ID_SURVEYOR;
    SessionManager sessionManager;

    ApiInterface apiService;
    LocationManager lm;
    LocationListener locationListener;

    private static final String TAG = RespondenActivity.class.getSimpleName();

    private ArrayList<String> id_kabkota = new ArrayList<>();
    private ArrayList<String> nama_kabkota = new ArrayList<>();

    private ArrayList<Integer> id_kecamatan = new ArrayList<Integer>();
    private ArrayList<String> nama_kecamatan = new ArrayList<>();

    private ArrayList<Integer> id_kelurahan = new ArrayList<Integer>();
    private ArrayList<String> nama_kelurahan = new ArrayList<>();

    private Spinner spinnerkabkota, spinnerkecamatan, spinnerkelurahan;
    TextView tvprovinsi;

    EditText etnama_responden, etalamat, etrt, etrw, etno_hp;

    RadioGroup radiogroup_pertanyaan_12;
    RadioButton radiobutton_pertanyaan_12_ya, radiobutton_pertanyaan_12_tidak, radiobutton_pertanyaan_12_belum_tahu;
    String rg_pertanyaan_12;

    RadioGroup radiogroup_pertanyaan_13;
    RadioButton radiobutton_pertanyaan_13_ya, radiobutton_pertanyaan_13_ragu, radiobutton_pertanyaan_13_tidak;
    String rg_pertanyaan_13;

    RadioGroup radiogroup_pertanyaan_14;
    RadioButton radiobutton_laki, radiobutton_perempuan;
    String jenis_kelamin;

    Spinner spinner_pertanyaan_15, spinner_pertanyaan_16, spinner_pertanyaan_17, spinner_pertanyaan_18, spinner_pertanyaan_19,
            spinner_pertanyaan_20, spinner_pertanyaan_21, spinner_pertanyaan_22, spinner_pertanyaan_23;
    String spinner15, spinner16, spinner17, spinner18, spinner19, spinner20, spinner21, spinner22, spinner23;

    TextView tvpertanyaan_24_1, tvpertanyaan_24_2, tvpertanyaan_24_3, tvpertanyaan_24_4, tvpertanyaan_24_5, tvpertanyaan_24_6,
            tvpertanyaan_24_7;
    Spinner spinner_pertanyaan_24_1, spinner_pertanyaan_24_2, spinner_pertanyaan_24_3, spinner_pertanyaan_24_4,
            spinner_pertanyaan_24_5, spinner_pertanyaan_24_6, spinner_pertanyaan_24_7;
    String spinner24_1, spinner24_2, spinner24_3, spinner24_4, spinner24_5, spinner24_6, spinner24_7;

    CheckBox cbpertanyaan_25_1, cbpertanyaan_25_2, cbpertanyaan_25_3, cbpertanyaan_25_4, cbpertanyaan_25_5,
            cbpertanyaan_25_6, cbpertanyaan_25_7, cbpertanyaan_25_8,cbpertanyaan_25_9, cbpertanyaan_25_10,
            cbpertanyaan_25_11, cbpertanyaan_25_12, cbpertanyaan_25_13, cbpertanyaan_25_14,
            cbpertanyaan_25_15, cbpertanyaan_25_16;

    CheckBox cbpertanyaan_26_1, cbpertanyaan_26_2, cbpertanyaan_26_3, cbpertanyaan_26_4, cbpertanyaan_26_5,
            cbpertanyaan_26_6, cbpertanyaan_26_7, cbpertanyaan_26_8,cbpertanyaan_26_9, cbpertanyaan_26_10,
            cbpertanyaan_26_11, cbpertanyaan_26_12, cbpertanyaan_26_13, cbpertanyaan_26_14,
            cbpertanyaan_26_15, cbpertanyaan_26_16;

    CheckBox cbpertanyaan_27_1, cbpertanyaan_27_2, cbpertanyaan_27_3, cbpertanyaan_27_4, cbpertanyaan_27_5,
            cbpertanyaan_27_6, cbpertanyaan_27_7, cbpertanyaan_27_8,cbpertanyaan_27_9, cbpertanyaan_27_10,
            cbpertanyaan_27_11, cbpertanyaan_27_12, cbpertanyaan_27_13, cbpertanyaan_27_14,
            cbpertanyaan_27_15, cbpertanyaan_27_16;

    CheckBox cbpertanyaan_28_1, cbpertanyaan_28_2, cbpertanyaan_28_3, cbpertanyaan_28_4, cbpertanyaan_28_5,
            cbpertanyaan_28_6, cbpertanyaan_28_7, cbpertanyaan_28_8,cbpertanyaan_28_9, cbpertanyaan_28_10,
            cbpertanyaan_28_11, cbpertanyaan_28_12, cbpertanyaan_28_13, cbpertanyaan_28_14,
            cbpertanyaan_28_15, cbpertanyaan_28_16, cbpertanyaan_28_17;

    RadioGroup radiogroup_pertanyaan_29;
    RadioButton rbpertanyaan_29_1, rbpertanyaan_29_2,rbpertanyaan_29_3, rbpertanyaan_29_4,
            rbpertanyaan_29_5, rbpertanyaan_29_6, rbpertanyaan_29_7, rbpertanyaan_29_8,
            rbpertanyaan_29_9, rbpertanyaan_29_10, rbpertanyaan_29_11, rbpertanyaan_29_12,
            rbpertanyaan_29_13, rbpertanyaan_29_14, rbpertanyaan_29_15, rbpertanyaan_29_16,
            rbpertanyaan_29_17, rbpertanyaan_29_18;
    String rg_pertanyaan_29;

    CheckBox cbpertanyaan_30_1, cbpertanyaan_30_2, cbpertanyaan_30_3, cbpertanyaan_30_4, cbpertanyaan_30_5,
            cbpertanyaan_30_6, cbpertanyaan_30_7, cbpertanyaan_30_8, cbpertanyaan_30_9, cbpertanyaan_30_10;

    TextView tvpartai1,tvpertanyaan_31_1_2;
    CheckBox cbpertanyaan_31_1_1,cbpertanyaan_31_1_2,cbpertanyaan_31_1_3,cbpertanyaan_31_1_4,cbpertanyaan_31_1_5,
             cbpertanyaan_31_1_6, cbpertanyaan_31_1_7;
    TextView tvpartai2,tvpertanyaan_31_2_2;
    CheckBox cbpertanyaan_31_2_1,cbpertanyaan_31_2_2,cbpertanyaan_31_2_3,cbpertanyaan_31_2_4,cbpertanyaan_31_2_5,
            cbpertanyaan_31_2_6, cbpertanyaan_31_2_7;
    TextView tvpartai3,tvpertanyaan_31_3_2;
    CheckBox cbpertanyaan_31_3_1,cbpertanyaan_31_3_2,cbpertanyaan_31_3_3,cbpertanyaan_31_3_4,cbpertanyaan_31_3_5,
            cbpertanyaan_31_3_6, cbpertanyaan_31_3_7;
    TextView tvpartai4,tvpertanyaan_31_4_2;
    CheckBox cbpertanyaan_31_4_1,cbpertanyaan_31_4_2,cbpertanyaan_31_4_3,cbpertanyaan_31_4_4,cbpertanyaan_31_4_5,
            cbpertanyaan_31_4_6, cbpertanyaan_31_4_7;
    TextView tvpartai5,tvpertanyaan_31_5_2;
    CheckBox cbpertanyaan_31_5_1,cbpertanyaan_31_5_2,cbpertanyaan_31_5_3,cbpertanyaan_31_5_4,cbpertanyaan_31_5_5,
            cbpertanyaan_31_5_6, cbpertanyaan_31_5_7;
    TextView tvpartai6,tvpertanyaan_31_6_2;
    CheckBox cbpertanyaan_31_6_1,cbpertanyaan_31_6_2;
    TextView tvpartai7,tvpertanyaan_31_7_2;
    CheckBox cbpertanyaan_31_7_1,cbpertanyaan_31_7_2,cbpertanyaan_31_7_3,cbpertanyaan_31_7_4,cbpertanyaan_31_7_5,
            cbpertanyaan_31_7_6, cbpertanyaan_31_7_7;
    TextView tvpartai8,tvpertanyaan_31_8_2;
    CheckBox cbpertanyaan_31_8_1,cbpertanyaan_31_8_2,cbpertanyaan_31_8_3,cbpertanyaan_31_8_4,cbpertanyaan_31_8_5,
            cbpertanyaan_31_8_6, cbpertanyaan_31_8_7;
    TextView tvpartai9,tvpertanyaan_31_9_2;
    CheckBox cbpertanyaan_31_9_1,cbpertanyaan_31_9_2,cbpertanyaan_31_9_3,cbpertanyaan_31_9_4,cbpertanyaan_31_9_5,
            cbpertanyaan_31_9_6, cbpertanyaan_31_9_7;
    TextView tvpartai10,tvpertanyaan_31_10_2;
    CheckBox cbpertanyaan_31_10_1,cbpertanyaan_31_10_2,cbpertanyaan_31_10_3,cbpertanyaan_31_10_4,cbpertanyaan_31_10_5,
            cbpertanyaan_31_10_6, cbpertanyaan_31_10_7;
    TextView tvpartai11,tvpertanyaan_31_11_2;
    CheckBox cbpertanyaan_31_11_1,cbpertanyaan_31_11_2,cbpertanyaan_31_11_3,cbpertanyaan_31_11_4,cbpertanyaan_31_11_5,
            cbpertanyaan_31_11_6, cbpertanyaan_31_11_7;
    TextView tvpartai12,tvpertanyaan_31_12_2;
    CheckBox cbpertanyaan_31_12_1,cbpertanyaan_31_12_2,cbpertanyaan_31_12_3,cbpertanyaan_31_12_4,cbpertanyaan_31_12_5,
            cbpertanyaan_31_12_6, cbpertanyaan_31_12_7;
    TextView tvpartai13,tvpertanyaan_31_13_2;
    CheckBox cbpertanyaan_31_13_1,cbpertanyaan_31_13_2,cbpertanyaan_31_13_3,cbpertanyaan_31_13_4,cbpertanyaan_31_13_5;
    TextView tvpartai14,tvpertanyaan_31_14_2;
    CheckBox cbpertanyaan_31_14_1,cbpertanyaan_31_14_2,cbpertanyaan_31_14_3,cbpertanyaan_31_14_4,cbpertanyaan_31_14_5,
            cbpertanyaan_31_14_6, cbpertanyaan_31_14_7;
    TextView tvpartai19,tvpertanyaan_31_19_2;
    CheckBox cbpertanyaan_31_19_1,cbpertanyaan_31_19_2,cbpertanyaan_31_19_3,cbpertanyaan_31_19_4,cbpertanyaan_31_19_5,
            cbpertanyaan_31_19_6, cbpertanyaan_31_19_7;
    TextView tvpartai20,tvpertanyaan_31_20_2;
    CheckBox cbpertanyaan_31_20_1;


    CheckBox cbpertanyaan_32_1, cbpertanyaan_32_2, cbpertanyaan_32_3, cbpertanyaan_32_4, cbpertanyaan_32_5,
            cbpertanyaan_32_6, cbpertanyaan_32_7;

    //dpr ri
    TextView tvpertanyaan_33_1;
    TextView tvpertanyaan_33_1_1;//    no urut partai
    Spinner spinner_pertanyaan_33_1_1;
    String spinner33_1_1;
    TextView tvpertanyaan_33_1_2;//no urut caleg
    Spinner spinner_pertanyaan_33_1_2;
    String spinner33_1_2;

    //dpr provinsi
    TextView tvpertanyaan_33_2;
    TextView tvpertanyaan_33_2_1;//    no urut partai
    Spinner spinner_pertanyaan_33_2_1;
    String spinner33_2_1;
    TextView tvpertanyaan_33_2_2; //no urut caleg
    Spinner spinner_pertanyaan_33_2_2;
    String spinner33_2_2;

    //dpr kabkota
    TextView tvpertanyaan_33_3;
    TextView tvpertanyaan_33_3_1;//    no urut partai
    Spinner spinner_pertanyaan_33_3_1;
    String spinner33_3_1;
    TextView tvpertanyaan_33_3_2;   //no urut caleg
    Spinner spinner_pertanyaan_33_3_2;
    String spinner33_3_2;

    //    dpd
    TextView tvpertanyaan_33_4, tvpertanyaan_33_4_1;
    Spinner spinner_pertanyaan_33_4_1;
    String spinner33_4_1;

    CheckBox cbpertanyaan_34_1, cbpertanyaan_34_2, cbpertanyaan_34_3, cbpertanyaan_34_4, cbpertanyaan_34_5,
            cbpertanyaan_34_6, cbpertanyaan_34_7, cbpertanyaan_34_8;

    CheckBox cbpertanyaan_35_1, cbpertanyaan_35_2, cbpertanyaan_35_3, cbpertanyaan_35_4, cbpertanyaan_35_5,
            cbpertanyaan_35_6, cbpertanyaan_35_7, cbpertanyaan_35_8;

    CheckBox cbpertanyaan_36_1, cbpertanyaan_36_2, cbpertanyaan_36_3, cbpertanyaan_36_4, cbpertanyaan_36_5,
            cbpertanyaan_36_6, cbpertanyaan_36_7, cbpertanyaan_36_8, cbpertanyaan_36_9, cbpertanyaan_36_10,
            cbpertanyaan_36_11, cbpertanyaan_36_12;

    CheckBox cbpertanyaan_37_1, cbpertanyaan_37_2, cbpertanyaan_37_3, cbpertanyaan_37_4, cbpertanyaan_37_5,
            cbpertanyaan_37_6;

    Spinner spinner_pertanyaan_38;
    String spinner38;

    RadioGroup radiogroup_pertanyaan_39;
    RadioButton radiobutton_pertanyaan_39_1, radiobutton_pertanyaan_39_2, radiobutton_pertanyaan_39_3,
            radiobutton_pertanyaan_39_4;
    String rg_pertanyaan_39;

    CheckBox cbpertanyaan_40_1, cbpertanyaan_40_2, cbpertanyaan_40_3, cbpertanyaan_40_4, cbpertanyaan_40_5,
            cbpertanyaan_40_6, cbpertanyaan_40_7, cbpertanyaan_40_8,cbpertanyaan_40_9, cbpertanyaan_40_10;


    TextView tvlat, tvlang;
    Button btnsubmit;

    String nama_responden, alamat, provinsi, kab_kota, kecamatan, kel_desa, rt, rw, no_hp,
            pertanyaan_12, pertanyaan_13, pertanyaan_14, pertanyaan_15, pertanyaan_16, pertanyaan_17,
            pertanyaan_18, pertanyaan_19, pertanyaan_20, pertanyaan_21, pertanyaan_22, pertanyaan_23, pertanyaan_24, pertanyaan_25,
            pertanyaan_26, pertanyaan_27, pertanyaan_28, pertanyaan_29, pertanyaan_30, pertanyaan_31, pertanyaan_32, pertanyaan_33,
            pertanyaan_34, pertanyaan_35, pertanyaan_36, pertanyaan_37, pertanyaan_38, pertanyaan_39, pertanyaan_40, lat,
            lang;


    //=========================================== Location Based Manager ========================================================================
    public class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            if (location != null) {
//                Toast.makeText(getBaseContext(), "Location Change : Lat :" + location.getLatitude() +
//                        "lang : " + location.getLongitude(), Toast.LENGTH_SHORT).show();
                tvlat.setText(String.valueOf(location.getLatitude()));
                tvlang.setText(String.valueOf(location.getLongitude()));
//                etlat.setText(String.valueOf(location.getLatitude()));
//                etlang.setText(String.valueOf(location.getLongitude()));
            }
        }

        @Override
        public void onProviderEnabled(String provider) {
//            Toast.makeText(getBaseContext(), "Provider : " + provider + " enable",
//                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
//            Toast.makeText(getBaseContext(), "Provider : " + provider + " disable",
//                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
//            String statusString = "";
//            switch (status) {
//                case LocationProvider.AVAILABLE:
//                    statusString = "availabe";
//                case LocationProvider.OUT_OF_SERVICE:
//                    statusString = "out of service";
//                case LocationProvider.TEMPORARILY_UNAVAILABLE:
//                    statusString = "temporarily unavailable";
//            }
//            Toast.makeText(getBaseContext(), provider + " " + statusString, Toast.LENGTH_SHORT).show();
        }
    }
//================================================  END Location Based Manager ================================================================


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responden);

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new RespondenActivity.MyLocationListener();

        sessionManager = new SessionManager(this);
        SESSION_ID_SURVEYOR = sessionManager.getSurveyorDetail().get(SessionManager.ID_SURVEYOR);
        apiService = ApiClient.getClient().create(ApiInterface.class);

        getKabkota();

        etnama_responden = findViewById(R.id.etnama_responden);
        etalamat = findViewById(R.id.etalamat);
        etrt = findViewById(R.id.etrt);
        etrw = findViewById(R.id.etrw);
        etno_hp = findViewById(R.id.etno_hp);

        tvprovinsi = findViewById(R.id.tvprovinsi);
        spinnerkabkota = findViewById(R.id.spinnerkabkota);
        spinnerkecamatan = findViewById(R.id.spinnerkecamatan);
        spinnerkelurahan = findViewById(R.id.spinnerkelurahan);
//================================================== Pertanyaan ==========================================================================

        // Radio Group dan Radio Button Pertanyaan 12
        radiogroup_pertanyaan_12 = findViewById(R.id.radio_group_pertanyaan_12);
        radiobutton_pertanyaan_12_ya = findViewById(R.id.radiobutton_pertanyaan_12_ya);
        radiobutton_pertanyaan_12_tidak = findViewById(R.id.radiobutton_pertanyaan_12_tidak);
        radiobutton_pertanyaan_12_belum_tahu = findViewById(R.id.radiobutton_pertanyaan_12_belum_tahu);

        radiogroup_pertanyaan_12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int option = radiogroup_pertanyaan_12.getCheckedRadioButtonId();
                switch (option) {
                    case R.id.radiobutton_pertanyaan_12_ya:
                        rg_pertanyaan_12 = "Ya";
                        break;
                    case R.id.radiobutton_pertanyaan_12_tidak:
                        Intent a = new Intent(RespondenActivity.this, MainActivity.class);
                        startActivity(a);
                        break;
                    case R.id.radiobutton_pertanyaan_12_belum_tahu:
                        rg_pertanyaan_12 = "Belum Tahu";
                        break;
                }
            }
        });
        // END Radio Group dan Radio Button Pertanyaan 12

        // Radio Group dan Radio Button Pertanyaan 13
        radiogroup_pertanyaan_13 = findViewById(R.id.radio_group_pertanyaan_13);
        radiobutton_pertanyaan_13_ya = findViewById(R.id.radiobutton_pertanyaan_13_ya);
        radiobutton_pertanyaan_13_ragu = findViewById(R.id.radiobutton_pertanyaan_13_ragu);
        radiobutton_pertanyaan_13_tidak = findViewById(R.id.radiobutton_pertanyaan_13_tidak);

        radiogroup_pertanyaan_13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int option = radiogroup_pertanyaan_13.getCheckedRadioButtonId();
                switch (option) {
                    case R.id.radiobutton_pertanyaan_13_ya:
                        rg_pertanyaan_13 = "Ya";
                        break;
                    case R.id.radiobutton_pertanyaan_13_ragu:
                        rg_pertanyaan_13 = "Ragu-Ragu";
                        break;
                    case R.id.radiobutton_pertanyaan_13_tidak:
                        Intent a = new Intent(RespondenActivity.this, MainActivity.class);
                        startActivity(a);
                        break;
                }
            }
        });
        // END Radio Group dan Radio Button Pertanyaan 13

        // Radio Group dan Radio Button Jenis Kelamin 14
        radiogroup_pertanyaan_14 = findViewById(R.id.radio_group_pertanyaan_14);
        radiobutton_laki = findViewById(R.id.radiobutton_laki_laki);
        radiobutton_perempuan = findViewById(R.id.radiobutton_perempuan);

        radiogroup_pertanyaan_14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int option = radiogroup_pertanyaan_14.getCheckedRadioButtonId();
                switch (option) {
                    case R.id.radiobutton_laki_laki:
                        jenis_kelamin = "Laki-laki";
                        break;
                    case R.id.radiobutton_perempuan:
                        jenis_kelamin = "Perempuan";
                        break;
                }
            }
        });
        // End Radio Group dan Radio Button Jenis Kelamin 14

        // Spinner pertanyaan 15
        spinner_pertanyaan_15 = findViewById(R.id.spinner_pertanyaan_15);

        spinner_pertanyaan_15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_15);
                spinner15 = String.valueOf(size_values);
                spinner15 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 15

        // Spinner pertanyaan 16
        spinner_pertanyaan_16 = findViewById(R.id.spinner_pertanyaan_16);

        spinner_pertanyaan_16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_16);
                spinner16 = String.valueOf(size_values);
                spinner16 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 16

        // Spinner pertanyaan 17
        spinner_pertanyaan_17 = findViewById(R.id.spinner_pertanyaan_17);

        spinner_pertanyaan_17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_17);
                spinner17 = String.valueOf(size_values);
                spinner17 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 17

        // Spinner pertanyaan 18
        spinner_pertanyaan_18 = findViewById(R.id.spinner_pertanyaan_18);

        spinner_pertanyaan_18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_18);
                spinner18 = String.valueOf(size_values);
                spinner18 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 18

        // Spinner pertanyaan 19
        spinner_pertanyaan_19 = findViewById(R.id.spinner_pertanyaan_19);

        spinner_pertanyaan_19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_19);
                spinner19 = String.valueOf(size_values);
                spinner19 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 19

        // Spinner pertanyaan 20
        spinner_pertanyaan_20 = findViewById(R.id.spinner_pertanyaan_20);

        spinner_pertanyaan_20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_20);
                spinner20 = String.valueOf(size_values);
                spinner20 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 20

        // Spinner pertanyaan 21
        spinner_pertanyaan_21 = findViewById(R.id.spinner_pertanyaan_21);

        spinner_pertanyaan_21.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_21);
                spinner21 = String.valueOf(size_values);
                spinner21 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 21

        // Spinner pertanyaan 22
        spinner_pertanyaan_22 = findViewById(R.id.spinner_pertanyaan_22);

        spinner_pertanyaan_22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_22);
                spinner22 = String.valueOf(size_values);
                spinner22 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 22

        // Spinner pertanyaan 23
        spinner_pertanyaan_23 = findViewById(R.id.spinner_pertanyaan_23);

        spinner_pertanyaan_23.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_23);
                spinner23 = String.valueOf(size_values);
                spinner23 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 23

        //========================================== pertanyaan 24 =====================================================================
        tvpertanyaan_24_1 = findViewById(R.id.tvpertanyaan_24_1);
        tvpertanyaan_24_2 = findViewById(R.id.tvpertanyaan_24_2);
        tvpertanyaan_24_3 = findViewById(R.id.tvpertanyaan_24_3);
        tvpertanyaan_24_4 = findViewById(R.id.tvpertanyaan_24_4);
        tvpertanyaan_24_5 = findViewById(R.id.tvpertanyaan_24_5);
        tvpertanyaan_24_6 = findViewById(R.id.tvpertanyaan_24_6);
        tvpertanyaan_24_7 = findViewById(R.id.tvpertanyaan_24_7);

        spinner_pertanyaan_24_1 = findViewById(R.id.spinner_pertanyaan_24_1);
        spinner_pertanyaan_24_2 = findViewById(R.id.spinner_pertanyaan_24_2);
        spinner_pertanyaan_24_3 = findViewById(R.id.spinner_pertanyaan_24_3);
        spinner_pertanyaan_24_4 = findViewById(R.id.spinner_pertanyaan_24_4);
        spinner_pertanyaan_24_5 = findViewById(R.id.spinner_pertanyaan_24_5);
        spinner_pertanyaan_24_6 = findViewById(R.id.spinner_pertanyaan_24_6);
        spinner_pertanyaan_24_7 = findViewById(R.id.spinner_pertanyaan_24_7);

        spinner_pertanyaan_24_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24_1 = String.valueOf(size_values);
                spinner24_1 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_pertanyaan_24_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24_2 = String.valueOf(size_values);
                spinner24_2 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_24_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24_3 = String.valueOf(size_values);
                spinner24_3 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_24_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24_4 = String.valueOf(size_values);
                spinner24_4 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_24_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24_5 = String.valueOf(size_values);
                spinner24_5 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_24_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24_6 = String.valueOf(size_values);
                spinner24_6 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_24_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24_7 = String.valueOf(size_values);
                spinner24_7 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //========================================= END pertanyaan 24 ================================================================

        // ================================================= CheckBox 25 ============================================================
        cbpertanyaan_25_1 = findViewById(R.id.cbpertanyaan_25_1);
        cbpertanyaan_25_2 = findViewById(R.id.cbpertanyaan_25_2);
        cbpertanyaan_25_3 = findViewById(R.id.cbpertanyaan_25_3);
        cbpertanyaan_25_4 = findViewById(R.id.cbpertanyaan_25_4);
        cbpertanyaan_25_5 = findViewById(R.id.cbpertanyaan_25_5);
        cbpertanyaan_25_6 = findViewById(R.id.cbpertanyaan_25_6);
        cbpertanyaan_25_7 = findViewById(R.id.cbpertanyaan_25_7);
        cbpertanyaan_25_8 = findViewById(R.id.cbpertanyaan_25_8);
        cbpertanyaan_25_9 = findViewById(R.id.cbpertanyaan_25_9);
        cbpertanyaan_25_10 = findViewById(R.id.cbpertanyaan_25_10);
        cbpertanyaan_25_11 = findViewById(R.id.cbpertanyaan_25_11);
        cbpertanyaan_25_12 = findViewById(R.id.cbpertanyaan_25_12);
        cbpertanyaan_25_13 = findViewById(R.id.cbpertanyaan_25_13);
        cbpertanyaan_25_14 = findViewById(R.id.cbpertanyaan_25_14);
        cbpertanyaan_25_15 = findViewById(R.id.cbpertanyaan_25_15);
        cbpertanyaan_25_16 = findViewById(R.id.cbpertanyaan_25_16);
        // =========================================== End Checkbox pertanyaan 25 ==============================================================

        // Spinner pertanyaan 26
        cbpertanyaan_26_1 = findViewById(R.id.cbpertanyaan_26_1);
        cbpertanyaan_26_2 = findViewById(R.id.cbpertanyaan_26_2);
        cbpertanyaan_26_3 = findViewById(R.id.cbpertanyaan_26_3);
        cbpertanyaan_26_4 = findViewById(R.id.cbpertanyaan_26_4);
        cbpertanyaan_26_5 = findViewById(R.id.cbpertanyaan_26_5);
        cbpertanyaan_26_6 = findViewById(R.id.cbpertanyaan_26_6);
        cbpertanyaan_26_7 = findViewById(R.id.cbpertanyaan_26_7);
        cbpertanyaan_26_8 = findViewById(R.id.cbpertanyaan_26_8);
        cbpertanyaan_26_9 = findViewById(R.id.cbpertanyaan_26_9);
        cbpertanyaan_26_10 = findViewById(R.id.cbpertanyaan_26_10);
        cbpertanyaan_26_11 = findViewById(R.id.cbpertanyaan_26_11);
        cbpertanyaan_26_12 = findViewById(R.id.cbpertanyaan_26_12);
        cbpertanyaan_26_13 = findViewById(R.id.cbpertanyaan_26_13);
        cbpertanyaan_26_14 = findViewById(R.id.cbpertanyaan_26_14);
        cbpertanyaan_26_15 = findViewById(R.id.cbpertanyaan_26_15);
        cbpertanyaan_26_16 = findViewById(R.id.cbpertanyaan_26_16);
        // END Spinner pertanyaan 26

        // ================================================= CheckBox 27 ============================================================
        cbpertanyaan_27_1 = findViewById(R.id.cbpertanyaan_27_1);
        cbpertanyaan_27_2 = findViewById(R.id.cbpertanyaan_27_2);
        cbpertanyaan_27_3 = findViewById(R.id.cbpertanyaan_27_3);
        cbpertanyaan_27_4 = findViewById(R.id.cbpertanyaan_27_4);
        cbpertanyaan_27_5 = findViewById(R.id.cbpertanyaan_27_5);
        cbpertanyaan_27_6 = findViewById(R.id.cbpertanyaan_27_6);
        cbpertanyaan_27_7 = findViewById(R.id.cbpertanyaan_27_7);
        cbpertanyaan_27_8 = findViewById(R.id.cbpertanyaan_27_8);
        cbpertanyaan_27_9 = findViewById(R.id.cbpertanyaan_27_9);
        cbpertanyaan_27_10 = findViewById(R.id.cbpertanyaan_27_10);
        cbpertanyaan_27_11 = findViewById(R.id.cbpertanyaan_27_11);
        cbpertanyaan_27_12 = findViewById(R.id.cbpertanyaan_27_12);
        cbpertanyaan_27_13 = findViewById(R.id.cbpertanyaan_27_13);
        cbpertanyaan_27_14 = findViewById(R.id.cbpertanyaan_27_14);
        cbpertanyaan_27_15 = findViewById(R.id.cbpertanyaan_27_15);
        cbpertanyaan_27_16 = findViewById(R.id.cbpertanyaan_27_16);
        // =========================================== End Checkbox pertanyaan 27 ==============================================================

        // ================================================= CheckBox 28 ============================================================
        cbpertanyaan_28_1 = findViewById(R.id.cbpertanyaan_28_1);
        cbpertanyaan_28_2 = findViewById(R.id.cbpertanyaan_28_2);
        cbpertanyaan_28_3 = findViewById(R.id.cbpertanyaan_28_3);
        cbpertanyaan_28_4 = findViewById(R.id.cbpertanyaan_28_4);
        cbpertanyaan_28_5 = findViewById(R.id.cbpertanyaan_28_5);
        cbpertanyaan_28_6 = findViewById(R.id.cbpertanyaan_28_6);
        cbpertanyaan_28_7 = findViewById(R.id.cbpertanyaan_28_7);
        cbpertanyaan_28_8 = findViewById(R.id.cbpertanyaan_28_8);
        cbpertanyaan_28_9 = findViewById(R.id.cbpertanyaan_28_9);
        cbpertanyaan_28_10 = findViewById(R.id.cbpertanyaan_28_10);
        cbpertanyaan_28_11 = findViewById(R.id.cbpertanyaan_28_11);
        cbpertanyaan_28_12 = findViewById(R.id.cbpertanyaan_28_12);
        cbpertanyaan_28_13 = findViewById(R.id.cbpertanyaan_28_13);
        cbpertanyaan_28_14 = findViewById(R.id.cbpertanyaan_28_14);
        cbpertanyaan_28_15 = findViewById(R.id.cbpertanyaan_28_15);
        cbpertanyaan_28_16 = findViewById(R.id.cbpertanyaan_28_16);
        cbpertanyaan_28_17 = findViewById(R.id.cbpertanyaan_28_17);
        // =========================================== End Checkbox pertanyaan 28 ==============================================================

        // ================================================= Radio Button 29 ============================================================
        radiogroup_pertanyaan_29 = findViewById(R.id.radiogroup_pertanyaan_29);
        rbpertanyaan_29_1 = findViewById(R.id.rbpertanyaan_29_1);
        rbpertanyaan_29_2 = findViewById(R.id.rbpertanyaan_29_2);
        rbpertanyaan_29_3 = findViewById(R.id.rbpertanyaan_29_3);
        rbpertanyaan_29_4 = findViewById(R.id.rbpertanyaan_29_4);
        rbpertanyaan_29_5 = findViewById(R.id.rbpertanyaan_29_5);
        rbpertanyaan_29_6 = findViewById(R.id.rbpertanyaan_29_6);
        rbpertanyaan_29_7 = findViewById(R.id.rbpertanyaan_29_7);
        rbpertanyaan_29_8 = findViewById(R.id.rbpertanyaan_29_8);
        rbpertanyaan_29_9 = findViewById(R.id.rbpertanyaan_29_9);
        rbpertanyaan_29_10 = findViewById(R.id.rbpertanyaan_29_10);
        rbpertanyaan_29_11 = findViewById(R.id.rbpertanyaan_29_11);
        rbpertanyaan_29_12 = findViewById(R.id.rbpertanyaan_29_12);
        rbpertanyaan_29_13 = findViewById(R.id.rbpertanyaan_29_13);
        rbpertanyaan_29_14 = findViewById(R.id.rbpertanyaan_29_14);
        rbpertanyaan_29_15 = findViewById(R.id.rbpertanyaan_29_15);
        rbpertanyaan_29_16 = findViewById(R.id.rbpertanyaan_29_16);
        rbpertanyaan_29_17 = findViewById(R.id.rbpertanyaan_29_17);
        rbpertanyaan_29_18 = findViewById(R.id.rbpertanyaan_29_18);

        radiogroup_pertanyaan_29.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbpertanyaan_29_1.isChecked()){
                    rg_pertanyaan_29 = "PKB";
                }
                if (rbpertanyaan_29_2.isChecked()){
                    rg_pertanyaan_29 = "GERINDA";
                }
                if (rbpertanyaan_29_3.isChecked()){
                    rg_pertanyaan_29 = "PDI Perjuangan";
                }
                if (rbpertanyaan_29_4.isChecked()){
                    rg_pertanyaan_29 = "Golkar";
                }
                if (rbpertanyaan_29_5.isChecked()){
                    rg_pertanyaan_29 = "NASDEM";
                }
                if (rbpertanyaan_29_6.isChecked()){
                    rg_pertanyaan_29 = "Partai Garuda";
                }
                if (rbpertanyaan_29_7.isChecked()){
                    rg_pertanyaan_29 = "Partai Berkaya";
                }
                if (rbpertanyaan_29_8.isChecked()){
                    rg_pertanyaan_29 = "PKS";
                }
                if (rbpertanyaan_29_9.isChecked()){
                    rg_pertanyaan_29 = "PERINDO";
                }
                if (rbpertanyaan_29_10.isChecked()){
                    rg_pertanyaan_29 = "PPP";
                }
                if (rbpertanyaan_29_11.isChecked()){
                    rg_pertanyaan_29 = "PSI";
                }
                if (rbpertanyaan_29_12.isChecked()){
                    rg_pertanyaan_29 = "PAN";
                }if (rbpertanyaan_29_13.isChecked()){
                    rg_pertanyaan_29 = "HANURA";
                }if (rbpertanyaan_29_14.isChecked()){
                    rg_pertanyaan_29 = "DEMOKRAT";
                }if (rbpertanyaan_29_15.isChecked()){
                    rg_pertanyaan_29 = "PBB";
                }if (rbpertanyaan_29_16.isChecked()) {
                    rg_pertanyaan_29 = "PKP Indonesia";
                }if (rbpertanyaan_29_17.isChecked()) {
                    rg_pertanyaan_29 = "Belum menentukan pilihan";
                }if (rbpertanyaan_29_18.isChecked()) {
                    rg_pertanyaan_29 = "Tidak mau menyebutkan pilihan";
                }
            }
        });
        // =============================================== END Radio Button 29 ============================================================

        // ================================================= CheckBox 30 ============================================================
        cbpertanyaan_30_1 = findViewById(R.id.cbpertanyaan_30_1);
        cbpertanyaan_30_2 = findViewById(R.id.cbpertanyaan_30_2);
        cbpertanyaan_30_3 = findViewById(R.id.cbpertanyaan_30_3);
        cbpertanyaan_30_4 = findViewById(R.id.cbpertanyaan_30_4);
        cbpertanyaan_30_5 = findViewById(R.id.cbpertanyaan_30_5);
        cbpertanyaan_30_6 = findViewById(R.id.cbpertanyaan_30_6);
        cbpertanyaan_30_7 = findViewById(R.id.cbpertanyaan_30_7);
        cbpertanyaan_30_8 = findViewById(R.id.cbpertanyaan_30_8);
        cbpertanyaan_30_9 = findViewById(R.id.cbpertanyaan_30_9);
        cbpertanyaan_30_10 = findViewById(R.id.cbpertanyaan_30_10);
        // =========================================== End Checkbox pertanyaan 30 ====================================================

        //========================================== pertanyaan 31 =====================================================================
        tvpartai1 = findViewById(R.id.tvpartai1);
        tvpertanyaan_31_1_2 = findViewById(R.id.tvpertanyaan_31_1_2);
        tvpartai2 = findViewById(R.id.tvpartai2);
        tvpertanyaan_31_2_2 = findViewById(R.id.tvpertanyaan_31_2_2);
        tvpartai3 = findViewById(R.id.tvpartai3);
        tvpertanyaan_31_3_2 = findViewById(R.id.tvpertanyaan_31_3_2);
        tvpartai4 = findViewById(R.id.tvpartai4);
        tvpertanyaan_31_4_2 = findViewById(R.id.tvpertanyaan_31_4_2);
        tvpartai5 = findViewById(R.id.tvpartai5);
        tvpertanyaan_31_5_2 = findViewById(R.id.tvpertanyaan_31_5_2);
        tvpartai6 = findViewById(R.id.tvpartai6);
        tvpertanyaan_31_6_2 = findViewById(R.id.tvpertanyaan_31_6_2);
        tvpartai7 = findViewById(R.id.tvpartai7);
        tvpertanyaan_31_7_2 = findViewById(R.id.tvpertanyaan_31_7_2);
        tvpartai8 = findViewById(R.id.tvpartai8);
        tvpertanyaan_31_8_2 = findViewById(R.id.tvpertanyaan_31_8_2);
        tvpartai9 = findViewById(R.id.tvpartai9);
        tvpertanyaan_31_9_2 = findViewById(R.id.tvpertanyaan_31_9_2);
        tvpartai10 = findViewById(R.id.tvpartai10);
        tvpertanyaan_31_10_2 = findViewById(R.id.tvpertanyaan_31_10_2);
        tvpartai11 = findViewById(R.id.tvpartai11);
        tvpertanyaan_31_11_2 = findViewById(R.id.tvpertanyaan_31_11_2);
        tvpartai12 = findViewById(R.id.tvpartai12);
        tvpertanyaan_31_12_2 = findViewById(R.id.tvpertanyaan_31_12_2);
        tvpartai13 = findViewById(R.id.tvpartai13);
        tvpertanyaan_31_13_2 = findViewById(R.id.tvpertanyaan_31_13_2);
        tvpartai14 = findViewById(R.id.tvpartai14);
        tvpertanyaan_31_14_2 = findViewById(R.id.tvpertanyaan_31_14_2);
        tvpartai19 = findViewById(R.id.tvpartai19);
        tvpertanyaan_31_19_2 = findViewById(R.id.tvpertanyaan_31_19_2);
        tvpartai20 = findViewById(R.id.tvpartai20);
        tvpertanyaan_31_20_2 = findViewById(R.id.tvpertanyaan_31_20_2);

        cbpertanyaan_31_1_1 = findViewById(R.id.cbpertanyaan_31_1_1);
        cbpertanyaan_31_1_2 = findViewById(R.id.cbpertanyaan_31_1_2);
        cbpertanyaan_31_1_3 = findViewById(R.id.cbpertanyaan_31_1_3);
        cbpertanyaan_31_1_4 = findViewById(R.id.cbpertanyaan_31_1_4);
        cbpertanyaan_31_1_5 = findViewById(R.id.cbpertanyaan_31_1_5);
        cbpertanyaan_31_1_6 = findViewById(R.id.cbpertanyaan_31_1_6);
        cbpertanyaan_31_1_7 = findViewById(R.id.cbpertanyaan_31_1_7);

        cbpertanyaan_31_2_1 = findViewById(R.id.cbpertanyaan_31_2_1);
        cbpertanyaan_31_2_2 = findViewById(R.id.cbpertanyaan_31_2_2);
        cbpertanyaan_31_2_3 = findViewById(R.id.cbpertanyaan_31_2_3);
        cbpertanyaan_31_2_4 = findViewById(R.id.cbpertanyaan_31_2_4);
        cbpertanyaan_31_2_5 = findViewById(R.id.cbpertanyaan_31_2_5);
        cbpertanyaan_31_2_6 = findViewById(R.id.cbpertanyaan_31_2_6);
        cbpertanyaan_31_2_7 = findViewById(R.id.cbpertanyaan_31_2_7);

        cbpertanyaan_31_3_1 = findViewById(R.id.cbpertanyaan_31_3_1);
        cbpertanyaan_31_3_2 = findViewById(R.id.cbpertanyaan_31_3_2);
        cbpertanyaan_31_3_3 = findViewById(R.id.cbpertanyaan_31_3_3);
        cbpertanyaan_31_3_4 = findViewById(R.id.cbpertanyaan_31_3_4);
        cbpertanyaan_31_3_5 = findViewById(R.id.cbpertanyaan_31_3_5);
        cbpertanyaan_31_3_6 = findViewById(R.id.cbpertanyaan_31_3_6);
        cbpertanyaan_31_3_7 = findViewById(R.id.cbpertanyaan_31_3_7);

        cbpertanyaan_31_4_1 = findViewById(R.id.cbpertanyaan_31_4_1);
        cbpertanyaan_31_4_2 = findViewById(R.id.cbpertanyaan_31_4_2);
        cbpertanyaan_31_4_3 = findViewById(R.id.cbpertanyaan_31_4_3);
        cbpertanyaan_31_4_4 = findViewById(R.id.cbpertanyaan_31_4_4);
        cbpertanyaan_31_4_5 = findViewById(R.id.cbpertanyaan_31_4_5);
        cbpertanyaan_31_4_6 = findViewById(R.id.cbpertanyaan_31_4_6);
        cbpertanyaan_31_4_7 = findViewById(R.id.cbpertanyaan_31_4_7);

        cbpertanyaan_31_5_1 = findViewById(R.id.cbpertanyaan_31_5_1);
        cbpertanyaan_31_5_2 = findViewById(R.id.cbpertanyaan_31_5_2);
        cbpertanyaan_31_5_3 = findViewById(R.id.cbpertanyaan_31_5_3);
        cbpertanyaan_31_5_4 = findViewById(R.id.cbpertanyaan_31_5_4);
        cbpertanyaan_31_5_5 = findViewById(R.id.cbpertanyaan_31_5_5);
        cbpertanyaan_31_5_6 = findViewById(R.id.cbpertanyaan_31_5_6);
        cbpertanyaan_31_5_7 = findViewById(R.id.cbpertanyaan_31_5_7);

        cbpertanyaan_31_6_1 = findViewById(R.id.cbpertanyaan_31_6_1);
        cbpertanyaan_31_6_2 = findViewById(R.id.cbpertanyaan_31_6_2);

        cbpertanyaan_31_7_1 = findViewById(R.id.cbpertanyaan_31_7_1);
        cbpertanyaan_31_7_2 = findViewById(R.id.cbpertanyaan_31_7_2);
        cbpertanyaan_31_7_3 = findViewById(R.id.cbpertanyaan_31_7_3);
        cbpertanyaan_31_7_4 = findViewById(R.id.cbpertanyaan_31_7_4);
        cbpertanyaan_31_7_5 = findViewById(R.id.cbpertanyaan_31_7_5);
        cbpertanyaan_31_7_6 = findViewById(R.id.cbpertanyaan_31_7_6);
        cbpertanyaan_31_7_7 = findViewById(R.id.cbpertanyaan_31_7_7);

        cbpertanyaan_31_8_1 = findViewById(R.id.cbpertanyaan_31_8_1);
        cbpertanyaan_31_8_2 = findViewById(R.id.cbpertanyaan_31_8_2);
        cbpertanyaan_31_8_3 = findViewById(R.id.cbpertanyaan_31_8_3);
        cbpertanyaan_31_8_4 = findViewById(R.id.cbpertanyaan_31_8_4);
        cbpertanyaan_31_8_5 = findViewById(R.id.cbpertanyaan_31_8_5);
        cbpertanyaan_31_8_6 = findViewById(R.id.cbpertanyaan_31_8_6);
        cbpertanyaan_31_8_7 = findViewById(R.id.cbpertanyaan_31_8_7);

        cbpertanyaan_31_9_1 = findViewById(R.id.cbpertanyaan_31_9_1);
        cbpertanyaan_31_9_2 = findViewById(R.id.cbpertanyaan_31_9_2);
        cbpertanyaan_31_9_3 = findViewById(R.id.cbpertanyaan_31_9_3);
        cbpertanyaan_31_9_4 = findViewById(R.id.cbpertanyaan_31_9_4);
        cbpertanyaan_31_9_5 = findViewById(R.id.cbpertanyaan_31_9_5);
        cbpertanyaan_31_9_6 = findViewById(R.id.cbpertanyaan_31_9_6);
        cbpertanyaan_31_9_7 = findViewById(R.id.cbpertanyaan_31_9_7);

        cbpertanyaan_31_10_1 = findViewById(R.id.cbpertanyaan_31_10_1);
        cbpertanyaan_31_10_2 = findViewById(R.id.cbpertanyaan_31_10_2);
        cbpertanyaan_31_10_3 = findViewById(R.id.cbpertanyaan_31_10_3);
        cbpertanyaan_31_10_4 = findViewById(R.id.cbpertanyaan_31_10_4);
        cbpertanyaan_31_10_5 = findViewById(R.id.cbpertanyaan_31_10_5);
        cbpertanyaan_31_10_6 = findViewById(R.id.cbpertanyaan_31_10_6);
        cbpertanyaan_31_10_7 = findViewById(R.id.cbpertanyaan_31_10_7);

        cbpertanyaan_31_11_1 = findViewById(R.id.cbpertanyaan_31_11_1);
        cbpertanyaan_31_11_2 = findViewById(R.id.cbpertanyaan_31_11_2);
        cbpertanyaan_31_11_3 = findViewById(R.id.cbpertanyaan_31_11_3);
        cbpertanyaan_31_11_4 = findViewById(R.id.cbpertanyaan_31_11_4);
        cbpertanyaan_31_11_5 = findViewById(R.id.cbpertanyaan_31_11_5);
        cbpertanyaan_31_11_6 = findViewById(R.id.cbpertanyaan_31_11_6);
        cbpertanyaan_31_11_7 = findViewById(R.id.cbpertanyaan_31_11_7);

        cbpertanyaan_31_12_1 = findViewById(R.id.cbpertanyaan_31_12_1);
        cbpertanyaan_31_12_2 = findViewById(R.id.cbpertanyaan_31_12_2);
        cbpertanyaan_31_12_3 = findViewById(R.id.cbpertanyaan_31_12_3);
        cbpertanyaan_31_12_4 = findViewById(R.id.cbpertanyaan_31_12_4);
        cbpertanyaan_31_12_5 = findViewById(R.id.cbpertanyaan_31_12_5);
        cbpertanyaan_31_12_6 = findViewById(R.id.cbpertanyaan_31_12_6);
        cbpertanyaan_31_12_7 = findViewById(R.id.cbpertanyaan_31_12_7);

        cbpertanyaan_31_13_1 = findViewById(R.id.cbpertanyaan_31_13_1);
        cbpertanyaan_31_13_2 = findViewById(R.id.cbpertanyaan_31_13_2);
        cbpertanyaan_31_13_3 = findViewById(R.id.cbpertanyaan_31_13_3);
        cbpertanyaan_31_13_4 = findViewById(R.id.cbpertanyaan_31_13_4);
        cbpertanyaan_31_13_5 = findViewById(R.id.cbpertanyaan_31_13_5);

        cbpertanyaan_31_14_1 = findViewById(R.id.cbpertanyaan_31_14_1);
        cbpertanyaan_31_14_2 = findViewById(R.id.cbpertanyaan_31_14_2);
        cbpertanyaan_31_14_3 = findViewById(R.id.cbpertanyaan_31_14_3);
        cbpertanyaan_31_14_4 = findViewById(R.id.cbpertanyaan_31_14_4);
        cbpertanyaan_31_14_5 = findViewById(R.id.cbpertanyaan_31_14_5);
        cbpertanyaan_31_14_6 = findViewById(R.id.cbpertanyaan_31_14_6);
        cbpertanyaan_31_14_7 = findViewById(R.id.cbpertanyaan_31_14_7);

        cbpertanyaan_31_19_1 = findViewById(R.id.cbpertanyaan_31_19_1);
        cbpertanyaan_31_19_2 = findViewById(R.id.cbpertanyaan_31_19_2);
        cbpertanyaan_31_19_3 = findViewById(R.id.cbpertanyaan_31_19_3);
        cbpertanyaan_31_19_4 = findViewById(R.id.cbpertanyaan_31_19_4);
        cbpertanyaan_31_19_5 = findViewById(R.id.cbpertanyaan_31_19_5);
        cbpertanyaan_31_19_6 = findViewById(R.id.cbpertanyaan_31_19_6);
        cbpertanyaan_31_19_7 = findViewById(R.id.cbpertanyaan_31_19_7);

        cbpertanyaan_31_20_1 = findViewById(R.id.cbpertanyaan_31_20_1);
        //========================================== End pertanyaan 31 ================================================================

        // ================================================= CheckBox 32 ============================================================
        cbpertanyaan_32_1 = findViewById(R.id.cbpertanyaan_32_1);
        cbpertanyaan_32_2 = findViewById(R.id.cbpertanyaan_32_2);
        cbpertanyaan_32_3 = findViewById(R.id.cbpertanyaan_32_3);
        cbpertanyaan_32_4 = findViewById(R.id.cbpertanyaan_32_4);
        cbpertanyaan_32_5 = findViewById(R.id.cbpertanyaan_32_5);
        cbpertanyaan_32_6 = findViewById(R.id.cbpertanyaan_32_6);
        cbpertanyaan_32_7 = findViewById(R.id.cbpertanyaan_32_7);
        // =========================================== End Checkbox pertanyaan 32 ========================================================

        //========================================== pertanyaan 33 =====================================================================
        tvpertanyaan_33_1 = findViewById(R.id.tvpertanyaan_33_1);
        tvpertanyaan_33_1_1 = findViewById(R.id.tvpertanyaan_33_1_1);
        tvpertanyaan_33_1_2 = findViewById(R.id.tvpertanyaan_33_1_2);
        tvpertanyaan_33_2 = findViewById(R.id.tvpertanyaan_33_2);
        tvpertanyaan_33_2_1 = findViewById(R.id.tvpertanyaan_33_2_1);
        tvpertanyaan_33_2_2 = findViewById(R.id.tvpertanyaan_33_2_2);
        tvpertanyaan_33_3 = findViewById(R.id.tvpertanyaan_33_3);
        tvpertanyaan_33_3_1 = findViewById(R.id.tvpertanyaan_33_3_1);
        tvpertanyaan_33_3_2 = findViewById(R.id.tvpertanyaan_33_3_2);
        tvpertanyaan_33_4 = findViewById(R.id.tvpertanyaan_33_4);
        tvpertanyaan_33_4_1 = findViewById(R.id.tvpertanyaan_33_4_1);

        spinner_pertanyaan_33_1_1 = findViewById(R.id.spinner_pertanyaan_33_1_1);
        spinner_pertanyaan_33_1_2 = findViewById(R.id.spinner_pertanyaan_33_1_2);
        spinner_pertanyaan_33_2_1 = findViewById(R.id.spinner_pertanyaan_33_2_1);
        spinner_pertanyaan_33_2_2 = findViewById(R.id.spinner_pertanyaan_33_2_2);
        spinner_pertanyaan_33_3_1 = findViewById(R.id.spinner_pertanyaan_33_3_1);
        spinner_pertanyaan_33_3_2 = findViewById(R.id.spinner_pertanyaan_33_3_2);
        spinner_pertanyaan_33_4_1 = findViewById(R.id.spinner_pertanyaan_33_4_1);

        // ------------------------------------- dpr ri ------------------------------------------------------
        spinner_pertanyaan_33_1_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_33_1);
                spinner33_1_1 = String.valueOf(size_values);
                spinner33_1_1 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_33_1_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_33_1_2);
                spinner33_1_2 = String.valueOf(size_values);
                spinner33_1_2 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // --------------------------------------- End dpr ri ------------------------------------------------------
        // ---------------------------------------- dpr provinsi --------------------------------------------------
        spinner_pertanyaan_33_2_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_33);
                spinner33_2_1 = String.valueOf(size_values);
                spinner33_2_1 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_33_2_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_33_2_2);
                spinner33_2_2 = String.valueOf(size_values);
                spinner33_2_2 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // --------------------------------------- END dpr provinsi -----------------------------------------------

        // ---------------------------------------- dpr kabkota -------------------------------------------------
        spinner_pertanyaan_33_3_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_33);
                spinner33_3_1 = String.valueOf(size_values);
                spinner33_3_1 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_33_3_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_33_1_2);
                spinner33_3_2 = String.valueOf(size_values);
                spinner33_3_2 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // ----------------------------------------- END dpr kabkota -----------------------------------------

        // ------------------------------------------  dprd  --------------------------------------------------
        spinner_pertanyaan_33_4_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_33_4);
                spinner33_4_1 = String.valueOf(size_values);
                spinner33_4_1 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // ------------------------------------------  End dprd  --------------------------------------------------



        //========================================= END pertanyaan 33 ================================================================

        // ================================================= CheckBox 34 ============================================================
        cbpertanyaan_34_1 = findViewById(R.id.cbpertanyaan_34_1);
        cbpertanyaan_34_2 = findViewById(R.id.cbpertanyaan_34_2);
        cbpertanyaan_34_3 = findViewById(R.id.cbpertanyaan_34_3);
        cbpertanyaan_34_4 = findViewById(R.id.cbpertanyaan_34_4);
        cbpertanyaan_34_5 = findViewById(R.id.cbpertanyaan_34_5);
        cbpertanyaan_34_6 = findViewById(R.id.cbpertanyaan_34_6);
        cbpertanyaan_34_7 = findViewById(R.id.cbpertanyaan_34_7);
        cbpertanyaan_34_8 = findViewById(R.id.cbpertanyaan_34_8);
        // =========================================== End Checkbox pertanyaan 34 ====================================================

        // ================================================= CheckBox 35 ============================================================
        cbpertanyaan_35_1 = findViewById(R.id.cbpertanyaan_35_1);
        cbpertanyaan_35_2 = findViewById(R.id.cbpertanyaan_35_2);
        cbpertanyaan_35_3 = findViewById(R.id.cbpertanyaan_35_3);
        cbpertanyaan_35_4 = findViewById(R.id.cbpertanyaan_35_4);
        cbpertanyaan_35_5 = findViewById(R.id.cbpertanyaan_35_5);
        cbpertanyaan_35_6 = findViewById(R.id.cbpertanyaan_35_6);
        cbpertanyaan_35_7 = findViewById(R.id.cbpertanyaan_35_7);
        cbpertanyaan_35_8 = findViewById(R.id.cbpertanyaan_35_8);
        // =========================================== End Checkbox pertanyaan 35 ========================================================

        // ================================================= CheckBox 36 ============================================================
        cbpertanyaan_36_1 = findViewById(R.id.cbpertanyaan_36_1);
        cbpertanyaan_36_2 = findViewById(R.id.cbpertanyaan_36_2);
        cbpertanyaan_36_3 = findViewById(R.id.cbpertanyaan_36_3);
        cbpertanyaan_36_4 = findViewById(R.id.cbpertanyaan_36_4);
        cbpertanyaan_36_5 = findViewById(R.id.cbpertanyaan_36_5);
        cbpertanyaan_36_6 = findViewById(R.id.cbpertanyaan_36_6);
        cbpertanyaan_36_7 = findViewById(R.id.cbpertanyaan_36_7);
        cbpertanyaan_36_8 = findViewById(R.id.cbpertanyaan_36_8);
        cbpertanyaan_36_9 = findViewById(R.id.cbpertanyaan_36_9);
        cbpertanyaan_36_10 = findViewById(R.id.cbpertanyaan_36_10);
        cbpertanyaan_36_11 = findViewById(R.id.cbpertanyaan_36_11);
        cbpertanyaan_36_12 = findViewById(R.id.cbpertanyaan_36_12);
        // =========================================== End Checkbox pertanyaan 36 ====================================================

        // ================================================= CheckBox 37 ============================================================
        cbpertanyaan_37_1 = findViewById(R.id.cbpertanyaan_37_1);
        cbpertanyaan_37_2 = findViewById(R.id.cbpertanyaan_37_2);
        cbpertanyaan_37_3 = findViewById(R.id.cbpertanyaan_37_3);
        cbpertanyaan_37_4 = findViewById(R.id.cbpertanyaan_37_4);
        cbpertanyaan_37_5 = findViewById(R.id.cbpertanyaan_37_5);
        cbpertanyaan_37_6 = findViewById(R.id.cbpertanyaan_37_6);
        // =========================================== End Checkbox pertanyaan 37 ====================================================

        // Spinner pertanyaan 38
        spinner_pertanyaan_38 = findViewById(R.id.spinner_pertanyaan_38);

        spinner_pertanyaan_38.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_38);
                spinner38 = String.valueOf(size_values);
                spinner38 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // END Spinner pertanyaan 38

        // ================================================= Radio Button 39 ============================================================
        radiogroup_pertanyaan_39 = findViewById(R.id.radio_group_pertanyaan_39);
        radiobutton_pertanyaan_39_1 = findViewById(R.id.radiobutton_pertanyaan_39_1);
        radiobutton_pertanyaan_39_2 = findViewById(R.id.radiobutton_pertanyaan_39_2);
        radiobutton_pertanyaan_39_3 = findViewById(R.id.radiobutton_pertanyaan_39_3);
        radiobutton_pertanyaan_39_4 = findViewById(R.id.radiobutton_pertanyaan_39_4);

        radiogroup_pertanyaan_39.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radiobutton_pertanyaan_39_1.isChecked()){
                    rg_pertanyaan_39 = "Joko Widodo - Makruf Amin";
                }
                if (radiobutton_pertanyaan_39_2.isChecked()){
                    rg_pertanyaan_39 = "Prabowo Subianto - Sandiaga Uno";
                }
                if (radiobutton_pertanyaan_39_3.isChecked()){
                    rg_pertanyaan_39 = "Belum menentukan pilihan";
                }
                if (radiobutton_pertanyaan_39_4.isChecked()){
                    rg_pertanyaan_39 = "Tidak mau memberitahukan pilihan";
                }
            }
        });
        // =============================================== END Radio Button 39 ============================================================

        // ================================================= CheckBox 40 ============================================================
        cbpertanyaan_40_1 = findViewById(R.id.cbpertanyaan_40_1);
        cbpertanyaan_40_2 = findViewById(R.id.cbpertanyaan_40_2);
        cbpertanyaan_40_3 = findViewById(R.id.cbpertanyaan_40_3);
        cbpertanyaan_40_4 = findViewById(R.id.cbpertanyaan_40_4);
        cbpertanyaan_40_5 = findViewById(R.id.cbpertanyaan_40_5);
        cbpertanyaan_40_6 = findViewById(R.id.cbpertanyaan_40_6);
        cbpertanyaan_40_7 = findViewById(R.id.cbpertanyaan_40_7);
        cbpertanyaan_40_8 = findViewById(R.id.cbpertanyaan_40_8);
        cbpertanyaan_40_9 = findViewById(R.id.cbpertanyaan_40_9);
        cbpertanyaan_40_10 = findViewById(R.id.cbpertanyaan_40_10);
        // =========================================== End Checkbox pertanyaan 40 ==============================================================


//=================================================== END Pertanyaan ======================================================================
        tvlat = findViewById(R.id.tvlat);
        tvlang = findViewById(R.id.tvlang);
        btnsubmit = findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addsresponden();
            }
        });
//        getKecamatan(1401);
        spinnerkabkota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getKecamatan(Integer.valueOf(id_kabkota.get(position)));
                System.out.println("Dipilih kabkota dengan id : " + id_kabkota.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerkecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getKelurahan(Integer.valueOf(id_kecamatan.get(position)));
                System.out.println("Pilih Kecamatan : " + id_kecamatan.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        lm.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0,
                0,
                locationListener);
    }

    //=============================================================== getKabkota ===============================================================
    private void getKabkota(){
        apiService.GetAllByIdKabKota("1401").enqueue(new Callback<ResponseKabkota>() {
            @Override
            public void onResponse(Call<ResponseKabkota> call, Response<ResponseKabkota> response) {
                if (response.isSuccessful()){
                    if (response.body().getMaster().size()>0){
                        for (int i = 0; i < response.body().getMaster().size() ; i++) {
                            id_kabkota.add(response.body().getMaster().get(i).getIdKabkota());
                            nama_kabkota.add(response.body().getMaster().get(i).getNama());
                        }
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(RespondenActivity.this, android.R.layout.simple_spinner_dropdown_item, nama_kabkota );
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerkabkota.setAdapter(dataAdapter);
                }
            }
            @Override
            public void onFailure(Call<ResponseKabkota> call, Throwable t) {

            }
        });
    }
//============================================================= END getKabkota ==============================================================

    //============================================================= getKecamatan ==============================================================
    private void getKecamatan(int idKabkota){
        apiService.GetAllByIdKecamatan(String.valueOf(idKabkota)).enqueue(new Callback<ResponseKecamatan>() {
            @Override
            public void onResponse(Call<ResponseKecamatan> call, Response<ResponseKecamatan> response) {
                if (response.isSuccessful()){
                    if (response.body().getMaster().size()>0){
//                        Log.d("id_kabkota", response.body().getMaster().get(0).getNama());
                        id_kecamatan.clear();
                        nama_kecamatan.clear();
                        for (int i = 0; i < response.body().getMaster().size() ; i++) {
                            id_kecamatan.add(response.body().getMaster().get(i).getIdKecamatan());
                            nama_kecamatan.add(response.body().getMaster().get(i).getNama());
                        }
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(RespondenActivity.this, android.R.layout.simple_spinner_dropdown_item, nama_kecamatan );
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerkecamatan.setAdapter(dataAdapter);
                }
            }
            @Override
            public void onFailure(Call<ResponseKecamatan> call, Throwable t) {

            }
        });
    }
//============================================================= END getKecamatan ==============================================================

    //============================================================= getKelurahan ==============================================================
    private void getKelurahan(int idKecamatan){
        apiService.GetAllByIdKelurahan(String.valueOf(idKecamatan)).enqueue(new Callback<ResponseKelurahan>() {
            @Override
            public void onResponse(Call<ResponseKelurahan> call, Response<ResponseKelurahan> response) {
                if (response.body().getMaster().size()>0){
                    id_kelurahan.clear();
                    nama_kelurahan.clear();
                    for (int i = 0; i < response.body().getMaster().size() ; i++) {
                        id_kelurahan.add(response.body().getMaster().get(i).getIdKelurahan());
                        nama_kelurahan.add(response.body().getMaster().get(i).getNama());
                    }
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(RespondenActivity.this, android.R.layout.simple_spinner_dropdown_item, nama_kelurahan );
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerkelurahan.setAdapter(dataAdapter);
            }
            @Override
            public void onFailure(Call<ResponseKelurahan> call, Throwable t) {

            }
        });
    }
//============================================================= End getKelurahan ==============================================================

    //============================================================= Method ADD Responden ==============================================================
    private void addsresponden() {
        nama_responden = etnama_responden.getText().toString();
        alamat = etalamat.getText().toString();
        provinsi = tvprovinsi.getText().toString();
        kab_kota = spinnerkabkota.getSelectedItem().toString();
        kecamatan = spinnerkecamatan.getSelectedItem().toString();
        kel_desa = spinnerkelurahan.getSelectedItem().toString();
        rt = etrt.getText().toString();
        rw = etrw.getText().toString();
        no_hp = etno_hp.getText().toString();

        pertanyaan_12 = rg_pertanyaan_12;
        pertanyaan_13 = rg_pertanyaan_13;
        pertanyaan_14 = jenis_kelamin;
        pertanyaan_15 = spinner15;
        pertanyaan_16 = spinner16;
        pertanyaan_17 = spinner17;
        pertanyaan_18 = spinner18;
        pertanyaan_19 = spinner19;
        pertanyaan_20 = spinner20;
        pertanyaan_21 = spinner21;
        pertanyaan_22 = spinner22;
        pertanyaan_23 = spinner23;
        pertanyaan_24 = tvpertanyaan_24_1.getText().toString() + " : " + spinner24_1 + ", "
                + tvpertanyaan_24_2.getText().toString() + " : " + spinner24_2+ ", "
                + tvpertanyaan_24_3.getText().toString() + " : " + spinner24_3+ ", "
                + tvpertanyaan_24_4.getText().toString() + " : " + spinner24_4+ ", "
                + tvpertanyaan_24_5.getText().toString() + " : " + spinner24_5+ ", "
                + tvpertanyaan_24_6.getText().toString() + " : " + spinner24_6+ ", "
                + tvpertanyaan_24_7.getText().toString() + " : " + spinner24_7;

        // =========================================== pertanyaan 25 ===================================================================
        pertanyaan_25 = "";
        int count_pertanyaan_25 = 0;
        if (cbpertanyaan_25_1.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_1.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_2.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_2.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_3.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_3.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_4.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_4.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_5.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_5.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_6.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_6.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_7.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_7.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_8.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_8.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_9.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_9.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_10.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_10.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_11.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_12.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_12.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_12.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_13.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_13.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_14.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_14.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_15.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_15.getText().toString() + ", ";
            count_pertanyaan_25++;
        }if (cbpertanyaan_25_16.isChecked()) {
            pertanyaan_25 += cbpertanyaan_25_16.getText().toString()+ ", ";
            count_pertanyaan_25++;
        }
        // =========================================== END pertanyaan 25 ====================================================================
        pertanyaan_26 = "";
        int count_pertanyaan_26 = 0;
        if (cbpertanyaan_26_1.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_1.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_2.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_2.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_3.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_3.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_4.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_4.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_5.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_5.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_6.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_6.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_7.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_7.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_8.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_8.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_9.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_9.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_10.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_10.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_11.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_12.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_12.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_12.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_13.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_13.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_14.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_14.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_15.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_15.getText().toString() + ", ";
            count_pertanyaan_26++;
        }if (cbpertanyaan_26_16.isChecked()) {
            pertanyaan_26 += cbpertanyaan_26_16.getText().toString()+ ", ";
            count_pertanyaan_26++;
        }
        // =========================================== pertanyaan 27 ===================================================================
        pertanyaan_27 = "";
        int count_pertanyaan_27 = 0;
        if (cbpertanyaan_27_1.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_1.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_2.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_2.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_3.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_3.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_4.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_4.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_5.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_5.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_6.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_6.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_7.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_7.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_8.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_8.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_9.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_9.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_10.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_10.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_11.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_12.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_12.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_12.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_13.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_13.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_14.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_14.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_15.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_15.getText().toString() + ", ";
            count_pertanyaan_27++;
        }if (cbpertanyaan_27_16.isChecked()) {
            pertanyaan_27 += cbpertanyaan_27_16.getText().toString()+ ", ";
            count_pertanyaan_27++;
        }
        // =========================================== END pertanyaan 27 ====================================================================

        // =========================================== pertanyaan 28 ===================================================================
        pertanyaan_28 = "";
        int count_pertanyaan_28 = 0;
        if (cbpertanyaan_28_1.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_1.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_2.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_2.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_3.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_3.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_4.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_4.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_5.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_5.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_6.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_6.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_7.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_7.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_8.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_8.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_9.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_9.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_10.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_10.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_11.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_12.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_12.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_12.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_13.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_13.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_14.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_14.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_15.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_15.getText().toString() + ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_16.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_16.getText().toString()+ ", ";
            count_pertanyaan_28++;
        }if (cbpertanyaan_28_17.isChecked()) {
            pertanyaan_28 += cbpertanyaan_28_17.getText().toString()+ ", ";
            count_pertanyaan_28++;
        }
        // =========================================== END pertanyaan 28 ====================================================================

        pertanyaan_29 = rg_pertanyaan_29;
        // =========================================== pertanyaan 30 ===================================================================
        pertanyaan_30 = "";
        int count_pertanyaan_30 = 0;
        if (cbpertanyaan_30_1.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_1.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_2.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_2.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_3.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_3.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_4.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_4.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_5.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_5.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_6.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_6.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_7.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_7.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_8.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_8.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_9.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_9.getText().toString() + ", ";
            count_pertanyaan_30++;
        }if (cbpertanyaan_30_10.isChecked()) {
            pertanyaan_30 += cbpertanyaan_30_10.getText().toString() + ", ";
            count_pertanyaan_30++;
        }
        // =========================================== END pertanyaan 30 ====================================================================
        pertanyaan_31 = "";
        int count_pertanyaan_31 = 0;
        if (cbpertanyaan_31_1_1.isChecked()) {
            pertanyaan_31 += tvpartai1.getText().toString()+ " " +tvpertanyaan_31_1_2.getText().toString() +""+
                             cbpertanyaan_31_1_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_1_2.isChecked()) {
            pertanyaan_31 += tvpartai1.getText().toString()+ " " +tvpertanyaan_31_1_2.getText().toString() +""+
                             cbpertanyaan_31_1_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_1_3.isChecked()) {
            pertanyaan_31 += tvpartai1.getText().toString()+ " " +tvpertanyaan_31_1_2.getText().toString() +""+
                             cbpertanyaan_31_1_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_1_4.isChecked()) {
            pertanyaan_31 += tvpartai1.getText().toString()+ " " +tvpertanyaan_31_1_2.getText().toString() +""+
                             cbpertanyaan_31_1_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_1_5.isChecked()) {
            pertanyaan_31 += tvpartai1.getText().toString()+ " " +tvpertanyaan_31_1_2.getText().toString() +""+
                             cbpertanyaan_31_1_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_1_6.isChecked()) {
            pertanyaan_31 += tvpartai1.getText().toString()+ " " +tvpertanyaan_31_1_2.getText().toString() +""+
                             cbpertanyaan_31_1_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_1_7.isChecked()) {
            pertanyaan_31 += tvpartai1.getText().toString()+ " " +tvpertanyaan_31_1_2.getText().toString() +""+
                             cbpertanyaan_31_1_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_2_1.isChecked()) {
            pertanyaan_31 += tvpartai2.getText().toString()+ " " +tvpertanyaan_31_2_2.getText().toString() +""+
                    cbpertanyaan_31_2_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_2_2.isChecked()) {
            pertanyaan_31 += tvpartai2.getText().toString()+ " " +tvpertanyaan_31_2_2.getText().toString() +""+
                    cbpertanyaan_31_2_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_2_3.isChecked()) {
            pertanyaan_31 += tvpartai2.getText().toString()+ " " +tvpertanyaan_31_2_2.getText().toString() +""+
                    cbpertanyaan_31_2_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_2_4.isChecked()) {
            pertanyaan_31 += tvpartai2.getText().toString()+ " " +tvpertanyaan_31_2_2.getText().toString() +""+
                    cbpertanyaan_31_2_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_2_5.isChecked()) {
            pertanyaan_31 += tvpartai2.getText().toString()+ " " +tvpertanyaan_31_2_2.getText().toString() +""+
                    cbpertanyaan_31_2_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_2_6.isChecked()) {
            pertanyaan_31 += tvpartai2.getText().toString()+ " " +tvpertanyaan_31_2_2.getText().toString() +""+
                    cbpertanyaan_31_2_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_2_7.isChecked()) {
            pertanyaan_31 += tvpartai2.getText().toString()+ " " +tvpertanyaan_31_2_2.getText().toString() +""+
                    cbpertanyaan_31_2_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_3_1.isChecked()) {
            pertanyaan_31 += tvpartai3.getText().toString()+ " " +tvpertanyaan_31_3_2.getText().toString() +""+
                    cbpertanyaan_31_3_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_3_2.isChecked()) {
            pertanyaan_31 += tvpartai3.getText().toString()+ " " +tvpertanyaan_31_3_2.getText().toString() +""+
                    cbpertanyaan_31_3_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_3_3.isChecked()) {
            pertanyaan_31 += tvpartai3.getText().toString()+ " " +tvpertanyaan_31_3_2.getText().toString() +""+
                    cbpertanyaan_31_3_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_3_4.isChecked()) {
            pertanyaan_31 += tvpartai3.getText().toString()+ " " +tvpertanyaan_31_3_2.getText().toString() +""+
                    cbpertanyaan_31_3_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_3_5.isChecked()) {
            pertanyaan_31 += tvpartai3.getText().toString()+ " " +tvpertanyaan_31_3_2.getText().toString() +""+
                    cbpertanyaan_31_3_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_3_6.isChecked()) {
            pertanyaan_31 += tvpartai3.getText().toString()+ " " +tvpertanyaan_31_3_2.getText().toString() +""+
                    cbpertanyaan_31_3_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_3_7.isChecked()) {
            pertanyaan_31 += tvpartai3.getText().toString()+ " " +tvpertanyaan_31_3_2.getText().toString() +""+
                    cbpertanyaan_31_3_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_4_1.isChecked()) {
            pertanyaan_31 += tvpartai4.getText().toString()+ " " +tvpertanyaan_31_4_2.getText().toString() +""+
                    cbpertanyaan_31_4_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_4_2.isChecked()) {
            pertanyaan_31 += tvpartai4.getText().toString()+ " " +tvpertanyaan_31_4_2.getText().toString() +""+
                    cbpertanyaan_31_4_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_4_3.isChecked()) {
            pertanyaan_31 += tvpartai4.getText().toString()+ " " +tvpertanyaan_31_4_2.getText().toString() +""+
                    cbpertanyaan_31_4_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_4_4.isChecked()) {
            pertanyaan_31 += tvpartai4.getText().toString()+ " " +tvpertanyaan_31_4_2.getText().toString() +""+
                    cbpertanyaan_31_4_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_4_5.isChecked()) {
            pertanyaan_31 += tvpartai4.getText().toString()+ " " +tvpertanyaan_31_4_2.getText().toString() +""+
                    cbpertanyaan_31_4_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_4_6.isChecked()) {
            pertanyaan_31 += tvpartai4.getText().toString()+ " " +tvpertanyaan_31_4_2.getText().toString() +""+
                    cbpertanyaan_31_4_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_4_7.isChecked()) {
            pertanyaan_31 += tvpartai4.getText().toString()+ " " +tvpertanyaan_31_4_2.getText().toString() +""+
                    cbpertanyaan_31_4_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }


        if (cbpertanyaan_31_5_1.isChecked()) {
            pertanyaan_31 += tvpartai5.getText().toString()+ " " +tvpertanyaan_31_5_2.getText().toString() +""+
                    cbpertanyaan_31_5_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_5_2.isChecked()) {
            pertanyaan_31 += tvpartai5.getText().toString()+ " " +tvpertanyaan_31_5_2.getText().toString() +""+
                    cbpertanyaan_31_5_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_5_3.isChecked()) {
            pertanyaan_31 += tvpartai5.getText().toString()+ " " +tvpertanyaan_31_5_2.getText().toString() +""+
                    cbpertanyaan_31_5_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_5_4.isChecked()) {
            pertanyaan_31 += tvpartai5.getText().toString()+ " " +tvpertanyaan_31_5_2.getText().toString() +""+
                    cbpertanyaan_31_5_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_5_5.isChecked()) {
            pertanyaan_31 += tvpartai5.getText().toString()+ " " +tvpertanyaan_31_5_2.getText().toString() +""+
                    cbpertanyaan_31_5_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_5_6.isChecked()) {
            pertanyaan_31 += tvpartai5.getText().toString()+ " " +tvpertanyaan_31_5_2.getText().toString() +""+
                    cbpertanyaan_31_5_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_5_7.isChecked()) {
            pertanyaan_31 += tvpartai5.getText().toString()+ " " +tvpertanyaan_31_5_2.getText().toString() +""+
                    cbpertanyaan_31_5_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_6_1.isChecked()) {
            pertanyaan_31 += tvpartai6.getText().toString()+ " " +tvpertanyaan_31_6_2.getText().toString() +""+
                    cbpertanyaan_31_6_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_6_2.isChecked()) {
            pertanyaan_31 += tvpartai6.getText().toString()+ " " +tvpertanyaan_31_6_2.getText().toString() +""+
                    cbpertanyaan_31_6_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_7_1.isChecked()) {
            pertanyaan_31 += tvpartai7.getText().toString()+ " " +tvpertanyaan_31_7_2.getText().toString() +""+
                    cbpertanyaan_31_7_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_7_2.isChecked()) {
            pertanyaan_31 += tvpartai7.getText().toString()+ " " +tvpertanyaan_31_7_2.getText().toString() +""+
                    cbpertanyaan_31_7_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_7_3.isChecked()) {
            pertanyaan_31 += tvpartai7.getText().toString()+ " " +tvpertanyaan_31_7_2.getText().toString() +""+
                    cbpertanyaan_31_7_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_7_4.isChecked()) {
            pertanyaan_31 += tvpartai7.getText().toString()+ " " +tvpertanyaan_31_7_2.getText().toString() +""+
                    cbpertanyaan_31_7_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_7_5.isChecked()) {
            pertanyaan_31 += tvpartai7.getText().toString()+ " " +tvpertanyaan_31_7_2.getText().toString() +""+
                    cbpertanyaan_31_7_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_7_6.isChecked()) {
            pertanyaan_31 += tvpartai7.getText().toString()+ " " +tvpertanyaan_31_7_2.getText().toString() +""+
                    cbpertanyaan_31_7_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_7_7.isChecked()) {
            pertanyaan_31 += tvpartai7.getText().toString()+ " " +tvpertanyaan_31_7_2.getText().toString() +""+
                    cbpertanyaan_31_7_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_8_1.isChecked()) {
            pertanyaan_31 += tvpartai8.getText().toString()+ " " +tvpertanyaan_31_8_2.getText().toString() +""+
                    cbpertanyaan_31_8_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_8_2.isChecked()) {
            pertanyaan_31 += tvpartai8.getText().toString()+ " " +tvpertanyaan_31_8_2.getText().toString() +""+
                    cbpertanyaan_31_8_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_8_3.isChecked()) {
            pertanyaan_31 += tvpartai8.getText().toString()+ " " +tvpertanyaan_31_8_2.getText().toString() +""+
                    cbpertanyaan_31_8_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_8_4.isChecked()) {
            pertanyaan_31 += tvpartai8.getText().toString()+ " " +tvpertanyaan_31_8_2.getText().toString() +""+
                    cbpertanyaan_31_8_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_8_5.isChecked()) {
            pertanyaan_31 += tvpartai8.getText().toString()+ " " +tvpertanyaan_31_8_2.getText().toString() +""+
                    cbpertanyaan_31_8_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_8_6.isChecked()) {
            pertanyaan_31 += tvpartai8.getText().toString()+ " " +tvpertanyaan_31_8_2.getText().toString() +""+
                    cbpertanyaan_31_8_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_8_7.isChecked()) {
            pertanyaan_31 += tvpartai8.getText().toString()+ " " +tvpertanyaan_31_8_2.getText().toString() +""+
                    cbpertanyaan_31_8_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_9_1.isChecked()) {
            pertanyaan_31 += tvpartai9.getText().toString()+ " " +tvpertanyaan_31_9_2.getText().toString() +""+
                    cbpertanyaan_31_9_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_9_2.isChecked()) {
            pertanyaan_31 += tvpartai9.getText().toString()+ " " +tvpertanyaan_31_9_2.getText().toString() +""+
                    cbpertanyaan_31_9_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_9_3.isChecked()) {
            pertanyaan_31 += tvpartai9.getText().toString()+ " " +tvpertanyaan_31_9_2.getText().toString() +""+
                    cbpertanyaan_31_9_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_9_4.isChecked()) {
            pertanyaan_31 += tvpartai9.getText().toString()+ " " +tvpertanyaan_31_9_2.getText().toString() +""+
                    cbpertanyaan_31_9_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_9_5.isChecked()) {
            pertanyaan_31 += tvpartai9.getText().toString()+ " " +tvpertanyaan_31_9_2.getText().toString() +""+
                    cbpertanyaan_31_9_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_9_6.isChecked()) {
            pertanyaan_31 += tvpartai9.getText().toString()+ " " +tvpertanyaan_31_9_2.getText().toString() +""+
                    cbpertanyaan_31_9_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_9_7.isChecked()) {
            pertanyaan_31 += tvpartai9.getText().toString()+ " " +tvpertanyaan_31_9_2.getText().toString() +""+
                    cbpertanyaan_31_9_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_10_1.isChecked()) {
            pertanyaan_31 += tvpartai10.getText().toString()+ " " +tvpertanyaan_31_10_2.getText().toString() +""+
                    cbpertanyaan_31_10_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_10_2.isChecked()) {
            pertanyaan_31 += tvpartai10.getText().toString()+ " " +tvpertanyaan_31_10_2.getText().toString() +""+
                    cbpertanyaan_31_10_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_10_3.isChecked()) {
            pertanyaan_31 += tvpartai10.getText().toString()+ " " +tvpertanyaan_31_10_2.getText().toString() +""+
                    cbpertanyaan_31_10_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_10_4.isChecked()) {
            pertanyaan_31 += tvpartai10.getText().toString()+ " " +tvpertanyaan_31_10_2.getText().toString() +""+
                    cbpertanyaan_31_10_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_10_5.isChecked()) {
            pertanyaan_31 += tvpartai10.getText().toString()+ " " +tvpertanyaan_31_10_2.getText().toString() +""+
                    cbpertanyaan_31_10_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_10_6.isChecked()) {
            pertanyaan_31 += tvpartai10.getText().toString()+ " " +tvpertanyaan_31_10_2.getText().toString() +""+
                    cbpertanyaan_31_10_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_10_7.isChecked()) {
            pertanyaan_31 += tvpartai10.getText().toString()+ " " +tvpertanyaan_31_10_2.getText().toString() +""+
                    cbpertanyaan_31_10_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_11_1.isChecked()) {
            pertanyaan_31 += tvpartai11.getText().toString()+ " " +tvpertanyaan_31_11_2.getText().toString() +""+
                    cbpertanyaan_31_11_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_11_2.isChecked()) {
            pertanyaan_31 += tvpartai11.getText().toString()+ " " +tvpertanyaan_31_11_2.getText().toString() +""+
                    cbpertanyaan_31_11_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_11_3.isChecked()) {
            pertanyaan_31 += tvpartai11.getText().toString()+ " " +tvpertanyaan_31_11_2.getText().toString() +""+
                    cbpertanyaan_31_11_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_11_4.isChecked()) {
            pertanyaan_31 += tvpartai11.getText().toString()+ " " +tvpertanyaan_31_11_2.getText().toString() +""+
                    cbpertanyaan_31_11_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_11_5.isChecked()) {
            pertanyaan_31 += tvpartai11.getText().toString()+ " " +tvpertanyaan_31_11_2.getText().toString() +""+
                    cbpertanyaan_31_11_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_11_6.isChecked()) {
            pertanyaan_31 += tvpartai11.getText().toString()+ " " +tvpertanyaan_31_11_2.getText().toString() +""+
                    cbpertanyaan_31_11_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_11_7.isChecked()) {
            pertanyaan_31 += tvpartai11.getText().toString()+ " " +tvpertanyaan_31_11_2.getText().toString() +""+
                    cbpertanyaan_31_11_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_12_1.isChecked()) {
            pertanyaan_31 += tvpartai12.getText().toString()+ " " +tvpertanyaan_31_12_2.getText().toString() +""+
                    cbpertanyaan_31_12_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_12_2.isChecked()) {
            pertanyaan_31 += tvpartai12.getText().toString()+ " " +tvpertanyaan_31_12_2.getText().toString() +""+
                    cbpertanyaan_31_12_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_12_3.isChecked()) {
            pertanyaan_31 += tvpartai12.getText().toString()+ " " +tvpertanyaan_31_12_2.getText().toString() +""+
                    cbpertanyaan_31_12_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_12_4.isChecked()) {
            pertanyaan_31 += tvpartai12.getText().toString()+ " " +tvpertanyaan_31_12_2.getText().toString() +""+
                    cbpertanyaan_31_12_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_12_5.isChecked()) {
            pertanyaan_31 += tvpartai12.getText().toString()+ " " +tvpertanyaan_31_12_2.getText().toString() +""+
                    cbpertanyaan_31_12_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_12_6.isChecked()) {
            pertanyaan_31 += tvpartai12.getText().toString()+ " " +tvpertanyaan_31_12_2.getText().toString() +""+
                    cbpertanyaan_31_12_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_12_7.isChecked()) {
            pertanyaan_31 += tvpartai12.getText().toString()+ " " +tvpertanyaan_31_12_2.getText().toString() +""+
                    cbpertanyaan_31_12_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_13_1.isChecked()) {
            pertanyaan_31 += tvpartai13.getText().toString()+ " " +tvpertanyaan_31_13_2.getText().toString() +""+
                    cbpertanyaan_31_13_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_13_2.isChecked()) {
            pertanyaan_31 += tvpartai13.getText().toString()+ " " +tvpertanyaan_31_13_2.getText().toString() +""+
                    cbpertanyaan_31_13_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_13_3.isChecked()) {
            pertanyaan_31 += tvpartai13.getText().toString()+ " " +tvpertanyaan_31_13_2.getText().toString() +""+
                    cbpertanyaan_31_13_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_13_4.isChecked()) {
            pertanyaan_31 += tvpartai13.getText().toString()+ " " +tvpertanyaan_31_13_2.getText().toString() +""+
                    cbpertanyaan_31_13_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_13_5.isChecked()) {
            pertanyaan_31 += tvpartai13.getText().toString()+ " " +tvpertanyaan_31_13_2.getText().toString() +""+
                    cbpertanyaan_31_13_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        }


        if (cbpertanyaan_31_14_1.isChecked()) {
            pertanyaan_31 += tvpartai14.getText().toString()+ " " +tvpertanyaan_31_14_2.getText().toString() +""+
                    cbpertanyaan_31_14_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_14_2.isChecked()) {
            pertanyaan_31 += tvpartai14.getText().toString()+ " " +tvpertanyaan_31_14_2.getText().toString() +""+
                    cbpertanyaan_31_14_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_14_3.isChecked()) {
            pertanyaan_31 += tvpartai14.getText().toString()+ " " +tvpertanyaan_31_14_2.getText().toString() +""+
                    cbpertanyaan_31_14_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_14_4.isChecked()) {
            pertanyaan_31 += tvpartai14.getText().toString()+ " " +tvpertanyaan_31_14_2.getText().toString() +""+
                    cbpertanyaan_31_14_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_14_5.isChecked()) {
            pertanyaan_31 += tvpartai14.getText().toString()+ " " +tvpertanyaan_31_14_2.getText().toString() +""+
                    cbpertanyaan_31_14_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_14_6.isChecked()) {
            pertanyaan_31 += tvpartai14.getText().toString()+ " " +tvpertanyaan_31_14_2.getText().toString() +""+
                    cbpertanyaan_31_14_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_14_7.isChecked()) {
            pertanyaan_31 += tvpartai14.getText().toString()+ " " +tvpertanyaan_31_14_2.getText().toString() +""+
                    cbpertanyaan_31_14_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }


        if (cbpertanyaan_31_19_1.isChecked()) {
            pertanyaan_31 += tvpartai19.getText().toString()+ " " +tvpertanyaan_31_19_2.getText().toString() +""+
                    cbpertanyaan_31_19_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_19_2.isChecked()) {
            pertanyaan_31 += tvpartai19.getText().toString()+ " " +tvpertanyaan_31_19_2.getText().toString() +""+
                    cbpertanyaan_31_19_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_19_3.isChecked()) {
            pertanyaan_31 += tvpartai19.getText().toString()+ " " +tvpertanyaan_31_19_2.getText().toString() +""+
                    cbpertanyaan_31_19_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_19_4.isChecked()) {
            pertanyaan_31 += tvpartai19.getText().toString()+ " " +tvpertanyaan_31_19_2.getText().toString() +""+
                    cbpertanyaan_31_19_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_19_5.isChecked()) {
            pertanyaan_31 += tvpartai19.getText().toString()+ " " +tvpertanyaan_31_19_2.getText().toString() +""+
                    cbpertanyaan_31_19_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_19_6.isChecked()) {
            pertanyaan_31 += tvpartai19.getText().toString()+ " " +tvpertanyaan_31_19_2.getText().toString() +""+
                    cbpertanyaan_31_19_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        } if (cbpertanyaan_31_19_7.isChecked()) {
            pertanyaan_31 += tvpartai19.getText().toString()+ " " +tvpertanyaan_31_19_2.getText().toString() +""+
                    cbpertanyaan_31_19_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }

        if (cbpertanyaan_31_20_1.isChecked()) {
            pertanyaan_31 += tvpartai20.getText().toString()+ " " +tvpertanyaan_31_20_2.getText().toString() +""+
                    cbpertanyaan_31_20_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        }


        // =========================================== pertanyaan 32 ===================================================================
        pertanyaan_32 = "";
        int count_pertanyaan_32 = 0;
        if (cbpertanyaan_32_1.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_1.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_2.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_2.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_3.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_3.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_4.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_4.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_5.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_5.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_6.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_6.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_7.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_7.getText().toString() + ", ";
            count_pertanyaan_32++;
        }
        // =========================================== END pertanyaan 32 ====================================================================

        pertanyaan_33 = tvpertanyaan_33_1.getText().toString() + "(" + tvpertanyaan_33_1_1.getText().toString()+" : "+spinner33_1_1+
                 ","+tvpertanyaan_33_1_2.getText().toString()+" : "+spinner33_1_2+")"+"."+
                tvpertanyaan_33_2.getText().toString() + "(" + tvpertanyaan_33_2_1.getText().toString()+" : "+spinner33_2_1+
                ","+tvpertanyaan_33_2_2.getText().toString()+" : "+spinner33_2_2+")"+"."+
                tvpertanyaan_33_3.getText().toString() + "(" + tvpertanyaan_33_3_1.getText().toString()+" : "+spinner33_3_1+
                ","+tvpertanyaan_33_3_2.getText().toString()+" : "+spinner33_3_2+")"+"."+
                tvpertanyaan_33_4.getText().toString() + "(" + tvpertanyaan_33_4_1.getText().toString()+" : "+spinner33_4_1+")";

        // =========================================== pertanyaan 34 ===================================================================
        pertanyaan_34 = "";
        int count_pertanyaan_34 = 0;
        if (cbpertanyaan_34_1.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_1.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_2.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_2.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_3.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_3.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_4.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_4.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_5.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_5.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_6.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_6.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_7.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_7.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_8.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_8.getText().toString() + ", ";
            count_pertanyaan_34++;
        }
        // =========================================== END pertanyaan 34 ====================================================================

        // =========================================== pertanyaan 35 ===================================================================
        pertanyaan_35 = "";
        int count_pertanyaan_35 = 0;
        if (cbpertanyaan_35_1.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_1.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_2.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_2.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_3.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_3.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_4.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_4.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_5.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_5.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_6.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_6.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_7.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_7.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_8.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_8.getText().toString() + ", ";
            count_pertanyaan_35++;
        }
        // =========================================== END pertanyaan 35 ====================================================================

        // =========================================== pertanyaan 36 ===================================================================
        pertanyaan_36 = "";
        int count_pertanyaan_36 = 0;
        if (cbpertanyaan_36_1.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_1.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_2.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_2.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_3.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_3.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_4.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_4.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_5.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_5.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_6.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_6.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_7.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_7.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_8.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_8.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_9.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_9.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_10.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_10.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_11.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_11.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_12.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_12.getText().toString() + ", ";
            count_pertanyaan_36++;
        }
        // =========================================== END pertanyaan 36 ====================================================================

        // =========================================== pertanyaan 37 ===================================================================
        pertanyaan_37 = "";
        int count_pertanyaan_37 = 0;
        if (cbpertanyaan_37_1.isChecked()) {
            pertanyaan_37 += cbpertanyaan_37_1.getText().toString() + ", ";
            count_pertanyaan_37++;
        }if (cbpertanyaan_37_2.isChecked()) {
            pertanyaan_37 += cbpertanyaan_37_2.getText().toString() + ", ";
            count_pertanyaan_37++;
        }if (cbpertanyaan_37_3.isChecked()) {
            pertanyaan_37 += cbpertanyaan_37_3.getText().toString() + ", ";
            count_pertanyaan_37++;
        }if (cbpertanyaan_37_4.isChecked()) {
            pertanyaan_37 += cbpertanyaan_37_4.getText().toString() + ", ";
            count_pertanyaan_37++;
        }if (cbpertanyaan_37_5.isChecked()) {
            pertanyaan_37 += cbpertanyaan_37_5.getText().toString() + ", ";
            count_pertanyaan_37++;
        }if (cbpertanyaan_37_6.isChecked()) {
            pertanyaan_37 += cbpertanyaan_37_6.getText().toString() + ", ";
            count_pertanyaan_37++;
        }
        // =========================================== END pertanyaan 37 ====================================================================

        pertanyaan_38 = spinner38;
        pertanyaan_39 = rg_pertanyaan_39;

        // =========================================== pertanyaan 40 ===================================================================
        pertanyaan_40 = "";
        int count_pertanyaan_40 = 0;
        if (cbpertanyaan_40_1.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_1.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_2.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_2.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_3.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_3.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_4.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_4.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_5.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_5.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_6.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_6.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_7.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_7.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_8.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_8.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_9.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_9.getText().toString() + ", ";
            count_pertanyaan_40++;
        }if (cbpertanyaan_40_10.isChecked()) {
            pertanyaan_40 += cbpertanyaan_40_10.getText().toString() + ", ";
            count_pertanyaan_40++;
        }
// =========================================== END pertanyaan 40 ====================================================================

        lat = tvlat.getText().toString();
        lang = tvlang.getText().toString();

        if (count_pertanyaan_25 < 4 && count_pertanyaan_26 < 1 && count_pertanyaan_27 < 4 && count_pertanyaan_28 < 1
                && count_pertanyaan_30 < 1 && count_pertanyaan_32 < 1 && count_pertanyaan_36 < 1
                && count_pertanyaan_37 < 1 && count_pertanyaan_40 < 1){
            Toast.makeText(getApplicationContext(), "CheckBox Eror", Toast.LENGTH_LONG).show();
        }else {
            apiService.surveyorAdd(SESSION_ID_SURVEYOR, nama_responden, alamat, provinsi, kab_kota, kecamatan, kel_desa, rt, rw, no_hp,
                    pertanyaan_12, pertanyaan_13, pertanyaan_14, pertanyaan_15, pertanyaan_16, pertanyaan_17,
                    pertanyaan_18, pertanyaan_19, pertanyaan_20, pertanyaan_21, pertanyaan_22, pertanyaan_23, pertanyaan_24, pertanyaan_25,
                    pertanyaan_26, pertanyaan_27, pertanyaan_28, pertanyaan_29, pertanyaan_30, pertanyaan_31, pertanyaan_32, pertanyaan_33,
                    pertanyaan_34, pertanyaan_35, pertanyaan_36, pertanyaan_37, pertanyaan_38, pertanyaan_39, pertanyaan_40, lat,
                    lang).enqueue(new Callback<ResponseResponden>() {
                @Override
                public void onResponse(Call<ResponseResponden> call, Response<ResponseResponden> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode()==200) {
                            Log.d("kumbang", "kedua");
                            String id_surveyor = response.body().getResponden().getIdSurveyor();
                            String nama_responden = response.body().getResponden().getNamaResponden();
                            String alamat = response.body().getResponden().getAlamat();
                            String provinsi = response.body().getResponden().getProvinsi();
                            String kab_kota = response.body().getResponden().getKabKota();
                            String kecamatan = response.body().getResponden().getKecamatan();
                            String kel_desa = response.body().getResponden().getKelDesa();
                            String rt = response.body().getResponden().getRt();
                            String rw = response.body().getResponden().getRw();
                            String no_hp = response.body().getResponden().getNoHp();
                            String pertanyaan_12 = response.body().getResponden().getPertanyaan12();
                            String pertanyaan_13 = response.body().getResponden().getPertanyaan13();
                            String pertanyaan_14 = response.body().getResponden().getPertanyaan14();
                            String pertanyaan_15 = response.body().getResponden().getPertanyaan15();
                            String pertanyaan_16 = response.body().getResponden().getPertanyaan16();
                            String pertanyaan_17 = response.body().getResponden().getPertanyaan17();
                            String pertanyaan_18 = response.body().getResponden().getPertanyaan18();
                            String pertanyaan_19 = response.body().getResponden().getPertanyaan19();
                            String pertanyaan_20 = response.body().getResponden().getPertanyaan20();
                            String pertanyaan_21 = response.body().getResponden().getPertanyaan21();
                            String pertanyaan_22 = response.body().getResponden().getPertanyaan22();
                            String pertanyaan_23 = response.body().getResponden().getPertanyaan23();
                            String pertanyaan_24 = response.body().getResponden().getPertanyaan24();
                            String pertanyaan_25 = response.body().getResponden().getPertanyaan25();
                            String pertanyaan_26 = response.body().getResponden().getPertanyaan26();
                            String pertanyaan_27 = response.body().getResponden().getPertanyaan27();
                            String pertanyaan_28 = response.body().getResponden().getPertanyaan28();
                            String pertanyaan_29 = response.body().getResponden().getPertanyaan29();
                            String pertanyaan_30 = response.body().getResponden().getPertanyaan30();
                            String pertanyaan_31 = response.body().getResponden().getPertanyaan31();
                            String pertanyaan_32 = response.body().getResponden().getPertanyaan32();
                            String pertanyaan_33 = response.body().getResponden().getPertanyaan33();
                            String pertanyaan_34 = response.body().getResponden().getPertanyaan34();
                            String pertanyaan_35 = response.body().getResponden().getPertanyaan35();
                            String pertanyaan_36 = response.body().getResponden().getPertanyaan36();
                            String pertanyaan_37 = response.body().getResponden().getPertanyaan37();
                            String pertanyaan_38 = response.body().getResponden().getPertanyaan38();
                            String pertanyaan_39 = response.body().getResponden().getPertanyaan39();
                            String pertanyaan_40 = response.body().getResponden().getPertanyaan40();
                            String lat = response.body().getResponden().getLat();
                            String lang = response.body().getResponden().getLang();

                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                            Intent a = new Intent(RespondenActivity.this, MainActivity.class);
                            startActivity(a);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
                @Override
                public void onFailure(Call<ResponseResponden> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Gagal konek ke server", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                }
            });
        }
    }
//======================================================= End Method ADD Responden ==========================================================
}
