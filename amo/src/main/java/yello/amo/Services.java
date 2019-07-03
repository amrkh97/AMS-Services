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
import Models.Company.CompanyModel;
import Models.ServerResponse;
import Models.Firebase.FBLocation.FBLocationEnum;
import Models.Firebase.FBLocation.HttpConnectionHelper;
import Models.Locations.Location;
import Models.Medicine.CompanyMedicineMap;
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
    
    
    
  //////////////////////////////////////////////////////////////////////////////////////////////////////  
  //////////////////////////////// AmbulanceVehicle ////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////////  
    

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////// INSERT /////////////////////////////////////////////////////////
   
    @Path("addAmbulanceVehicle")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAmbulanceVehicle(AmbulanceVehicleModel CAR) 
    {
    	if (CAR.getVin()==0){		return Response.ok("Bad Request No VIN").build(); }
  	
    	  ServerResponse X =AmbulanceVehicleManger.insertCar(CAR);
      	if(X==null){		return Response.ok("404 the Ambulance Vehicle already there ").build(); }

		return Response.ok(X).build() ;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////// GET ///////////////////////////////////////////////////////
    
   
    ////////////////////////////////// ALL
    
		@Path("GetAmbulanceVehicles")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response GetAmbulanceVehicle () 
		{
		return Response.ok(AmbulanceVehicleManger.getAllCars()).build();
		}


    ///////////////////////////////// ID
     
    @Path("GetAmbulanceVehicles/ID")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicleID (AmbulanceVehicleModel CAR) 
    {
    	if (CAR.getVin()==0){		return Response.ok("Bad Request No VIN").build(); }
    

    	return Response.ok(AmbulanceVehicleManger.getCarById(CAR.getVin())).build();
    }
    
    

    ///////////////////////////////// Brand
       
    @Path("GetAmbulanceVehicles/Brand")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicleBrand(AmbulanceVehicleModel CAR) 
    { 
    
    	if (CAR.getBrand()==null)
       {return Response.ok("Bad Request No Brand").build();}
    	
	     ArrayList<AmbulanceVehicleModel> X =	AmbulanceVehicleManger.getCarsByBrand(CAR.getBrand());
	   if (X == null)
	    {return Response.ok(" unknown error with database  ").build();}
		return Response.ok(X).build();
    }
    

    ///////////////////////////////// Status    
    
    @Path("GetAmbulanceVehicles/Status")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicleSts(AmbulanceVehicleModel CAR) 
    { 
    	if (CAR.getVehicleStatus()==null)
        {return Response.ok("Bad Request No VehicleStatus").build();}
	     ArrayList<AmbulanceVehicleModel> X =	AmbulanceVehicleManger.getCarsBySts(CAR.getVehicleStatus());
	   if (X == null)
	    {return Response.ok(" unknown error with database  ").build();}
		return Response.ok(X).build();
  }
    
    
   /////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////// Update /////////////////////////////////////////////
    
    @Path("UpdateAmbulanceVehicles")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateAmbulanceVehicle (AmbulanceVehicleModel Car) 
    {
     	ServerResponse X =AmbulanceVehicleManger.UpdateCar(Car);
    	if(X==null){		return Response.ok("404 the Ambulance Vehicle not found").build(); }

		return Response.ok(X).build();
    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
     ////////////////////////////////////////// Delete  /////////////////////////////////////////////
      
    
    @Path("deleteAmbulanceVehicles")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAmbulanceVehicle (AmbulanceVehicleModel Car) 
    {
     	ServerResponse X =AmbulanceVehicleManger.DeleteCars(Car.getVin());


		return Response.ok(X).build();
    }
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////// Medicines ///////////////////////////////////////////////////////
   /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    

    ////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////// GET ///////////////////////////////////////////////////////
    
   
    ////////////////////////////////// ALL
   
    @Path("GetMedicines")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicines () 
    {
		return Response.ok(MedicineManager.getAllMedicines()).build();
    }

    ////////////////////////////////// BarCode
   
    @Path("GetMedicines/BarCode")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByBC (Medicine MED) 
    {
		return Response.ok(MedicineManager.getMedicineByBC(MED.getBarCode())).build();
    }

	////////////////////////////////// Name 
	
	@Path("GetMedicines/Name")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByName (Medicine MED) 
	{
	return Response.ok(MedicineManager.getMedicineByName(MED.getMedicineName())).build();
	}   
	  
    ////////////////////////////////// Status 
	
	@Path("GetMedicines/Status")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByStatus (Medicine MED) 
	{
	return Response.ok(MedicineManager.getMedicineByStatus(MED.getMedicineStatus())).build();
	}   

    
    ////////////////////////////////////// Active Component
    
    @Path("GetMedicines/ActiveComponent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByActiveComponent (Medicine MED) 
    {
		return Response.ok(MedicineManager.getMedicineByActiveComponent(MED.getActiveComponent())).build();
    }
    
    ////////////////////////////////// Company Name 
    
    @Path("GetMedicines/CompanyName")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByComName (CompanyModel COMP) 
    {
		return Response.ok(MedicineManager.getMedicineByCompanyName(COMP.getCompanyName())).build();
    }   
    
////////////////////////////////// Company Status 
    
    @Path("GetMedicines/CompanyStatus")
    @POST                                                          
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByCompanyStatus (CompanyModel COMP) 
    {
		return Response.ok(MedicineManager.getMedicineByCompanyStatus(COMP.getCompanyStatus())).build();
    }   

////////////////////////////////// Contact Person
    
    @Path("GetMedicines/ContactPerson")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicineByContactPerson(CompanyModel COMP) 
    {
    	if (COMP.getCompanyContactPerson()==null)
        {return Response.ok("Bad Request No ContactPerson").build();}
    	
		return Response.ok(MedicineManager.getMedicineByContactPerson(COMP.getCompanyContactPerson())).build();
    }   
    

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////// INSERT /////////////////////////////////////////////////////////
    @Path("InsertMedicines")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert_Medicine (Medicine MED) 
    {
    	System.out.println(MED);
    	if (MED.getBarCode()==null){		return Response.ok("Bad Request No BarCode").build(); }
       ServerResponse X=MedicineManager.insertMedicine(MED);
    	if(X==null){		return Response.ok("400 the Medicine already there ").build(); }

		return Response.ok(X).build();
    }   
    

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////// UPDATE /////////////////////////////////////////////////////////    
    
    @Path("UpdatetMedicines")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Update_Medicine (Medicine MED) 
    {
    	ServerResponse X =MedicineManager.UpdateMedicine(MED);
    	if(X==null){		return Response.ok("404 the medicine not found").build(); }
		return Response.ok(X).build();
    }   

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////// DELETE ///////////////////////////////////////////////////////
    
    @Path("deleteMedicines")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Detele_Medicine (Medicine MED) 
    {  
    	System.out.println(MED.getBarCode());
    	ServerResponse X =MedicineManager.DeleteMedicine(MED.getBarCode());
		return Response.ok(X).build();
    }   
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////  
    //////////////////////////////// CompanyMedicineMap //////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////  
      

      
      ////////////////////////////////////////////////////////////////////////////////////////////////////
      ///////////////////////////////////// INSERT /////////////////////////////////////////////////////////
   
    
    @Path("InsertCompanyMedicineMap")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response InsertCompanyMedicineMap (CompanyMedicineMap Map) 
    {
     	ServerResponse X =CompanyMedicineMapManager.insertRelation(Map);


		return Response.ok(X).build();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////// DELETE ///////////////////////////////////////////////////////

    @Path("deleteCompanyMedicineMap")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCompanyMedicineMap (CompanyMedicineMap Map) 
    {
     	ServerResponse X =CompanyMedicineMapManager.DeleteRelation(Map);


		return Response.ok(X).build();
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

