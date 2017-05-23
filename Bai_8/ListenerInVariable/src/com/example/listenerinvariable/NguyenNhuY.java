package com.example.listenerinvariable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NguyenNhuY extends Activity {

	EditText c, f;
	Button btntoC, btntoF, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_nhu_y);
        c=(EditText) findViewById(R.id.tC);
        f=(EditText) findViewById(R.id.tF);
        btntoC=(Button) findViewById(R.id.button1);
        btntoF=(Button) findViewById(R.id.button2);
        btnClear=(Button) findViewById(R.id.button3);
        btntoC.setOnClickListener(myVarListener);
        btntoF.setOnClickListener(myVarListener);
        btnClear.setOnClickListener(myVarListener);

    }
    private OnClickListener myVarListener=new OnClickListener() {
    	public void onClick(View v) {
    		if(v==btntoC){
    			try{
    	    		double df = Double.parseDouble(f.getText().toString());
    	        	c.setText((df - 32)*5/9 + "") ;
    	    	}
    	    	catch(Exception e)
    	    	{
    	    		c.setText("Lỗi dữ liệu nhập") ;
    	    	}
    		}
    		if(v==btntoF){
    			try{
    	    		double dc = Double.parseDouble(c.getText().toString());
    	        	f.setText(dc*9/5 + 32 + "") ;
    	    	}
    	    	catch(Exception e)
    	    	{
    	    		f.setText("Lỗi dữ liệu nhập") ;
    	    	}
    		}
    		if(v==btnClear){
    			f.setText("") ;
    	    	c.setText("") ;
    	    	f.requestFocus();
    		}
    	}
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nguyen_nhu_y, menu);
        return true;
    }
    
}
