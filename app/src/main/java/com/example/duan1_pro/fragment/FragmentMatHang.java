package com.example.duan1_pro.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1_pro.R;
import com.example.duan1_pro.adapter.LoaiMHSPAdapter;
import com.example.duan1_pro.adapter.MatHangAdapter;
import com.example.duan1_pro.dao.loaiMatHangDAO;
import com.example.duan1_pro.dao.matHangDAO;
import com.example.duan1_pro.model.loaiMatHang;
import com.example.duan1_pro.model.matHang;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class FragmentMatHang extends Fragment {

    ListView listView;
    FloatingActionButton btnAddMatHang;
    matHangDAO mathangDAO;
    MatHangAdapter adapter;
    matHang item;
    List<matHang> list;

    Dialog dialog;
    EditText edMaMH, edTenMH, edGiaMH;
    Spinner spinner;
    Button btnLuu, btnCancle;

    LoaiMHSPAdapter loaiMHSPAdapter;
    ArrayList<loaiMatHang> listLoaiMH;
    loaiMatHangDAO LoaiMHDAO;
    loaiMatHang LoaiMH;
    int maLoaiMH, position;

    public FragmentMatHang() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mat_hang, container, false);
        listView = view.findViewById(R.id.lvMatHang);
        btnAddMatHang = view.findViewById(R.id.btnAddMatHang);
        btnAddMatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog(getActivity(), 0);
            }
        });
         mathangDAO= new matHangDAO(getContext());
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = list.get(position);
                openDialog(getActivity(), 1);
                return false;
            }
        });


        upLv();
        return view;

    }

    void upLv() {
        list = (ArrayList<matHang>) mathangDAO.getAll();
        adapter = new MatHangAdapter(getActivity(), this, list);
        listView.setAdapter(adapter);

    }

    public void delete(String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa không ? ");
        builder.setCancelable(true);
        //
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mathangDAO.delete(id);
                upLv();
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void openDialog(Context context, int type) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_themmathang);
        edMaMH = dialog.findViewById(R.id.edMaMH);
        edTenMH = dialog.findViewById(R.id.edTenMH);
        edGiaMH = dialog.findViewById(R.id.edGiaMH);
        spinner = dialog.findViewById(R.id.spLoaiMH);
        btnLuu = dialog.findViewById(R.id.btnLuuMH);
        btnCancle = dialog.findViewById(R.id.btnHuyMH);
        //
        listLoaiMH = new ArrayList<loaiMatHang>();
        LoaiMHDAO = new loaiMatHangDAO(context);
        listLoaiMH= (ArrayList<loaiMatHang>) LoaiMHDAO.getAll();
        //
        loaiMHSPAdapter = new LoaiMHSPAdapter(context, listLoaiMH);
        spinner.setAdapter(loaiMHSPAdapter);
        //lấy mã loại
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maLoaiMH = listLoaiMH.get(i).getMaLoaiMatHang();
                Toast.makeText(context, "Chọn" + listLoaiMH.get(i).getTenLoaiMatHang(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        edMaMH.setEnabled(false);
        if (type != 0) {
            edMaMH.setText(String.valueOf(item.getMaLoaiMatHang()));
            edTenMH.setText(item.getTenMatHang());
            edGiaMH.setText(String.valueOf(item.getGiaban()));
            for (int i = 0; i < listLoaiMH.size(); i++)
                if (item.getMaMatHang() == (listLoaiMH.get(i).getMaLoaiMatHang())) {
                    position = i;
                }
            Log.i("demo", "Sach " + position);
            spinner.setSelection(position);


        }
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = new matHang();
                item.setTenMatHang(edTenMH.getText().toString());
                item.setGiaban(Integer.parseInt(edGiaMH.getText().toString()));
                item.setMaMatHang(maLoaiMH);
                if (validate() > 0) {
                    if (type == 0) {
                        if (mathangDAO.insert(item)  ) {
                            Toast.makeText(context, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Thêm Fail", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        item.setMaMatHang(Integer.parseInt(edMaMH.getText().toString()));
                        if (mathangDAO.update(item) ) {
                            Toast.makeText(context, "Up Thành Công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Up fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                    upLv();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public int validate() {
        int check = 1;
        if (edTenMH.getText().length() == 0 || edGiaMH.getText().length() == 0) {
            Toast.makeText(getContext(), "Dữ liệu trống", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}