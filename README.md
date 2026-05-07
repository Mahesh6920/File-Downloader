## Multi-Threaded File Downloader in Java

### Overview

This project is a console-based multi-threaded file downloader built using core Java. The application downloads files from the internet by splitting them into smaller chunks and downloading those chunks concurrently using multiple threads.

The project was created to understand:

- Java multithreading
- Thread pools
- HTTP range requests
- File handling
- RandomAccessFile
- Concurrent file writing
- Network programming fundamentals

---

### Features
- Download files using multiple threads
- Dynamic chunk calculation
- HTTP Range header support
- Concurrent downloading using ExecutorService
- Random-access writing using RandomAccessFile
- Thread pool management
- Partial download handling
- File size detection from server

---

 ### Technologies Used
- Java
- HttpURLConnection
- ExecutorService
- RandomAccessFile
- Multithreading
- Java I/O Streams

---

 ### Project Structure
 ```
src/
│
├── FileDownloader
    ├── ChunkCaluculator.java
    ├──FileDownloder.java
    ├── Main.java
├── MultiThreadFileDownload
    ├── FileDownload.java
    ├──Main.java
    ├── Main1.java
```

---

### Output:
Single Thread File Download
```
Expected: 1059
Thread 0 -> 0 to 263
Thread 1 -> 264 to 527
Thread 2 -> 528 to 791
Thread 3 -> 792 to 1058
Download: 1059 size.
```

Multi Threaded File Download (Without Thread Pool)
```
Thread-1 Response: 206
Thread-0 Response: 206
Thread-1 completed 1024 -> 2047
Thread-0 completed 0 -> 1023
Downloaded completed.
```

Multi Threaded File Download (With Thread Pool)
```
pool-1-thread-4 Response: 416
Partial download failed.
pool-1-thread-2 Response: 206
pool-1-thread-1 Response: 206
pool-1-thread-3 Response: 416
Partial download failed.
pool-1-thread-2 completed 1024 -> 2047
pool-1-thread-1 completed 0 -> 1023
Download comleted
```

---

## Author

Mahesh tailor

Built for learning core Java networking and multithreading concepts through practical implementation.
