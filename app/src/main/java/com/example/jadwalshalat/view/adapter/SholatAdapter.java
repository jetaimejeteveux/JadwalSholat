package com.example.jadwalshalat.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jadwalshalat.R;
import com.example.jadwalshalat.data.local.AppDatabase;
import com.example.jadwalshalat.data.local.DataModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SholatAdapter extends RecyclerView.Adapter<SholatAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DataModel> sholatItems = new ArrayList<>();
    private AppDatabase appDatabase;

    public SholatAdapter(Context context) {
        this.context = context;
        appDatabase = AppDatabase.initDatabase(this.context);
    }

    public void setData(ArrayList<DataModel> items) {
        sholatItems.clear();
        sholatItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SholatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_sholat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SholatAdapter.ViewHolder holder, final int position) {
        holder.city.setText(sholatItems.get(position).getCity().toString());
        holder.country.setText(sholatItems.get(position).getCountry().toString());
        holder.month.setText(sholatItems.get(position).getMonth().toString());
        holder.year.setText(sholatItems.get(position).getYear().toString());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    DataModel dataModel=new DataModel();
                    dataModel.setId(sholatItems.get(position).getId());
                    dataModel.setCity(sholatItems.get(position).getCity());
                    dataModel.setCountry(sholatItems.get(position).getCountry());
                    dataModel.setMonth(sholatItems.get(position).getMonth());
                    dataModel.setYear(sholatItems.get(position).getYear());

                    appDatabase.sholatDAO().deleteSholat(dataModel);

                    Log.d("SholatAdapter", "Sukses Ditampilkan");
                    Toast.makeText(context, "Tertampilkan", Toast.LENGTH_LONG).show();
                }
                catch(Exception ex){
                    Log.e("SholatAdapter", "Gagal menampilkan, msg: " + ex.getMessage());
                    Toast.makeText(context, "Gagal Menampilkan", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return sholatItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnDelete;
        TextView city, country, month, year;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDelete = itemView.findViewById(R.id.itemlist_sholat_btndel);
            city = itemView.findViewById(R.id.itemlist_sholat_city);
            country = itemView.findViewById(R.id.itemlist_sholat_country);
            month = itemView.findViewById(R.id.itemlist_sholat_month);
            year = itemView.findViewById(R.id.itemlist_sholat_year);


        }
    }
}
