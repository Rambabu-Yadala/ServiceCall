package com.test.demo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("https://192.168.0.109:5554/mgmt/config/SIT/MQSourceProtocolHandler")
				  .method("GET", null)
				  .addHeader("Authorization", "Basic YWRtaW46ZGF0YXBvd2Vy")
				  .build();
				Response response = client.newCall(request).execute();
	}

}
