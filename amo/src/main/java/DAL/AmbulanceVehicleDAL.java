package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import DB.DBManager;
import Models.AmbulanceVehicleModel;
import Models.ServerResponse;

public class AmbulanceVehicleDAL {

	//Get all Cars
	 public static AmbulanceVehicleModel[] getAllCars()
	 {
		 
		
		return null;
		 
	 }
	//Get all Car by ID
		 public static AmbulanceVehicleModel getCarByID(int VIN)
		 {
			 
				
					String SPsql = "EXEC usp_AmbulanceVehicle_SelectByVIN ?";
					Connection conn = DBManager.getDBConn();
					AmbulanceVehicleModel _AmbulanceVehicle = new AmbulanceVehicleModel();
					try {
							CallableStatement cstmt  = conn.prepareCall(SPsql);
					        cstmt.setInt(1,VIN);
					        ResultSet rs = cstmt.executeQuery();
					      
					      
					        _AmbulanceVehicle.setImplication(rs.getNString("Implication"));
					        _AmbulanceVehicle.setMake(rs.getString("Make"));
					        _AmbulanceVehicle.setType(rs.getString("Type"));
					        _AmbulanceVehicle.setProductionYear(rs.getString("ProductionYear"));
					        _AmbulanceVehicle.setRegYear(rs.getString("RegYear"));
					        _AmbulanceVehicle.setLicencePlate(rs.getString("LicencePlate"));
					        _AmbulanceVehicle.setOwnerName(rs.getString("OwnerName"));
					        _AmbulanceVehicle.setLicenceStateOrProvince(rs.getString("LicenceStateOrProvince"));
					        _AmbulanceVehicle.setServiceStartDate(rs.getString("ServiceStartDate"));
					        _AmbulanceVehicle.setEngineNumber(rs.getString("EngineNumber"));
					        _AmbulanceVehicle.setBrand(rs.getString("Brand"));
					         _AmbulanceVehicle.setChasiahNumber(rs.getString("ChasiahNumber"));
					        _AmbulanceVehicle.setModel(rs.getString("Model"));
					        _AmbulanceVehicle.setDriverPhoneNumber(rs.getString("DriverPhoneNumber"));
					   					        
					        cstmt.execute();
					        
					        
				         }catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						try {
							conn.close();
							System.out.println("Connention Closed");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						
					
					return _AmbulanceVehicle;
				}
				
				
				
				
	
	 
	 //New Car insertion
	 public static ServerResponse insertCar(AmbulanceVehicleModel Car)
	 {
		 System.out.println(Car.getImplication());
			System.out.println(Car.getServiceStartDate());
			
			String SPsql = "EXEC usp_AmbulanceVehicle_Insert ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
			Connection conn = DBManager.getDBConn();
			ServerResponse _ServerResponse = new ServerResponse();
			 System.out.println("im dal");

			try {
				 System.out.println("im dal");

					CallableStatement cstmt  = conn.prepareCall(SPsql);
					
			        cstmt.setInt(1, Car.getVin());
			        cstmt.setString(2, Car.getImplication());
			        cstmt.setString(3, Car.getMake());
			        cstmt.setString(4, Car.getType());
			        cstmt.setNString(5, Car.getProductionYear());
			        cstmt.setString(6, Car.getRegYear());
			        cstmt.setString(7, Car.getLicencePlate());
			        cstmt.setString(8, Car.getOwnerName());
			        cstmt.setString(9, Car.getLicenceStateOrProvince());
			        cstmt.setString(10, Car.getServiceStartDate());
			        cstmt.setString(11, Car.getEngineNumber());
			        cstmt.setString(12, Car.getBrand());
			        cstmt.setString(13,Car.getChasiahNumber());
			        cstmt.setString(14,Car.getModel());
			        cstmt.setString(15,Car.getDriverPhoneNumber());
			        cstmt.execute();
			        _ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));
			        _ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));
						System.out.println(_ServerResponse.getResponseMsg());
		         }catch (SQLException e) {
		        	 System.out.println("i hav error");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					System.out.println("Connention Closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return _ServerResponse;
				
	
	 }
	
	//Update  a Car insertion
	 public static boolean UpdateCar (AmbulanceVehicleModel Car)
	 {
		 
		
		return true ;
		 
	 }
	 //delete car
	 public static boolean DeleteCars(int vin)
	 {
		 
		
		return true;
		 
	 }
	
}
