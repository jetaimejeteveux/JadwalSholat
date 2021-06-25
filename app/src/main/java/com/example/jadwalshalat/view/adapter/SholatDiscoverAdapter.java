package com.example.jadwalshalat.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jadwalshalat.R;
import com.example.jadwalshalat.data.model.DataResponse;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class SholatDiscoverAdapter extends RecyclerView.Adapter<SholatDiscoverAdapter.ViewHolder> {
    private ArrayList<DataResponse> timingsItems = new ArrayList<>();
    private Context context;

    public SholatDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataResponse> items) {
        timingsItems.clear();
        timingsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SholatDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SholatDiscoverAdapter.ViewHolder holder, int position) {

        holder.subuh.setText("Subuh: "+timingsItems.get(position).getTimings().getFajr()+"");
        holder.dzuhur.setText("Dzuhur: "+timingsItems.get(position).getTimings().getDhuhr()+"");
        holder.ashar.setText("Ashar: "+timingsItems.get(position).getTimings().getAsr()+"");
        holder.maghrib.setText("Maghrib: "+timingsItems.get(position).getTimings().getMaghrib()+"");
        holder.isya.setText("Isya: "+timingsItems.get(position).getTimings().getIsha()+"");
        holder.tanggal.setText("Tanggal: "+timingsItems.get(position).getDate().getReadable()+"");

    }

    @Override
    public int getItemCount() {
        return timingsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subuh, dzuhur, ashar, maghrib, isya, tanggal;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            subuh = itemView.findViewById(R.id.itemlist_subuh);
            dzuhur = itemView.findViewById(R.id.itemlist_dzuhur);
            ashar = itemView.findViewById(R.id.itemlist_ashar);
            maghrib = itemView.findViewById(R.id.itemlist_maghrib);
            isya = itemView.findViewById(R.id.itemlist_isya);
            tanggal = itemView.findViewById(R.id.itemlist_tanggal);
        }
    }
}
