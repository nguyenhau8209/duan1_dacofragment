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
import com.example.duan1_pro.fragment.FragmentTop10Nuoc;
import com.example.duan1_pro.model.top;

import java.util.ArrayList;

public class topAdapter extends ArrayAdapter<top> {
    private Context context;
    FragmentTop10Nuoc frmTop;
    ArrayList<top> listtop;
    TextView tvSach , tvSoLuong;
    ImageView imgView;

    public topAdapter(@NonNull Context context, FragmentTop10Nuoc frmTop, ArrayList<top> listtop) {
        super(context, 0 , listtop);
        this.context = context;
        this.frmTop = frmTop;
        this.listtop = listtop;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_top10 , null);

        }
        final top item = listtop.get(position);
        if(item != null){
            tvSach = view.findViewById(R.id.tenMH);
            tvSach.setText("Sách: " + item.getTenMatHang());
            tvSoLuong = view.findViewById(R.id.soluong);
            tvSoLuong.setText("Số lượng: " + item.getSoLuong());
        }

        return view;
    }
}
