package com.test.demo;

import java.nio.charset.Charset;

import javax.security.auth.message.callback.TrustStoreCallback;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Security.TrustStrategy;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoService {
	private RestTemplate restTemplate;
	@Autowired
	DemoBO demoBO;
	DemoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	String uri = "https://192.168.0.109:5554/mgmt/config/XXXXX/MQSourceProtocolHandler";   
	
	public String getResponseForService() {
		
		String[] envs= {"SIT","Test"};
		for (int i = 0; i < envs.length; i++) {
			String url = uri.replace("XXXXX", envs[i]);
			System.out.println("***************************"+url);
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,
					new HttpEntity(createHeaders("admin", "datapower")), String.class);
			System.out.println(response.getBody());
			demoBO.StringJsonConversion(response.getBody());
		}
		
		return "<canter><b>Calls for \"SIT\",\"Test\" have done sucessfully ...</b></center>";
		
	}
	
	HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader ); 	 	 	
		      }};
		}

	

	

}
