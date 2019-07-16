package Models.AmbulanceMap;

public class AmbulanceMapModel {
	private Integer vin;
	private Integer paramedicID;
	private Integer driverID;
	private Integer yellopadID;
	private String statusMap;
	private Long batchID;

	public Integer getYellopadID() {
		return yellopadID;
	}

	public void setYellopadID(Integer yellopadID) {
		this.yellopadID = yellopadID;
	}

	public Integer getDriverID() {
		return driverID;
	}

	public void setDriverID(Integer driverID) {
		this.driverID = driverID;
	}

	public Integer getParamedicID() {
		return paramedicID;
	}

	public void setParamedicID(Integer paramedicID) {
		this.paramedicID = paramedicID;
	}

	public Integer getVin() {
		return vin;
	}

	public void setVin(Integer vin) {
		this.vin = vin;
	}

	public String getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(String statusMap) {
		this.statusMap = statusMap;
	}

	public Long getBatchID() {
		return batchID;
	}

	public void setBatchID(Long batchID) {
		this.batchID = batchID;
	}

}
