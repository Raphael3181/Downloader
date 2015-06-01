package ru.example.downloader;

import android.os.AsyncTask;
import android.widget.TextView;

public class TextDl extends AsyncTask<String, Void, String> {
	
	private final TextView textview;
	
	public TextDl(TextView v) { textview = v; }
	
	protected String doInBackground(String... params) {
		return Downloader.TextDl(params[0]);
	}
	
	protected void onPostExecute(final String result) {
		textview.post(new Runnable() {
			public void run() {
				textview.setText(result);
			}
		});
	}
}
