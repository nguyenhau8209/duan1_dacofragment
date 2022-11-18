package com.example.duan1_pro.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_pro.model.matHang;
import com.example.duan1_pro.sqlite.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class matHangDAO {
    SQLiteDatabase db;
    DbHelper dbHelper;

    public matHangDAO(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    public boolean insert(matHang matHang){
        ContentValues values = new ContentValues();
        values.put("tenMatHang", matHang.getTenMatHang());
        values.put("giaBan", matHang.getGiaban());
        values.put("maLoaiMH", matHang.getMaLoaiMatHang());
        long check = db.insert("MATHANG", null, values);

        if (check ==-1){
            return false;
        }

        return true;
    }

    public boolean update(matHang matHang){
        ContentValues values = new ContentValues();
        values.put("tenMatHang", matHang.getTenMatHang());
        values.put("giaBan", matHang.getGiaban());
        values.put("maLoaiMH", matHang.getMaLoaiMatHang());
        long check = db.update("MATHANG", values, "maMatHang=?", new String[]{String.valueOf(matHang.getMaMatHang())});

        if(check==-1){
            return false;
        }
        return true;
    }

    public int delete(String id){
        return db.delete("MATHANG", "maMatHang", new String[]{id});
    }

    @SuppressLint("Range")
    public ArrayList<matHang> getData(String sql, String...selectionArgs){
        ArrayList<matHang> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            matHang matHang = new matHang();
            matHang.setMaMatHang(Integer.parseInt(c.getString(c.getColumnIndex("maMatHang"))));
            matHang.setTenMatHang(c.getString(c.getColumnIndex("tenMatHang")));
            matHang.setGiaban(Integer.parseInt(c.getString(c.getColumnIndex("giaBan"))));
            matHang.setMaLoaiMatHang(Integer.parseInt(c.getString(c.getColumnIndex("maLoaiMH"))));
            list.add(matHang);
        }
        return list;

    }


    //getall
    public ArrayList<matHang> getAll(){
        String sql = "SELECT * FROM MATHANG";
        return getData(sql);
    }


    //get id
    public matHang getID(String id){
        String sql = "SELECT * FROM MATHANG where maMatHang=?";
        List<matHang> list = getData(sql, id);
        if(list.size()==0){
            return new matHang();
        }else {
            return list.get(0);
        }
    }
}
