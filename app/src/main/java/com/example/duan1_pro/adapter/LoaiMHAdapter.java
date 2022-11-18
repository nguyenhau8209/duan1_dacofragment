package com.example.duan1_pro.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_pro.R;
import com.example.duan1_pro.dao.loaiMatHangDAO;
import com.example.duan1_pro.model.ItemClick;
import com.example.duan1_pro.model.loaiMatHang;

import java.util.ArrayList;

public class LoaiMHAdapter extends RecyclerView.Adapter<LoaiMHAdapter.ViewHolder> {
    Context context;
    ArrayList<loaiMatHang> listLMH;
    private ItemClick itemClick;

    public LoaiMHAdapter(Context context, ArrayList<loaiMatHang> listLMH , ItemClick itemClick) {
        this.context = context;
        this.listLMH = listLMH;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_loaimathang, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMa.setText("Mã Loại: " + listLMH.get(position).getMaLoaiMatHang());
        holder.tvTen.setText("Tên Loại: " + listLMH.get(position).getTenLoaiMatHang() + "");

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loaiMatHangDAO loaiMHDAO = new loaiMatHangDAO(context);
                int check = loaiMHDAO.delete(listLMH.get(holder.getAdapterPosition()).getMaLoaiMatHang());
                switch (check) {
                    case 1:
                        listLMH.clear();
                        listLMH = loaiMHDAO.getAll();
                        notifyDataSetChanged();
                        Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                        break;
                    case -1:
                        Toast.makeText(context, "Không thể xóa vì đã có mặt hàng", Toast.LENGTH_SHORT).show();
                    case 0:
                        Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();

                }
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loaiMatHang loaiMH = listLMH.get(holder.getAdapterPosition());
                itemClick.onClickLoaiMH(loaiMH);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listLMH.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMa, tvTen;
        ImageView btnDelete;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMa = itemView.findViewById(R.id.txtmaloai);
            tvTen = itemView.findViewById(R.id.txttenloai);
            btnDelete = itemView.findViewById(R.id.txtxoaloai);
            cardView = itemView.findViewById(R.id.full);
        }
    }
}
