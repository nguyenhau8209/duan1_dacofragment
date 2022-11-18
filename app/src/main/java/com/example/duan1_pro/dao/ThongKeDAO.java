package com.example.duan1_pro.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_pro.model.matHang;
import com.example.duan1_pro.sqlite.DbHelper;

import java.util.ArrayList;

public class ThongKeDAO {
    DbHelper dbHelper;
    public ThongKeDAO(Context context){
        dbHelper= new DbHelper(context);
    }
    public ArrayList<matHang> gettop10(){
        ArrayList<matHang> list= new ArrayList<>();
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT hd.maMatHang,mh.tenMatHang, COUNT(hd.maMatHang) FROM HOADON hd,MATHANG mh WHERE hd.maMatHang=mh.maMatHang GROUP BY hd.maMatHang,mh.maMatHang ORDER BY COUNT(hd.maMatHang) DESC LIMIT 10",null);
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            do {
                list.add(new matHang(cursor.getInt(0), cursor.getString(1), cursor.getFloat(2),cursor.getInt(3) ));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public  int getDoanhthu(String ngaybatdau,String ngayketthuc){
        ngaybatdau= ngaybatdau.replace("/","");
        ngayketthuc=ngayketthuc.replace("/","");
        SQLiteDatabase sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT SUM(tienthue) \n" +
                "FROM PHIEUMUON \n" +
                "WHERE substr(ngay,7)||substr(ngay,4,2)||substr(ngay,1,2) between ? and ?",new String[]{ngaybatdau,ngayketthuc});
        if (cursor.getCount()!=0){
            cursor.moveToFirst();
            return cursor.getInt(0);
        }
        return 0;
    }
}
