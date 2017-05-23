package com.example.activityislistener;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NguyenNhuY extends Activity implements OnClickListener{
	EditText Ten, ChieuCao,CanNang, BMI, ChuanDoan;
	Button nut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_nhu_y);
        nut=(Button) findViewById(R.id.button1);
        nut.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nguyen_nhu_y, menu);
        return true;
    }

	@Override
	public void onClick(View arg0) {
		ChieuCao=(EditText) findViewById(R.id.tC);
    	CanNang=(EditText) findViewById(R.id.tN);
    	BMI=(EditText) findViewById(R.id.tB);
    	ChuanDoan=(EditText) findViewById(R.id.tD);
    	DecimalFormat LamTron=new DecimalFormat("#.0");
    	try  
        {  
    	
    		double iCao= Double.parseDouble(ChieuCao.getText().toString());
    		double iCanNang=Double.parseDouble(CanNang.getText().toString());
    		double dBMI = iCanNang/Math.pow(iCao, 2);
           if(dBMI>35) {
        	   BMI.setText(LamTron.format(dBMI)+"");
        	   ChuanDoan.setText("Người béo phì độ III");
           }
           else if(dBMI>=30) {
        	   BMI.setText(LamTron.format(dBMI)+"");
        	   ChuanDoan.setText("Người béo phì độ II");
           }
           else if(dBMI>=25) {
        	   BMI.setText(LamTron.format(dBMI)+"");
        	   ChuanDoan.setText("Người béo phì độ I");
           }
           else if(dBMI>=18) {
        	   BMI.setText(LamTron.format(dBMI)+"");
        	   ChuanDoan.setText("Người bình thường");
           }else{
        	   BMI.setText(LamTron.format(dBMI)+"");
        	   ChuanDoan.setText("Người gầy");
           }
        	   
        }  
        catch(Exception e)  
        {  
        	BMI.setText("Lỗi dữ liệu nhập vào");
     	   ChuanDoan.setText("Lỗi dữ liệu nhập vào");
        }  
	}
    
}
