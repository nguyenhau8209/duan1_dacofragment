package com.example.duan1_pro.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duan1_pro.R;
import com.example.duan1_pro.dao.loaiMatHangDAO;
import com.example.duan1_pro.fragment.FragmentMatHang;
import com.example.duan1_pro.model.loaiMatHang;
import com.example.duan1_pro.model.matHang;

import java.util.List;

public class MatHangAdapter extends ArrayAdapter<matHang> {
    Context context;
    FragmentMatHang frmMH;
    List<matHang> list;
    TextView tvMaMH, tvTenMH, tvGiaBan, tvLoai;
    ImageView imgDel;

    public MatHangAdapter(@NonNull Context context, FragmentMatHang frmMH, List<matHang> list) {
        super(context, 0, list);
        this.context = context;
        this.frmMH = frmMH;
        this.list = list;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_mathang, null);
        }

        final matHang item = list.get(position);
        if (item != null) {
            loaiMatHangDAO loaiMHDAO = new loaiMatHangDAO(context);
            loaiMatHang loaiMH = loaiMHDAO.getID(item.getMaLoaiMatHang() + "");
//            Log.e("zzzz","Mã Loại: " + item.getMaLoai());
            Log.e("zzzz","Mã Loại: " + loaiMH.getTenLoaiMatHang() + " " + loaiMH.getMaLoaiMatHang());
//            LoaiSach loaiSach = (LoaiSach) loaiSachDAO.getAll();
            tvMaMH = view.findViewById(R.id.txtmaMH);
            tvMaMH.setText("Mã Mặt hàng: " + item.getMaMatHang());

            tvTenMH = view.findViewById(R.id.txttenMH);
            tvTenMH.setText("Tên Mặt hàng: " + item.getTenMatHang());

            tvGiaBan = view.findViewById(R.id.txtgiaban);
            tvGiaBan.setText("Gía Bán: " + item.getGiaban());

            tvLoai = view.findViewById(R.id.txtmaloai);
            tvLoai.setText("Loại Sách: " + loaiMH.getTenLoaiMatHang());

            imgDel = view.findViewById(R.id.txtxoaMH);
        }

        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                frmMH.delete(String.valueOf(item.getMaMatHang()));

            }
        });


        return view;
    }
}
