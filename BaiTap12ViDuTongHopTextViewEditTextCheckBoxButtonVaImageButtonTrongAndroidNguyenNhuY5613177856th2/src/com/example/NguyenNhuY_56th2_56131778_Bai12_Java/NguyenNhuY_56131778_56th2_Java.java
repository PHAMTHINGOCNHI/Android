package com.example.NguyenNhuY_56th2_56131778_Bai12_Java;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class NguyenNhuY_56131778_56th2_Java extends Activity {
	Button bTT, bTiep, bTK;
	ImageButton ibThoat;
	EditText etTen, etSoLuong, etTongKH, etTongKHVIP, etTongTT;
	TextView tvHienThiTT;
	CheckBox cbVIP;
	DanhSachKhachHang ListKhachHang=new DanhSachKhachHang();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_dar_nguyen_nhu_y_56131778_56th2_java_);
        AnhXa();
		ThemSuKien();
    }
    public void AnhXa()
    {
    	bTT = (Button) findViewById(R.id.button1);
    	bTiep = (Button) findViewById(R.id.button2);
    	bTK = (Button) findViewById(R.id.button3);
    	ibThoat = (ImageButton) findViewById(R.id.DoYouLoveMe);
    	etTen = (EditText) findViewById(R.id.editText1);
    	etSoLuong = (EditText) findViewById(R.id.editText2);
    	etTongKH = (EditText) findViewById(R.id.editText4);
    	etTongKHVIP = (EditText) findViewById(R.id.editText5);
    	etTongTT = (EditText) findViewById(R.id.editText6);
    	tvHienThiTT = (TextView) findViewById(R.id.DoYouLikeMeAni);
    	cbVIP = (CheckBox) findViewById(R.id.checkBox1);
    }
    
    public void ThemSuKien()
    {
    	bTT.setOnClickListener(new ProcessMyEvent());
    	bTiep.setOnClickListener(new ProcessMyEvent());
    	bTK.setOnClickListener(new ProcessMyEvent());
    	ibThoat.setOnClickListener(new ProcessMyEvent());
    	
    }
    
    private void Thoat() {
		AlertDialog.Builder CanhBao = new AlertDialog.Builder(this);
		CanhBao.setTitle("Cảnh Báo!");
		CanhBao.setMessage("Bạn có thật sự muốn thoát ?");
		CanhBao.setNegativeButton("Không, Tôi nhầm!", new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		CanhBao.setPositiveButton("Có,  Hỏi lắm thế", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		CanhBao.create().show();
	}

	private void ThongKe() {
		// TODO Auto-generated method stub
		etTongKH.setText(ListKhachHang.tongKhachHang()+"");
		etTongKHVIP.setText(ListKhachHang.tongKhachHangVip()+"");
		etTongTT.setText(ListKhachHang.tongDoanhThu()+"");
	}

	private void Tiep() {
		// TODO Auto-generated method stub
		etTen.setText("");
		etSoLuong.setText("");
		tvHienThiTT.setText("");
		etTen.requestFocus();
	}

	private void TinhTien() {
		try{
			// TODO Auto-generated method stub
			KhachHang Tmp = new KhachHang();
			Tmp.setTenKh(etTen.getText().toString());
			Tmp.setSlmua(Integer.parseInt(etSoLuong.getText().toString()));
			Tmp.setVip(cbVIP.isChecked());
			tvHienThiTT.setText(Tmp.tinhThanhTien() + "");
			ListKhachHang.addKhachHang(Tmp);
		}
		catch(Exception exception)
		{
			Toast.makeText(this, "Lỗi dữ liệu nhập vào bị sai lệch!", Toast.LENGTH_LONG).show();
		}
	}
    private class ProcessMyEvent extends Activity  implements OnClickListener
	{

		public void onClick(View arg0) {
			switch(arg0.getId())
			{
			case R.id.button1:
				TinhTien();
				break;
			case R.id.button2:
				Tiep();
				break;
			case R.id.button3:
				ThongKe();
				break;
			case R.id.DoYouLoveMe:
				Thoat();
				break;
			}
		}
	}
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nguyen_nhu_y_56131778_56th2__java, menu);
        return true;
    }
}
