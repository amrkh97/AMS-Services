package Models.Firebase.FBLocation;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class HttpConnectionHelper 
{
	private HttpClient httpClient;
	
	public HttpConnectionHelper() 
	{
		httpClient = HttpClientBuilder.create().build();
	}
	
	
	public void sendPost(String url, JSONObject jsonObject) throws Exception
	{
		HttpPost httpPostRequest = new HttpPost(url);
	    StringEntity params =new StringEntity(jsonObject.toString());
	    httpPostRequest.addHeader("content-type", "application/json");
	    httpPostRequest.setEntity(params);
	    
	    HttpResponse response = httpClient.execute(httpPostRequest);
	    
	    //TODO Handle the incoming response
	}
}
