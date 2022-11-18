package com.example.duan1_pro.adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.example.duan1_pro.dao.khachHangDAO;
import com.example.duan1_pro.dao.matHangDAO;
import com.example.duan1_pro.fragment.FragmentHoaDon;
import com.example.duan1_pro.model.hoaDon;
import com.example.duan1_pro.model.khachHang;
import com.example.duan1_pro.model.matHang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class HoaDonAdapter extends ArrayAdapter<hoaDon> {
    private Context context;
    FragmentHoaDon qlhoadon;
    private ArrayList<hoaDon> list;
    TextView tvmaHD, tvTenHD,tvmaKH,tvmaMH, tvThanhTien,tvgiomua, tvNgaymua,tvtenKH,tvtenMH;
    ImageView imgDel;
    matHangDAO MHDAO;
    khachHangDAO KHDAO;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat df = new SimpleDateFormat("h:mm a");

    public HoaDonAdapter(@NonNull Context context, FragmentHoaDon qlhoadon, ArrayList<hoaDon> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.qlhoadon = qlhoadon;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_hoadon, null);

        }
        final hoaDon item = list.get(position);
        if (item != null) {
            tvmaHD = view.findViewById(R.id.mahd);
            tvmaHD.setText("Mã Hóa Đơn: " + item.getMaHoaDon());

            tvTenHD = view.findViewById(R.id.tenhd);
            tvTenHD.setText("Tên Hóa Đơn: "+ item.getTenHoaDon());

//            if(item.getThanhTien()<= 50000) {
//                tvmaHD.setTextColor(Color.BLUE);
//            }else{
//                tvmaHD.setTextColor(Color.RED);
//            }

            MHDAO = new matHangDAO(context);
            matHang mh = MHDAO.getID("mã mặt hàng " + String.valueOf(item.getMaMatHang()));
            tvtenMH = view.findViewById(R.id.tenmh);
            tvtenMH.setText("Tên Mặt hàng: " + mh.getTenMatHang());

            KHDAO = new khachHangDAO(context);
            khachHang khachHang = KHDAO.getID("mã khách hàng" + String.valueOf(item.getMaKhachHang()));
            tvtenKH = view.findViewById(R.id.tenkh);
            tvtenKH.setText("Khách Hàng:" + khachHang.getTenKhachHang());
            //
            Log.e("zzzz", "Khách hàng: " + khachHang.getTenKhachHang() + " " + khachHang.getMaKhachHang());
            //
            tvThanhTien = view.findViewById(R.id.thanhtien);
            tvThanhTien.setText("Thành tiền: " + mh.getGiaban() + " ");
            Log.e("zzzz", "Thành tiền" + item.getThanhTien());



            tvNgaymua = view.findViewById(R.id.ngaymua);
            tvNgaymua.setText("Ngày Mua: " + sdf.format(item.getNgayMua()));


            imgDel = view.findViewById(R.id.deletehd);
        }
        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                qlhoadon.xoa(item.getMaHoaDon() + "");
            }
        });
        return view;
    }
}
