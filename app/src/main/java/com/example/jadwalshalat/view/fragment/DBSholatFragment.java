package com.example.jadwalshalat.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jadwalshalat.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DBSholatFragment extends Fragment {
    private Button button_prof;

    public DBSholatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tampil = inflater.inflate(R.layout.fragment_d_b_sholat, container, false);
        return tampil;
    }
}
