package FileDownloader;

//import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {
	ChunkCaluculator cc = null;
	
	public void download(String urlPath, String outputPath) {
		cc = new ChunkCaluculator();
		
		long totalSize = 0;
		
		long start = 0;
		long end = 4096;
						
	    try {
	        URL url = new URL(urlPath);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	 
	        con.setRequestProperty("Range", "bytes=" + start + "-" + end);
	      	        
	        int code = con.getResponseCode();
	        if (code != 206) {
	            System.out.println("Server does not support partial download");
	            return;
	        } else if (code < 200 || code >= 300) {
	            System.out.println("Download failed");
	            return;
	        }
	        
	        long expectedSize = con.getContentLengthLong();
	        System.out.println("Expected: " + expectedSize);
	        
	        // taking own no.of threads
	        int threads = 4;
	        cc.caluculateChunk(expectedSize, threads);

	        try (InputStream is = con.getInputStream();
//	             FileOutputStream fos = new FileOutputStream(outputPath)
	        	 RandomAccessFile file = new RandomAccessFile(outputPath, "rw")) {
	        	
	        	file.seek(start);

	            byte[] buffer = new byte[4096];
	            int bytesRead;

	            while ((bytesRead = is.read(buffer)) != -1) {
	            	totalSize += bytesRead;
	                file.write(buffer, 0, bytesRead);
	            }
	        }
	        
	        con.disconnect();
	        
	        System.out.println("Download: " + totalSize + " size.");       

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
