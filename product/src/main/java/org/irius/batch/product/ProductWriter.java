package org.irius.batch.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import io.swagger.client.api.ProductsApi;
import io.swagger.client.model.CreateProduct;
import io.swagger.client.model.ProductShort;

/**
 * @author Raghu
 *
 */
public class ProductWriter<T> implements ItemWriter<T> {

	 private static final Logger LOG = LoggerFactory.getLogger(ProductWriter.class);
		
	    public void write(List<? extends T> items) throws Exception {
	    LOG.trace("Console item writer starts");
	    
	    String apiToken = "api-token";
	    
	    for (T item : items) {
	        LOG.info(item.toString());
	       try {
	        CreateProduct cp = (CreateProduct) item;
	        ProductsApi pa = new ProductsApi();
	        ProductShort ps = pa.productsPost(apiToken, cp);
	        System.out.println("Output after productwrite ==" + ps.toString());
	       } catch(Exception ex)
	       
	       {
	    	   ex.printStackTrace();
	       }
	    }
	    LOG.trace("Console item writer ends");
	    }
}