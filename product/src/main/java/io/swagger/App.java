package io.swagger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.swagger.client.ApiException;
import io.swagger.client.api.ProductsApi;
import io.swagger.client.model.CreateProduct;
import io.swagger.client.model.Product;
import io.swagger.client.model.ProductShort;
import io.swagger.client.model.Udt;

public class App {

    public static void main(String[] args){

        System.out.println("Called the getRisksSummaryIrius method");
        System.setProperty("javax.net.debug","all");
        ProductsApi apiInstance = new ProductsApi();

        String apiToken = "api-token"; // String | Authentication
        String productRef = "comettestproduct";

        //JsonData jsonData = new JsonData(); // JsonData | JSON data that contains information of the fields

        try {

        	CreateProduct cp = new CreateProduct();
        	cp.setRef("test-raghu-batch");
        	cp.setName("raghu-test-batch");
        	cp.setDesc("Creating test product from batch");
        	cp.setTags("raghu,batch,sample");
        	//List<Udt>  li= new ArrayList<Udt> ();
        	cp.setUdts(createUdt());
	        ProductsApi pa = new ProductsApi();
	        //ProductShort ps = pa.productsPost(apiToken, cp);
	        //System.out.println("Output after productwrite ==" + ps.toString());
	        
            Product rs =  apiInstance.productsRefGet(apiToken, productRef);

            System.out.println("RS ==" + rs.toString());

        } catch (Exception e) {

            System.err.println("Exception when calling AuthorizationApi#rolesPost");

            e.printStackTrace();

        }
    }
    
    private static List<Udt> createUdt() throws Exception
    {
    	List<Udt> li = new ArrayList<Udt> ();
    	
    	HashMap<String, String> hashmap = createMap(); 
    	
    	// Getting a Set of Key-value pairs
    	
    	
    	
        Set entrySet = hashmap.entrySet();
     
        // Obtaining an iterator for the entry set
        Iterator it = entrySet.iterator();
     
        // Iterate through HashMap entries(Key-Value pairs)
        System.out.println("HashMap Key-Value Pairs : ");
        while(it.hasNext()){
           Map.Entry me = (Map.Entry)it.next();
           System.out.println("Key is: "+me.getKey() + 
           " & " + 
           " value is: "+me.getValue());
           	Udt ud = new Udt();
   			ud.setRef((String)me.getKey());
   			ud.setValue((String)me.getValue());
   			li.add(ud);
       }
    		
    	return li;
    }
    
    private static HashMap<String,String> createMap() throws Exception
    {
    	HashMap<String, String> map 
        = new HashMap<>(); 

    print(map); 
    map.put("Third Party Data Centre", "sample1"); 
    //map.put("risk_assess_cons", "");
    map.put("Part Outsourced" , "sample3");
    map.put("ITSO Delegate" , "sample4");
    map.put("ReportingLink" , "sample5");
    map.put("HSBC Data Centre", "sample6"); 
    map.put("Application Instance ID", "sample7");
    map.put("Application Version ID", "sample8");
    map.put("App Instance Name", "sample9");
    map.put("ITSO", "sample10");
    map.put("BIA ID", "sample11");
    map.put("Confidentiality", "sample12");
    map.put("Integrity", "sample13");
    map.put("Availability", "sample14");
    map.put("BIA_EIM", "sample15");
    map.put("Data Classification", "sample16");
    map.put("BIA", "sample17");	
    print(map);
    return map;
    }
    
    public static void print(Map<String, String> map) 
    { 
        if (map.isEmpty()) { 
            System.out.println("map is empty"); 
        } 
  
        else { 
            System.out.println(map); 
        } 
    } 
}
