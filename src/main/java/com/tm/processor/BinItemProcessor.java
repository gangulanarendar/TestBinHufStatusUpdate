package com.tm.processor;

import java.util.Arrays;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tm.model.BinHufStatus;
import com.tm.model.BincodeJsonResponse;

public class BinItemProcessor implements ItemProcessor<BinHufStatus, BinHufStatus> {

	@Override
	public BinHufStatus process(BinHufStatus bin) throws Exception {

		/**
		 * https://api.bincodes.com/bin/json/bd690e1ec04c32c5b2d3d70ebfe40a84/400194/
		 **/

		final String uri = "https://api.bincodes.com/bin/json/bd690e1ec04c32c5b2d3d70ebfe40a84/" + bin.getInt_binid();
		System.out.println("*************" + uri);
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<BincodeJsonResponse> result = restTemplate.exchange(uri, HttpMethod.GET, entity,
				BincodeJsonResponse.class);

		System.out.println(result.getBody().getBank());
		if (result.getStatusCode() == HttpStatus.OK)
			bin.setIssuingBank(result.getBody().getBank());
		else
			bin.setIssuingBank("ERROR");

		return bin;
	}

}