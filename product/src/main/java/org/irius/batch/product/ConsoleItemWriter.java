package org.irius.batch.product;

import java.util.List;

//import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class ConsoleItemWriter<T> implements ItemWriter<T> { 
	
	 private static final Logger LOG = LoggerFactory.getLogger(ConsoleItemWriter.class);
	
    public void write(List<? extends T> items) throws Exception {
    LOG.trace("Console item writer starts");
    for (T item : items) {
        LOG.info(item.toString());
        System.out.println("Output ==" + item.toString());
    }
    LOG.trace("Console item writer ends");
    }
}