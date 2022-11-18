package com.example.duan1_pro.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1_pro.model.quanLy;
import com.example.duan1_pro.sqlite.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class quanLyDAO {
SQLiteDatabase db;
DbHelper dbHelper;

public quanLyDAO(Context context){
    dbHelper = new DbHelper(context);
    db = dbHelper.getWritableDatabase();
}

public boolean insert(quanLy quanLy){
    ContentValues values = new ContentValues();
    values.put("maQuanLy", quanLy.getMaQuanLy());
    values.put("tenQuanLy", quanLy.getTenQuanLy());
    values.put("matKhau", quanLy.getMatkhau());
    long check = db.insert("QUANLY", null, values);
    if (check == -1){
        return false;
    }
    return true;

}

public boolean update(quanLy quanLy){
    ContentValues values = new ContentValues();
    values.put("maQuanLy", quanLy.getMaQuanLy());
    values.put("tenQuanLy", quanLy.getTenQuanLy());
    values.put("matKhau", quanLy.getMatkhau());
    long check = db.update("QUANLY", values, "maQuanLy=?", new String[]{quanLy.getMaQuanLy()});
    if (check == -1){
        return false;
    }
    return true;
}

public int delete(String id){
    return db.delete("QUANLY", "maQuanLy=?", new String[]{id});
}

@SuppressLint("Range")
public ArrayList<quanLy> getData(String sql, String...selectionArgs){
    ArrayList<quanLy> list = new ArrayList<>();
    Cursor c = db.rawQuery(sql, selectionArgs);
    while (c.moveToNext()){
        quanLy quanLy = new quanLy();
        quanLy.setMaQuanLy(c.getString(c.getColumnIndex("maQuanLy")));
        quanLy.setTenQuanLy(c.getString(c.getColumnIndex("tenQuanLy")));
        quanLy.setMatkhau(c.getString(c.getColumnIndex("matKhau")));
        list.add(quanLy);
    }
    return list;
}


//getall
    public ArrayList<quanLy> getAll(){
    String sql = "SELECT * FROM QUANLY";
    return getData(sql);
    }

    //getID
    public quanLy getID(String id){
    String sql = "SELECT * FROM QUANLY where maQuanLy=?";
        List<quanLy> list = getData(sql, id);
        return list.get(0);
    }
}
