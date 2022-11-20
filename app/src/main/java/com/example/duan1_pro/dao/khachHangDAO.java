package com.example.duan1_pro.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.duan1_pro.model.khachHang;
import com.example.duan1_pro.sqlite.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class khachHangDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public khachHangDAO(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    public long insert(khachHang khachHang){
        ContentValues values = new ContentValues();
        values.put("tenKhachHang", khachHang.getTenKhachHang());
        values.put("soDT", khachHang.getSoDienThoai());
        values.put("diaChi", khachHang.getDiaChi());
        values.put("tuoi", khachHang.getTuoi());
        values.put("gioitinh", khachHang.getGioiTinh());
        return db.insert("KHACHHANG", null, values);
    }

    public long update(khachHang khachHang){
        ContentValues values = new ContentValues();
        values.put("tenKhachHang", khachHang.getTenKhachHang());
        values.put("soDT", khachHang.getSoDienThoai());
        values.put("diaChi", khachHang.getDiaChi());
        values.put("tuoi", khachHang.getTuoi());
        values.put("gioitinh", khachHang.getGioiTinh());
        return db.update("KHACHHANG", values, "maKhachHang=?", new String[]{String.valueOf(khachHang.getMaKhachHang())});
    }

    public int delete(String id){
        return db.delete("KHACHHANG", "maKhachHang=?", new String[]{id});
    }

    @SuppressLint("Range")
    public ArrayList<khachHang> getData(String sql , String...selectionArgs){
        ArrayList<khachHang> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            khachHang khachHang = new khachHang();
            khachHang.setMaKhachHang(Integer.parseInt(c.getString(c.getColumnIndex("maKhachHang"))));
            khachHang.setTenKhachHang(c.getString(c.getColumnIndex("tenKhachHang")));
            khachHang.setSoDienThoai(Integer.parseInt(c.getString(c.getColumnIndex("soDT"))));
            khachHang.setDiaChi(c.getString(c.getColumnIndex("diaChi")));
            khachHang.setTuoi(Integer.parseInt(c.getString(c.getColumnIndex("tuoi"))));
            khachHang.setGioiTinh(c.getString(c.getColumnIndex("gioitinh")));
            Log.i("zzzz", khachHang.toString());
            list.add(khachHang);
        }
        return list;
    }

    //getall
    public List<khachHang> getAll(){
        String sql = "Select * from KHACHHANG";
        return getData(sql);
    }

    //get id
    public khachHang getID(String id){
        String sql = "SELECT * FROM KHACHHANG WHERE maTV=?";
        List<khachHang> list = getData(sql, id);
        if (list.size()==0){
            return new khachHang();
        }else {
            return list.get(0);
        }
    }



}
