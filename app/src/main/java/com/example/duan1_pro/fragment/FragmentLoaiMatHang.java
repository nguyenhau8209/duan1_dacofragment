package com.example.duan1_pro.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.duan1_pro.R;
import com.example.duan1_pro.adapter.LoaiMHAdapter;
import com.example.duan1_pro.dao.loaiMatHangDAO;
import com.example.duan1_pro.model.ItemClick;
import com.example.duan1_pro.model.loaiMatHang;

import java.util.ArrayList;

public class FragmentLoaiMatHang extends Fragment {

    RecyclerView recyclerView;
    loaiMatHangDAO dao;
    EditText edThemMatHang;
    int maLoai;

    public FragmentLoaiMatHang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loai_mat_hang, container, false);
        recyclerView = view.findViewById(R.id.lvLoaiMatHang);
        edThemMatHang = view.findViewById(R.id.edThemMatHang);
        Button btnAddLoaiMH = view.findViewById(R.id.btnAddMatHang);
        Button btnSua = view.findViewById(R.id.btnUpMatHang);
        dao = new loaiMatHangDAO(getContext());

        btnAddLoaiMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edThemMatHang.getText().toString();
                if (dao.insert(ten)) {
                    //Thông báo + loadlis
                    Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                    //
                    LoadData();
                } else {
                    Toast.makeText(getContext(), "Thêm Không Thành Công", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten= edThemMatHang.getText().toString();
                loaiMatHang LoaiMH= new loaiMatHang( maLoai,ten);
                if(dao.update(LoaiMH)){
                    LoadData();
                    edThemMatHang.setText("");
                    Toast.makeText(getContext(), "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private void LoadData(){
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        ArrayList<loaiMatHang> list=dao.getAll();
        LoaiMHAdapter adapter=new LoaiMHAdapter(getContext(), list, new ItemClick() {
            @Override
            public void onClickLoaiMH(loaiMatHang LoaiMH) {
                edThemMatHang.setText(LoaiMH.getTenLoaiMatHang());
                maLoai=LoaiMH.getMaLoaiMatHang();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}