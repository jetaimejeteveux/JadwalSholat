package com.example.jadwalshalat.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwalshalat.R;
import com.example.jadwalshalat.view.adapter.SholatDiscoverAdapter;
import com.example.jadwalshalat.data.model.DataResponse;
import com.example.jadwalshalat.viewmodel.SholatViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SholatFragment extends Fragment {
    private SholatDiscoverAdapter sholatDiscoverAdapter;
    private RecyclerView rvSholatDiscover;
    private SholatViewModel sholatViewModel;

    public SholatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sholat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sholatDiscoverAdapter = new SholatDiscoverAdapter(getContext());
        sholatDiscoverAdapter.notifyDataSetChanged();
        rvSholatDiscover = view.findViewById(R.id.fragmentsholat_rv);
        rvSholatDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));
        sholatViewModel = new ViewModelProvider(this).get(SholatViewModel.class);
        sholatViewModel.setSholatDiscover();
        sholatViewModel.getSholatDiscover().observe(this,getSholatDiscover);

        rvSholatDiscover.setAdapter(sholatDiscoverAdapter);
    }

   private Observer<ArrayList<DataResponse>> getSholatDiscover=new Observer<ArrayList<DataResponse>>() {
       @Override
       public void onChanged(ArrayList<DataResponse> timings) {
           if(timings != null){
               sholatDiscoverAdapter.setData(timings);
           }
       }
   };
}
