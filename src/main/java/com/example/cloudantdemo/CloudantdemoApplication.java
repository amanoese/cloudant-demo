package com.example.cloudantdemo;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cloudant.client.api.query.Expression.*;

@RestController
@SpringBootApplication
public class CloudantdemoApplication {

	@Autowired
	CloudantClient cloudantClient;

	public static void main(String[] args) {
		SpringApplication.run(CloudantdemoApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		Database db = cloudantClient.database("users",false);
		QueryResult<JsonObject> result  = db.query(new QueryBuilder(eq("name","LLENN")).build(), JsonObject.class);
		return result.getDocs().toString();
	}
}
