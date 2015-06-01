package ru.example.downloader;

import java.io.*;
import java.net.*;

import android.graphics.*;

public class Downloader {
	
	public static Bitmap ImageDl(String URL) {
		Bitmap bitmap = null;
		try {
			InputStream in = openHttpConnection(URL);
			bitmap = BitmapFactory.decodeStream(in);
			in.close();
		} catch (IOException e) { e.printStackTrace(); }
		return bitmap;               
	}
	
	public static String TextDl(String URL) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(openHttpConnection(URL), "UTF-8"));
			String str = "", s;
			while((s = reader.readLine()) != null) str += s + "\n";
			reader.close();
			return str;
		} catch (Exception e) { return ""; }
	}
	
	private static InputStream openHttpConnection(String url) throws IOException {          
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setAllowUserInteraction(false);
		conn.setInstanceFollowRedirects(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Connection", "close");
		conn.connect();    
		if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) return conn.getInputStream();
		else throw new IOException("Bad request");
	}
}
