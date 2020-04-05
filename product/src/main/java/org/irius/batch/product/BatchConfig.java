package org.irius.batch.product;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import io.swagger.client.model.CreateProduct;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
    private JobBuilderFactory jobBuilderFactory;
     
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
 
    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
	
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<CreateProduct, CreateProduct>chunk(5)
                .reader(reader())
                .writer(writer())
                .build();
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    
	public FlatFileItemReader<CreateProduct> reader() 
	{
	    //Create reader instance
	    FlatFileItemReader<CreateProduct> reader = new FlatFileItemReader<CreateProduct>();
	     
	    //Set input file location
	    reader.setResource(new FileSystemResource("input/inputData.csv"));
	     
	    //Set number of lines to skips. Use it if file has header rows.
	    reader.setLinesToSkip(1);   
	     
	    //Configure how each line will be parsed and mapped to different values
	    reader.setLineMapper(new DefaultLineMapper() {
	        {
	            //3 columns in each row
	            setLineTokenizer(new DelimitedLineTokenizer() {
	                {
	                    setNames(new String[] { "ref", "name", "desc", "tags", "Third Party Data Centre" , "risk_assess_cons", "Part Outsourced" ,
	                    		"ITSO Delegate" , "ReportingLink" , "HSBC Data Centre" ,"Application Instance ID","Application Version ID",
	                    		"App Instance Name","ITSO","BIA ID","Confidentiality","Integrity","Availability","BIA_EIM", "Data Classification","BIA" });
	                }
	            });
	            //Set values in Product class
	            setFieldSetMapper(new ProductFieldSetMapper() );
	        }
	    });
	    return reader;
	}
    
    @Bean
    public ProductWriter<CreateProduct> writer() 
    {
        return new ProductWriter<CreateProduct>();
    }
}
