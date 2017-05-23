package com.example.baitap11sudungcheckboxvaradiobuttontrongandroidnguyennhuy_56131778;
import android.R.color;
import android.os.Bundle;
import android.provider.CalendarContract.Colors;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
public class ViDu3_NguyenNhuY_56131778_56th2  extends Activity {
	RadioGroup NhomBangCap;
	CheckBox Bao, Sach, Code;
	EditText HoTen, CMND, BoSung;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtincanhan);
        NhomBangCap = (RadioGroup) findViewById(R.id.NhomBangCap);
        Bao = (CheckBox)findViewById(R.id.checkBox1);
        Sach = (CheckBox)findViewById(R.id.checkBox2);
        Code = (CheckBox)findViewById(R.id.checkBox3);
        HoTen = (EditText) findViewById(R.id.editText1);
        CMND = (EditText) findViewById(R.id.editText2);
        BoSung = (EditText) findViewById(R.id.editText3);
	}
	
	public void RunNaoNhuY56131778(View v)
	{
		if(KiemTraten()==1&&KiemTraCMND()==1&&KiemTraBangCap()==1&&KiemTraSoThich()==1)
		{
			HienThi();
		}
	}
	
	public int KiemTraten()
	{
		if(HoTen.getText().toString().length() <=3)
		{
			HoTen.requestFocus();
			HoTen.selectAll();
			Toast.makeText(this, "Tên phải lớn hơn 3ký tự", Toast.LENGTH_LONG).show();
			return -1;
		}
		return 1;
	}
	public int KiemTraCMND()
	{
		if(CMND.getText().toString().trim().length() != 9)
		{
			CMND.requestFocus();
			CMND.selectAll();
			Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
			return -1;
		}
		return 1;
	}
	
	public int KiemTraBangCap()
	{
		
		if(NhomBangCap.getCheckedRadioButtonId()==-1)
		{
			Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
			return -1;
		}
		return 1;
	}
	public int KiemTraSoThich()
	{
		if(Bao.isChecked()) return 1;
		if(Sach.isChecked()) return 1;
		if(Code.isChecked()) return 1;
		Toast.makeText(this, "Phải chọn ít nhất 1 sở thích", Toast.LENGTH_LONG).show();
		return -1;
	}

	public void HienThi()
	{
		String KetQua = "";
		KetQua += HoTen.getText() + "\n";
		KetQua +=CMND.getText() + "\n";
		KetQua += ((RadioButton) findViewById(NhomBangCap.getCheckedRadioButtonId())).getText().toString() + "\n";
		String ST="";
		if(Bao.isChecked()) ST += Bao.getText().toString() + " - " ;
		if(Sach.isChecked()) ST += Sach.getText().toString() + " - " ;
		if(Code.isChecked()) ST += Code.getText().toString() + " - " ;
		KetQua +=ST.substring(0, ST.length() - 3) + "\n";
		KetQua += "-----------------------------------------------------\n";
		KetQua += "Thông tin bổ sung: \n";
		KetQua += BoSung.getText().toString();
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
    	builder.setTitle("Thông tin cá nhân!");
    	builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
    		@Override
    		public void onClick(DialogInterface dialog, int which) {
    		// TODO Auto-generated method stub
    		dialog.cancel();
    		}
    			
    		});
    	builder.setMessage(KetQua);//thiết lập nội dung
    	builder.create().show();//hiển thị Dialog
	}
}














//Nguyễn Như Ý Trân Trọng!