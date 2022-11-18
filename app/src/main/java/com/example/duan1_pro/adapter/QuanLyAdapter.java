package com.example.duan1_pro.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_pro.R;
import com.example.duan1_pro.dao.quanLyDAO;
import com.example.duan1_pro.fragment.FragmentQuanLy;
import com.example.duan1_pro.model.ItemClickQuanLy;
import com.example.duan1_pro.model.quanLy;

import java.util.List;

public class QuanLyAdapter extends RecyclerView.Adapter<QuanLyAdapter.ViewHolder> {
    private Context context;
    List<quanLy> listQL;
    ItemClickQuanLy itemClickQL;
    FragmentQuanLy frmAddQL = new FragmentQuanLy();

    public QuanLyAdapter( Context context, List<quanLy> listQL, ItemClickQuanLy itemClickQL) {
        this.context = context;
        this.listQL = listQL;
        this.itemClickQL = itemClickQL;
    }


    @Override
    public QuanLyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_quanly, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuanLyAdapter.ViewHolder holder, int position) {
        holder.tvMa.setText("Tài Khoản: " + listQL.get(position).getMaQuanLy());
        holder.tvTen.setText("Tên Người Dùng: " + listQL.get(position).getTenQuanLy());
        holder.tvPass.setText("Mật Khẩu: " + listQL.get(position).getMatkhau());

        holder.imdDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                frmAddUser.delete(String.valueOf(listThuThu.get(position).getMaTT()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listQL.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTen, tvMa, tvPass;
        quanLyDAO quanLyDAO = new quanLyDAO(context);
        ImageView imdDel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMa = itemView.findViewById(R.id.txtUser);
            tvTen = itemView.findViewById(R.id.txtName);
            tvPass = itemView.findViewById(R.id.txtPass);
            imdDel = itemView.findViewById(R.id.btnXoaUser);


        }
    }


}
