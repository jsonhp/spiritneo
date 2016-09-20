package com.jsonhp.watch;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchManager {

	public static void main(String[] args) throws IOException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		WatchKey key = Paths.get("/home/jsonhp/Documents/wlp2/usr/shared/resources/spirit").register(watchService, ENTRY_CREATE);
		
		while(true) {
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println("Hello, created file :V " + event.kind().toString());
			}
		}
		
	}
	
	
	
	
	
}
