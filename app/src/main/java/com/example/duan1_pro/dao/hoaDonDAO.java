package com.example.duan1_pro.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_pro.model.hoaDon;
import com.example.duan1_pro.model.matHang;
import com.example.duan1_pro.model.top;
import com.example.duan1_pro.sqlite.DbHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class hoaDonDAO {
    static SQLiteDatabase db;
    Context context;
    DbHelper dbHelper;
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");

    public hoaDonDAO(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    public long insert(hoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("tenHoaDon", hoaDon.getTenHoaDon());
        values.put("maKhachHang", hoaDon.getMaKhachHang());
        values.put("maMatHang", hoaDon.getMaMatHang());
        values.put("ngayMua", sdf.format(hoaDon.getNgayMua()));
        values.put("thanhTien", hoaDon.getThanhTien());
        return db.insert("HOADON", null, values);
    }

    public long update(hoaDon hoaDon){
        ContentValues values = new ContentValues();
        values.put("tenHoaDon", hoaDon.getTenHoaDon());
        values.put("maKhachHang", hoaDon.getMaKhachHang());
        values.put("maMatHang", hoaDon.getMaMatHang());
        values.put("ngayMua", sdf.format(hoaDon.getNgayMua()));
        values.put("thanhTien", hoaDon.getThanhTien());
        return db.update("HOADON", values, "maHoaDon=?", new String[]{String.valueOf(hoaDon.getMaHoaDon())});
    }

    public int delete(String id){
        return db.delete("HOADON", "maHoaDon=?", new String[]{id});
    }


    @SuppressLint("Range")
    public static ArrayList<hoaDon> getData(String sql, String... selectionArgs){
        ArrayList<hoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            hoaDon hoaDon = new hoaDon();
            hoaDon.setMaHoaDon(Integer.parseInt(c.getString(c.getColumnIndex("maHoaDon"))));
            hoaDon.setTenHoaDon(c.getString(c.getColumnIndex("tenHoaDon")));
            hoaDon.setMaKhachHang(Integer.parseInt(c.getString(c.getColumnIndex("maKhachHang"))));
            hoaDon.setMaMatHang(Integer.parseInt(c.getString(c.getColumnIndex("maMatHang"))));
            try {
                hoaDon.setNgayMua(sdf.parse(c.getString(c.getColumnIndex("ngayMua"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            hoaDon.setThanhTien(Integer.parseInt(c.getString(c.getColumnIndex("thanhTien"))));
            list.add(hoaDon);
        }
        return list;
    }

    public static List<hoaDon> getAll(){
        String sql = "SELECT * FROM HOADON";
        return getData(sql);
    }

    public hoaDon getID(String id){
        String sql = "select * from HOADON where maHoaDon =?";
        List<hoaDon> list = getData(sql, id);
        if (list.size()==0){
            return new hoaDon();
        }else {
            return list.get(0);
        }

    }


    //Thong ke top 10


    @SuppressLint("Range")
    public List<top> getTop(){
        String sqlTop = "Select maMatHang , count(maMatHang) as soLuong from HOADON group by maMatHang order by soLuong DESC limit 10";
        List<top> list = new ArrayList<>();
        matHangDAO matHangDAO = new matHangDAO(context);
        Cursor c = db.rawQuery(sqlTop, null);
        while (c.moveToNext()){
            top top = new top();
            @SuppressLint("Range") matHang matHang = matHangDAO.getID(c.getString(c.getColumnIndex("maMatHang")));
            top.setTenMatHang(matHang.getTenMatHang());
            top.setSoLuong(Integer.parseInt(c.getString(c.getColumnIndex("soLuong"))));
            list.add(top);
        }
        return list;

    }

    @SuppressLint("Range")
    public int getDoanhThu(String min, String max){
        String sqlDoanhThu = "Select Sum(thanhToan) as doanhThu from HOADON where ngayMua between ? and ?";
        List<Integer> list = new ArrayList<>();
        Cursor c = db.rawQuery(sqlDoanhThu, new String[]{min, max});
        while (c.moveToNext()){
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("doanhThu"))));

            } catch (Exception e) {
                list.add(0);
            }
        }
        return list.get(0);
    }
}
