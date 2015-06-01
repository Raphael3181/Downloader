package ru.example.downloader;

import android.app.*;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView address;
	private TextDl textDl;
	private ImageDl imgDl;
	WebView webview;
	TextView text;
	ImageView img;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}	
	
	public void onBtnClick(View v) {
		address = (TextView)findViewById(R.id.address);
		text = (TextView)findViewById(R.id.dl_text);
		img = (ImageView)findViewById(R.id.dl_img);
		webview = (WebView) findViewById(R.id.dl_web);
		switch (v.getId()){ 
			case R.id.btn_text: {
				text.setVisibility(View.VISIBLE);
				img.setVisibility(View.GONE);
				webview.setVisibility(View.GONE);
				if(textDl != null && textDl.getStatus() != Status.RUNNING) textDl.cancel(true);
				textDl = null;
				textDl = new TextDl(text);
				textDl.execute(address.getText().toString());	
			} break;
			case R.id.btn_img: {
				text.setVisibility(View.GONE);
				img.setVisibility(View.VISIBLE);
				webview.setVisibility(View.GONE);
				if(imgDl != null && imgDl.getStatus() != Status.RUNNING) imgDl.cancel(true);
				imgDl = null;
				imgDl = new ImageDl(img);
				imgDl.execute(address.getText().toString());
			} break;
			case R.id.btn_web:{
				text.setVisibility(View.GONE);
				img.setVisibility(View.GONE);
				webview.setVisibility(View.VISIBLE);
				webview.getSettings().setBuiltInZoomControls(true);
				webview.loadUrl(address.getText().toString());
			} break;
		}
	}
}
