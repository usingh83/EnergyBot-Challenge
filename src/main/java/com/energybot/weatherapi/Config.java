package com.energybot.weatherapi;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class Config {
	 @Autowired
	 public JobBuilderFactory jobBuilderFactory;

	 @Autowired
	 public StepBuilderFactory stepBuilderFactory;

	 @Autowired
	 public DataSource dataSource;
	    
	 @Bean
	 public FlatFileItemReader<Weather> reader() {
	        FlatFileItemReader<Weather> reader = new FlatFileItemReader<Weather>();
	        reader.setResource(new ClassPathResource("2017.csv"));
	        reader.setLineMapper(new DefaultLineMapper<Weather>() {{
	            setLineTokenizer(new DelimitedLineTokenizer() {{
	                setNames(new String[] { "Stationid", "yearmonth","element","value1","mflag1","qflag1","sflag1","value2" });
	            }});
	            setFieldSetMapper(new BeanWrapperFieldSetMapper<Weather>() {{
	                setTargetType(Weather.class);
	            }});
	        }});
	        return reader;
	    }
	    @Bean
	    public Processor processor() {
	        return new Processor();
	    }

	    @Bean
	    public JdbcBatchItemWriter<Weather> writer() {
	        JdbcBatchItemWriter<Weather> writer = new JdbcBatchItemWriter<Weather>();
	        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Weather>());
	        writer.setSql("INSERT INTO Weather (Stationid, yearmonth,element,value1,mflag1, qflag1,sflag1,value2) VALUES (:Stationid, :yearmonth,:element,:value1,:mflag1,:qflag1,:sflag1,:value2)");
	        writer.setDataSource(dataSource);
	        return writer;
	    }
	    @Bean
	    public Job importUserJob(Listener listener) {
	        return jobBuilderFactory.get("importUserJob")
	                .incrementer(new RunIdIncrementer())
	                .listener(listener)
	                .flow(step1())
	                .end()
	                .build();
	    }

	    @Bean
	    public Step step1() {
	        return stepBuilderFactory.get("step1")
	                .<Weather, Weather> chunk(100000)
	                .reader(reader())
	                .processor(processor())
	                .writer(writer())
	                .build();
	    }
}
