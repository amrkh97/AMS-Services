package Models.AmbulanceMap;

public class AmbulanceMapModel {
	private Integer VIN;
	private Integer ParamedicID;
	private Integer DriverID;
	private Integer YellopadID;
	
	public Integer getYellopadID() {
		return YellopadID;
	}
	public void setYellopadID(Integer yellopadID) {
		YellopadID = yellopadID;
	}
	public Integer getDriverID() {
		return DriverID;
	}
	public void setDriverID(Integer driverID) {
		DriverID = driverID;
	}
	public Integer getParamedicID() {
		return ParamedicID;
	}
	public void setParamedicID(Integer paramedicID) {
		ParamedicID = paramedicID;
	}
	public Integer getVIN() {
		return VIN;
	}
	public void setVIN(Integer vIN) {
		VIN = vIN;
	}

}
