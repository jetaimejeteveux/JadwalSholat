package com.example.jadwalshalat.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jadwalshalat.R;
import com.example.jadwalshalat.data.local.AppDatabase;
import com.example.jadwalshalat.data.local.DataModel;
import com.example.jadwalshalat.view.activity.ReadActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FormFragment extends Fragment {
    private EditText city, country, month, year;
    private Button button, buttonLihatData;
    private AppDatabase appDatabase;

    public FormFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View tampil = inflater.inflate(R.layout.fragment_form, container, false);
        //buttonTrans = tampil.findViewById(R.id.btnTrans);
        city = tampil.findViewById(R.id.fragment_form_city);
        country =tampil.findViewById(R.id.fragment_form_country);
        month = tampil.findViewById(R.id.fragment_form_month);
        year = tampil.findViewById(R.id.fragment_form_year);
        button = tampil.findViewById(R.id.simpleButton);
        buttonLihatData = tampil.findViewById(R.id.btnLihat);
        appDatabase = AppDatabase.initDatabase(getActivity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DataModel dataModel = new DataModel();
                    dataModel.setCity(city.getText().toString());
                    dataModel.setCountry(country.getText().toString());
                    dataModel.setMonth(month.getText().toString());
                    dataModel.setYear(year.getText().toString());
                    appDatabase.sholatDAO().insertSholat(dataModel);
                    Log.d("Simpan", "Sukses");
                    Toast.makeText(getActivity(), "Tersimpan", Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Log.e("Gagal simpan", "Gagal menyimpan, msg: " + ex.getMessage());
                    Toast.makeText(getActivity(), "Gagal Menyimpan", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReadActivity.class);
                startActivity(intent);
            }
        });


        return tampil;
    }
}
