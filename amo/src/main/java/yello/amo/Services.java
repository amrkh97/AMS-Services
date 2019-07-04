package yello.amo;

import java.util.ArrayList;
import BLL.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Models.ServerResponse;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Company.CompanyModel;
import Models.ServerResponse;
import Models.Company.CompanyModel;
import Models.Firebase.FBLocation.FBLocationEnum;
import Models.Firebase.FBLocation.HttpConnectionHelper;
import Models.Job.Job;
import Models.Locations.Location;

import Models.Medicine.CompanyMedicineMap;
import Models.Medicine.Medicine;
import Models.MedicalRecord.MedicalRecord;
import Models.MedicalRecord.MedicalRecord;
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
  
  @Path("logout")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response logout(LogoutResponse req) {

    return Response.ok(UserManager.logout(req.getUserID())).build();
  }

  @Path("signup")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response signup(SignUp req) {

    return Response.ok(UserManager.signup(req)).build();
  }

  @Path("incidents/incidentType")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response getIncidentType() {

    return Response.ok(IncidentTypeManager.getIncidentType()).build();
  }
  @Path("incidnets/incidentPriority")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response getIncidentPriority() {
  
      return Response.ok(IncidentPriorityManager.getIncidentPriority()).build();
  }

  @Path("incidents/alarmLevel")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAlarmLevel() {
  
      return Response.ok(AlarmLevelManager.getAlarmLevel()).build();
  }

  @Path("addLocation")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response addLocation(Location location) {
    // ServerResponse serverResponse = LocationManager.addLocation(location);
    // if(Integer.parseInt(serverResponse.getResponseHexCode(), 16) == 0x00)
    // {
    // // At This Point i know that the Insertion In DB is ok
    // JSONObject fbLocationObj = new JSONObject();
    //
    // fbLocationObj.put(FBLocationEnum.Address.getJsonKey(),
    // location.getFreeFormatAddress());
    // fbLocationObj.put(FBLocationEnum.Longitude.getJsonKey(),
    // location.getLongitude());
    // fbLocationObj.put(FBLocationEnum.Latitude.getJsonKey(),
    // location.getLatitude());
    //
    // HttpConnectionHelper httpConnectionHelper = new HttpConnectionHelper();
    // try
    // {
    // httpConnectionHelper.sendPost(FBLocationEnum.FBLocationsURL.getJsonKey(),
    // fbLocationObj);
    // }
    // catch (Exception e)
    // {
    // System.err.println("Error Sending Location Post Request: " + e);
    // e.printStackTrace();
    // }
    // }
    // At This Point i know that the Insertion In DB is ok
    // JSONObject fbLocationObj = new JSONObject();

    // fbLocationObj.put(FBLocationEnum.Address.getJsonKey(), location.getFreeFormatAddress());
    // fbLocationObj.put(FBLocationEnum.Longitude.getJsonKey(), location.getLongitude());
    // fbLocationObj.put(FBLocationEnum.Latitude.getJsonKey(), location.getLatitude());

    // HttpConnectionHelper httpConnectionHelper = new HttpConnectionHelper();
    // try {
    //   System.out.println("sdsd");
    //   httpConnectionHelper.sendPost(FBLocationEnum.FBLocationsURL.getJsonKey(), fbLocationObj);
    // } catch (Exception e) {
    //   System.err.println("Error Sending Location Post Request: " + e);
    //   e.printStackTrace();
    // }
    return Response.ok().build();



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
    
    
    
    
    
    @Path("medicalRecord/addMedicalRecord")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord MedicalRecorda) 
    {
    	return Response.ok(MedicalRecordManager.addMedicalRecord(MedicalRecorda)).build();
    }
    @Path("medicalRecord/getAllMedicalRecords")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicalRecords() 
    {
    
    	return Response.ok(MedicalRecordManager.getAllMedicalRecords()).build();
    }
    @Path("medicalRecord/getMedicalRecordByID")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordByID(MedicalRecord MedicalRecorda ) 
    {
    
    	return Response.ok(MedicalRecordManager.getMedicalRecordByID(MedicalRecorda.getMedicalRecordID())).build();
    }
    @Path("medicalRecord/getMedicalRecordByStatus")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordByStatus(MedicalRecord MedicalRecorda ) 
    {
    
    	return Response.ok(MedicalRecordManager.getMedicalRecordByStatus(MedicalRecorda.getmRStatus() )).build();
    }
    @Path("medicalRecord/updateMedicalRecord")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(MedicalRecord MedicalRecorda) 
    {
    	return Response.ok(MedicalRecordManager.updateMedicalRecord(MedicalRecorda)).build();
    }
    @Path("medicalRecord/deleteMedicalRecord")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMedicalReport(MedicalRecord MedicalRecorda) 
    {
    	return Response.ok(MedicalRecordManager.deleteMedicalRecord(MedicalRecorda.getMedicalRecordID() )).build();
    }
    
    
    @Path("medicalRecord/getMedicalRecordByPatientID")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordByPatientID(MedicalRecord MedicalRecorda ) 
    {
    
    	return Response.ok(MedicalRecordManager.getMedicalRecordByPatientID(MedicalRecorda.getPatientID())).build();
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

  ///////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////
  @Path("yelloPad/getAllYelloPads")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllYelloPads() {

    return Response.ok().entity(YelloPadManager.getYelloPads()).build();
  }

  
  @Path("ambulanceMap/addAmbulanceMap")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response addAmbulanceMap(AmbulanceMapModel AmbulanceToBeAdded) {
    return Response.ok(AmbulanceMapManager.addAmbulanceMap(AmbulanceToBeAdded)).build();
  }
  
  @Path("ambulanceMap/getByCarID")
  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAmbulanceMapbyVIN(Integer ID) {
    return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByCarID(ID)).build();
  }
 
  @Path("ambulanceMap/getByDriverID")
  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAmbulanceCarMapByDriverID(Integer ID) {
    return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByDriverID(ID)).build();
  }
  
  @Path("ambulanceMap/getByParamedicID")
  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAmbulanceCarMapByParamedicID(Integer ID) {
    return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByParamedicID(ID)).build();
  }
  
  @Path("ambulanceMap/getByYelloPadID")
  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAmbulanceCarMapByYelloPadID(Integer ID) {
    return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByYelloPadID(ID)).build();
  }
  
  @Path("ambulanceMap/deleteAmbulanceMap")
  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteAmbulanceMap(Integer AmbulanceToBeAdded) {
    return Response.ok(AmbulanceMapManager.deleteAmbulanceMap(AmbulanceToBeAdded)).build();
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

