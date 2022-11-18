package com.example.duan1_pro.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duan1_pro.R;
import com.example.duan1_pro.adapter.KhachHangAdapter;
import com.example.duan1_pro.dao.khachHangDAO;
import com.example.duan1_pro.model.khachHang;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class FragmentKhachHang extends Fragment {
    ListView listView;
    FloatingActionButton btnAdd;
    khachHangDAO khachhangDAO;
    ArrayList<khachHang> list;
    KhachHangAdapter adapter;
    khachHang item;
    Dialog dialog;
    EditText edtMaKH, edtNameKH, edtSdtKH, edtDiaChiKH, edtTuoiKH;
    Button btnThem, btnCancle;

    public FragmentKhachHang() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_khach_hang, container,false);
        listView=view.findViewById(R.id.lvKhachHang);
        btnAdd=view.findViewById(R.id.btnAddKhachHang);
        khachhangDAO=new khachHangDAO(getActivity());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item =list.get(i);
//
                return false;
            }
        });
        upListV();
        return view;
    }
    void upListV(){
        list=(ArrayList<khachHang>) khachhangDAO.getAll();
        adapter=new KhachHangAdapter(getActivity() , this, list);
        listView.setAdapter(adapter);
    }
    public void xoa(String id){
        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa hay không");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                khachhangDAO.delete(id);
                upListV();
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    protected void openDiaLog(final Context context, final int type){
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.fragment_khach_hang);
        edtMaKH=dialog.findViewById(R.id.edtMaKH);
        edtNameKH=dialog.findViewById(R.id.edtNameKH);
        edtSdtKH=dialog.findViewById(R.id.edtSdtKH);
        edtDiaChiKH=dialog.findViewById(R.id.edtDiaChiKH);
        edtTuoiKH=dialog.findViewById(R.id.edtTuoiKH);
        btnThem = dialog.findViewById(R.id.btnThem);
        btnCancle = dialog.findViewById(R.id.btnCancle);

        edtMaKH.setEnabled(false);
        if(type != 0){
            edtMaKH.setText(String.valueOf(item.getMaKhachHang()));
            edtNameKH.setText(item.getTenKhachHang());
            edtSdtKH.setText(item.getSoDienThoai());
            edtDiaChiKH.setText(item.getDiaChi());
//
        }
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item=new khachHang();
                item.setTenKhachHang(edtNameKH.getText().toString());
//                item.setSoDienThoai(edtSdtKH.getText().toString());
                item.setDiaChi(edtDiaChiKH.getText().toString());
                if(valilate() >0){
                    if(type==0){
                        if(khachhangDAO.insert(item) > 0){
                            Toast.makeText(context, "Thêm Thành Công", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "Them Fail", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        item.setMaKhachHang(Integer.parseInt(edtMaKH.getText().toString()));
                        if(khachhangDAO.update(item) > 0){
                            Toast.makeText(context, "Update Thành Công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Update Fail", Toast.LENGTH_SHORT).show();
                        }

                    }
                    upListV();
                    dialog.dismiss();
                }
            }
        });
    }
    public int valilate(){
        int check=1;
        if(edtNameKH.getText().length()==0 || edtDiaChiKH.getText().length()==0){
            Toast.makeText(getContext(),"Dữ liệu trống", Toast.LENGTH_SHORT).show();
            check= -1;

        }
        return check;
    }
}