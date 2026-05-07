package FileDownloader;

public class ChunkCaluculator {

	public void caluculateChunk(long fileSize, int threads) {
		
		long chunkSize = fileSize / threads;
		
		for (int i=0; i<threads; i++) {
			long start = i*chunkSize;
			long end;
			
			if (i == threads - 1) {
                end = fileSize - 1;
            } else {
                end = start + chunkSize - 1;
            }

            System.out.println("Thread " + i + " -> " + start + " to " + end);
		}
	}
	
}
