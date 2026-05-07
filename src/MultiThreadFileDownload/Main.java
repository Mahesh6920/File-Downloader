package MultiThreadFileDownload;

public class Main {

	public static void main(String[] args) {
		
		String urlPath = "http://speed.hetzner.de/10MB.bin";
		String outputPath = "D:\\\\Java25\\\\MultiThreadedFileDownloader\\\\output.bin";
		
		FileDownload f1 = new  FileDownload(urlPath, outputPath, 0, 1023);
		FileDownload f2 = new FileDownload(urlPath, outputPath, 1024, 2047);
		
		Thread t1 = new Thread(f1);
		Thread t2 = new Thread(f2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Downloaded completed.");
		
	}
	
}
