package com.example.inlineanonymouslistener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NguyenNhuY extends Activity {
	EditText ac;
	TextView bc;
	Button nutc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_nhu_y);
        nutc = (Button) findViewById(R.id.nut);
        nutc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ac = (EditText) findViewById(R.id.a);
		    	bc = (TextView) findViewById(R.id.b);
		    	try{
			    	int x = Integer.parseInt(ac.getText().toString());
			    	bc.setText(Can(x%10)+ " " + Chi(x%12));
		    	}
		    	catch (Exception e1)
		    	{
		    		bc.setText("Dữ liệu nhập vào không hợp lệ!");
		    	}	
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nguyen_nhu_y, menu);
        return true;
    }
    
    public String Can(int x){
    	switch (x)
    	{
    	    case 0 : return "Canh";
    	    case 1 : return "Tân";
    	    case 2 : return "Nhâm";
    	    case 3 : return "Quý";
    	    case 4 : return "Giáp";
    	    case 5 : return "Ất";
    	    case 6 : return "Bính";
    	    case 7 : return "Đinh";
    	    case 8 : return "Mậu";
    	    case 9 : return "Kỷ";
    	    default : return "lỗi";
    	}
    	
    }
    
    public String Chi(int x){
    	switch (x)
    	{
    	    case 0 : return "Thân";
    	    case 1 : return "Dậu";
    	    case 2 : return "Tuất";
    	    case 3 : return "Hợi";
    	    case 4 : return "Tý";
    	    case 5 : return "Sửu";
    	    case 6 : return "Dần";
    	    case 7 : return "Mẹo";
    	    case 8 : return "Thình";
    	    case 9 : return "Tỵ";
    	    case 10 : return "Ngọ";
    	    case 11 : return "Mùi";
    	    default : return "lỗi";
    	}
    	
    }
}
