package yello.amo;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import BLL.*;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Company.CompanyModel;
import Models.Firebase.FBLocation.FBLocationEnum;
import Models.Firebase.FBLocation.HttpConnectionHelper;
import Models.Job.Job;
import Models.Locations.Location;
import Models.PatientLocation.PatientLoc;
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
    
    @Path("incidents/incidentType")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIncidentType() {
    
        return Response.ok(IncidentTypeManager.getIncidentType()).build();
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
    @Path("ambulance/addAmbulanceVehicle")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAmbulanceVehicle(AmbulanceVehicleModel CAR) 
    {
    	
		return Response.ok(AmbulanceVehicleManger.insertCar(CAR)).build() ;
    }
    
    @Path("ambulance/getAmbulanceVehicles/ID")
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
    
    
    
    
    @Path("ambulance/getAmbulanceVehicles/Brand")
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
    
    @Path("ambulance/getAmbulanceVehicles/Status")
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
    
    @Path("ambulance/getAmbulanceVehicles")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAmbulanceVehicle () 
    {
		return Response.ok(AmbulanceVehicleManger.getAllCars()).build();
    }

    @Path("ambulance/updateAmbulanceVehicles")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response UpdateAmbulanceVehicle (AmbulanceVehicleModel Car) 
    {
		return Response.ok(AmbulanceVehicleManger.UpdateCar(Car)).build();
    }
    
    @Path("yelloPad/getAllYelloPads")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllYelloPads() {
    	
    	return Response.ok().entity(YelloPadManager.getYelloPads()).build();
    }
    
    @Path("yelloPad/searchYelloPad")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchYelloPad(String ID) {
    	
    	return Response.ok().entity(YelloPadManager.searchYelloPad(ID)).build();
    }
    
    @Path("yelloPad/getYelloPadStatus")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYelloPadStatus(String ID) {
    	
    	return Response.ok().entity(YelloPadManager.getYelloPadStatus(ID)).build();
    }
    
    @Path("yelloPad/getYelloPadNetworkCardNo")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYelloPadNetworkCardNo(String ID) {
    	
    	return Response.ok().entity(YelloPadManager.getYelloPadNetworkCardNo(ID)).build();
    }
    
    
    
    
    @Path("patient/addLocation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPatientLocation(PatientLoc location) 
    {
    
    	return Response.ok(PatientLocationManager.addPatientLocation(location.getNationalID(),
    			location.getAddress(), location.getLatitude(), location.getLongitude())).build();
    }
    
    
    
    @Path("patient/getAllLocations")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatientLocations(String PatientNationalID) 
    {
    
    	return Response.ok(PatientLocationManager.getAllPatientLocations(PatientNationalID)).build();
    }
    
    
    @Path("pharmaCompany/getAllCompanies")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompanies() 
    {
    
    	return Response.ok(CompanyManager.getAllCompanies()).build();
    }
    
    @Path("pharmaCompany/getCompanyByID")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByID(Integer companyID) 
    {
    	return Response.ok(CompanyManager.getCompanyByID(companyID)).build();
    }
    
    @Path("pharmaCompany/getCompanyByStatus")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByStatus(Integer companyStatus) 
    {
    	return Response.ok(CompanyManager.getCompanyByStatus(companyStatus)).build();
    }
    
    @Path("pharmaCompany/getCompanyByName")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByName(String companyName) 
    {
    	return Response.ok(CompanyManager.getCompanyByName(companyName)).build();
    }
    
    @Path("pharmaCompany/addCompany")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCompany(CompanyModel companyToBeAdded) 
    {
    	return Response.ok(CompanyManager.addCompany(companyToBeAdded)).build();
    }
    
    
    @Path("pharmaCompany/updateCompany")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCompany(CompanyModel companyToBeAdded) 
    {
    	return Response.ok(CompanyManager.updateCompany(companyToBeAdded)).build();
    }
    
    @Path("pharmaCompany/deleteCompany")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCompany(Integer companyToBeAdded) 
    {
    	return Response.ok(CompanyManager.deleteCompany(companyToBeAdded)).build();
    }
    
    @Path("job/addJob")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addJob(Job Joba) 
    {
    	return Response.ok(JobManager.addJob(Joba)).build();
    }
    
    @Path("job/updateJob")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateJob(Job Joba) 
    {
    	return Response.ok(JobManager.updateJob(Joba)).build();
    }
    @Path("job/getAllJobs")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs() 
    {
    
    	return Response.ok(JobManager.getAllJobs()).build();
    }
    @Path("job/getJobByTitle")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getJobByTitle(String jobTitle) 
    {
    
    	return Response.ok(JobManager.getJobByTitle(jobTitle)).build();
    }
    @Path("job/getJobByStatus")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getJobByStatus(String jobStatus) 
    {
    
    	return Response.ok(JobManager.getJobByStatus(jobStatus)).build();
    }
    @Path("job/deleteJob")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response deleteJob(String JobID) 
    {
    	return Response.ok(JobManager.deleteJob(JobID)).build();
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
