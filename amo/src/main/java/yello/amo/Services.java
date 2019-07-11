package yello.amo;

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
import BLL.PatientManger;
import BLL.UserManager;
import BLL.YelloPadManager;
import BLL.ReportManager;
import BLL.ReceiptsManager;
import Models.ServerResponse;
import Models.ServerResponse_ID;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.AmbulanceVehicle.AmbulanceArray;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Company.CompanyModel;
import Models.Data.DataModel;
import Models.Job.Job;
import Models.Locations.Location;
import Models.MedicalRecord.MedicalRecord;
import Models.Medicine.CompanyMedicineMap;
import Models.Medicine.Medicine;
import Models.Patient.PatientArray;
import Models.Patient.PatientModel;
import Models.PatientLocation.PatientLoc;
import Models.Receipts.Receipt;
import Models.Users.LoginCredentialsRequest;
import Models.Users.LogoutResponse;
import Models.Users.SignUp;
import Models.Reports.Report;

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

	//----------------------------------------Start Of LogIn/LogOut/SignUp--------------------------------------------//
	
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
	
	//----------------------------------------End Of LogIn/LogOut/SignUp--------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//----------------------------------------Start Of Ambulance Services ------------------------------------------//

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

	@Path("ambulance/getAmbulanceVehicles/Brand")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicleBrand(AmbulanceVehicleModel CAR) {
		System.out.println(CAR.getBrand());
		if (CAR.getBrand() == null) {
			return Response.ok("Bad Request No VIN").header("Access-Control-Allow-Origin", "*").build();
		}
		AmbulanceArray X = AmbulanceVehicleManger.getCarsByBrand(CAR.getBrand());
		if (X.equals(null)) {
			return Response.ok(" unknown error with database  ").header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getDeactivatedAmbulanceVehicles")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicle() {
		return Response.ok(AmbulanceVehicleManger.getDeActivatedCars()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getActivatedAmbulanceVehicles")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicleSts() {

		return Response.ok(AmbulanceVehicleManger.getActivatedCars()).header("Access-Control-Allow-Origin", "*").build();

	}

	@Path("ambulance/getDeletedAmbulanceVehicles")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetDeletedAmbulanceVehicle() {

		return Response.ok(AmbulanceVehicleManger.getDeletedCars()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getFreeAmbulanceVehicles")
	@POST
	
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetFreeAmbulanceVehicle() {

		return Response.ok(AmbulanceVehicleManger.getFreeCars()).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Path("ambulance/getBusyAmbulanceVehicles")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetBusyAmbulanceVehicle() {
	
	return Response.ok(AmbulanceVehicleManger.getBusyCars()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getAssignedAmbulanceVehicles")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAssignedAmbulanceVehicle() {

		return Response.ok(AmbulanceVehicleManger.getAssignedCars()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/addAmbulanceVehicle")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAmbulanceVehicle(AmbulanceVehicleModel CAR) {
		return Response.ok(AmbulanceVehicleManger.insertCar(CAR)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/updateAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateAmbulanceVehicle(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.UpdateCar(Car)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/status/free")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCarFree(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.SetCarFree(Car.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("ambulance/status/busy")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCarBusy(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.SetCarBusy(Car.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("ambulance/status/maintainance")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCarMaintainance(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.SetCarMaintain(Car.getVin()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/status/assigned")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setCarAssigned(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.SetCarAssigned(Car.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("ambulance/delete")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response DeleteCar(AmbulanceVehicleModel Car) {
		return Response.ok(AmbulanceVehicleManger.DeleteCars(Car.getVin())).header("Access-Control-Allow-Origin", "*")
				.build();
	}
	
	//----------------------------------------End Of Ambulance Services --------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//----------------------------------------Start of Ambulance Map -----------------------------------------------//
	
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceMapbyVIN(DataModel ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByCarID(ID)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("ambulanceMap/getByDriverID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceCarMapByDriverID(DataModel ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByDriverID(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/getByParamedicID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceCarMapByParamedicID(DataModel ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByParamedicID(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/getByYelloPadID")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceCarMapByYelloPadID(DataModel ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByYelloPadID(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/deleteAmbulanceMap")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAmbulanceMap(DataModel AmbulanceToBeAdded) {
		return Response.ok(AmbulanceMapManager.deleteAmbulanceMap(AmbulanceToBeAdded))
				.header("Access-Control-Allow-Origin", "*").build();
	}
	
	//-----------------------------------------End Of Ambulance Map ------------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-----------------------------------------Start of Employee Services-------------------------------------------//
	
	@Path("employee/getAllParamedics")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllParamedics(DataModel superSSN) {
		
		return Response.ok(EmployeeManager.getAllParamedics(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getActiveParamedics")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveParamedics(DataModel superSSN) {

		return Response.ok(EmployeeManager.getActiveParamedics(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getInActiveParamedics")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInActiveParamedics(DataModel superSSN) {

		return Response.ok(EmployeeManager.getInActiveParamedics(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getAllDrivers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDrivers(DataModel superSSN) {
		
		return Response.ok(EmployeeManager.getAllDrivers(superSSN)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("employee/getActiveDrivers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveDrivers(DataModel superSSN) {

		return Response.ok(EmployeeManager.getActiveDrivers(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getInActiveDrivers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInActiveDrivers(DataModel superSSN) {

		return Response.ok(EmployeeManager.getInActiveDrivers(superSSN)).header("Access-Control-Allow-Origin", "*")
				.build();
	}
	
	//-----------------------------------------End Of Employee Services---------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-----------------------------------------Start Of Incident Services-------------------------------------------//
	
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
	
	//-------------------------------------------End Of Incident Services-------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//------------------------------------------Start Of Job Services-----------------------------------------------//
	
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getJobByTitle(DataModel jobTitle) {
		
		return Response.ok(JobManager.getJobByTitle(jobTitle.getSentStatus())).header("Access-Control-Allow-Origin", "*").build();
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteJob(DataModel JobID) {
		return Response.ok(JobManager.deleteJob(JobID.getStringID())).header("Access-Control-Allow-Origin", "*").build();
	}
	
	//--------------------------------------------End Of Job Services-----------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-------------------------------------------Start of Medicine Services-----------------------------------------//
	
	@Path("medicine/getMedicines")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMedicines() {
		
		return Response.ok(MedicineManager.getAllMedicines()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicine/getMedicines/barCode")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByBC(Medicine MED) {
		return Response.ok(MedicineManager.getMedicineByBC(MED.getBarCode())).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("medicine/getMedicines/name")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByName(Medicine MED) {
		return Response.ok(MedicineManager.getMedicineByName(MED.getMedicineName()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicine/getMedicines/status")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByStatus(Medicine MED) {
	
		return Response.ok(MedicineManager.getMedicineByStatus(MED.getMedicineStatus()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicine/getMedicines/activeComponent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByActiveComponent(Medicine MED) {

		return Response.ok(MedicineManager.getMedicineByActiveComponent(MED.getActiveComponent()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicine/getMedicines/companyName")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByComName(CompanyModel COMP) {
		
		return Response.ok(MedicineManager.getMedicineByCompanyName(COMP.getCompanyName()))
				.header("Access-Control-Allow-Origin", "*").build();
	} 

	@Path("medicine/getMedicines/companyStatus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByCompanyStatus(CompanyModel COMP) {

		return Response.ok(MedicineManager.getMedicineByCompanyStatus(COMP.getCompanyStatus()))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicine/getMedicines/contactPerson")
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

	@Path("medicine/insertMedicines")
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

	@Path("medicine/updatetMedicines")
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

	@Path("medicine/deleteMedicines")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Detele_Medicine(Medicine MED) {
		System.out.println(MED.getBarCode());
		ServerResponse X = MedicineManager.DeleteMedicine(MED.getBarCode());
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	//-------------------------------------------End Of Medicine Services-------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-------------------------------------------Start Of Medicine Map----------------------------------------------//
	
	@Path("medicineMap/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response InsertCompanyMedicineMap(CompanyMedicineMap Map) {
		ServerResponse X = CompanyMedicineMapManager.insertRelation(Map);

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicineMap/delete")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCompanyMedicineMap(CompanyMedicineMap Map) {
		ServerResponse X = CompanyMedicineMapManager.DeleteRelation(Map);

		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}
	
	//-------------------------------------------End Of Medicine Map------------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-------------------------------------------Start Of Medical Record--------------------------------------------//
	
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
	
	//-------------------------------------------End Of Medical Record----------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//------------------------------------------Start Of Operator Services------------------------------------------//
	
	@Path("operator/insertLocation")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertLocation(Location location) {

			return Response.ok(LocationManager.addLocation(location)).header("Access-Control-Allow-Origin", "*").build();
	}
		
	//-------------------------------------------End Of Operator Services ------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//------------------------------------------Start Of Patient Services-------------------------------------------//
	
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPatientLocations(DataModel PatientNationalID) {

		return Response.ok(PatientLocationManager.getAllPatientLocations(PatientNationalID)).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Path("patient/getAll")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllPatient() {
		PatientArray X =PatientManger.getAllPatient();
    	if(X.equals(null)){		
    		return Response.ok("402 the patient not Added").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
		 
	}

	@Path("patient/addNewPatient")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response addNewPatient(PatientModel patientModel) {
		ServerResponse_ID X =PatientManger.addNewPatient(patientModel);
    	if(X.equals(null)){		
    		return Response.ok("402 the patient not Added").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
		 
	}

	@Path("patient/updatePatientData")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response editPatient (PatientModel patientModel) {
		ServerResponse X =PatientManger.updatePatientData(patientModel);
    	if(X.equals(null)){		
    		return Response.ok("404 the patient not found").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();

	}
	 
	@Path("patient/get/NID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getPatientByNID (PatientModel patientModel) {
		PatientArray  X =PatientManger.getPatientByNId(patientModel.getPatientNationalID());
			if(X.equals(null)){		
    		return Response.ok("404 the patient not found").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();

	}

	@Path("patient/deletePatient")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response deletePatient (PatientModel patientModel) {
		ServerResponse X =PatientManger.deletePatient(patientModel);
    	if(X.equals(null)){
    		return Response.ok("404 the patient not found").header("Access-Control-Allow-Origin", "*").build(); 
    		}
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();

	}

	//--------------------------------------------End Of Patient Services------------------------------------------//
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//--------------------------------------------Start Of PharmaCompany-------------------------------------------//
	
	@Path("pharmaCompany/getAllCompanies")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCompanies() {
		
		return Response.ok(CompanyManager.getAllCompanies()).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getCompanyByID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyByID(DataModel companyID) {
		return Response.ok(CompanyManager.getCompanyByID(companyID)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getCompanyByStatus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyByStatus(DataModel companyStatus) {
		return Response.ok(CompanyManager.getCompanyByStatus(companyStatus)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getCompanyByName")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyByName(DataModel companyName) {
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
	public Response deleteCompany(DataModel companyToBeAdded) {
		
		return Response.ok(CompanyManager.deleteCompany(companyToBeAdded)).header("Access-Control-Allow-Origin", "*")
				.build();
	}
		
	//---------------------------------------------End Of PharmaCompany--------------------------------------------//
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//---------------------------------------------Start Of YelloPad Services--------------------------------------//
	
	@Path("yelloPad/getAllYelloPads")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllYelloPads() {

		return Response.ok(YelloPadManager.getAllYelloPads()).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("yelloPad/getAllActiveYelloPads")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllActiveYelloPads() {

		return Response.ok(YelloPadManager.getAllActiveYelloPads()).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("yelloPad/getAllInActiveYelloPads")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInActiveYelloPads() {

		return Response.ok(YelloPadManager.getAllInActiveYelloPads())
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("yelloPad/searchYelloPad")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchYelloPad(DataModel ID) {

		return Response.ok().entity(YelloPadManager.searchYelloPad(ID.getStringID())).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("yelloPad/getYelloPadStatus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYelloPadStatus(DataModel ID) {

		return Response.ok().entity(YelloPadManager.getYelloPadStatus(ID.getStringID())).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("yelloPad/getYelloPadNetworkCardNo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getYelloPadNetworkCardNo(DataModel ID) {

		return Response.ok().entity(YelloPadManager.getYelloPadNetworkCardNo(ID.getStringID())).header("Access-Control-Allow-Origin", "*").build();
	}

	//---------------------------------------------End Of YelloPad Services-----------------------------------------//
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//---------------------------------------------Start Of Reports Services--------------------------------------//
	@Path("report/getreport/status")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetReportByStatus(Report report) 
    {
    	return Response.ok(ReportManager.selectByReportStatus(report.getReportStatus())).build();
    	
    }
    @Path("report/getreport/issueTime")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetReportByIssueTime(Report report) 
    {
    	return Response.ok(ReportManager.selectByReportIssueTime(report.getReportIssueTime())).build();
    	
    }
    @Path("report/getreport/patientId")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetReportByPatientId(Report report) 
    {
    	return Response.ok(ReportManager.selectByPatientId(report.getPatientId())).build();
    	
    }
    @Path("report/getreport/reportTitleAndStatus")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetReportByReportTitleAndStatus(Report report) 
    { 
    	return Response.ok(ReportManager.selectByReportTitleAndStatus(report.getReportTitle(),report.getReportStatus())).build();
    	
    }    
    @Path("report/addReport")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reportInsert(Report report) 
    {  
        return Response.ok(ReportManager.insertReport(report)).build();
    	
    }
    @Path("report/removeReport")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeReport(Report report) 
    {  
        return Response.ok(ReportManager.deleteReport(report.getReportId())).build();
    	
    }
    @Path("report/getreport/title")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetReportByTitle(Report report) 
    {  
        return Response.ok(ReportManager.selectByReportTitle(report.getReportTitle())).build();
    	
    }
  
    //---------------------------------------------End Of Reports Services-----------------------------------------//
  	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	//---------------------------------------------Start Of Receipts Services--------------------------------------//
    @Path("receipt/addReceipt")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiptInsert(Receipt receiptIN) 
    {  
        return Response.ok(ReceiptsManager.insertReceipt(receiptIN)).build();
    	
    }
    @Path("receipt/removeReceipt")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response receiptRemove(Receipt receiptIN) 
    {  
        return Response.ok(ReceiptsManager.deleteReceipt(receiptIN.getReceiptID())).build();
    	
    }
    @Path("receipt/getReceipt/respSQN")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecByRespSQN(Receipt receiptIN) 
    {  
        return Response.ok(ReceiptsManager.getRecByRespSQN(receiptIN.getRespSQN())).build();
    	
    }
    @Path("receipt/getReceipt/casheirSSN")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecByCasheirSSN(Receipt receiptIN) 
    {  
    	System.out.println("Service");
        return Response.ok(ReceiptsManager.getRecByCasheirSSN(receiptIN.getCasheirSSN())).build();
    	
    }
    @Path("receipt/getReceipt/FTPFileLocation")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecByFTPFileLocation(Receipt receiptIN) 
    {  
        return Response.ok(ReceiptsManager.getRecByFTPFileLocation(receiptIN.getFTPFileLocation())).build();
    	
    }
    @Path("receipt/getReceipt/receiptStatus")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecByReceiptStatus(Receipt receiptIN) 
    {  
        return Response.ok(ReceiptsManager.getRecByReceiptStatus(receiptIN.getReceiptStatus())).build();
    	
    }
    @Path("receipt/getReceipt/cost")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecByCost(Receipt receiptIN) 
    {  
        return Response.ok(ReceiptsManager.getRecByCost(receiptIN.getCost())).build();
    	
    }
    @Path("receipt/getReceipt/paymentMethod")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecByPaymentMethod(Receipt receiptIN) 
    {  
        return Response.ok(ReceiptsManager.getRecByPaymentMethod(receiptIN.getPaymentMethod())).build();
    	
    }
    @Path("receipt/getReceipt/creationTime")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetRecByCreationTime(Report receiptIN) 
    {
    	System.out.println("Service");
    	return Response.ok(ReceiptsManager.selectByReceiptCreationTime(receiptIN.getReportIssueTime())).build();
    	
    }

	
}
