package com.jsonhp.batch;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jsonhp.cdi.TransactionalIT;

@Named
public class BatchWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager em;
	
    @TransactionalIT
	@Override
	public void writeItems(List<Object> items) throws Exception {
		items.forEach(em::persist);
		
	}

}
