package com.example.duan1_pro.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_pro.model.loaiMatHang;
import com.example.duan1_pro.sqlite.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class loaiMatHangDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public loaiMatHangDAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public boolean insert(String loaiMatHang) {
        ContentValues values = new ContentValues();
        values.put("tenLoaiMH", loaiMatHang);
        long check = db.insert("LOAIMATHANG", null, values);
        if (check == -1) {
            return false;
        }
        return true;
    }

    public boolean update(loaiMatHang loaiMatHang) {
        ContentValues values = new ContentValues();
        values.put("tenLoaiMH", loaiMatHang.getTenLoaiMatHang());
        long check = db.update("LOAIMATHANG", values, "maLoaiMH", new String[]{String.valueOf(loaiMatHang.getMaLoaiMatHang())});
        if (check == -1) {
            return false;
        }
        return true;
    }

//    public int delete(String id){
//        return db.delete("LOAIMATHANG", "maLoaiMH", new String[]{id});
//    }

    public int delete(int id) {
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MATHANG where maLoaiMH =?", new String[]{String.valueOf(id)});
        if (cursor.getCount() != 0) {
            return -1;//bằng -1 là không được xóa
        }
        long check = db.delete("LOAIMATHANG", "maLoaiMH=?", new String[]{String.valueOf(id)});
        if (check == -1) {
            return 0;//xóa thất bại
        }
        return 1;
    }

    @SuppressLint("Range")
    public ArrayList<loaiMatHang> getData(String sql, String... selectionArgs) {
        ArrayList<loaiMatHang> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()) {
            loaiMatHang loaiMatHang = new loaiMatHang();
            loaiMatHang.setMaLoaiMatHang(Integer.parseInt(c.getString(c.getColumnIndex("maLoaiMH"))));
            loaiMatHang.setTenLoaiMatHang(c.getString(c.getColumnIndex("tenLoaiMH")));
            list.add(loaiMatHang);
        }
        return list;

    }


    //getall
    public ArrayList<loaiMatHang> getAll() {
        String sql = "SELECT * FROM LOAIMATHANG";
        return getData(sql);
    }


    //get id
    public loaiMatHang getID(String id) {
        String sql = "SELECT * FROM LOAIMATHANG where maLoaiMH =?";
        List<loaiMatHang> list = getData(sql, id);
        if (list.size() == 0) {
            return new loaiMatHang();
        } else {
            return list.get(0);
        }
    }


}
