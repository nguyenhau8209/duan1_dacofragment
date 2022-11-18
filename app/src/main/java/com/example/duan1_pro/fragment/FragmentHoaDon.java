package com.example.duan1_pro.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SearchView;

import com.example.duan1_pro.R;
import com.example.duan1_pro.adapter.HoaDonAdapter;
import com.example.duan1_pro.adapter.KhachHangSPAdapter;
import com.example.duan1_pro.adapter.MatHangSPAdapter;
import com.example.duan1_pro.dao.hoaDonDAO;
import com.example.duan1_pro.dao.khachHangDAO;
import com.example.duan1_pro.dao.matHangDAO;
import com.example.duan1_pro.model.hoaDon;
import com.example.duan1_pro.model.khachHang;
import com.example.duan1_pro.model.matHang;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentHoaDon extends Fragment {
    ListView lvHoaDon;
    FloatingActionButton btnAdd;
    ArrayList<hoaDon> list;
    hoaDonDAO HoaDonDAO;
    HoaDonAdapter adapter;
    hoaDon item;

    Dialog dialog;
    EditText edtMaHD, edtMaKH, edtMaMH, edtNgay, edtTien;
    RadioGroup radio;
    Button btnSave, btnCancle;

    KhachHangSPAdapter khachHangSPAdapter;
    ArrayList<khachHang> listKhachHang;
    khachHangDAO KhachHangDAO;
    khachHang KhachHang;
    int maKhachHang;

    MatHangSPAdapter matHangSPAdapter;
    ArrayList<matHang> listMH;
    matHangDAO MatHangDAO;
    matHang mathang;
    int maMatHang, Tien;

    int positionKH, positionMatHang;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat df = new SimpleDateFormat("h:mm a");
    SearchView searchview;
    TextInputEditText edtsearch;

    public FragmentHoaDon() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hoa_don, container, false);
        btnAdd = view.findViewById(R.id.btnAddHoaDon);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiaLog(getActivity(), 0);
            }
        });
        lvHoaDon = view.findViewById(R.id.lvHoaDon);
        lvHoaDon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = list.get(i);
                openDiaLog(getActivity(), 1);
                return false;
            }
        });
        hoaDonDAO hoaDonDAO = new hoaDonDAO(getContext());
        searchview = view.findViewById(R.id.search_view);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchText(newText);
                return true;
            }
        });
        capNhatLV();
        return view;
    }

    private void searchText(String newText) {
    }

    void capNhatLV() {
        ArrayList<hoaDon> list;
        list = (ArrayList<hoaDon>) hoaDonDAO.getAll();
        adapter = new HoaDonAdapter(getActivity(), this, list);
        lvHoaDon.setAdapter(adapter);
    }

    protected void openDiaLog(Context context, int type) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_themhoadon);
        edtMaHD = dialog.findViewById(R.id.edtMaHD);
        edtMaHD.setEnabled(false);
        edtMaMH = dialog.findViewById(R.id.edtMaMH);
        edtMaKH = dialog.findViewById(R.id.edtMaKH);
        edtNgay = dialog.findViewById(R.id.edtNgay);
        edtTien = dialog.findViewById(R.id.edtTien);
        radio = dialog.findViewById(R.id.radio);
        btnCancle = dialog.findViewById(R.id.btnHuyHD);
        btnSave = dialog.findViewById(R.id.btnLuuHD);
//
        edtNgay.setText("Ngày mua: " + sdf.format(new Date()));
        KhachHangDAO = new khachHangDAO(context);
        listKhachHang = new ArrayList<khachHang>();
        listKhachHang = (ArrayList<khachHang>) KhachHangDAO.getAll();
        khachHangSPAdapter = new KhachHangSPAdapter(context, listKhachHang);
        lvHoaDon.setAdapter(khachHangSPAdapter);

    }
}