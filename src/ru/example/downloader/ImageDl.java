package ru.example.downloader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageDl extends AsyncTask<String, Void, Bitmap> {
	
	private final ImageView imageview;
	
	public ImageDl(ImageView v) { imageview = v; }
	
	protected Bitmap doInBackground(String... params) {
		return Downloader.ImageDl(params[0]);
	}
	
	protected void onPostExecute(final Bitmap result) {
		imageview.post(new Runnable() {
			public void run() {
				imageview.setImageBitmap(result);
			}
		});
	}
}
