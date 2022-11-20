package com.example.duan1_pro.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public final static String DBName = "DBHELPER";
    public final static int DBVersion = 3;
    public DbHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbAdmin = "CREATE TABLE ADMIN (taiKhoan text, matKhau text)";
        sqLiteDatabase.execSQL(dbAdmin);
        String dbQuanLy = "CREATE TABLE QUANLY (maQuanLy text primary key, tenQuanLy text, matKhau text)";
        sqLiteDatabase.execSQL(dbQuanLy);
        String dbKhachHang = "CREATE TABLE KHACHHANG (maKhachHang integer primary key autoincrement, tenKhachHang text, soDT integer, diaChi text, tuoi integer, gioitinh text)";
        sqLiteDatabase.execSQL(dbKhachHang);
        String dbLoaiMatHang = "CREATE TABLE LOAIMATHANG (maLoaiMH integer primary key autoincrement, tenLoaiMH text)";
        sqLiteDatabase.execSQL(dbLoaiMatHang);
        String dbMatHang = "CREATE TABLE MATHANG (maMatHang integer primary key autoincrement, tenMatHang text, giaBan integer, maLoaiMH integer references LOAIMATHANG(maLoaiMH))";
        sqLiteDatabase.execSQL(dbMatHang);
        String dbHoaDon ="CREATE TABLE HOADON (maHoaDon integer primary key autoincrement, tenHoaDon text, maKhachHang integer references KHACHHANG(maKhachHang),maMatHang integer references MATHANG(maMatHang),  ngayMua date, thanhTien integer)";
        sqLiteDatabase.execSQL(dbHoaDon);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ADMIN");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS QUANLY");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KHACHHANG");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAIMATHANG");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MATHANG");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HOADON");
            onCreate(sqLiteDatabase);
        }

    }
}
