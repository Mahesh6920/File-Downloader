package MultiThreadFileDownload;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main1 {

	public static void main(String[] args) {
		String urlPath = "http://speed.hetzner.de/10MB.bin";
		String outputPath = "D:\\\\Java25\\\\MultiThreadedFileDownloader\\\\output.bin";
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		service.execute(
				new FileDownload(urlPath, outputPath, 0, 1023));
		
		service.execute(
				new FileDownload(urlPath, outputPath, 1024, 2047));
		
		service.execute(
				new FileDownload(urlPath, outputPath, 2048, 3071));
		
		service.execute(
				new FileDownload(urlPath, outputPath, 3072, 4096));
		
		service.shutdown();
		
		try {

            service.awaitTermination(
                    1,
                    TimeUnit.MINUTES
            );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		System.out.println("Download comleted");

	}

}
