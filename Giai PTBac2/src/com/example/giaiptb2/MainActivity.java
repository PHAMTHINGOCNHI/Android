package com.example.giaiptb2;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	Button btnTT,btnGiai,btnThoat;
	EditText edita, editb,editc;
	TextView txtkq;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnTT = (Button) findViewById(R.id.btnTT);
		btnTT.setOnClickListener(new MyEvent());
		
		btnGiai.setOnClickListener(new MyEvent());
		btnThoat.setOnClickListener(new MyEvent());
		edita=(EditText) findViewById(R.id.txtA);
		editb=(EditText) findViewById(R.id.txtB);
		editc=(EditText) findViewById(R.id.txtC);
		txtkq=(TextView) findViewById(R.id.txtKQ);

	}
	public void giaiPtb2()
	{
	String sa=edita.getText()+"";
	String sb=editb.getText()+"";
	String sc=editc.getText()+"";
	int a=Integer.parseInt(sa);
	int b=Integer.parseInt(sb);
	int c=Integer.parseInt(sc);
	String kq="";
	DecimalFormat dcf=new DecimalFormat("#.00");
	if(a==0)
	{
	if(b==0)
	{
	if(c==0)
	kq="PT vô số nghiệm";
	else
	kq="PT vô nghiệm";
	}
	else
	{
	kq="Pt có 1 No, x="+dcf.format(-c/b);
	}
	}
	else
	{
	double delta=b*b-4*a*c;
	if(delta<0)
	{
	kq="PT vô nghiệm";
	}
	else if(delta==0)
	{
	kq="Pt có No kép x1=x2="+dcf.format(-b/(2*a));
	}
	else
	{
	kq="Pt có 2 No: x1="+dcf.format((-b-Math.sqrt(delta))/(2*a))+
	"; x2="+dcf.format((-b-Math.sqrt(delta))/(2*a));
	}
	}
	txtkq.setText(kq);
	}

	private class MyEvent implements OnClickListener
	{
	@Override
	public void onClick(View arg0) {
	if(arg0==btnTT)
	{
	edita.setText("");
	editb.setText("");
	editc.setText("");
	edita.requestFocus();
	}
	else if(arg0.getId()==R.id.btnGiai)
	{
	giaiPtb2();
	}
	else if(arg0.getId()==R.id.btnThoat)
	{
	finish();
	}
	}
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
