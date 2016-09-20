package com.jsonhp.watch;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WatchManager implements ServletContextListener {

	public void initSpirit() throws IOException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		WatchKey key = Paths.get("C:/wlp2/wlp/usr/shared/resources/spirit").register(watchService, ENTRY_CREATE);
		
		while(true) {
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println("Hello, created file :V " + event.kind().toString());
			}
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			initSpirit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
	
	
	
	
}
