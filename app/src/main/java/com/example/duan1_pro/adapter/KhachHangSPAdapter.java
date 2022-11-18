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
import com.example.duan1_pro.model.khachHang;

import java.util.ArrayList;

public class KhachHangSPAdapter extends ArrayAdapter<khachHang> {
    private Context context;
    private ArrayList<khachHang> list;
    TextView tvMaKH, tvTenKH;
    public KhachHangSPAdapter(@NonNull Context context, ArrayList<khachHang> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sp_khachhang, null);

        }
        final khachHang item = list.get(position);
        if (item != null) {
            tvMaKH = view.findViewById(R.id.tvMaSPKhachHang);
            tvMaKH.setText(item.getMaKhachHang() + ". ");
            tvTenKH = view.findViewById(R.id.tvTenSPKhachHang);
            tvTenKH.setText(item.getTenKhachHang());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sp_khachhang, null);

        }
        final khachHang item = list.get(position);
        if (item != null) {
            tvMaKH = view.findViewById(R.id.tvMaSPKhachHang);
            tvMaKH.setText(item.getTenKhachHang() + ". ");
            tvTenKH = view.findViewById(R.id.tvTenSPKhachHang);
            tvTenKH.setText(item.getTenKhachHang());
        }
        return view;
    }
}
