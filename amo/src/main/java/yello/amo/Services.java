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
import BLL.PatientManger;
import BLL.UserManager;
import BLL.YelloPadManager;
import Models.ServerResponse;
import Models.AmbulanceMap.AmbulanceMapModel;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Company.CompanyModel;
import Models.Data.DataArrayModel;
import Models.Data.DataModel;
import Models.Employee.EmployeeModel;
import Models.Job.Job;
import Models.Locations.Location;
import Models.MedicalRecord.MedicalRecord;
import Models.Medicine.CompanyMedicineMap;
import Models.Medicine.Medicine;
import Models.Patient.PatientModel;
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
		ArrayList<AmbulanceVehicleModel> X = AmbulanceVehicleManger.getCarsByBrand(CAR.getBrand());
		if (X == null) {
			return Response.ok(" unknown error with database  ").header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getDeactivatedAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicle() {
		ArrayList<AmbulanceVehicleModel> Xs = AmbulanceVehicleManger.getDeActivatedCars();
		DataArrayModel<AmbulanceVehicleModel> X = new DataArrayModel<AmbulanceVehicleModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getActivatedAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAmbulanceVehicleSts() {

		ArrayList<AmbulanceVehicleModel> Xs = AmbulanceVehicleManger.getActivatedCars();
		DataArrayModel<AmbulanceVehicleModel> X = new DataArrayModel<AmbulanceVehicleModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();

	}

	@Path("ambulance/getDeletedAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetDeletedAmbulanceVehicle() {

		ArrayList<AmbulanceVehicleModel> Xs = AmbulanceVehicleManger.getDeletedCars();
		DataArrayModel<AmbulanceVehicleModel> X = new DataArrayModel<AmbulanceVehicleModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getFreeAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetFreeAmbulanceVehicle() {

		ArrayList<AmbulanceVehicleModel> Xs = AmbulanceVehicleManger.getFreeCars();
		DataArrayModel<AmbulanceVehicleModel> X = new DataArrayModel<AmbulanceVehicleModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Path("ambulance/getFreeAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetBusyAmbulanceVehicle() {
	
	ArrayList<AmbulanceVehicleModel> Xs = AmbulanceVehicleManger.getBusyCars();
	DataArrayModel<AmbulanceVehicleModel> X = new DataArrayModel<AmbulanceVehicleModel>();
	X.set_ArrayList(Xs);
	return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulance/getAssignedAmbulanceVehicles")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAssignedAmbulanceVehicle() {

		ArrayList<AmbulanceVehicleModel> Xs = AmbulanceVehicleManger.getAssignedCars();
		DataArrayModel<AmbulanceVehicleModel> X = new DataArrayModel<AmbulanceVehicleModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
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
	public Response getAmbulanceMapbyVIN(Integer ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByCarID(ID)).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("ambulanceMap/getByDriverID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAmbulanceCarMapByDriverID(Integer ID) {
		return Response.ok(AmbulanceMapManager.getAmbulanceCarMapByDriverID(ID))
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("ambulanceMap/getByParamedicID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
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
	
	//-----------------------------------------End Of Ambulance Map ------------------------------------------------//
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-----------------------------------------Start of Employee Services-------------------------------------------//
	
	@Path("employee/getAllParamedics")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllParamedics(DataModel superSSN) {
		ArrayList<EmployeeModel> Xs = EmployeeManager.getAllParamedics(superSSN.getSentID());
		DataArrayModel<EmployeeModel> X = new DataArrayModel<EmployeeModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getActiveParamedics")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveParamedics(DataModel superSSN) {

		ArrayList<EmployeeModel> Xs = EmployeeManager.getActiveParamedics(superSSN.getSentID());
		DataArrayModel<EmployeeModel> X = new DataArrayModel<EmployeeModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getInActiveParamedics")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInActiveParamedics(DataModel superSSN) {

		ArrayList<EmployeeModel> Xs = EmployeeManager.getInActiveParamedics(superSSN.getSentID());
		DataArrayModel<EmployeeModel> X = new DataArrayModel<EmployeeModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getAllDrivers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDrivers(DataModel superSSN) {
		ArrayList<EmployeeModel> Xs = EmployeeManager.getAllDrivers(superSSN.getSentID());
		DataArrayModel<EmployeeModel> X = new DataArrayModel<EmployeeModel>();
		X.set_ArrayList(Xs);
		
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("employee/getActiveDrivers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActiveDrivers(DataModel superSSN) {

		ArrayList<EmployeeModel> Xs = EmployeeManager.getActiveDrivers(superSSN.getSentID());
		DataArrayModel<EmployeeModel> X = new DataArrayModel<EmployeeModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*")
				.build();
	}

	@Path("employee/getInActiveDrivers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInActiveDrivers(DataModel superSSN) {

		ArrayList<EmployeeModel> Xs = EmployeeManager.getInActiveDrivers(superSSN.getSentID());
		DataArrayModel<EmployeeModel> X = new DataArrayModel<EmployeeModel>();
		X.set_ArrayList(Xs);
		return Response.ok(X).header("Access-Control-Allow-Origin", "*")
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
		ArrayList<Job> Xs = JobManager.getAllJobs();
		DataArrayModel<Job> X = new DataArrayModel<Job>();
		X.set_ArrayList(Xs);
		
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("job/getJobByTitle")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getJobByTitle(DataModel jobTitle) {
		ArrayList<Job> Xs = JobManager.getJobByTitle(jobTitle.getSentStatus());
		DataArrayModel<Job> X = new DataArrayModel<Job>();
		X.set_ArrayList(Xs);
		
		
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("job/getJobByStatus")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getJobByStatus(String jobStatus) {

		ArrayList<Job> Xs = JobManager.getJobByStatus(jobStatus);
		DataArrayModel<Job> X = new DataArrayModel<Job>();
		X.set_ArrayList(Xs);
		
		
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
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
		ArrayList<Medicine> Xs = MedicineManager.getAllMedicines();
		DataArrayModel<Medicine> X = new DataArrayModel<Medicine>();
		X.set_ArrayList(Xs);
		
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
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
		ArrayList<Medicine> Xs = MedicineManager.getMedicineByStatus(MED.getMedicineStatus());
		DataArrayModel<Medicine> X = new DataArrayModel<Medicine>();
		X.set_ArrayList(Xs);
		return Response.ok(X)
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicine/getMedicines/activeComponent")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByActiveComponent(Medicine MED) {

		ArrayList<Medicine> Xs = MedicineManager.getMedicineByActiveComponent(MED.getActiveComponent());
		DataArrayModel<Medicine> X = new DataArrayModel<Medicine>();
		X.set_ArrayList(Xs);
		return Response.ok(X)
				.header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("medicine/getMedicines/companyName")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByComName(CompanyModel COMP) {

		ArrayList<Medicine> Xs =MedicineManager.getMedicineByCompanyName(COMP.getCompanyName());
		DataArrayModel<Medicine> X = new DataArrayModel<Medicine>();
		X.set_ArrayList(Xs);

		return Response.ok(X)
				.header("Access-Control-Allow-Origin", "*").build();
	} 

	@Path("medicine/getMedicines/companyStatus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMedicineByCompanyStatus(CompanyModel COMP) {

		ArrayList<Medicine> Xs = MedicineManager.getMedicineByCompanyStatus(COMP.getCompanyStatus());
		DataArrayModel<Medicine> X = new DataArrayModel<Medicine>();
		X.set_ArrayList(Xs);

		return Response.ok(X)
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


		ArrayList<Medicine> Xs = MedicineManager.getMedicineByContactPerson(COMP.getCompanyContactPerson());
		DataArrayModel<Medicine> X = new DataArrayModel<Medicine>();
		X.set_ArrayList(Xs);
		return Response.ok(X)
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

		return Response.ok(PatientLocationManager.getAllPatientLocations(PatientNationalID.getStringID())).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@Path("patient/getAll")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllPatient() {
		ArrayList<PatientModel> X =PatientManger.getAllPatient();
		DataArrayModel<PatientModel>OBJ = new 	DataArrayModel<PatientModel>()  ;
		OBJ.set_ArrayList(X);
    	if(X==null){		
    		return Response.ok("402 the patient not Added").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(OBJ).header("Access-Control-Allow-Origin", "*").build();
		 
	}

	@Path("patient/addNewPatient")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response addNewPatient(PatientModel patientModel) {
		ServerResponse X =PatientManger.addNewPatient(patientModel);
    	if(X==null){		
    		return Response.ok("402 the patient not Added").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();
		 
	}

	@Path("patient/updatePatientData")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response editPatient (PatientModel patientModel) {
		ServerResponse X =PatientManger.updatePatientData(patientModel);
    	if(X==null){		
    		return Response.ok("404 the patient not found").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(X).header("Access-Control-Allow-Origin", "*").build();

	}
	 
	@Path("patient/get/NID")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getPatientByNID (PatientModel patientModel) {
		ArrayList<PatientModel>  X =PatientManger.getPatientByNId(patientModel.getPatientNationalID());
		DataArrayModel<PatientModel>OBJ = new 	DataArrayModel<PatientModel>()  ;
		OBJ.set_ArrayList(X);
    
		if(X==null){		
    		return Response.ok("404 the patient not found").header("Access-Control-Allow-Origin", "*").build(); }
		return Response.ok(OBJ).header("Access-Control-Allow-Origin", "*").build();

	}

	@Path("patient/deletePatient")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response deletePatient (PatientModel patientModel) {
		ServerResponse X =PatientManger.deletePatient(patientModel.getPatientID());
    	if(X==null){
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
	public Response getCompanyByID(Integer companyID) {
		return Response.ok(CompanyManager.getCompanyByID(companyID)).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getCompanyByStatus")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyByStatus(DataModel companyStatus) {
		return Response.ok(CompanyManager.getCompanyByStatus(companyStatus.getSentStatus())).header("Access-Control-Allow-Origin", "*").build();
	}

	@Path("pharmaCompany/getCompanyByName")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
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
		
	//---------------------------------------------End Of PharmaCompany--------------------------------------------//
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//---------------------------------------------Start Of YelloPad Services--------------------------------------//
	
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
}
