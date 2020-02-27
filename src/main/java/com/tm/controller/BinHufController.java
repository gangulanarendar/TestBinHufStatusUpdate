package com.tm.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tm.model.BincodeJsonResponse;

@RestController
public class BinHufController {
	
	

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @RequestMapping("/jobLauncher.html")
    public void handle() throws Exception{
        jobLauncher.run(job, new JobParameters());
    }
	
	@RequestMapping("/getit")
	public ResponseEntity<Object> getDetails()
	{
		
		 final String uri = "http://localhost:8080/bincode";	     
		 RestTemplate restTemplate = new RestTemplate();
		 BincodeJsonResponse result = restTemplate.getForObject(uri, BincodeJsonResponse.class);
		 System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/bincode", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public String getAllEmployeesJSON(Model model) 
	{
		
		String json = "{" + 
				"\"bin\": \"400194\"," + 
				"\"bank\": \"BANCO MULTIPLE CARIBE INTERNACIONAL, S.A.\"," + 
				"\"card\": \"VISA\"," + 
				"\"type\": \"CREDIT\"," + 
				"\"level\": \"INFINITE\"," + 
				"\"country\": \"DOMINICAN REPUBLIC\"," + 
				"\"countrycode\": \"DO\"," + 
				"\"website\": \"HTTP://WWW.BANCOCARIBE.COM.DO\"," + 
				"\"phone\": \"809-378-0505 OR 1-809-200-0505\"," + 
				"\"valid\": \"true\"" + 
				"}";
		return json;
	}

}
