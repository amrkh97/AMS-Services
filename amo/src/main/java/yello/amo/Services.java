package yello.amo;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import BLL.AlarmLevelManager;
import BLL.AmbulanceMapManager;
import BLL.AmbulanceVehicleManger;
import BLL.CompanyManager;
import BLL.CompanyMedicineMapManager;
import BLL.EmployeeManager;
import BLL.IncidentPriorityManager;
import BLL.IncidentTypeManager;
import BLL.JobManager;
import BLL.LocationManager;
import BLL.MedicalRecordManager;
import BLL.MedicineManager;
import BLL.PatientLocationManager;
import BLL.UserManager;
import BLL.YelloPadManager;
import Models.ServerResponse;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Company.CompanyModel;
import Models.Job.Job;
import Models.Locations.Location;
import Models.MedicalRecord.MedicalRecord;
import Models.Medicine.CompanyMedicineMap;
import Models.Medicine.Medicine;
import Models.PatientLocation.PatientLoc;
import Models.Users.LoginCredentialsRequest;
import Models.Users.LogoutResponse;
import Models.Users.SignUp;

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

		return Response.ok(UserManager.login(req.getEmailOrPAN(), req.getPassword()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("logout")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout(LogoutResponse req) {

		return Response.ok(UserManager.logout(req.getUserID())).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("signup")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response signup(SignUp req) {

		return Response.ok(UserManager.signup(req)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("incidents/incidentType")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncidentType() {

		return Response.ok(IncidentTypeManager.getIncidentType()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("incidents/incidentPriority")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIncidentPriority() {

		return Response.ok(IncidentPriorityManager.getIncidentPriority()).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("incidents/alarmLevel")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlarmLevel() {

		return Response.ok(AlarmLevelManager.getAlarmLevel()).header("Access-Control-Allow-Origin", "*").build();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////// GET
	//////////////////////////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////

	////////////////////////////////// ALL

	@Path("GetMedicines")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMedicines() {
		return Response.ok(MedicineManager.getAllMedicines()).header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////// BarCode

	@Path("GetMedicines/BarCode")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByBC(Medicine MED) {
		return Response.ok(MedicineManager.getMedicineByBC(MED.getBarCode())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("ambulance/addAmbulanceVehicle")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAmbulanceVehicle(AmbulanceVehicleModel CAR) {
		return Response.ok(AmbulanceVehicleManger.insertCar(CAR)).header("Access-Control-Allow-Origin", "*").build();
	}
	////////////////////////////////// Name

	@Path("GetMedicines/Name")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByName(Medicine MED) {
		return Response.ok(MedicineManager.getMedicineByName(MED.getMedicineName()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////// Status

	@Path("GetMedicines/Status")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByStatus(Medicine MED) {
		return Response.ok(MedicineManager.getMedicineByStatus(MED.getMedicineStatus()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////////// Active Component

	@Path("GetMedicines/ActiveComponent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByActiveComponent(Medicine MED) {
		return Response.ok(MedicineManager.getMedicineByActiveComponent(MED.getActiveComponent()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////// Company Name

	@Path("GetMedicines/CompanyName")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByComName(CompanyModel COMP) {
		return Response.ok(MedicineManager.getMedicineByCompanyName(COMP.getCompanyName()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

////////////////////////////////// Company Status 

	@Path("GetMedicines/CompanyStatus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByCompanyStatus(CompanyModel COMP) {
		return Response.ok(MedicineManager.getMedicineByCompanyStatus(COMP.getCompanyStatus()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////// Contact Person

	@Path("GetMedicines/ContactPerson")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByContactPerson(CompanyModel COMP) {
		if (COMP.getCompanyContactPerson() == null) {
			return Response.ok("Bad Request No ContactPerson").header("Access-Control-Allow-Origin", "*").build();
		}

		return Response.ok(MedicineManager.getMedicineByContactPerson(COMP.getCompanyContactPerson()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////// GET
	//////////////////////////////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////// INSERT
	//////////////////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////
	@Path("InsertMedicines")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert_Medicine(Medicine MED) {
		System.out.println(MED);
		if (MED.getBarCode() == null) {
			return Response.ok("Bad Request No BarCode").header("Access-Control-Allow-Origin", "*").build();
		}
		ServerResponse X = MedicineManager.insertMedicine(MED);
		if (X == null) {
			return Response.ok("400 the Medicine already there ").header("Access-Control-Allow-Origin", "*").build();
		}

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	///////////////////////////////////////////// BY VIN
	@Path("ambulance/getAmbulanceVehicles/ID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicleID(AmbulanceVehicleModel CAR) {
		if (CAR.getVin() == 0) {
			return Response.ok("Bad Request No VIN").header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.ok(AmbulanceVehicleManger.getCarById(CAR.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////// UPDATE
	//////////////////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////

	@Path("UpdatetMedicines")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Update_Medicine(Medicine MED) {
		ServerResponse X = MedicineManager.UpdateMedicine(MED);
		if (X == null) {
			return Response.ok("404 the medicine not found").header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////// DELETE
	//////////////////////////////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////

	@Path("deleteMedicines")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Detele_Medicine(Medicine MED) {
		System.out.println(MED.getBarCode());
		ServerResponse X = MedicineManager.DeleteMedicine(MED.getBarCode());
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////// CompanyMedicineMap
	////////////////////////////////////////////////////////////////////////////////////////////////////// //////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////// INSERT
	//////////////////////////////////////////////////////////////////////////////////////////////////// /////////////////////////////////////////////////////////

	@Path("InsertCompanyMedicineMap")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response InsertCompanyMedicineMap(CompanyMedicineMap Map) {
		ServerResponse X = CompanyMedicineMapManager.insertRelation(Map);

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////// DELETE
	//////////////////////////////////////////////////////////////////////////////////////////////////// ///////////////////////////////////////////////////////

	@Path("deleteCompanyMedicineMap")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCompanyMedicineMap(CompanyMedicineMap Map) {
		ServerResponse X = CompanyMedicineMapManager.DeleteRelation(Map);

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	/*
	 * @Path("locations/{id}")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getLocation(@PathParam("id") int id) { return
	 * Response.ok(LocationManager.getLocation(id)).header(
	 * "Access-Control-Allow-Origin", "*").build(); }
	 */

	///////////////////////////////////////////// BY BRAND
	@Path("ambulance/getAmbulanceVehicles/Brand")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicleBrand(AmbulanceVehicleModel CAR) {
		System.out.println(CAR.getBrand());
		if (CAR.getBrand() == null) {
			return Response.ok("Bad Request No VIN").header("Access-Control-Allow-Origin", "*").build();
		}
		ArrayList<AmbulanceVehicleModel> X = AmbulanceVehicleManger.getCarsByBrand(CAR.getBrand());
		if (X == null) {
			return Response.ok(" unknown error with database  ").header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	///////////////////////////// DeActivated
	@Path("ambulance/getDeactivatedAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicle() {
		ArrayList<AmbulanceVehicleModel> X = AmbulanceVehicleManger.getDeActivatedCars();

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	///////////////////////////// Activated
	@Path("ambulance/getActivatedAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicleSts() {

		ArrayList<AmbulanceVehicleModel> X = AmbulanceVehicleManger.getActivatedCars();

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();

	}

	///////////////////////////// Deleted

	@Path("ambulance/getDeletedAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetDeletedAmbulanceVehicle() {

		ArrayList<AmbulanceVehicleModel> X = AmbulanceVehicleManger.getDeletedCars();

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("yelloPad/getAllYelloPads")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllYelloPads() {

		return Response.ok().entity(YelloPadManager.getAllYelloPads()).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("yelloPad/getAllActiveYelloPads")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllActiveYelloPads() {

		return Response.ok().entity(YelloPadManager.getAllActiveYelloPads()).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("yelloPad/getAllInActiveYelloPads")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInActiveYelloPads() {

		return Response.ok().entity(YelloPadManager.getAllInActiveYelloPads())
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("yelloPad/searchYelloPad")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchYelloPad(String ID) {

		return Response.ok().entity(YelloPadManager.searchYelloPad(ID)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("yelloPad/getYelloPadStatus")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYelloPadStatus(String ID) {

		return Response.ok().entity(YelloPadManager.getYelloPadStatus(ID)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("yelloPad/getYelloPadNetworkCardNo")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYelloPadNetworkCardNo(String ID) {

		return Response.ok().entity(YelloPadManager.getYelloPadNetworkCardNo(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("patient/addLocation")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPatientLocation(PatientLoc location) {

		return Response
				.ok(PatientLocationManager.addPatientLocation(location.getNationalID(), location.getAddress(),
						location.getLatitude(), location.getLongitude()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("patient/getAllLocations")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPatientLocations(String PatientNationalID) {

		return Response.ok(PatientLocationManager.getAllPatientLocations(PatientNationalID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getAllCompanies")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCompanies() {

		return Response.ok(CompanyManager.getAllCompanies()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getCompanyByID")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyByID(Integer companyID) {
		return Response.ok(CompanyManager.getCompanyByID(companyID)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getCompanyByStatus")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyByStatus(Integer companyStatus) {
		return Response.ok(CompanyManager.getCompanyByStatus(companyStatus)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("pharmaCompany/getCompanyByName")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyByName(String companyName) {
		return Response.ok(CompanyManager.getCompanyByName(companyName)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("pharmaCompany/addCompany")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCompany(CompanyModel companyToBeAdded) {
		return Response.ok(CompanyManager.addCompany(companyToBeAdded)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("pharmaCompany/updateCompany")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCompany(CompanyModel companyToBeAdded) {
		return Response.ok(CompanyManager.updateCompany(companyToBeAdded)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("pharmaCompany/deleteCompany")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCompany(Integer companyToBeAdded) {
		return Response.ok(CompanyManager.deleteCompany(companyToBeAdded)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("job/addJob")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addJob(Job Joba) {
		return Response.ok(JobManager.addJob(Joba)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("job/updateJob")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateJob(Job Joba) {
		return Response.ok(JobManager.updateJob(Joba)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("job/getAllJobs")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllJobs() {

		return Response.ok(JobManager.getAllJobs()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("job/getJobByTitle")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getJobByTitle(String jobTitle) {

		return Response.ok(JobManager.getJobByTitle(jobTitle)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("job/getJobByStatus")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getJobByStatus(String jobStatus) {

		return Response.ok(JobManager.getJobByStatus(jobStatus)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("job/deleteJob")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteJob(String JobID) {
		return Response.ok(JobManager.deleteJob(JobID)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicalRecord/addMedicalRecord")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMedicalRecord(MedicalRecord MedicalRecorda) {
		return Response.ok(MedicalRecordManager.addMedicalRecord(MedicalRecorda))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicalRecord/getAllMedicalRecords")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMedicalRecords() {

		return Response.ok(MedicalRecordManager.getAllMedicalRecords()).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("medicalRecord/getMedicalRecordByID")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMedicalRecordByID(MedicalRecord MedicalRecorda) {

		return Response.ok(MedicalRecordManager.getMedicalRecordByID(MedicalRecorda.getMedicalRecordID()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicalRecord/getMedicalRecordByStatus")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMedicalRecordByStatus(MedicalRecord MedicalRecorda) {

		return Response.ok(MedicalRecordManager.getMedicalRecordByStatus(MedicalRecorda.getmRStatus()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicalRecord/updateMedicalRecord")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMedicalRecord(MedicalRecord MedicalRecorda) {
		return Response.ok(MedicalRecordManager.updateMedicalRecord(MedicalRecorda))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicalRecord/deleteMedicalRecord")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteMedicalReport(MedicalRecord MedicalRecorda) {
		return Response.ok(MedicalRecordManager.deleteMedicalRecord(MedicalRecorda.getMedicalRecordID()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicalRecord/getMedicalRecordByPatientID")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMedicalRecordByPatientID(MedicalRecord MedicalRecorda) {

		return Response.ok(MedicalRecordManager.getMedicalRecordByPatientID(MedicalRecorda.getPatientID()))
				.header("Access-Control-Allow-Origin", "*").build();
	}
	/*
	 * @Path("locations/{id}")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getLocation(@PathParam("id") int id) { return
	 * Response.ok(LocationManager.getLocation(id)).header(
	 * "Access-Control-Allow-Origin", "*").build(); }
	 */

	@Path("ambulance/updateAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateAmbulanceVehicle(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.UpdateCar(Car)).header("Access-Control-Allow-Origin", "*").build();
	}

	/////////////////////////////////////////// status/////////////////////////////////////////////////
	//////////////////////////// FREE
	@Path("ambulance/status/free")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCarFree(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.SetCarFree(Car.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	//////////////////////////////////// BUSY
	@Path("ambulance/status/busy")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCarBusy(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.SetCarBusy(Car.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	//////////////////////////////////// MAINTAINANCE
	@Path("ambulance/status/maintainance")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCarMaintainance(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.SetCarMaintain(Car.getVin()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////// DELETE
	////////////////////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////

	@Path("ambulance/delete")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response DeleteCar(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.DeleteCars(Car.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	///////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	@Path("ambulanceMap/addAmbulanceMap")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAmbulanceMap(AmbulanceMapModel AmbulanceToBeAdded) {
		return Response.ok(AmbulanceMapManager.addAmbulanceMap(AmbulanceToBeAdded))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/getByCarID")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceMapbyVIN(Integer ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByCarID(ID)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("ambulanceMap/getByDriverID")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceCarMapByDriverID(Integer ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByDriverID(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/getByParamedicID")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceCarMapByParamedicID(Integer ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByParamedicID(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/getByYelloPadID")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceCarMapByYelloPadID(Integer ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByYelloPadID(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/deleteAmbulanceMap")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAmbulanceMap(Integer AmbulanceToBeAdded) {
		return Response.ok(AmbulanceMapManager.deleteAmbulanceMap(AmbulanceToBeAdded))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("employee/getllParamedics")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllParamedics(Integer superSSN) {
		return Response.ok(EmployeeManager.getAllParamedics(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getActiveParamedics")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveParamedics(Integer superSSN) {
		return Response.ok(EmployeeManager.getActiveParamedics(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getInActiveParamedics")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInActiveParamedics(Integer superSSN) {
		return Response.ok(EmployeeManager.getInActiveParamedics(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getAllDrivers")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDrivers(Integer superSSN) {
		return Response.ok(EmployeeManager.getAllDrivers(superSSN)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("employee/getActiveDrivers")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveDrivers(Integer superSSN) {
		return Response.ok(EmployeeManager.getActiveDrivers(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getInActiveDrivers")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInActiveDrivers(Integer superSSN) {
		return Response.ok(EmployeeManager.getInActiveDrivers(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("operator/insertLocation")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertLocation(Location location) {

		return Response.ok(LocationManager.addLocation(location)).header("Access-Control-Allow-Origin", "*").build();
	}

	/*
	 * @Path("locations/{id}")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getLocation(@PathParam("id") int id) { return
	 * Response.ok(LocationManager.getLocation(id)).header(
	 * "Access-Control-Allow-Origin", "*").build(); }
	 */

}
