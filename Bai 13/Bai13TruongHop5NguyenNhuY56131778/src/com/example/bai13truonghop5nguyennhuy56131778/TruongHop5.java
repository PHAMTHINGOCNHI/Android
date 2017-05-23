package com.example.bai13truonghop5nguyennhuy56131778;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.app.Activity;
import android.view.Menu;

public class TruongHop5 extends ListActivity {


TextView selection;
 String arr[]={"Intel","SamSung",
 "Nokia","Simen","AMD",
 "KIC","ECD"};
 ArrayAdapter<String >adapter=null;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.nguyen_nhu_y_truong_hop5);
 adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
 setListAdapter(adapter);
 
 selection=(TextView) findViewById(R.id.selection);
 }
 protected void onListItemClick(ListView l, View v, int position, long id) {
 super.onListItemClick(l, v, position, id);
 String txt="postion = "+position +"; value ="+arr[position];
 selection.setText(txt);
 }
}
