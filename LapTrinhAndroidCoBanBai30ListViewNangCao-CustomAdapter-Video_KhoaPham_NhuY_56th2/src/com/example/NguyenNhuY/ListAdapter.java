package com.example.NguyenNhuY;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<SinhVien> {

    public ListAdapter(Context context, int resource, List<SinhVien> items) {
    	//màng hình đang đứng + màng hình row + Mảng
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.dongsinhvien, null);
        }
        SinhVien p = getItem(position);
        if (p != null) {
            TextView tt1 = (TextView) view.findViewById(R.id.textViewHoTen);
            TextView tt2 = (TextView) view.findViewById(R.id.textViewNamSinh);
            tt1.setText(p.HoTen);
            tt2.setText(String.valueOf(p.NamSinh));
        }
        return view;
    }

}