package com.example.duan1_pro.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.duan1_pro.R;
import com.example.duan1_pro.adapter.topAdapter;
import com.example.duan1_pro.dao.hoaDonDAO;
import com.example.duan1_pro.model.top;

import java.util.ArrayList;


public class FragmentTop10Nuoc extends Fragment {


    ListView listView;
    ArrayList<top> listTop;
    topAdapter topAdapter;


    public FragmentTop10Nuoc() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_top10_nuoc, container, false);
        listView = view.findViewById(R.id.lvTop);
        hoaDonDAO HoaDonDAO=new hoaDonDAO(getActivity());
        listTop= (ArrayList<top>) HoaDonDAO.getTop();
        topAdapter=new topAdapter(getActivity(), this, listTop);
        listView.setAdapter(topAdapter);
        return view;
    }
}