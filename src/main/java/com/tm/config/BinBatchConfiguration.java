package com.tm.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.tm.model.BinHufStatus;
import com.tm.processor.BinItemProcessor;
import com.tm.processor.BinPrepareStatementSetter;

@Configuration
@EnableBatchProcessing
public class BinBatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Bean
	public JdbcCursorItemReader<BinHufStatus> reader() {
		JdbcCursorItemReader<BinHufStatus> reader = new JdbcCursorItemReader<BinHufStatus>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT int_binId, int_countryId, chr_status, str_agent_name, last_updated FROM tbl_bin_hostility_status ");
		reader.setRowMapper(new BinHufStatusRowMapper());

		return reader;
	}

	public class BinHufStatusRowMapper implements RowMapper<BinHufStatus> {

		@Override
		public BinHufStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
			BinHufStatus BinHufStatus = new BinHufStatus();
			BinHufStatus.setInt_binid(rs.getInt("int_binId"));
			BinHufStatus.setInt_countryId(rs.getInt("int_countryId"));
			BinHufStatus.setChr_status(rs.getString("chr_status"));
			BinHufStatus.setStr_agent_name(rs.getString("str_agent_name"));
			BinHufStatus.setLast_updated(rs.getDate("last_updated"));

			return BinHufStatus;
		}

	}

	@Bean
	public BinItemProcessor processor() {
		return new BinItemProcessor();
	}

   @Bean
	public JdbcBatchItemWriter<BinHufStatus> writer2(){ 
		JdbcBatchItemWriter<BinHufStatus> itemWriter=new JdbcBatchItemWriter<BinHufStatus>();
		itemWriter.setSql("INSERT INTO tbl_bin_hostility_status2 (int_binId,int_countryId,chr_status,str_agent_name,last_updated,str_issuing_bank) VALUES (?,?,?,?,?,?)");
		itemWriter.setDataSource(dataSource);
		itemWriter.setItemPreparedStatementSetter(new BinPrepareStatementSetter());
		itemWriter.afterPropertiesSet();
		
		return itemWriter;
	} 
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<BinHufStatus, BinHufStatus>chunk(10).reader(reader()).processor(processor())
				.writer(writer2()).build();
	}

    @Bean(name="job")
	public Job exportBinHufStatusJob() {
		return jobBuilderFactory.get("exportBinHufStatusJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

}