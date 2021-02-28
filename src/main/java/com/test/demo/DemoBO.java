package com.test.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DemoBO {

	public void StringJsonConversion(String body) throws JsonParseException, JsonMappingException, IOException {
		try {
			List<String> getQueuesList = new ArrayList<>();
			List<String> getExList = new ArrayList<>();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		     JSONObject jsonObject = new JSONObject(body);
		     JSONArray jsonObject1 = (JSONArray) jsonObject.get("MQSourceProtocolHandler");
		     System.out.println(jsonObject1.toString());
		     for (int i = 0; i < jsonObject1.length(); i++) {
		    	 JSONObject jsonObj = jsonObject1.getJSONObject(i);
		    	 String getQueue = (String) jsonObj.get("GetQueue");
		    	 JSONObject jsonObject2Ex = (JSONObject) jsonObj.get("ExcludeHeaders");
		    	 getExList.add(jsonObject2Ex.toString());
		    	 getQueuesList.add(getQueue);
			}
		     
		     System.out.println(jsonObject.get("MQSourceProtocolHandler"));
		     System.out.println("//*************************************************************//");
		     for (String object : getQueuesList) {
				System.out.println(object);
			}
		     System.out.println("//*************************************************************//");
		     
		     
		     System.out.println("//*************************************************************//");
		     for (String object : getExList) {
				System.out.println(object);
			}
		     System.out.println("//*************************************************************//");
		     
		     System.out.println();
		     
		   //  ObjectMapper mapper = new ObjectMapper();
		     //Map<String, String> map = mapper.readValue(jsonObject2.toString(), Map.class);
		   //  System.out.println("//*************************************************************//");
		   //  System.out.println(map);
		    // System.out.println("//*************************************************************//");
		     
		}catch (JSONException err){
		}
	}
	


}
