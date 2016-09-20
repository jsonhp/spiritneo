package com.jsonhp.batch;

import java.util.StringTokenizer;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

import com.jsonhp.entities.Payroll;

@Named
public class BatchProcessor implements ItemProcessor {

	@Override
	public Object processItem(Object item) throws Exception {
        StringTokenizer tokens = new StringTokenizer((String)item, ",");

        String name = tokens.nextToken();
        double salary = Double.parseDouble(tokens.nextToken());
		return new Payroll(name, salary);
	}

}
