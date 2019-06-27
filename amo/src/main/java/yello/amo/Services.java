package yello.amo;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import BLL.*;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.ServerResponse;
import Models.Firebase.FBLocation.FBLocationEnum;
import Models.Firebase.FBLocation.HttpConnectionHelper;
import Models.Locations.Location;
import Models.Medicine.Medicine;
import Models.Users.*;


/**
 * Root resource (exposed at "api" path)
 */
@Path("api")
public class Services {

  
    private static final AmbulanceVehicleModel Null = null;


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
    @Path("addAmbulanceVehicle")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAmbulanceVehicle(AmbulanceVehicleModel CAR) 
    {
    	
		return Response.ok(AmbulanceVehicleManger.insertCar(CAR)).build() ;
    }
    
    @Path("GetAmbulanceVehicles/ID")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicleID (AmbulanceVehicleModel CAR) 
    {
    	if (CAR.getVin()==0){		return Response.ok("Bad Request No VIN").build(); }
    
    	AmbulanceVehicleModel X =	AmbulanceVehicleManger.getCarById(CAR.getVin());
    	
    	if (X == null){    return Response.ok(" unknown error with database  ").build();}
		return Response.ok(AmbulanceVehicleManger.getCarById(CAR.getVin())).build();
    }
    
    
    
    
    @Path("GetAmbulanceVehicles/Brand")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicleBrand(AmbulanceVehicleModel CAR) 
    { 
    	System.out.println(CAR.getBrand());
    	if (CAR.getBrand()==null)
       {return Response.ok("Bad Request No VIN").build();}
	     ArrayList<AmbulanceVehicleModel> X =	AmbulanceVehicleManger.getCarsByBrand(CAR.getBrand());
	   if (X == null)
	    {return Response.ok(" unknown error with database  ").build();}
		return Response.ok().build();
    }
    
    
    
    
    
    
    @Path("GetAmbulanceVehicles/Status")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicleSts(AmbulanceVehicleModel CAR) 
    { 
    	if (CAR.getVehicleStatus()==null)
        {return Response.ok("Bad Request No VIN").build();}
	     ArrayList<AmbulanceVehicleModel> X =	AmbulanceVehicleManger.getCarsBySts(CAR.getVehicleStatus());
	   if (X == null)
	    {return Response.ok(" unknown error with database  ").build();}
		return Response.ok(X).build();
  }
    
    
    
    
    
    
    
    @Path("GetAmbulanceVehicles")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicle () 
    {
		return Response.ok(AmbulanceVehicleManger.getAllCars()).build();
    }
    

    @Path("UpdateAmbulanceVehicles")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateAmbulanceVehicle (AmbulanceVehicleModel Car) 
    {
		return Response.ok(AmbulanceVehicleManger.UpdateCar(Car)).build();
    }
    
    @Path("GetMedicines")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicines () 
    {
		return Response.ok(MedicineManager.getAllMedicines()).build();
    }

    
    @Path("GetMedicines/BarCode")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByBC (Medicine MED) 
    {
		return Response.ok(MedicineManager.getMedicineByBC(MED.getBarCode())).build();
    }
    @Path("GetMedicines/ActiveComponent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByActiveComponent (Medicine MED) 
    {
		return Response.ok(MedicineManager.getMedicineByActiveComponent(MED.getActiveComponent())).build();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    @Path("GetMedicines/CompanyName")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByComName (Medicine MED) 
    {
		return Response.ok().build();
    	//.ok(MedicineManager.getMedicineByCompanyName(MED.get())).build();
    }   

    @Path("GetMedicines/CompanyStatus")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByCompanyStatus (Medicine MED) 
    {
    	//MedicineManager.getMedicineByCompanyStatus(MED.getActiveComponent())
		return Response.ok().build();
    }   

    @Path("GetMedicines/ContactPerson")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByContactPerson(Medicine MED) 
    {//MedicineManager.getMedicineByContactPerson(MED.getActiveComponent())
		return Response.ok().build();
    }   
  ///////////////////////////////////////////////////////////////////////////////////////////
 ///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
    @Path("GetMedicines/Name")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByName (Medicine MED) 
    {
		return Response.ok(MedicineManager.getMedicineByName(MED.getMedicineName())).build();
    }   
    @Path("GetMedicines/Status")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByStatus (Medicine MED) 
    {
		return Response.ok(MedicineManager.getMedicineByStatus(MED.getMedicineStatus())).build();
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
