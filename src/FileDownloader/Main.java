package FileDownloader;

public class Main {

	public static void main(String[] args) {
		String dPath = "http://speed.hetzner.de/10MB.bin";
		String savePath = "D:\\Java25\\MultiThreadedFileDownloader\\output.bin";
		
		try {
			FileDownloader f = new FileDownloader();
			f.download(dPath, savePath);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
