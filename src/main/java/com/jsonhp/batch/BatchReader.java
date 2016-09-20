package com.jsonhp.batch;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named
public class BatchReader extends AbstractItemReader {
	
	Path path;
	
	@Override
	public void open(Serializable checkpoint) throws Exception {
		path = Paths.get("/home/jsonhp/Documents/wlp2/usr/shared/resources/spirit/nomina.csv");
	}

	@Override
	public Object readItem() throws Exception {
		return Files.lines(path);
	}
	
}
