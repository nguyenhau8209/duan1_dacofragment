package com.example.duan1_pro.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.duan1_pro.R;
import com.example.duan1_pro.dao.ThongKeDAO;

import java.util.Calendar;


public class FragmentDoanhThu extends Fragment {


    public FragmentDoanhThu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_doanh_thu,container,false);

        EditText edtstart= view.findViewById(R.id.edtStart);
        EditText edtend= view.findViewById(R.id.edtEnd);
        Button btnthongke= view.findViewById(R.id.btnthongke);
        TextView txtkq= view.findViewById(R.id.textketqua);

        Calendar calendar= Calendar.getInstance();
        edtstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        String ngay="";
                        String thang="";
                        if (dayOfMonth<10){
                            ngay="0"+dayOfMonth;
                        }else {
                            ngay=String.valueOf(dayOfMonth);
                        }
                        if ((month + 1)<10){
                            thang="0" + (month+1);
                        }else{
                            thang= String.valueOf((month+1));
                        }
                        edtstart.setText(year + "/" + thang + "/" + ngay);
                    }
                },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        edtend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog= new DatePickerDialog(
                        getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        String ngay="";
                        String thang="";
                        if (dayOfMonth<10){
                            ngay="0"+dayOfMonth;
                        }else {
                            ngay=String.valueOf(dayOfMonth);
                        }
                        if ((month + 1)<10){
                            thang="0" + (month+1);
                        }else{
                            thang= String.valueOf((month+1));
                        }
                        edtend.setText(year + "/" + thang + "/" + ngay);
                    }
                },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
        btnthongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThongKeDAO ThongKeDAO = new ThongKeDAO(getContext());
                String ngaybatdau=edtstart.getText().toString();
                String ngayketthuc=edtend.getText().toString();
                int doanhthu= ThongKeDAO.getDoanhthu(ngaybatdau,ngayketthuc);
                txtkq.setText(doanhthu + "VNĐ");
            }
        });
        return view;
    }

}