package hello_java;

import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class helper   {
	
	public static int help(String request,String url) throws JSONException
	{
		if(request.equals("GET"))
		{
			return GET(url);
		}
		else if(request.equals("POST"))
		{
			return POST(url);
		}
		else if(request.equals("PUT"))
		{
			return PUT(url);
		}
		else
			return DELETE(url);
	}
	
	public static int GET(String url)
	{
		 Response response = RestAssured.get(url);
		 int actualresponsecode = response.getStatusCode();
		 return actualresponsecode;
	}
	public static int POST(String url) throws JSONException
	{
		 RequestSpecification req=RestAssured.given();
		   req.header("Content-Type" , "application/json");
		   JSONObject requestParams = new JSONObject();
  	       requestParams.put("FirstName", "Jyosana"); 
		   requestParams.put("LastName", "Saini");
	   	   requestParams.put("UserName", "jyosana24");
		   requestParams.put("Password", "password1");
		   requestParams.put("Email",  "jyosanasaini@gmail.com");
		   req.body(requestParams.toString());
		   Response response = req.post(url);
		   int actualresponsecode = response.getStatusCode();
		   return actualresponsecode;
	}
	public static int PUT(String url) throws JSONException
	{
		RequestSpecification req=RestAssured.given();
		   JSONObject json = new JSONObject();
		   int id =5;
		   json.put("userID","1");
		   json.put("title", "updated");
		   json.put("body", "updated");
		   Response res = req.put(url + "/update/" + id);
		   int actual = res.getStatusCode();
		   return actual;
	}
	public static int DELETE(String url)
	{
		   int id = 15410;
		   RequestSpecification req=RestAssured.given();
		   Response res = req.delete(url + "/delete/" + id);
		   int actual = res.getStatusCode();
		   return actual;
	}

}
