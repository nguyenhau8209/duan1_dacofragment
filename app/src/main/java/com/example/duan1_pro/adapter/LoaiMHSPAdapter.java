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
import com.example.duan1_pro.model.loaiMatHang;

import java.util.ArrayList;

public class LoaiMHSPAdapter extends ArrayAdapter<loaiMatHang> {
    Context context;
    ArrayList<loaiMatHang> list;
    TextView tvMaLoai, tvTenLoai;

    public LoaiMHSPAdapter(@NonNull Context context, ArrayList<loaiMatHang> list) {

        super(context, 0, list);
        this.context = context;
        this.list = list;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sp_loaimh, null);
        }
        final loaiMatHang item = list.get(position);
        if (item != null) {
            tvMaLoai = view.findViewById(R.id.maLoaiSp);
            tvMaLoai.setText(String.valueOf(item.getMaLoaiMatHang()));
            //
            tvTenLoai = view.findViewById(R.id.tenLoaiSp);
            tvTenLoai.setText(item.getTenLoaiMatHang());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sp_loaimh, null);
        }
        final loaiMatHang item = list.get(position);
        if (item != null) {
            tvMaLoai = view.findViewById(R.id.maLoaiSp);
            tvMaLoai.setText(String.valueOf(item.getMaLoaiMatHang()));
            //
            tvTenLoai = view.findViewById(R.id.tenLoaiSp);
            tvTenLoai.setText(item.getTenLoaiMatHang());
        }
        return view;
    }
}
