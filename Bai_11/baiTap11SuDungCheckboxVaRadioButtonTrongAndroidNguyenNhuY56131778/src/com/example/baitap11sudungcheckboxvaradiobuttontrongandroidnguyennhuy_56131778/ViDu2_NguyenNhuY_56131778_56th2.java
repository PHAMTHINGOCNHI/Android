package com.example.baitap11sudungcheckboxvaradiobuttontrongandroidnguyennhuy_56131778;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
public class ViDu2_NguyenNhuY_56131778_56th2  extends Activity {
	RadioGroup Nhom ;
	Button Nut;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vidu_radiobutton);
        Nhom = (RadioGroup) findViewById(R.id.Nhomradio);
        Nut = (Button) findViewById(R.id.button1);
        Nut.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ThongTinCheckBox();
				
			}
		});
    }
	
	 public void ThongTinCheckBox()
	    {
	    	String ketqua="";
	    	int tmp = Nhom.getCheckedRadioButtonId();
	    	if(tmp==R.id.radioButton1) ketqua+=((RadioButton)findViewById(tmp)).getText().toString();
	    	else if(tmp==R.id.radioButton2) ketqua+=((RadioButton)findViewById(tmp)).getText().toString();
	    	else if(tmp==R.id.radioButton3) ketqua+=((RadioButton)findViewById(tmp)).getText().toString();
	    	else if(tmp==R.id.radioButton4) ketqua+=((RadioButton)findViewById(tmp)).getText().toString();
	    	else if(tmp==R.id.radioButton5) ketqua+=((RadioButton)findViewById(tmp)).getText().toString();
	    	ketqua = "------------------------------------------- \n" + ketqua;
	    	AlertDialog.Builder builder=new AlertDialog.Builder(this);
	    	builder.setTitle("Bạn đã chọn!");
	    	builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
	    		@Override
	    		public void onClick(DialogInterface dialog, int which) {
	    		// TODO Auto-generated method stub
	    		dialog.cancel();
	    		}
	    		});
	    	builder.setMessage(ketqua);//thiết lập nội dung
	    	builder.create().show();//hiển thị Dialog

	    }
	 public void chuyenSangVidDu3(View v)
	 {
		 Intent chuyen = new Intent(ViDu2_NguyenNhuY_56131778_56th2.this, ViDu3_NguyenNhuY_56131778_56th2.class);
	    	startActivity(chuyen);
	 }
}














//Nguyễn  như ý _ 56131778