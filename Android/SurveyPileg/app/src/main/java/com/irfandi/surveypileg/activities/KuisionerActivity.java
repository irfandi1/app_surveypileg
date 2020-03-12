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

public class KuisionerActivity extends AppCompatActivity {

    Intent kampang;
    private static String SESSION_ID_SURVEYOR;
    SessionManager sessionManager;

    ApiInterface apiService;
    LocationManager lm;
    LocationListener locationListener;

    private static final String TAG = KuisionerActivity.class.getSimpleName();

    private ArrayList<String> id_kabkota = new ArrayList<>();
    private ArrayList<String> nama_kabkota = new ArrayList<>();

    private ArrayList<Integer> id_kecamatan = new ArrayList<Integer>();
    private ArrayList<String> nama_kecamatan = new ArrayList<>();

    private ArrayList<Integer> id_kelurahan = new ArrayList<Integer>();
    private ArrayList<String> nama_kelurahan = new ArrayList<>();

    private Spinner spinnerkabkota, spinnerkecamatan, spinnerkelurahan;
    TextView tvprovinsi;

    EditText etnama_responden, etalamat, etrt, etrw, etno_hp;

    TextView tvlat, tvlang;

    RadioGroup radiogroup_pertanyaan_12;
    RadioButton radiobutton_pertanyaan_12_ya, radiobutton_pertanyaan_12_tidak, radiobutton_pertanyaan_12_belum_tahu;
    String rg_pertanyaan_12;

    RadioGroup radiogroup_pertanyaan_13;
    RadioButton radiobutton_pertanyaan_13_1, radiobutton_pertanyaan_13_2;
    String rg_pertanyaan_13;

    RadioGroup radiogroup_pertanyaan_16;
    RadioButton radiobutton_laki, radiobutton_perempuan;
    String jenis_kelamin;

    Spinner spinner_pertanyaan_14, spinner_pertanyaan_15, spinner_pertanyaan_17, spinner_pertanyaan_18, spinner_pertanyaan_19,
            spinner_pertanyaan_20, spinner_pertanyaan_21, spinner_pertanyaan_22, spinner_pertanyaan_23, spinner_pertanyaan_24,
            spinner_pertanyaan_25, spinner_pertanyaan_26, spinner_pertanyaan_27, spinner_pertanyaan_29, spinner_pertanyaan_30,
            spinner_pertanyaan_37,
            spinner_pertanyaan_40,spinner_pertanyaan_41,spinner_pertanyaan_42, spinner_pertanyaan_43,
            spinner_pertanyaan_44,
            spinner_pertanyaan_54;
    String spinner14, spinner15, spinner17, spinner18, spinner19, spinner20, spinner21, spinner22, spinner23, spinner24,
            spinner25, spinner26, spinner27, spinner29, spinner30,
            spinner37,
            spinner40,spinner41,spinner42, spinner43,
            spinner44,
            spinner54;

    RadioGroup radiogroup_pertanyaan_55;
    RadioButton radiobutton_pertanyaan_55_1, radiobutton_pertanyaan_55_2;
    String rg_pertanyaan_55;

    Button btnsumbit;

    Spinner spinner_pertanyaan_52, spinner_pertanyaan_53;
    String spinner52, spinner53;

    TextView tvpertanyaan_28_1, tvpertanyaan_28_2, tvpertanyaan_28_3, tvpertanyaan_28_4, tvpertanyaan_28_5, tvpertanyaan_28_6,
            tvpertanyaan_28_7;
    Spinner spinner_pertanyaan_28_1, spinner_pertanyaan_28_2, spinner_pertanyaan_28_3, spinner_pertanyaan_28_4,
            spinner_pertanyaan_28_5, spinner_pertanyaan_28_6, spinner_pertanyaan_28_7;
    String spinner28_1, spinner28_2, spinner28_3, spinner28_4, spinner28_5, spinner28_6, spinner28_7;

    CheckBox cbpertanyaan_31_1, cbpertanyaan_31_2, cbpertanyaan_31_3, cbpertanyaan_31_4, cbpertanyaan_31_5,
            cbpertanyaan_31_6, cbpertanyaan_31_7, cbpertanyaan_31_8,cbpertanyaan_31_9, cbpertanyaan_31_10,
            cbpertanyaan_31_11, cbpertanyaan_31_12, cbpertanyaan_31_13, cbpertanyaan_31_14,
            cbpertanyaan_31_15, cbpertanyaan_31_16;

    CheckBox cbpertanyaan_32_1, cbpertanyaan_32_2, cbpertanyaan_32_3, cbpertanyaan_32_4, cbpertanyaan_32_5,
            cbpertanyaan_32_6, cbpertanyaan_32_7, cbpertanyaan_32_8,cbpertanyaan_32_9, cbpertanyaan_32_10,
            cbpertanyaan_32_11, cbpertanyaan_32_12, cbpertanyaan_32_13, cbpertanyaan_32_14,
            cbpertanyaan_32_15, cbpertanyaan_32_16;

    CheckBox cbpertanyaan_33_1, cbpertanyaan_33_2, cbpertanyaan_33_3, cbpertanyaan_33_4, cbpertanyaan_33_5,
            cbpertanyaan_33_6, cbpertanyaan_33_7, cbpertanyaan_33_8,cbpertanyaan_33_9, cbpertanyaan_33_10,
            cbpertanyaan_33_11, cbpertanyaan_33_12, cbpertanyaan_33_13, cbpertanyaan_33_14,
            cbpertanyaan_33_15, cbpertanyaan_33_16;

    CheckBox cbpertanyaan_34_1, cbpertanyaan_34_2, cbpertanyaan_34_3, cbpertanyaan_34_4, cbpertanyaan_34_5,
            cbpertanyaan_34_6, cbpertanyaan_34_7, cbpertanyaan_34_8,cbpertanyaan_34_9, cbpertanyaan_34_10,
            cbpertanyaan_34_11, cbpertanyaan_34_12, cbpertanyaan_34_13, cbpertanyaan_34_14,
            cbpertanyaan_34_15, cbpertanyaan_34_16;

    CheckBox cbpertanyaan_35_1, cbpertanyaan_35_2, cbpertanyaan_35_3, cbpertanyaan_35_4, cbpertanyaan_35_5,
            cbpertanyaan_35_6, cbpertanyaan_35_7, cbpertanyaan_35_8,cbpertanyaan_35_9, cbpertanyaan_35_10,
            cbpertanyaan_35_11, cbpertanyaan_35_12, cbpertanyaan_35_13, cbpertanyaan_35_14,
            cbpertanyaan_35_15, cbpertanyaan_35_16;

    CheckBox cbpertanyaan_36_1, cbpertanyaan_36_2, cbpertanyaan_36_3, cbpertanyaan_36_4, cbpertanyaan_36_5,
            cbpertanyaan_36_6, cbpertanyaan_36_7, cbpertanyaan_36_8,cbpertanyaan_36_9, cbpertanyaan_36_10,
            cbpertanyaan_36_11, cbpertanyaan_36_12, cbpertanyaan_36_13, cbpertanyaan_36_14,
            cbpertanyaan_36_15, cbpertanyaan_36_16;

    RadioGroup radiogroup_pertanyaan_38;
    RadioButton rbpertanyaan_38_1, rbpertanyaan_38_2,rbpertanyaan_38_3, rbpertanyaan_38_4,
            rbpertanyaan_38_5, rbpertanyaan_38_6, rbpertanyaan_38_7, rbpertanyaan_38_8,
            rbpertanyaan_38_9, rbpertanyaan_38_10, rbpertanyaan_38_11, rbpertanyaan_38_12,
            rbpertanyaan_38_13, rbpertanyaan_38_14, rbpertanyaan_38_15, rbpertanyaan_38_16;
    String rg_pertanyaan_38;

    TextView tvpertanyaan_39_1, tvpertanyaan_39_2, tvpertanyaan_39_3, tvpertanyaan_39_4, tvpertanyaan_39_5, tvpertanyaan_39_6,
            tvpertanyaan_39_7, tvpertanyaan_39_8, tvpertanyaan_39_9, tvpertanyaan_39_10, tvpertanyaan_39_11, tvpertanyaan_39_12,
            tvpertanyaan_39_13, tvpertanyaan_39_14, tvpertanyaan_39_15;
    Spinner spinner_pertanyaan_39_1, spinner_pertanyaan_39_2, spinner_pertanyaan_39_3, spinner_pertanyaan_39_4,
            spinner_pertanyaan_39_5, spinner_pertanyaan_39_6, spinner_pertanyaan_39_7, spinner_pertanyaan_39_8,
            spinner_pertanyaan_39_9, spinner_pertanyaan_39_10, spinner_pertanyaan_39_11, spinner_pertanyaan_39_12,
            spinner_pertanyaan_39_13, spinner_pertanyaan_39_14, spinner_pertanyaan_39_15;
    String spinner39_1, spinner39_2, spinner39_3, spinner39_4, spinner39_5, spinner39_6, spinner39_7,  spinner39_8, spinner39_9,
            spinner39_10, spinner39_11, spinner39_12, spinner39_13, spinner39_14, spinner39_15;

    TextView tvpertanyaan_45_1, tvpertanyaan_45_2, tvpertanyaan_45_3, tvpertanyaan_45_4;
    Spinner spinner_pertanyaan_45_1, spinner_pertanyaan_45_2, spinner_pertanyaan_45_3, spinner_pertanyaan_45_4;
    String spinner45_1, spinner45_2, spinner45_3, spinner45_4;

    TextView tvpertanyaan_46_1, tvpertanyaan_46_2, tvpertanyaan_46_3, tvpertanyaan_46_4, tvpertanyaan_46_5;
    Spinner spinner_pertanyaan_46_1, spinner_pertanyaan_46_2, spinner_pertanyaan_46_3, spinner_pertanyaan_46_4,
            spinner_pertanyaan_46_5;
    String spinner46_1, spinner46_2, spinner46_3, spinner46_4, spinner46_5;

    TextView tvpertanyaan_47_1, tvpertanyaan_47_2, tvpertanyaan_47_3, tvpertanyaan_47_4, tvpertanyaan_47_5;
    Spinner spinner_pertanyaan_47_1, spinner_pertanyaan_47_2, spinner_pertanyaan_47_3, spinner_pertanyaan_47_4,
            spinner_pertanyaan_47_5;
    String spinner47_1, spinner47_2, spinner47_3, spinner47_4, spinner47_5;

    TextView tvpertanyaan_48_1, tvpertanyaan_48_2, tvpertanyaan_48_3, tvpertanyaan_48_4, tvpertanyaan_48_5;
    Spinner spinner_pertanyaan_48_1, spinner_pertanyaan_48_2, spinner_pertanyaan_48_3, spinner_pertanyaan_48_4,
            spinner_pertanyaan_48_5;
    String spinner48_1, spinner48_2, spinner48_3, spinner48_4, spinner48_5;

    TextView tvpertanyaan_49_1, tvpertanyaan_49_2, tvpertanyaan_49_3, tvpertanyaan_49_4, tvpertanyaan_49_5, tvpertanyaan_49_6;
    Spinner spinner_pertanyaan_49_1, spinner_pertanyaan_49_2, spinner_pertanyaan_49_3, spinner_pertanyaan_49_4,
            spinner_pertanyaan_49_5, spinner_pertanyaan_49_6;
    String spinner49_1, spinner49_2, spinner49_3, spinner49_4, spinner49_5, spinner49_6;

    TextView tvpertanyaan_50_1, tvpertanyaan_50_2, tvpertanyaan_50_3, tvpertanyaan_50_4, tvpertanyaan_50_5;
    Spinner spinner_pertanyaan_50_1, spinner_pertanyaan_50_2, spinner_pertanyaan_50_3, spinner_pertanyaan_50_4,
            spinner_pertanyaan_50_5;
    String spinner50_1, spinner50_2, spinner50_3, spinner50_4, spinner50_5;

    TextView tvpertanyaan_51_1, tvpertanyaan_51_2, tvpertanyaan_51_3, tvpertanyaan_51_4, tvpertanyaan_51_5, tvpertanyaan_51_6,
            tvpertanyaan_51_7, tvpertanyaan_51_8, tvpertanyaan_51_9, tvpertanyaan_51_10, tvpertanyaan_51_11;
    Spinner spinner_pertanyaan_51_1, spinner_pertanyaan_51_2, spinner_pertanyaan_51_3, spinner_pertanyaan_51_4,
            spinner_pertanyaan_51_5, spinner_pertanyaan_51_6, spinner_pertanyaan_51_7, spinner_pertanyaan_51_8,
            spinner_pertanyaan_51_9, spinner_pertanyaan_51_10, spinner_pertanyaan_51_11;
    String spinner51_1, spinner51_2, spinner51_3, spinner51_4, spinner51_5, spinner51_6, spinner51_7, spinner51_8, spinner51_9,
            spinner51_10, spinner51_11;

    String nama_responden, alamat, provinsi, kab_kota, kecamatan, kel_desa, rt, rw, no_hp, nama_kk, no_urut_responden, pertanyaan_12,
            pertanyaan_13, pertanyaan_14, pertanyaan_15, pertanyaan_16, pertanyaan_17, pertanyaan_18, pertanyaan_19, pertanyaan_20,
            pertanyaan_21, pertanyaan_22, pertanyaan_23, pertanyaan_24, pertanyaan_25, pertanyaan_26, pertanyaan_27, pertanyaan_28,
            pertanyaan_29, pertanyaan_30, pertanyaan_31, pertanyaan_32, pertanyaan_33, pertanyaan_34, pertanyaan_35, pertanyaan_36,
            pertanyaan_37, pertanyaan_38, pertanyaan_39, pertanyaan_40, pertanyaan_41, pertanyaan_42, pertanyaan_43, pertanyaan_44,
            pertanyaan_45, pertanyaan_46, pertanyaan_47, pertanyaan_48, pertanyaan_49, pertanyaan_50, pertanyaan_51, pertanyaan_52,
            pertanyaan_53, pertanyaan_54, pertanyaan_55, lat, lang;

//    Double lat, lang; ===========================================================================================================

    //    Location Based Manager
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
//END Location Based Manager=======================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuisioner);

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener();

        sessionManager = new SessionManager(this);
        SESSION_ID_SURVEYOR = sessionManager.getSurveyorDetail().get(SessionManager.ID_SURVEYOR);
        apiService = ApiClient.getClient().create(ApiInterface.class);

        getKabkota();

        etnama_responden = findViewById(R.id.etnama_responden);
        etalamat = findViewById(R.id.etalamat);
        etrt = findViewById(R.id.etrt);
        etrw = findViewById(R.id.etrw);
        etno_hp = findViewById(R.id.etno_hp);
//        etnama_kk = findViewById(R.id.etnama_kk);
//        etno_urut_responden = findViewById(R.id.etno_urut_responden);

        tvprovinsi = findViewById(R.id.tvprovinsi);

        spinnerkabkota = findViewById(R.id.spinnerkabkota);
        spinnerkecamatan = findViewById(R.id.spinnerkecamatan);
        spinnerkelurahan = findViewById(R.id.spinnerkelurahan);

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
                        rg_pertanyaan_12 = "Tidak";
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
        radiobutton_pertanyaan_13_1 = findViewById(R.id.radiobutton_pertanyaan_13_1);
        radiobutton_pertanyaan_13_2 = findViewById(R.id.radiobutton_pertanyaan_13_2);

        radiogroup_pertanyaan_13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int option = radiogroup_pertanyaan_13.getCheckedRadioButtonId();
                switch (option) {
                    case R.id.radiobutton_pertanyaan_13_1:
                        rg_pertanyaan_13 = "Ya, dan menggunakan hak pilihnya";
                        break;
                    case R.id.radiobutton_pertanyaan_13_2:
                        rg_pertanyaan_13 = "Ya, tapi tidak menggunakan hak pilihnya";
                        break;
                }
            }
        });
// END Radio Group dan Radio Button Pertanyaan 13

// Spinner pertanyaan 14
        spinner_pertanyaan_14 = findViewById(R.id.spinner_pertanyaan_14);

        spinner_pertanyaan_14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_15);
                spinner14 = String.valueOf(size_values);
                spinner14 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 14

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

// Radio Group dan Radio Button Jenis Kelamin 16
        radiogroup_pertanyaan_16 = findViewById(R.id.radio_group_pertanyaan_16);
        radiobutton_laki = findViewById(R.id.radiobutton_laki_laki);
        radiobutton_perempuan = findViewById(R.id.radiobutton_perempuan);

        radiogroup_pertanyaan_16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int option = radiogroup_pertanyaan_16.getCheckedRadioButtonId();
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
// End Radio Group dan Radio Button Jenis Kelamin 16

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

// Spinner pertanyaan 24
        spinner_pertanyaan_24 = findViewById(R.id.spinner_pertanyaan_24);

        spinner_pertanyaan_24.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_24);
                spinner24 = String.valueOf(size_values);
                spinner24 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 24

// Spinner pertanyaan 25
        spinner_pertanyaan_25 = findViewById(R.id.spinner_pertanyaan_25);

        spinner_pertanyaan_25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_25);
                spinner25 = String.valueOf(size_values);
                spinner25 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 25

// Spinner pertanyaan 26
        spinner_pertanyaan_26 = findViewById(R.id.spinner_pertanyaan_26);

        spinner_pertanyaan_26.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_26);
                spinner26 = String.valueOf(size_values);
                spinner26 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 26

// Spinner pertanyaan 27
        spinner_pertanyaan_27 = findViewById(R.id.spinner_pertanyaan_27);

        spinner_pertanyaan_27.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_27);
                spinner27 = String.valueOf(size_values);
                spinner27 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 27

//========================================== pertanyaan 28 =====================================================================
        tvpertanyaan_28_1 = findViewById(R.id.tvpertanyaan_28_1);
        tvpertanyaan_28_2 = findViewById(R.id.tvpertanyaan_28_2);
        tvpertanyaan_28_3 = findViewById(R.id.tvpertanyaan_28_3);
        tvpertanyaan_28_4 = findViewById(R.id.tvpertanyaan_28_4);
        tvpertanyaan_28_5 = findViewById(R.id.tvpertanyaan_28_5);
        tvpertanyaan_28_6 = findViewById(R.id.tvpertanyaan_28_6);
        tvpertanyaan_28_7 = findViewById(R.id.tvpertanyaan_28_7);

        spinner_pertanyaan_28_1 = findViewById(R.id.spinner_pertanyaan_28_1);
        spinner_pertanyaan_28_2 = findViewById(R.id.spinner_pertanyaan_28_2);
        spinner_pertanyaan_28_3 = findViewById(R.id.spinner_pertanyaan_28_3);
        spinner_pertanyaan_28_4 = findViewById(R.id.spinner_pertanyaan_28_4);
        spinner_pertanyaan_28_5 = findViewById(R.id.spinner_pertanyaan_28_5);
        spinner_pertanyaan_28_6 = findViewById(R.id.spinner_pertanyaan_28_6);
        spinner_pertanyaan_28_7 = findViewById(R.id.spinner_pertanyaan_28_7);

        spinner_pertanyaan_28_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_28);
                spinner28_1 = String.valueOf(size_values);
                spinner28_1 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_pertanyaan_28_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_28);
                spinner28_2 = String.valueOf(size_values);
                spinner28_2 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_28_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_28);
                spinner28_3 = String.valueOf(size_values);
                spinner28_3 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_28_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_28);
                spinner28_4 = String.valueOf(size_values);
                spinner28_4 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_28_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_28);
                spinner28_5 = String.valueOf(size_values);
                spinner28_5 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_28_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_28);
                spinner28_6 = String.valueOf(size_values);
                spinner28_6 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_28_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_28);
                spinner28_7 = String.valueOf(size_values);
                spinner28_7 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//========================================= END pertanyaan 28 =================================================================

// Spinner pertanyaan 29
        spinner_pertanyaan_29 = findViewById(R.id.spinner_pertanyaan_29);

        spinner_pertanyaan_29.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_29);
                spinner29 = String.valueOf(size_values);
                spinner29 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 29

// Spinner pertanyaan 30
        spinner_pertanyaan_30 = findViewById(R.id.spinner_pertanyaan_30);

        spinner_pertanyaan_30.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_38);
                spinner30 = String.valueOf(size_values);
                spinner30 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 30
// ================================================= CheckBox 31 ============================================================

        cbpertanyaan_31_1 = findViewById(R.id.cbpertanyaan_31_1);
        cbpertanyaan_31_2 = findViewById(R.id.cbpertanyaan_31_2);
        cbpertanyaan_31_3 = findViewById(R.id.cbpertanyaan_31_3);
        cbpertanyaan_31_4 = findViewById(R.id.cbpertanyaan_31_4);
        cbpertanyaan_31_5 = findViewById(R.id.cbpertanyaan_31_5);
        cbpertanyaan_31_6 = findViewById(R.id.cbpertanyaan_31_6);
        cbpertanyaan_31_7 = findViewById(R.id.cbpertanyaan_31_7);
        cbpertanyaan_31_8 = findViewById(R.id.cbpertanyaan_31_8);
        cbpertanyaan_31_9 = findViewById(R.id.cbpertanyaan_31_9);
        cbpertanyaan_31_10 = findViewById(R.id.cbpertanyaan_31_10);
        cbpertanyaan_31_11 = findViewById(R.id.cbpertanyaan_31_11);
        cbpertanyaan_31_12 = findViewById(R.id.cbpertanyaan_31_12);
        cbpertanyaan_31_13 = findViewById(R.id.cbpertanyaan_31_13);
        cbpertanyaan_31_14 = findViewById(R.id.cbpertanyaan_31_14);
        cbpertanyaan_31_15 = findViewById(R.id.cbpertanyaan_31_15);
        cbpertanyaan_31_16 = findViewById(R.id.cbpertanyaan_31_16);

// =============================================== END CheckBox 31 ============================================================

// ================================================= CheckBox 32 ============================================================

        cbpertanyaan_32_1 = findViewById(R.id.cbpertanyaan_32_1);
        cbpertanyaan_32_2 = findViewById(R.id.cbpertanyaan_32_2);
        cbpertanyaan_32_3 = findViewById(R.id.cbpertanyaan_32_3);
        cbpertanyaan_32_4 = findViewById(R.id.cbpertanyaan_32_4);
        cbpertanyaan_32_5 = findViewById(R.id.cbpertanyaan_32_5);
        cbpertanyaan_32_6 = findViewById(R.id.cbpertanyaan_32_6);
        cbpertanyaan_32_7 = findViewById(R.id.cbpertanyaan_32_7);
        cbpertanyaan_32_8 = findViewById(R.id.cbpertanyaan_32_8);
        cbpertanyaan_32_9 = findViewById(R.id.cbpertanyaan_32_9);
        cbpertanyaan_32_10 = findViewById(R.id.cbpertanyaan_32_10);
        cbpertanyaan_32_11 = findViewById(R.id.cbpertanyaan_32_11);
        cbpertanyaan_32_12 = findViewById(R.id.cbpertanyaan_32_12);
        cbpertanyaan_32_13 = findViewById(R.id.cbpertanyaan_32_13);
        cbpertanyaan_32_14 = findViewById(R.id.cbpertanyaan_32_14);
        cbpertanyaan_32_15 = findViewById(R.id.cbpertanyaan_32_15);
        cbpertanyaan_32_16 = findViewById(R.id.cbpertanyaan_32_16);

// =============================================== END CheckBox 32 ============================================================

// ================================================= CheckBox 33 ============================================================

        cbpertanyaan_33_1 = findViewById(R.id.cbpertanyaan_33_1);
        cbpertanyaan_33_2 = findViewById(R.id.cbpertanyaan_33_2);
        cbpertanyaan_33_3 = findViewById(R.id.cbpertanyaan_33_3);
        cbpertanyaan_33_4 = findViewById(R.id.cbpertanyaan_33_4);
        cbpertanyaan_33_5 = findViewById(R.id.cbpertanyaan_33_5);
        cbpertanyaan_33_6 = findViewById(R.id.cbpertanyaan_33_6);
        cbpertanyaan_33_7 = findViewById(R.id.cbpertanyaan_33_7);
        cbpertanyaan_33_8 = findViewById(R.id.cbpertanyaan_33_8);
        cbpertanyaan_33_9 = findViewById(R.id.cbpertanyaan_33_9);
        cbpertanyaan_33_10 = findViewById(R.id.cbpertanyaan_33_10);
        cbpertanyaan_33_11 = findViewById(R.id.cbpertanyaan_33_11);
        cbpertanyaan_33_12 = findViewById(R.id.cbpertanyaan_33_12);
        cbpertanyaan_33_13 = findViewById(R.id.cbpertanyaan_33_13);
        cbpertanyaan_33_14 = findViewById(R.id.cbpertanyaan_33_14);
        cbpertanyaan_33_15 = findViewById(R.id.cbpertanyaan_33_15);
        cbpertanyaan_33_16 = findViewById(R.id.cbpertanyaan_33_16);

// =============================================== END CheckBox 33 ============================================================


// ================================================= CheckBox 34 ============================================================

        cbpertanyaan_34_1 = findViewById(R.id.cbpertanyaan_34_1);
        cbpertanyaan_34_2 = findViewById(R.id.cbpertanyaan_34_2);
        cbpertanyaan_34_3 = findViewById(R.id.cbpertanyaan_34_3);
        cbpertanyaan_34_4 = findViewById(R.id.cbpertanyaan_34_4);
        cbpertanyaan_34_5 = findViewById(R.id.cbpertanyaan_34_5);
        cbpertanyaan_34_6 = findViewById(R.id.cbpertanyaan_34_6);
        cbpertanyaan_34_7 = findViewById(R.id.cbpertanyaan_34_7);
        cbpertanyaan_34_8 = findViewById(R.id.cbpertanyaan_34_8);
        cbpertanyaan_34_9 = findViewById(R.id.cbpertanyaan_34_9);
        cbpertanyaan_34_10 = findViewById(R.id.cbpertanyaan_34_10);
        cbpertanyaan_34_11 = findViewById(R.id.cbpertanyaan_34_11);
        cbpertanyaan_34_12 = findViewById(R.id.cbpertanyaan_34_12);
        cbpertanyaan_34_13 = findViewById(R.id.cbpertanyaan_34_13);
        cbpertanyaan_34_14 = findViewById(R.id.cbpertanyaan_34_14);
        cbpertanyaan_34_15 = findViewById(R.id.cbpertanyaan_34_15);
        cbpertanyaan_34_16 = findViewById(R.id.cbpertanyaan_34_16);

// =============================================== END CheckBox 34 ============================================================

// ================================================= CheckBox 35 ============================================================

        cbpertanyaan_35_1 = findViewById(R.id.cbpertanyaan_35_1);
        cbpertanyaan_35_2 = findViewById(R.id.cbpertanyaan_35_2);
        cbpertanyaan_35_3 = findViewById(R.id.cbpertanyaan_35_3);
        cbpertanyaan_35_4 = findViewById(R.id.cbpertanyaan_35_4);
        cbpertanyaan_35_5 = findViewById(R.id.cbpertanyaan_35_5);
        cbpertanyaan_35_6 = findViewById(R.id.cbpertanyaan_35_6);
        cbpertanyaan_35_7 = findViewById(R.id.cbpertanyaan_35_7);
        cbpertanyaan_35_8 = findViewById(R.id.cbpertanyaan_35_8);
        cbpertanyaan_35_9 = findViewById(R.id.cbpertanyaan_35_9);
        cbpertanyaan_35_10 = findViewById(R.id.cbpertanyaan_35_10);
        cbpertanyaan_35_11 = findViewById(R.id.cbpertanyaan_35_11);
        cbpertanyaan_35_12 = findViewById(R.id.cbpertanyaan_35_12);
        cbpertanyaan_35_13 = findViewById(R.id.cbpertanyaan_35_13);
        cbpertanyaan_35_14 = findViewById(R.id.cbpertanyaan_35_14);
        cbpertanyaan_35_15 = findViewById(R.id.cbpertanyaan_35_15);
        cbpertanyaan_35_16 = findViewById(R.id.cbpertanyaan_35_16);

// =============================================== END CheckBox 35 ============================================================

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
        cbpertanyaan_36_13 = findViewById(R.id.cbpertanyaan_36_13);
        cbpertanyaan_36_14 = findViewById(R.id.cbpertanyaan_36_14);
        cbpertanyaan_36_15 = findViewById(R.id.cbpertanyaan_36_15);
        cbpertanyaan_36_16 = findViewById(R.id.cbpertanyaan_36_16);

// =============================================== END CheckBox 36 ============================================================


// Spinner pertanyaan 37
        spinner_pertanyaan_37 = findViewById(R.id.spinner_pertanyaan_37);

        spinner_pertanyaan_37.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_38);
                spinner37 = String.valueOf(size_values);
                spinner37 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// END Spinner pertanyaan 37

// ================================================= Radio Button 38 ============================================================
        radiogroup_pertanyaan_38 = findViewById(R.id.radiogroup_pertanyaan_38);
        rbpertanyaan_38_1 = findViewById(R.id.rbpertanyaan_38_1);
        rbpertanyaan_38_2 = findViewById(R.id.rbpertanyaan_38_2);
        rbpertanyaan_38_3 = findViewById(R.id.rbpertanyaan_38_3);
        rbpertanyaan_38_4 = findViewById(R.id.rbpertanyaan_38_4);
        rbpertanyaan_38_5 = findViewById(R.id.rbpertanyaan_38_5);
        rbpertanyaan_38_6 = findViewById(R.id.rbpertanyaan_38_6);
        rbpertanyaan_38_7 = findViewById(R.id.rbpertanyaan_38_7);
        rbpertanyaan_38_8 = findViewById(R.id.rbpertanyaan_38_8);
        rbpertanyaan_38_9 = findViewById(R.id.rbpertanyaan_38_9);
        rbpertanyaan_38_10 = findViewById(R.id.rbpertanyaan_38_10);
        rbpertanyaan_38_11 = findViewById(R.id.rbpertanyaan_38_11);
        rbpertanyaan_38_12 = findViewById(R.id.rbpertanyaan_38_12);
        rbpertanyaan_38_13 = findViewById(R.id.rbpertanyaan_38_13);
        rbpertanyaan_38_14 = findViewById(R.id.rbpertanyaan_38_14);
        rbpertanyaan_38_15 = findViewById(R.id.rbpertanyaan_38_15);
        rbpertanyaan_38_16 = findViewById(R.id.rbpertanyaan_38_16);

        radiogroup_pertanyaan_38.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rbpertanyaan_38_1.isChecked()){
                    rg_pertanyaan_38 = "PKB";
                }
                if (rbpertanyaan_38_2.isChecked()){
                    rg_pertanyaan_38 = "GERINDA";
                }
                if (rbpertanyaan_38_3.isChecked()){
                    rg_pertanyaan_38 = "PDI Perjuangan";
                }
                if (rbpertanyaan_38_4.isChecked()){
                    rg_pertanyaan_38 = "Golkar";
                }
                if (rbpertanyaan_38_5.isChecked()){
                    rg_pertanyaan_38 = "NASDEM";
                }
                if (rbpertanyaan_38_6.isChecked()){
                    rg_pertanyaan_38 = "Partai Garuda";
                }
                if (rbpertanyaan_38_7.isChecked()){
                    rg_pertanyaan_38 = "Partai Berkaya";
                }
                if (rbpertanyaan_38_8.isChecked()){
                    rg_pertanyaan_38 = "PKS";
                }
                if (rbpertanyaan_38_9.isChecked()){
                    rg_pertanyaan_38 = "PERINDO";
                }
                if (rbpertanyaan_38_10.isChecked()){
                    rg_pertanyaan_38 = "PPP";
                }
                if (rbpertanyaan_38_11.isChecked()){
                    rg_pertanyaan_38 = "PSI";
                }
                if (rbpertanyaan_38_12.isChecked()){
                    rg_pertanyaan_38 = "PAN";
                }if (rbpertanyaan_38_13.isChecked()){
                    rg_pertanyaan_38 = "HANURA";
                }if (rbpertanyaan_38_14.isChecked()){
                    rg_pertanyaan_38 = "DEMOKRAT";
                }if (rbpertanyaan_38_15.isChecked()){
                    rg_pertanyaan_38 = "PBB";
                }if (rbpertanyaan_38_16.isChecked()) {
                    rg_pertanyaan_38 = "PKP Indonesia";
                }
            }
        });

// =============================================== END Radio Button 38 ============================================================

// ============================================= pertanyaan 39 ================================================================
        tvpertanyaan_39_1  = findViewById(R.id.tvpertanyaan_39_1); tvpertanyaan_39_2  = findViewById(R.id.tvpertanyaan_39_2);
        tvpertanyaan_39_3  = findViewById(R.id.tvpertanyaan_39_3); tvpertanyaan_39_4  = findViewById(R.id.tvpertanyaan_39_4);
        tvpertanyaan_39_5  = findViewById(R.id.tvpertanyaan_39_5); tvpertanyaan_39_6  = findViewById(R.id.tvpertanyaan_39_6);
        tvpertanyaan_39_7  = findViewById(R.id.tvpertanyaan_39_7); tvpertanyaan_39_8  = findViewById(R.id.tvpertanyaan_39_8);
        tvpertanyaan_39_9  = findViewById(R.id.tvpertanyaan_39_9); tvpertanyaan_39_10 = findViewById(R.id.tvpertanyaan_39_10);
        tvpertanyaan_39_11 = findViewById(R.id.tvpertanyaan_39_11); tvpertanyaan_39_12 = findViewById(R.id.tvpertanyaan_39_12);
        tvpertanyaan_39_13 = findViewById(R.id.tvpertanyaan_39_13); tvpertanyaan_39_14 = findViewById(R.id.tvpertanyaan_39_14);
        tvpertanyaan_39_15 = findViewById(R.id.tvpertanyaan_39_15);

        spinner_pertanyaan_39_1 = findViewById(R.id.spinner_pertanyaan_39_1);
        spinner_pertanyaan_39_2 = findViewById(R.id.spinner_pertanyaan_39_2);
        spinner_pertanyaan_39_3 = findViewById(R.id.spinner_pertanyaan_39_3);
        spinner_pertanyaan_39_4 = findViewById(R.id.spinner_pertanyaan_39_4);
        spinner_pertanyaan_39_5 = findViewById(R.id.spinner_pertanyaan_39_5);
        spinner_pertanyaan_39_6 = findViewById(R.id.spinner_pertanyaan_39_6);
        spinner_pertanyaan_39_7 = findViewById(R.id.spinner_pertanyaan_39_7);
        spinner_pertanyaan_39_8 = findViewById(R.id.spinner_pertanyaan_39_8);
        spinner_pertanyaan_39_9 = findViewById(R.id.spinner_pertanyaan_39_9);
        spinner_pertanyaan_39_10 = findViewById(R.id.spinner_pertanyaan_39_10);
        spinner_pertanyaan_39_11 = findViewById(R.id.spinner_pertanyaan_39_11);
        spinner_pertanyaan_39_12 = findViewById(R.id.spinner_pertanyaan_39_12);
        spinner_pertanyaan_39_13 = findViewById(R.id.spinner_pertanyaan_39_13);
        spinner_pertanyaan_39_14 = findViewById(R.id.spinner_pertanyaan_39_14);
        spinner_pertanyaan_39_15 = findViewById(R.id.spinner_pertanyaan_39_15);

        spinner_pertanyaan_39_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_1 = String.valueOf(size_values);
                spinner39_1 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_2 = String.valueOf(size_values);
                spinner39_2 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_3 = String.valueOf(size_values);
                spinner39_3 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_4 = String.valueOf(size_values);
                spinner39_4 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_5 = String.valueOf(size_values);
                spinner39_5 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_6 = String.valueOf(size_values);
                spinner39_6 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_7 = String.valueOf(size_values);
                spinner39_7 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_8 = String.valueOf(size_values);
                spinner39_8 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_9 = String.valueOf(size_values);
                spinner39_9 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_10 = String.valueOf(size_values);
                spinner39_10 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_11 = String.valueOf(size_values);
                spinner39_11 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_12 = String.valueOf(size_values);
                spinner39_12 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_13 = String.valueOf(size_values);
                spinner39_13 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_14 = String.valueOf(size_values);
                spinner39_14 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_pertanyaan_39_15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_39);
                spinner39_15 = String.valueOf(size_values);
                spinner39_15 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// ============================================= END pertanyaan 39 =============================================================

// Spinner pertanyaan 40
        spinner_pertanyaan_40 = findViewById(R.id.spinner_pertanyaan_40);

        spinner_pertanyaan_40.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_40);
                spinner40 = String.valueOf(size_values);
                spinner40 = (String) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// =========================================== END Spinner pertanyaan 40 ======================================================

// ============================================= Spinner pertanyaan 41 ========================================================
//        spinner_pertanyaan_41 = findViewById(R.id.spinner_pertanyaan_41);
//
//        spinner_pertanyaan_41.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_41);
//                spinner41 = String.valueOf(size_values);
//                spinner41 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================ END Spinner pertanyaan 41 ==================================================

// ============================================= Spinner pertanyaan 42 ========================================================
//        spinner_pertanyaan_42 = findViewById(R.id.spinner_pertanyaan_42);
//
//        spinner_pertanyaan_42.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_41);
//                spinner42 = String.valueOf(size_values);
//                spinner42 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================ END Spinner pertanyaan 42 ==================================================

// ============================================= Spinner pertanyaan 43 ========================================================
//        spinner_pertanyaan_43 = findViewById(R.id.spinner_pertanyaan_43);
//
//        spinner_pertanyaan_43.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_43);
//                spinner43 = String.valueOf(size_values);
//                spinner43 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================ END Spinner pertanyaan 43 ==================================================

// Spinner pertanyaan 44
//        spinner_pertanyaan_44 = findViewById(R.id.spinner_pertanyaan_44);
//
//        spinner_pertanyaan_44.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_44);
//                spinner44 = String.valueOf(size_values);
//                spinner44 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// END Spinner pertanyaan 44

// ============================================= pertanyaan 45 ================================================================
//        tvpertanyaan_45_1  = findViewById(R.id.tvpertanyaan_45_1); tvpertanyaan_45_2  = findViewById(R.id.tvpertanyaan_45_2);
//        tvpertanyaan_45_3  = findViewById(R.id.tvpertanyaan_45_3); tvpertanyaan_45_4  = findViewById(R.id.tvpertanyaan_45_4);
//
//        spinner_pertanyaan_45_1 = findViewById(R.id.spinner_pertanyaan_45_1);
//        spinner_pertanyaan_45_2 = findViewById(R.id.spinner_pertanyaan_45_2);
//        spinner_pertanyaan_45_3 = findViewById(R.id.spinner_pertanyaan_45_3);
//        spinner_pertanyaan_45_4 = findViewById(R.id.spinner_pertanyaan_45_4);
//
//        spinner_pertanyaan_45_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_45_1);
//                spinner45_1 = String.valueOf(size_values);
//                spinner45_1 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_45_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_45_2);
//                spinner45_2 = String.valueOf(size_values);
//                spinner45_2 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_45_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_45_3);
//                spinner45_3 = String.valueOf(size_values);
//                spinner45_3 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_45_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_45_4);
//                spinner45_4 = String.valueOf(size_values);
//                spinner45_4 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================= END pertanyaan 45 =============================================================

// ============================================= pertanyaan 46 ================================================================
//        tvpertanyaan_46_1  = findViewById(R.id.tvpertanyaan_46_1);
//        tvpertanyaan_46_2  = findViewById(R.id.tvpertanyaan_46_2);
//        tvpertanyaan_46_3  = findViewById(R.id.tvpertanyaan_46_3);
//        tvpertanyaan_46_4  = findViewById(R.id.tvpertanyaan_46_4);
//        tvpertanyaan_46_5  = findViewById(R.id.tvpertanyaan_46_5);
//
//        spinner_pertanyaan_46_1 = findViewById(R.id.spinner_pertanyaan_46_1);
//        spinner_pertanyaan_46_2 = findViewById(R.id.spinner_pertanyaan_46_2);
//        spinner_pertanyaan_46_3 = findViewById(R.id.spinner_pertanyaan_46_3);
//        spinner_pertanyaan_46_4 = findViewById(R.id.spinner_pertanyaan_46_4);
//        spinner_pertanyaan_46_5 = findViewById(R.id.spinner_pertanyaan_46_5);
//
//        spinner_pertanyaan_46_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner46_1 = String.valueOf(size_values);
//                spinner46_1 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_46_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner46_2 = String.valueOf(size_values);
//                spinner46_2 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_46_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner46_3 = String.valueOf(size_values);
//                spinner46_3 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_46_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner46_4 = String.valueOf(size_values);
//                spinner46_4 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_46_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner46_5 = String.valueOf(size_values);
//                spinner46_5 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

// ============================================= END pertanyaan 46 =============================================================


// ============================================= pertanyaan 47 ================================================================

//        tvpertanyaan_47_1  = findViewById(R.id.tvpertanyaan_47_1);
//        tvpertanyaan_47_2  = findViewById(R.id.tvpertanyaan_47_2);
//        tvpertanyaan_47_3  = findViewById(R.id.tvpertanyaan_47_3);
//        tvpertanyaan_47_4  = findViewById(R.id.tvpertanyaan_47_4);
//        tvpertanyaan_47_5  = findViewById(R.id.tvpertanyaan_47_5);
//
//        spinner_pertanyaan_47_1 = findViewById(R.id.spinner_pertanyaan_47_1);
//        spinner_pertanyaan_47_2 = findViewById(R.id.spinner_pertanyaan_47_2);
//        spinner_pertanyaan_47_3 = findViewById(R.id.spinner_pertanyaan_47_3);
//        spinner_pertanyaan_47_4 = findViewById(R.id.spinner_pertanyaan_47_4);
//        spinner_pertanyaan_47_5 = findViewById(R.id.spinner_pertanyaan_47_5);
//
//        spinner_pertanyaan_47_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner47_1 = String.valueOf(size_values);
//                spinner47_1 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_47_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner47_2 = String.valueOf(size_values);
//                spinner47_2 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_47_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner47_3 = String.valueOf(size_values);
//                spinner47_3 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_47_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner47_4 = String.valueOf(size_values);
//                spinner47_4 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_47_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner47_5 = String.valueOf(size_values);
//                spinner47_5 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================= END pertanyaan 47 =============================================================


// ============================================= pertanyaan 48 ================================================================

//        tvpertanyaan_48_1  = findViewById(R.id.tvpertanyaan_48_1);
//        tvpertanyaan_48_2  = findViewById(R.id.tvpertanyaan_48_2);
//        tvpertanyaan_48_3  = findViewById(R.id.tvpertanyaan_48_3);
//        tvpertanyaan_48_4  = findViewById(R.id.tvpertanyaan_48_4);
//        tvpertanyaan_48_5  = findViewById(R.id.tvpertanyaan_48_5);
//
//        spinner_pertanyaan_48_1 = findViewById(R.id.spinner_pertanyaan_48_1);
//        spinner_pertanyaan_48_2 = findViewById(R.id.spinner_pertanyaan_48_2);
//        spinner_pertanyaan_48_3 = findViewById(R.id.spinner_pertanyaan_48_3);
//        spinner_pertanyaan_48_4 = findViewById(R.id.spinner_pertanyaan_48_4);
//        spinner_pertanyaan_48_5 = findViewById(R.id.spinner_pertanyaan_48_5);
//
//        spinner_pertanyaan_48_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner48_1 = String.valueOf(size_values);
//                spinner48_1 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_48_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner48_2 = String.valueOf(size_values);
//                spinner48_2 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_48_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner48_3 = String.valueOf(size_values);
//                spinner48_3 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_48_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner48_4 = String.valueOf(size_values);
//                spinner48_4 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_48_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner48_5 = String.valueOf(size_values);
//                spinner48_5 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================= END pertanyaan 48 =============================================================


// ============================================= pertanyaan 49 ================================================================

//        tvpertanyaan_49_1  = findViewById(R.id.tvpertanyaan_49_1);
//        tvpertanyaan_49_2  = findViewById(R.id.tvpertanyaan_49_2);
//        tvpertanyaan_49_3  = findViewById(R.id.tvpertanyaan_49_3);
//        tvpertanyaan_49_4  = findViewById(R.id.tvpertanyaan_49_4);
//        tvpertanyaan_49_5  = findViewById(R.id.tvpertanyaan_49_5);
//        tvpertanyaan_49_6  = findViewById(R.id.tvpertanyaan_49_6);
//
//        spinner_pertanyaan_49_1 = findViewById(R.id.spinner_pertanyaan_49_1);
//        spinner_pertanyaan_49_2 = findViewById(R.id.spinner_pertanyaan_49_2);
//        spinner_pertanyaan_49_3 = findViewById(R.id.spinner_pertanyaan_49_3);
//        spinner_pertanyaan_49_4 = findViewById(R.id.spinner_pertanyaan_49_4);
//        spinner_pertanyaan_49_5 = findViewById(R.id.spinner_pertanyaan_49_5);
//        spinner_pertanyaan_49_6 = findViewById(R.id.spinner_pertanyaan_49_6);
//
//        spinner_pertanyaan_49_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner49_1 = String.valueOf(size_values);
//                spinner49_1 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_49_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner49_2 = String.valueOf(size_values);
//                spinner49_2 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_49_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner49_3 = String.valueOf(size_values);
//                spinner49_3 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_49_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner49_4 = String.valueOf(size_values);
//                spinner49_4 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_49_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner49_5 = String.valueOf(size_values);
//                spinner49_5 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_49_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner49_6 = String.valueOf(size_values);
//                spinner49_6 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================= END pertanyaan 49 =============================================================



//        etpertanyaan_49 = findViewById(R.id.etpertanyaan_49);

// ============================================= pertanyaan 50 ================================================================
//        tvpertanyaan_50_1  = findViewById(R.id.tvpertanyaan_50_1);
//        tvpertanyaan_50_2  = findViewById(R.id.tvpertanyaan_50_2);
//        tvpertanyaan_50_3  = findViewById(R.id.tvpertanyaan_50_3);
//        tvpertanyaan_50_4  = findViewById(R.id.tvpertanyaan_50_4);
//        tvpertanyaan_50_5  = findViewById(R.id.tvpertanyaan_50_5);
//
//        spinner_pertanyaan_50_1 = findViewById(R.id.spinner_pertanyaan_50_1);
//        spinner_pertanyaan_50_2 = findViewById(R.id.spinner_pertanyaan_50_2);
//        spinner_pertanyaan_50_3 = findViewById(R.id.spinner_pertanyaan_50_3);
//        spinner_pertanyaan_50_4 = findViewById(R.id.spinner_pertanyaan_50_4);
//        spinner_pertanyaan_50_5 = findViewById(R.id.spinner_pertanyaan_50_5);
//
//        spinner_pertanyaan_50_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner50_1 = String.valueOf(size_values);
//                spinner50_1 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_50_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner50_2 = String.valueOf(size_values);
//                spinner50_2 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_50_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner50_3 = String.valueOf(size_values);
//                spinner50_3 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_50_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner50_4 = String.valueOf(size_values);
//                spinner50_4 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_50_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner50_5 = String.valueOf(size_values);
//                spinner50_5 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// ============================================= END pertanyaan 50 =============================================================


// ============================================= pertanyaan 51 ================================================================
//        tvpertanyaan_51_1  = findViewById(R.id.tvpertanyaan_51_1);
//        tvpertanyaan_51_2  = findViewById(R.id.tvpertanyaan_51_2);
//        tvpertanyaan_51_3  = findViewById(R.id.tvpertanyaan_51_3);
//        tvpertanyaan_51_4  = findViewById(R.id.tvpertanyaan_51_4);
//        tvpertanyaan_51_5  = findViewById(R.id.tvpertanyaan_51_5);
//        tvpertanyaan_51_6  = findViewById(R.id.tvpertanyaan_51_6);
//        tvpertanyaan_51_7  = findViewById(R.id.tvpertanyaan_51_7);
//        tvpertanyaan_51_8  = findViewById(R.id.tvpertanyaan_51_8);
//        tvpertanyaan_51_9  = findViewById(R.id.tvpertanyaan_51_9);
//        tvpertanyaan_51_10  = findViewById(R.id.tvpertanyaan_51_10);
//        tvpertanyaan_51_11  = findViewById(R.id.tvpertanyaan_51_11);
//
//        spinner_pertanyaan_51_1 = findViewById(R.id.spinner_pertanyaan_51_1);
//        spinner_pertanyaan_51_2 = findViewById(R.id.spinner_pertanyaan_51_2);
//        spinner_pertanyaan_51_3 = findViewById(R.id.spinner_pertanyaan_51_3);
//        spinner_pertanyaan_51_4 = findViewById(R.id.spinner_pertanyaan_51_4);
//        spinner_pertanyaan_51_5 = findViewById(R.id.spinner_pertanyaan_51_5);
//        spinner_pertanyaan_51_6 = findViewById(R.id.spinner_pertanyaan_51_6);
//        spinner_pertanyaan_51_7 = findViewById(R.id.spinner_pertanyaan_51_7);
//        spinner_pertanyaan_51_8 = findViewById(R.id.spinner_pertanyaan_51_8);
//        spinner_pertanyaan_51_9 = findViewById(R.id.spinner_pertanyaan_51_9);
//        spinner_pertanyaan_51_10 = findViewById(R.id.spinner_pertanyaan_51_10);
//        spinner_pertanyaan_51_11 = findViewById(R.id.spinner_pertanyaan_51_11);
//
//        spinner_pertanyaan_51_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_1 = String.valueOf(size_values);
//                spinner51_1 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_2 = String.valueOf(size_values);
//                spinner51_2 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_3 = String.valueOf(size_values);
//                spinner51_3 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_4 = String.valueOf(size_values);
//                spinner51_4 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_5 = String.valueOf(size_values);
//                spinner51_5 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_6 = String.valueOf(size_values);
//                spinner51_6 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_7 = String.valueOf(size_values);
//                spinner51_7 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_8 = String.valueOf(size_values);
//                spinner51_8 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_9 = String.valueOf(size_values);
//                spinner51_9 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_10 = String.valueOf(size_values);
//                spinner51_10 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
//        spinner_pertanyaan_51_11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_46);
//                spinner51_11 = String.valueOf(size_values);
//                spinner51_11 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

// ============================================= END pertanyaan 51 =============================================================




//        etpertanyaan_51 = findViewById(R.id.etpertanyaan_51);

// Spinner pertanyaan 52
//        spinner_pertanyaan_52 = findViewById(R.id.spinner_pertanyaan_52);
//
//        spinner_pertanyaan_52.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_52);
//                spinner52 = String.valueOf(size_values);
//                spinner52 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// END Spinner pertanyaan 52

// Spinner pertanyaan 53
//        spinner_pertanyaan_53 = findViewById(R.id.spinner_pertanyaan_53);
//
//        spinner_pertanyaan_53.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_53);
//                spinner53 = String.valueOf(size_values);
//                spinner53 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// END Spinner pertanyaan 53


// Spinner pertanyaan 54
//        spinner_pertanyaan_54 = findViewById(R.id.spinner_pertanyaan_54);
//
//        spinner_pertanyaan_54.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//                String[] size_values = getResources().getStringArray(R.array.array_pertanyaan_54);
//                spinner54 = String.valueOf(size_values);
//                spinner54 = (String) parent.getItemAtPosition(pos);
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
// END Spinner pertanyaan 54

//        etpertanyaan_55 = findViewById(R.id.etpertanyaan_55);

// Radio Group dan Radio Button Pertanyaan 55
//        radiogroup_pertanyaan_55 = findViewById(R.id.radio_group_pertanyaan_55);
//        radiobutton_pertanyaan_55_1 = findViewById(R.id.radiobutton_pertanyaan_55_1);
//        radiobutton_pertanyaan_55_2 = findViewById(R.id.radiobutton_pertanyaan_55_2);
//
//        radiogroup_pertanyaan_55.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                radiobutton_pertanyaan_55_1 = findViewById(R.id.radiobutton_pertanyaan_55_1);
//                if (radiobutton_pertanyaan_55_1.isChecked()){
//                    rg_pertanyaan_55 = "Joko Widodo - Makruf Amin";
//                }else {
//                    rg_pertanyaan_55 = "Prabowo Subianto - Sandiaga Uno";
//                }
//
//            }
//        });
// END Radio Group dan Radio Button Pertanyaan 55

        tvlat = findViewById(R.id.tvlat);
        tvlang = findViewById(R.id.tvlang);
        btnsumbit = findViewById(R.id.btnsubmit);

        btnsumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addsresponden();
            }
        });

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
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(KuisionerActivity.this, android.R.layout.simple_spinner_dropdown_item, nama_kabkota );
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerkabkota.setAdapter(dataAdapter);
                }
            }
            @Override
            public void onFailure(Call<ResponseKabkota> call, Throwable t) {

            }
        });
    }

    private void getKecamatan(int idKabkota){
        apiService.GetAllByIdKecamatan(String.valueOf(idKabkota)).enqueue(new Callback<ResponseKecamatan>() {
            @Override
            public void onResponse(Call<ResponseKecamatan> call, Response<ResponseKecamatan> response) {
                if (response.isSuccessful()){
                    if (response.body().getMaster().size()>0){
                        id_kecamatan.clear();
                        nama_kecamatan.clear();
                        for (int i = 0; i < response.body().getMaster().size() ; i++) {
                            id_kecamatan.add(response.body().getMaster().get(i).getIdKecamatan());
                            nama_kecamatan.add(response.body().getMaster().get(i).getNama());
                        }
                    }
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(KuisionerActivity.this, android.R.layout.simple_spinner_dropdown_item, nama_kecamatan );
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerkecamatan.setAdapter(dataAdapter);
                }
            }
            @Override
            public void onFailure(Call<ResponseKecamatan> call, Throwable t) {

            }
        });
    }

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
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(KuisionerActivity.this, android.R.layout.simple_spinner_dropdown_item, nama_kelurahan );
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerkelurahan.setAdapter(dataAdapter);
            }
            @Override
            public void onFailure(Call<ResponseKelurahan> call, Throwable t) {

            }
        });
    }


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
//        nama_kk = etnama_kk.getText().toString();
//        no_urut_responden = etno_urut_responden.getText().toString();
        pertanyaan_12 = rg_pertanyaan_12;
        pertanyaan_13 = rg_pertanyaan_13;
        pertanyaan_14 = spinner14;
        pertanyaan_15 = spinner15;
        pertanyaan_16 = jenis_kelamin;
        pertanyaan_17 = spinner17;
        pertanyaan_18 = spinner18;
        pertanyaan_19 = spinner19;
        pertanyaan_20 = spinner20;
        pertanyaan_21 = spinner21;
        pertanyaan_22 = spinner22;
        pertanyaan_23 = spinner23;
        pertanyaan_24 = spinner24;
        pertanyaan_25 = spinner25;
        pertanyaan_26 = spinner26;
        pertanyaan_27 = spinner27;
        pertanyaan_28 = tvpertanyaan_28_1.getText().toString() + " : " + spinner28_1 + ", "
                + tvpertanyaan_28_2.getText().toString() + " : " + spinner28_2+ ", "
                + tvpertanyaan_28_3.getText().toString() + " : " + spinner28_3+ ", "
                + tvpertanyaan_28_4.getText().toString() + " : " + spinner28_4+ ", "
                + tvpertanyaan_28_5.getText().toString() + " : " + spinner28_5+ ", "
                + tvpertanyaan_28_6.getText().toString() + " : " + spinner28_6+ ", "
                + tvpertanyaan_28_7.getText().toString() + " : " + spinner28_7+ ", ";
        pertanyaan_29 = spinner29;
        pertanyaan_30 = spinner30;
// =========================================== pertanyaan 31 ====================================================================
        pertanyaan_31 = "";
        int count_pertanyaan_31 = 0;
        if (cbpertanyaan_31_1.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_1.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_2.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_2.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_3.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_3.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_4.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_4.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_5.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_5.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_6.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_6.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_7.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_7.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_8.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_8.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_9.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_9.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_10.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_10.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_11.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_12.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_12.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_12.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_13.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_13.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_14.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_14.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_15.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_15.getText().toString() + ", ";
            count_pertanyaan_31++;
        }if (cbpertanyaan_31_16.isChecked()) {
            pertanyaan_31 += cbpertanyaan_31_16.getText().toString() + ", ";
            count_pertanyaan_31++;
        }
// =========================================== END pertanyaan 31 ====================================================================

// =========================================== pertanyaan 32 ====================================================================
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
        }if (cbpertanyaan_32_8.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_8.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_9.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_9.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_10.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_10.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_11.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_12.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_12.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_12.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_13.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_13.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_14.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_14.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_15.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_15.getText().toString() + ", ";
            count_pertanyaan_32++;
        }if (cbpertanyaan_32_16.isChecked()) {
            pertanyaan_32 += cbpertanyaan_32_16.getText().toString() + ", ";
            count_pertanyaan_32++;
        }
// =========================================== END pertanyaan 32 ====================================================================

// =========================================== pertanyaan 33 ====================================================================
        pertanyaan_33 = "";
        int count_pertanyaan_33 = 0;
        if (cbpertanyaan_33_1.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_1.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_2.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_2.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_3.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_3.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_4.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_4.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_5.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_5.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_6.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_6.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_7.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_7.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_8.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_8.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_9.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_9.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_10.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_10.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_11.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_12.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_12.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_12.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_13.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_13.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_14.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_14.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_15.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_15.getText().toString() + ", ";
            count_pertanyaan_33++;
        }if (cbpertanyaan_33_16.isChecked()) {
            pertanyaan_33 += cbpertanyaan_33_16.getText().toString() + ", ";
            count_pertanyaan_33++;
        }
// =========================================== END pertanyaan 33 ====================================================================


// =========================================== pertanyaan 34 ====================================================================
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
        }if (cbpertanyaan_34_9.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_9.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_10.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_10.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_11.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_12.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_12.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_12.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_13.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_13.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_14.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_14.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_15.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_15.getText().toString() + ", ";
            count_pertanyaan_34++;
        }if (cbpertanyaan_34_16.isChecked()) {
            pertanyaan_34 += cbpertanyaan_34_16.getText().toString() + ", ";
            count_pertanyaan_34++;
        }
// =========================================== END pertanyaan 34 ================================================================


// =========================================== pertanyaan 35 ====================================================================
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
        }if (cbpertanyaan_35_9.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_9.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_10.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_10.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_11.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_12.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_12.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_12.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_13.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_13.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_14.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_14.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_15.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_15.getText().toString() + ", ";
            count_pertanyaan_35++;
        }if (cbpertanyaan_35_16.isChecked()) {
            pertanyaan_35 += cbpertanyaan_35_16.getText().toString() + ", ";
            count_pertanyaan_35++;
        }
// =========================================== END pertanyaan 35 ================================================================

// =========================================== pertanyaan 36 ====================================================================
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
            pertanyaan_36 += cbpertanyaan_36_12.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_12.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_12.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_13.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_13.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_14.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_14.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_15.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_15.getText().toString() + ", ";
            count_pertanyaan_36++;
        }if (cbpertanyaan_36_16.isChecked()) {
            pertanyaan_36 += cbpertanyaan_36_16.getText().toString() + ", ";
            count_pertanyaan_36++;
        }
// =========================================== END pertanyaan 36 ================================================================

        pertanyaan_37 = spinner37;

// =========================================== pertanyaan 38 ====================================================================
        pertanyaan_38 = rg_pertanyaan_38;
// =========================================== END pertanyaan 38 ================================================================

// =============================================== pertanyaan 39 ================================================================

        pertanyaan_39 = tvpertanyaan_39_1.getText().toString() + " : " + spinner39_1 + ", "
                + tvpertanyaan_39_2.getText().toString() + " : " + spinner39_2 + ", "
                + tvpertanyaan_39_3.getText().toString() + " : " + spinner39_3 + ", "
                + tvpertanyaan_39_4.getText().toString() + " : " + spinner39_4 + ", "
                + tvpertanyaan_39_5.getText().toString() + " : " + spinner39_5 + ", "
                + tvpertanyaan_39_6.getText().toString() + " : " + spinner39_6 + ", "
                + tvpertanyaan_39_7.getText().toString() + " : " + spinner39_7 + ", "
                + tvpertanyaan_39_8.getText().toString() + " : " + spinner39_8 + ", "
                + tvpertanyaan_39_9.getText().toString() + " : " + spinner39_9 + ", "
                + tvpertanyaan_39_10.getText().toString() + " : " + spinner39_10 + ", "
                + tvpertanyaan_39_11.getText().toString() + " : " + spinner39_11 + ", "
                + tvpertanyaan_39_12.getText().toString() + " : " + spinner39_12 + ", "
                + tvpertanyaan_39_13.getText().toString() + " : " + spinner39_13 + ", "
                + tvpertanyaan_39_14.getText().toString() + " : " + spinner39_14 + ", "
                + tvpertanyaan_39_15.getText().toString() + " : " + spinner39_15 + ", ";

// ============================================= END pertanyaan 39 ==============================================================

        pertanyaan_40 = spinner40;
//        pertanyaan_41 = spinner41;
//        pertanyaan_42 = spinner42;
//        pertanyaan_43 = spinner43;
//        pertanyaan_44 = spinner44;
//
//        pertanyaan_45 = tvpertanyaan_45_1.getText().toString() + " " + spinner45_1 + ", "
//                + tvpertanyaan_45_2.getText().toString() + " " + spinner45_2 + ", "
//                + tvpertanyaan_45_3.getText().toString() + " " + spinner45_3 + ", "
//                + tvpertanyaan_45_3.getText().toString() + " " + spinner45_3;
//
//        pertanyaan_46 = tvpertanyaan_46_1.getText().toString() + " " + spinner46_1 + ", "
//                + tvpertanyaan_46_2.getText().toString() + " " + spinner46_2 + ", "
//                + tvpertanyaan_46_3.getText().toString() + " " + spinner46_3 + ", "
//                + tvpertanyaan_46_3.getText().toString() + " " + spinner46_3 +", "
//                + tvpertanyaan_46_4.getText().toString() + " " + spinner46_4 + ", "
//                + tvpertanyaan_46_5.getText().toString() + " " + spinner46_5;
//
//        pertanyaan_47 = tvpertanyaan_47_1.getText().toString() + " " + spinner47_1 + ", "
//                + tvpertanyaan_47_2.getText().toString() + " " + spinner47_2 + ", "
//                + tvpertanyaan_47_3.getText().toString() + " " + spinner47_3 + ", "
//                + tvpertanyaan_47_3.getText().toString() + " " + spinner47_3 +", "
//                + tvpertanyaan_47_4.getText().toString() + " " + spinner47_4 + ", "
//                + tvpertanyaan_47_5.getText().toString() + " " + spinner47_5 + ", ";
//
//        pertanyaan_48 = tvpertanyaan_48_1.getText().toString() + " " + spinner48_1 + ", "
//                + tvpertanyaan_48_2.getText().toString() + " " + spinner48_2 + ", "
//                + tvpertanyaan_48_3.getText().toString() + " " + spinner48_3 + ", "
//                + tvpertanyaan_48_3.getText().toString() + " " + spinner48_3 +", "
//                + tvpertanyaan_48_4.getText().toString() + " " + spinner48_4 + ", "
//                + tvpertanyaan_48_5.getText().toString() + " " + spinner48_5 + ", ";
//
//        pertanyaan_49 = tvpertanyaan_49_1.getText().toString() + " " + spinner49_1 + ", "
//                + tvpertanyaan_49_2.getText().toString() + " " + spinner49_2 + ", "
//                + tvpertanyaan_49_3.getText().toString() + " " + spinner49_3 + ", "
//                + tvpertanyaan_49_3.getText().toString() + " " + spinner49_3 +", "
//                + tvpertanyaan_49_4.getText().toString() + " " + spinner49_4 + ", "
//                + tvpertanyaan_49_5.getText().toString() + " " + spinner49_5 + ", "
//                + tvpertanyaan_49_6.getText().toString() + " " + spinner49_6 + ", ";
//
//        pertanyaan_50 = tvpertanyaan_50_1.getText().toString() + " " + spinner50_1 + ", "
//                + tvpertanyaan_50_2.getText().toString() + " " + spinner50_2 + ", "
//                + tvpertanyaan_50_3.getText().toString() + " " + spinner50_3 + ", "
//                + tvpertanyaan_50_3.getText().toString() + " " + spinner50_3 +", "
//                + tvpertanyaan_50_4.getText().toString() + " " + spinner50_4 + ", "
//                + tvpertanyaan_50_5.getText().toString() + " " + spinner50_5 + ", ";
//
//        pertanyaan_51 = tvpertanyaan_51_1.getText().toString() + " " + spinner51_1 + ", "
//                + tvpertanyaan_51_2.getText().toString() + " " + spinner51_2 + ", "
//                + tvpertanyaan_51_3.getText().toString() + " " + spinner51_3 + ", "
//                + tvpertanyaan_51_3.getText().toString() + " " + spinner51_3 +", "
//                + tvpertanyaan_51_4.getText().toString() + " " + spinner51_4 + ", "
//                + tvpertanyaan_51_5.getText().toString() + " " + spinner51_5 + ", "
//                + tvpertanyaan_51_6.getText().toString() + " " + spinner51_6 + ", "
//                + tvpertanyaan_51_7.getText().toString() + " " + spinner51_7 +", "
//                + tvpertanyaan_51_8.getText().toString() + " " + spinner51_8 + ", "
//                + tvpertanyaan_51_9.getText().toString() + " " + spinner51_9 +", "
//                + tvpertanyaan_51_10.getText().toString() + " " + spinner51_10 + ", "
//                + tvpertanyaan_51_11.getText().toString() + " " + spinner51_11;
//
//        pertanyaan_52 = spinner52;
//        pertanyaan_53 = spinner53;
//        pertanyaan_54 = spinner54;
//        pertanyaan_55 = rg_pertanyaan_55;
        lat = tvlat.getText().toString();
        lang = tvlang.getText().toString();

        if (count_pertanyaan_31 < 1 && count_pertanyaan_32 < 1 && count_pertanyaan_33 < 1 && count_pertanyaan_34 < 5
                && count_pertanyaan_35 < 5 && count_pertanyaan_36 < 1) {
            Toast.makeText(getApplicationContext(), "CheckBox Eror", Toast.LENGTH_LONG).show();

        } else {


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
//                            String nama_kk = response.body().getResponden().getNamaKk();
//                            String no_urut_responden = response.body().getResponden().getNamaKk();
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
//                            String pertanyaan_41 = response.body().getResponden().getPertanyaan41();
//                            String pertanyaan_42 = response.body().getResponden().getPertanyaan42();
//                            String pertanyaan_43 = response.body().getResponden().getPertanyaan43();
//                            String pertanyaan_44 = response.body().getResponden().getPertanyaan44();
//                            String pertanyaan_45 = response.body().getResponden().getPertanyaan45();
//                            String pertanyaan_46 = response.body().getResponden().getPertanyaan46();
//                            String pertanyaan_47 = response.body().getResponden().getPertanyaan47();
//                            String pertanyaan_48 = response.body().getResponden().getPertanyaan48();
//                            String pertanyaan_49 = response.body().getResponden().getPertanyaan49();
//                            String pertanyaan_50 = response.body().getResponden().getPertanyaan50();
//                            String pertanyaan_51 = response.body().getResponden().getPertanyaan51();
//                            String pertanyaan_52 = response.body().getResponden().getPertanyaan52();
//                            String pertanyaan_53 = response.body().getResponden().getPertanyaan53();
//                            String pertanyaan_54 = response.body().getResponden().getPertanyaan54();
//                            String pertanyaan_55 = response.body().getResponden().getPertanyaan55();
                            String lat = response.body().getResponden().getLat();
                            String lang = response.body().getResponden().getLang();

                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                            kampang = new Intent(KuisionerActivity.this, MainActivity.class);
                            startActivity(kampang);
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

}
