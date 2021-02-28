package com.test.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class DemoBO {

	public void StringJsonConversion(String body) {
		try {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		     JSONObject jsonObject = new JSONObject(body);
		     System.out.println(jsonObject.get("MQSourceProtocolHandler"));
		}catch (JSONException err){
		}
	}

}
