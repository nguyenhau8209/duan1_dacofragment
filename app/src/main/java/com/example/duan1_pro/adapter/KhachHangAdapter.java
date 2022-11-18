package com.example.duan1_pro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duan1_pro.R;
import com.example.duan1_pro.fragment.FragmentKhachHang;
import com.example.duan1_pro.model.khachHang;

import java.util.ArrayList;

public class KhachHangAdapter extends ArrayAdapter<khachHang> {
private Context context;
FragmentKhachHang fragmentKhachHang;
private ArrayList<khachHang> list;

TextView Txtmakh, Txttenkh,TxtSDTkh,TxtDiachikh;
ImageView img;

    public KhachHangAdapter( Context context1, FragmentKhachHang fragmentKhachHang, ArrayList<khachHang> list) {
        super(context1, 0, list);
        this.context = context1;
        this.fragmentKhachHang = fragmentKhachHang;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_khachhang , null);
        }
        final khachHang item = list.get(position);
        if(item != null){
            Txtmakh = v.findViewById(R.id.txtmakh);
            Txtmakh.setText("Mã Khách hàng: " + item.getMaKhachHang());

            Txttenkh = v.findViewById(R.id.txttenkh);
            Txttenkh.setText("Tên Khách hàng: " + item.getTenKhachHang());

            TxtSDTkh = v.findViewById(R.id.txtsdtkh);
            TxtSDTkh.setText("SDT khách hàng: " + item.getSoDienThoai());

            TxtDiachikh = v.findViewById(R.id.txtdiachikh);
            TxtDiachikh.setText("Địa chỉ khách hàng là: " + item.getDiaChi());
            //
            img = v.findViewById(R.id.txtxoakh);
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call p
//                fragmentKhachHang.xoa(String.valueOf(item.getMaKhachHang()));
            }
        });

        return v;
    }
}
