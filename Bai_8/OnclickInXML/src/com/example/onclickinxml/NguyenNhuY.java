package com.example.onclickinxml;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NguyenNhuY extends Activity {

	EditText a, b;
	Button nut;
	TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_nhu_y);
        a = (EditText) findViewById(R.id.soa);
        b = (EditText) findViewById(R.id.sob);
        nut = (Button) findViewById(R.id.nut);
        kq = (TextView) findViewById(R.id.kq);
    }

    public void Tong2so(View v)
    {
    	try{
			int ia = Integer.parseInt(a.getText().toString());
			int ib = Integer.parseInt(b.getText().toString());
			int ikq = ia+ib;
			kq.setText(ikq + "");}
			catch (Exception e1){
				kq.setText("Đầu vào bị lỗi");
			}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nguyen_nhu_y, menu);
        return true;
    }
    
}
