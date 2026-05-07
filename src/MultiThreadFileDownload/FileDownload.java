package MultiThreadFileDownload;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownload implements Runnable {
	
	private long start;
	private long end;
	
	private String urlPath;
	private String outputPath;

	FileDownload(String urlPath, String outputPath, long start, long end) {
		this.urlPath = urlPath;
		this.outputPath = outputPath;
		
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		
		try {
			URL url = new URL(urlPath);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestProperty("Range", "bytes=" + start + "-" + end);
			
			int code = con.getResponseCode();
			
			System.out.println(
                    Thread.currentThread().getName()
                    + " Response: "
                    + code
            );
			
			if (code != 206) {
				System.out.println("Partial download failed.");
				return;
			}
			
			try (InputStream is = con.getInputStream();
					RandomAccessFile file = new RandomAccessFile(outputPath, "rw")) {
				
				file.seek(start);
				
				byte[] buffer = new byte[4096];
				int bytesRead;
				

                while ((bytesRead = is.read(buffer)) != -1) {

                    file.write(buffer, 0, bytesRead);
                }
				
			}
			
			con.disconnect();
			
			System.out.println(
                    Thread.currentThread().getName()
                    + " completed "
                    + start
                    + " -> "
                    + end
            );
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}

}
