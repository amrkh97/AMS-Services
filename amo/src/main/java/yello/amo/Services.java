package yello.amo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import BLL.*;
import Models.Firebase.FBLocation.FBLocationEnum;
import Models.Firebase.FBLocation.HttpConnectionHelper;
import Models.Locations.Location;
import Models.Users.*;


/**
 * Root resource (exposed at "api" path)
 */
@Path("api")
public class Services {

  
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Server is Running ..!";
    }
    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginCredentialsRequest req) {
    
        return Response.ok(UserManager.login(req.getEmailOrPAN(), req.getPassword())).build();
    }
    
    @Path("addLocation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLocation(Location location) 
    {
//    	ServerResponse serverResponse = LocationManager.addLocation(location);
//    	if(Integer.parseInt(serverResponse.getResponseHexCode(), 16) == 0x00)
//    	{
//    		// At This Point i know that the Insertion In DB is ok
//    		JSONObject fbLocationObj = new JSONObject();
//    		
//    		fbLocationObj.put(FBLocationEnum.Address.getJsonKey(), location.getFreeFormatAddress());
//    		fbLocationObj.put(FBLocationEnum.Longitude.getJsonKey(), location.getLongitude());
//    		fbLocationObj.put(FBLocationEnum.Latitude.getJsonKey(), location.getLatitude());
//    		
//    		HttpConnectionHelper httpConnectionHelper = new HttpConnectionHelper();
//    		try 
//    		{
//				httpConnectionHelper.sendPost(FBLocationEnum.FBLocationsURL.getJsonKey(), fbLocationObj);
//			}
//    		catch (Exception e) 
//    		{
//    			System.err.println("Error Sending Location Post Request: " + e);
//				e.printStackTrace();
//			}
//    	}
    	// At This Point i know that the Insertion In DB is ok
		JSONObject fbLocationObj = new JSONObject();
		
		fbLocationObj.put(FBLocationEnum.Address.getJsonKey(), location.getFreeFormatAddress());
		fbLocationObj.put(FBLocationEnum.Longitude.getJsonKey(), location.getLongitude());
		fbLocationObj.put(FBLocationEnum.Latitude.getJsonKey(), location.getLatitude());
		
		HttpConnectionHelper httpConnectionHelper = new HttpConnectionHelper();
		try 
		{
			System.out.println("sdsd");
			httpConnectionHelper.sendPost(FBLocationEnum.FBLocationsURL.getJsonKey(), fbLocationObj);
		}
		catch (Exception e) 
		{
			System.err.println("Error Sending Location Post Request: " + e);
			e.printStackTrace();
		}
    	return Response.ok().build();
    }
    
    @Path("getAllYelloPads")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllYelloPads() {
    	
    	return Response.ok().entity(YelloPadManager.getYelloPads()).build();
    }
    
    @Path("searchYelloPad")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchYelloPad(String ID) {
    	
    	return Response.ok().entity(YelloPadManager.searchYelloPad(ID)).build();
    }
    
    @Path("getYelloPadStatus")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYelloPadStatus(String ID) {
    	
    	return Response.ok().entity(YelloPadManager.getYelloPadStatus(ID)).build();
    }
    
    @Path("getYelloPadNetworkCardNo")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYelloPadNetworkCardNo(String ID) {
    	
    	return Response.ok().entity(YelloPadManager.getYelloPadNetworkCardNo(ID)).build();
    }
    
    
    
    
	/*
	 * @Path("locations/{id}")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getLocation(@PathParam("id") int id) { return
	 * Response.ok(LocationManager.getLocation(id)).build(); }
	 */

}
