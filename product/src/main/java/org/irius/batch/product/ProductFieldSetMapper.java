package org.irius.batch.product;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import io.swagger.client.model.CreateProduct;
import io.swagger.client.model.Udt;

public class ProductFieldSetMapper implements FieldSetMapper<CreateProduct> {
    @Override
    public CreateProduct mapFieldSet(FieldSet fieldSet) throws BindException {
    	CreateProduct cp = new CreateProduct();
        
    	List<Udt> li = new ArrayList<Udt> ();
    	
        String[] fieldNames = fieldSet.getNames();
        
        for(int i=0;i < fieldNames.length;i++)
        {
        	String fieldName = fieldNames[i];
        	if (fieldName.trim().equals("ref"))
        		cp.setRef(fieldSet.readString("ref"));
        	else if (fieldName.trim().equals("name"))
        		cp.setName(fieldSet.readString("name"));
            		
        	else if (fieldName.trim().equals("desc"))	
        		cp.setDesc(fieldSet.readString("desc"));
            	
        	else if (fieldName.trim().equals("tags"))	
        		cp.setTags(fieldSet.readString("tags"));
            else
            {
            	Udt ud = new Udt();
       			ud.setRef(fieldName);
       			ud.setValue(fieldSet.readString(fieldName));
       			li.add(ud);
            }
            
        }
        
        cp.setUdts(li);
        return cp;
    }
}
