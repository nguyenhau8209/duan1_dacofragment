package com.example.duan1_pro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duan1_pro.R;
import com.example.duan1_pro.model.matHang;

import java.util.ArrayList;
import java.util.List;

public class MatHangSPAdapter extends ArrayAdapter<matHang> {
    private Context context;
    private ArrayList<matHang> list;
    TextView tvMa , tvTen;

    public MatHangSPAdapter(@NonNull Context context ,ArrayList<matHang> list ) {
        super(context, 0 ,  list);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sp_mathang , null);

        }
        matHang item = list.get(position);
        if(item != null){
            tvMa = view.findViewById(R.id.tvMaMHSP);
            tvMa.setText(item.getMaMatHang() + ". ");
            tvTen = view.findViewById(R.id.tvTenMHSP);
            tvTen.setText(item.getTenMatHang());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sp_mathang, null);

        }
        matHang item = list.get(position);
        if(item != null){
            tvMa = view.findViewById(R.id.tvMaMHSP);
            tvMa.setText(item.getMaMatHang() + ". ");
            tvTen = view.findViewById(R.id.tvTenMHSP);
            tvTen.setText(item.getTenMatHang());
        }
        return view;
    }
}
