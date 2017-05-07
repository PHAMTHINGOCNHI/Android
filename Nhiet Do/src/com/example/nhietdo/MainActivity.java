package com.example.nhietdo;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	private Button btnConvertC, btnConvertF, btnClear;
	private EditText txtC, txtF;
	private OnClickListener myVarListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			EditText txtC = (EditText) findViewById(R.id.txtC);
			EditText txtF = (EditText) findViewById(R.id.txtF);
			
			if(arg0 == btnConvertC)
			{
				double c;
				double f = Double.parseDouble(txtF.getText()+"");
				 c = (f - 32 )* 5/9 ;
				 
				 DecimalFormat dcf = new DecimalFormat("#.0");
				 txtC.setText(dcf.format(c));	
			}
			else
				if(arg0 == btnConvertF)
				{
					double f;
					double c = Double.parseDouble(txtC.getText()+"");
					 f= c*(9/5)+32 ;
					 
					 DecimalFormat dcf = new DecimalFormat("#.0");
					 txtC.setText(dcf.format(f));	
				}
				else if(arg0 == btnClear)
				{
					txtC.setText("");
					txtF.setText("");
					txtF.requestFocus();
				}
			
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText txtC = (EditText) findViewById(R.id.txtC);
		EditText txtF = (EditText) findViewById(R.id.txtF);
		
		
		Button btnConvertC = (Button) findViewById(R.id.btnConvertC);
		Button btnConvertF = (Button) findViewById(R.id.btnConvertF);
		Button btnClear = (Button) findViewById(R.id.btnClear);
		
		btnConvertC.setOnClickListener(myVarListener);
		btnConvertF.setOnClickListener(myVarListener);
		btnClear.setOnClickListener(myVarListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
