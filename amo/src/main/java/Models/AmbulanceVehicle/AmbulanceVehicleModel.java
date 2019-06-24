package Models;

import java.sql.Date;
import javax.ws.rs.Path;

public class AmbulanceVehicleModel {
	
	private int vin; 
	private String implication;
	private String make ;
	private String type;
	private String productionYear;
	private String regYear ;
	private String 	licencePlate ;
	private String ownerName ;
	private String licenceStateOrProvince ;
    private String  serviceStartDate ;
    private String engineNumber ;
    private String brand ;
    private String chasiahNumber ;
    private String model ;
    private String driverPhoneNumber ;
    private int  vehicleStatus ;

    public AmbulanceVehicleModel(){
    	setVehicleStatus(1);
    }

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public String getImplication() {
		return implication;
	}

	public void setImplication(String implication) {
		this.implication = implication;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLicenceStateOrProvince() {
		return licenceStateOrProvince;
	}

	public void setLicenceStateOrProvince(String licenceStateOrProvince) {
		this.licenceStateOrProvince = licenceStateOrProvince;
	}

	
	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getChasiahNumber() {
		return chasiahNumber;
	}

	public void setChasiahNumber(String chasiahNumber) {
		this.chasiahNumber = chasiahNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDriverPhoneNumber() {
		return driverPhoneNumber;
	}

	public void setDriverPhoneNumber(String driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}

	public int getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(int vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public String getRegYear() {
		return regYear;
	}

	public void setRegYear(String regYear) {
		this.regYear = regYear;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

}
