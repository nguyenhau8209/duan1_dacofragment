package com.example.duan1_pro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_pro.fragment.FragmentDoanhThu;
import com.example.duan1_pro.fragment.FragmentDoiMatKhau;
import com.example.duan1_pro.fragment.FragmentHoaDon;
import com.example.duan1_pro.fragment.FragmentKhachHang;
import com.example.duan1_pro.fragment.FragmentLoaiMatHang;
import com.example.duan1_pro.fragment.FragmentMatHang;
import com.example.duan1_pro.fragment.FragmentThemThanhVien;
import com.example.duan1_pro.fragment.FragmentTop10Nuoc;
import com.google.android.material.navigation.NavigationView;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        FrameLayout frameLayout = findViewById(R.id.framelayout);
        NavigationView navigationView=findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);
        View headerlayout= navigationView.getHeaderView(0);
        TextView txttitle=headerlayout.findViewById(R.id.txttitle);
        setSupportActionBar(toolbar);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();
                switch (item.getItemId()){
                    case R.id.nav_home:
                        setTitle("H??a ????n");
                        // tr???ng ?????p trai
                        break;
                    case R.id.nav_mathang:
                        setTitle("M???t h??ng");
                        Fragment fragment = new FragmentMatHang();
                        manager.beginTransaction().replace(R.id.framelayout, fragment).commit();
                        break;
                    case R.id.nav_loaimathang:
                        setTitle("Lo???i m???t h??ng");
                        Fragment frgLoaiMatHang = new FragmentLoaiMatHang();
                        manager.beginTransaction().replace(R.id.framelayout, frgLoaiMatHang).commit();
                        break;
                        // he
                    case R.id.nav_hoadon:
                        setTitle("H??a ????n");
                        Fragment frgHoaDon = new FragmentHoaDon();
                        manager.beginTransaction().replace(R.id.framelayout, frgHoaDon).commit();
                        break;
                    case R.id.nav_quanlykhachhang:
                        setTitle("Qu???n l?? kh??ch h??ng");
                        Fragment frgQuanLyKhachHang = new FragmentKhachHang();
                        manager.beginTransaction().replace(R.id.framelayout, frgQuanLyKhachHang).commit();
                        break;
                    case R.id.sub_top:
                        setTitle("Top 10 b??n ch???y nh???t");
                        Fragment frgTop = new FragmentTop10Nuoc();
                        manager.beginTransaction().replace(R.id.framelayout, frgTop).commit();
                        break;
                    case R.id.sub_doanhthu:
                        setTitle("Doanh thu");
                        Fragment frgDoanhThu = new FragmentDoanhThu();
                        manager.beginTransaction().replace(R.id.framelayout, frgDoanhThu).commit();
                        break;
                    case R.id.sub_themnhanvien:
                        setTitle("Th??m nh??n vi??n");
                        Fragment frgThemNhanVien = new FragmentThemThanhVien();
                        manager.beginTransaction().replace(R.id.framelayout, frgThemNhanVien).commit();
                        break;
                    case R.id.sub_doimatkhau:
                        setTitle("?????i m???t kh???u");
                        Fragment frgDoiMatKhau = new FragmentDoiMatKhau();
                        manager.beginTransaction().replace(R.id.framelayout, frgDoiMatKhau).commit();
                        break;
                    case R.id.sub_dangxuat:
                        setTitle("????ng xu???t");
                        startActivity(new Intent(MainActivity.this, Login.class));
                        Toast.makeText(MainActivity.this, "????ng xu???t th??nh c??ng", Toast.LENGTH_SHORT).show();
                        finish();
                        break;

                }
                drawerLayout.closeDrawers();
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

}