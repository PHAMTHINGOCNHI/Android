package com.example.explicitlistenerclass;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NguyenNhuY extends Activity {

	EditText a, b, c;
	TextView kq;
	Button btnTieptuc,btnGiai,btnThoat;
	DecimalFormat LamTron=new DecimalFormat("#.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_nhu_y);
        a=(EditText) findViewById(R.id.tA);
        b=(EditText) findViewById(R.id.tB);
        c=(EditText) findViewById(R.id.tC);
        kq=(TextView) findViewById(R.id.tK);
        btnTieptuc=(Button) findViewById(R.id.button1);
        btnGiai=(Button) findViewById(R.id.button2);
        btnThoat=(Button) findViewById(R.id.button3);
        btnTieptuc.setOnClickListener(new MyEvent());
        btnGiai.setOnClickListener(new MyEvent());
        btnThoat.setOnClickListener(new MyEvent());
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nguyen_nhu_y, menu);
        return true;
    }
    public  class MyEvent implements OnClickListener{

    	public void TiepTuc()
        {
        	a.setText("");
        	b.setText("");
        	c.setText("");
        	kq.setText("");
        	a.requestFocus();
        }
        
        public void GiaiPT()
        {
        	try{
        		double da = Double.parseDouble(a.getText().toString());
            	double db = Double.parseDouble(b.getText().toString());
            	double dc = Double.parseDouble(c.getText().toString());
            	
            	if(da==0)
            		if(db==0)
            			if(dc==0)
            				kq.setText("PT vô số nghiệm!");
            			else kq.setText("PT vô nghiệm!");
            		else kq.setText("PT có 1 N:o x= " + LamTron.format(-dc/db));
            	else
            	{
            		double delta = Math.pow(db, 2) - 4*da*dc;
            		if(delta<0) kq.setText("PT vô nghiệm!");
            		else if(delta==0) kq.setText("PT có No kép: x1 = x2 = " + LamTron.format(-db/(2*da)));
            		else {
            			double x1, x2;
            			x1 = (-db - Math.sqrt(delta))/(2*da);
            			x2 = (-db+ Math.sqrt(delta))/(2*da);
            			kq.setText("PT có 2 No: x1 = " + LamTron.format(x1) + ", x2 = " + LamTron.format(x2));
            		}
            		
            	}
        	}
        	catch(Exception e)
        	{
        		kq.setText("Lỗi dữ liệu nhập!");
        	}
        }
        
        public void Thoat()
        {
        	finish();
        }
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v==btnTieptuc) this.TiepTuc();
			if(v==btnGiai) this.GiaiPT();
			if(v==btnThoat) this.Thoat();
			
		}
    	
    }
}