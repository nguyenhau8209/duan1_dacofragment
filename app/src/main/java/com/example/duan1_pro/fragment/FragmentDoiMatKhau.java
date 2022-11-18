package com.example.duan1_pro.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.duan1_pro.R;
import com.example.duan1_pro.dao.quanLyDAO;
import com.example.duan1_pro.model.quanLy;
import com.google.android.material.textfield.TextInputEditText;


public class FragmentDoiMatKhau extends Fragment {

    TextInputEditText edPassOld, edPassTiep, edNewPass;
    Button btnSave, btnCance;
    quanLyDAO quanLyDAO;
    public FragmentDoiMatKhau() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doi_mat_khau, container, false);
        quanLyDAO = new quanLyDAO(getActivity());
        edPassOld = view.findViewById(R.id.edPassOld);
        edPassTiep = view.findViewById(R.id.edPassTiep);
        edNewPass = view.findViewById(R.id.edPassNew);
        btnSave = view.findViewById(R.id.btnSave);
        btnCance = view.findViewById(R.id.btnCancelPass);
        btnCance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edNewPass.setText("");
                edPassOld.setText("");
                edPassTiep.setText("");
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
                String user = sharedPreferences.getString("USERNAME", "");
                if (validate() > 0) {
                    quanLy quanLy;
                   quanLy = quanLyDAO.getID(user);
                    quanLy.setMatkhau(edNewPass.getText().toString());
                    quanLyDAO.update(quanLy);
                    if (quanLyDAO.update(quanLy)) {
                        Toast.makeText(getContext(), "Thay Đổi Mật Khẩu Thành Công", Toast.LENGTH_SHORT).show();
                        edNewPass.setText("");
                        edPassOld.setText("");
                        edPassTiep.setText("");
                    } else {
                        Toast.makeText(getActivity(), "Không thay đổi được mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        return view;
    }

    public int validate() {
        int check = 1;
        if (edPassOld.getText().length() == 0 || edNewPass.getText().length() == 0 || edPassTiep.getText().length() == 0) {
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
            String passOld = sharedPreferences.getString("PASSWORD", "");
            String pass = edNewPass.getText().toString();
            String rePass = edPassTiep.getText().toString();
            if (!passOld.equals(edPassOld.getText().toString())) {
                Toast.makeText(getContext(), "Mật Khẩu Cũ Sai", Toast.LENGTH_SHORT).show();
                check = -1;
            }
            if (!pass.equals(rePass)) {
                Toast.makeText(getContext(), "Mật Khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }


        return check;
    }

}