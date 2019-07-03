package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

// import org.json.JSONArray;
// import org.json.JSONObject;

import DB.DBManager;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.ServerResponse;

public class AmbulanceVehicleDAL {


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////Get all car///////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
				

	 public static ArrayList<AmbulanceVehicleModel>  getAllCars()
	 {
		 
		 String SPsql = "EXEC usp_AmbulanceVehicle_SelectAll";
		 Connection conn = DBManager.getDBConn();
		ArrayList<AmbulanceVehicleModel>  Array=  new 	ArrayList<AmbulanceVehicleModel>()  ;
		 	
	
		 	AmbulanceVehicleModel _AmbulanceVehicle  =new AmbulanceVehicleModel();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
			        ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_AmbulanceVehicle  =new AmbulanceVehicleModel();
			        	 _AmbulanceVehicle.setVin(rs.getInt("Vin"));
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
				        _AmbulanceVehicle.setAssignedYPID(rs.getString("AssignedYPID"));
				        _AmbulanceVehicle.setVehicleStatus(rs.getString("VehicleStatus"));
			       
			        	Array.add(_AmbulanceVehicle);
			        }
			      
			        
			   			        
			       
			        
			        
		         }catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					System.out.println("Connention Closed");
				} catch (SQLException e) {
					
					
					e.printStackTrace();
				}
			}
				
			
			return Array;
		}
		
	 


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////GEt car by ID///////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
					
		 public static AmbulanceVehicleModel getCarByID(int VIN)
		 {
			 
				
					String SPsql = "USE KAN_AMO; EXEC usp_AmbulanceVehicle_SelectByVIN ?,?,?";
					Connection conn = DBManager.getDBConn();
					AmbulanceVehicleModel _AmbulanceVehicle = new AmbulanceVehicleModel();
					ServerResponse _ServerResponse=new  ServerResponse();
					try {
							CallableStatement cstmt  = conn.prepareCall(SPsql);
					        cstmt.setInt(1,VIN);
					        cstmt.registerOutParameter(2, Types.NVARCHAR);
							cstmt.registerOutParameter(3, Types.NVARCHAR);
							cstmt.execute();
					         _ServerResponse.setResponseHexCode(cstmt.getString(2));						 
						      _ServerResponse.setResponseMsg(cstmt.getString(3));
                               System.out.println(_ServerResponse.getResponseMsg());
						       if (_ServerResponse.getResponseHexCode() == "ff")
					       {
						    	   						    	   return null;
						       }

								ResultSet resultSet =  cstmt.executeQuery();
						        resultSet.next();

					        _AmbulanceVehicle.setVin(resultSet.getInt("Vin"));
					        _AmbulanceVehicle.setImplication(resultSet.getString("Implication"));
					        _AmbulanceVehicle.setMake( resultSet.getString("Make"));
					        _AmbulanceVehicle.setType( resultSet.getString("Type"));
					        _AmbulanceVehicle.setProductionYear( resultSet.getString("ProductionYear"));
					        _AmbulanceVehicle.setRegYear( resultSet.getString("RegYear"));
					        _AmbulanceVehicle.setLicencePlate( resultSet.getString("LicencePlate"));
					        _AmbulanceVehicle.setOwnerName( resultSet.getString("OwnerName"));
					        _AmbulanceVehicle.setLicenceStateOrProvince( resultSet.getString("LicenceStateOrProvince"));
					        _AmbulanceVehicle.setServiceStartDate( resultSet.getString("ServiceStartDate"));
					        _AmbulanceVehicle.setEngineNumber( resultSet.getString("EngineNumber"));
					        _AmbulanceVehicle.setBrand( resultSet.getString("Brand"));
					        _AmbulanceVehicle.setChasiahNumber( resultSet.getString("ChasiahNumber"));
				            _AmbulanceVehicle.setModel( resultSet.getString("Model"));
          				    _AmbulanceVehicle.setDriverPhoneNumber( resultSet.getString("DriverPhoneNumber"));
				            _AmbulanceVehicle.setAssignedYPID( resultSet.getString("AssignedYPID"));
				            _AmbulanceVehicle.setVehicleStatus( resultSet.getString("VehicleStatus"));
					   			        
					        
					        
				         }catch (SQLException e) {
						
						e.printStackTrace();
					}finally {
						try {
							conn.close();
							System.out.println("Connention Closed");
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}
						
					
					return _AmbulanceVehicle;
				}

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////GEt cars by Brand///////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
			

		 public static ArrayList<AmbulanceVehicleModel>  getCarsByBrand(String Brand)
		 {
			 
			 String SPsql = "EXEC usp_AmbulanceVehicle_SelectByBrand ?,?,?";
			 Connection conn = DBManager.getDBConn();
			ArrayList<AmbulanceVehicleModel>  Array=  new 	ArrayList<AmbulanceVehicleModel>()  ;
			 	
		
			 	AmbulanceVehicleModel _AmbulanceVehicle  =new AmbulanceVehicleModel();
				try {
						CallableStatement cstmt  = conn.prepareCall(SPsql);
					     cstmt.setString(1,Brand);
				        cstmt.registerOutParameter(2, Types.NVARCHAR);
						cstmt.registerOutParameter(3, Types.NVARCHAR);
				        ResultSet rs = cstmt.executeQuery();
				     
				        while(rs.next()) {
				        	_AmbulanceVehicle  =new AmbulanceVehicleModel();
				        	 _AmbulanceVehicle.setVin(rs.getInt("Vin"));
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
					        _AmbulanceVehicle.setAssignedYPID(rs.getString("AssignedYPID"));
					        _AmbulanceVehicle.setVehicleStatus(rs.getString("VehicleStatus"));
				       
				        	Array.add(_AmbulanceVehicle);
				        }
				      
				        
				   			        
				       
				        
				        
			         }catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					try {
						conn.close();
						System.out.println("Connention Closed");
					} catch (SQLException e) {
						
						
						e.printStackTrace();
					}
				}
					
				
				return Array;
			}

			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////GEt cars by Brand///////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
			

		 public static ArrayList<AmbulanceVehicleModel>  getCarsBySts(String Sts)
		 {
			 
			 String SPsql = "EXEC usp_AmbulanceVehicle_SelectBySts ?,?,?";
			 Connection conn = DBManager.getDBConn();
			ArrayList<AmbulanceVehicleModel>  Array=  new 	ArrayList<AmbulanceVehicleModel>()  ;
			 	
		
			 	AmbulanceVehicleModel _AmbulanceVehicle  =new AmbulanceVehicleModel();
				try {
						CallableStatement cstmt  = conn.prepareCall(SPsql);
					     cstmt.setString(1,Sts);
				        cstmt.registerOutParameter(2, Types.NVARCHAR);
						cstmt.registerOutParameter(3, Types.NVARCHAR);
				        ResultSet rs = cstmt.executeQuery();
				     
				        while(rs.next()) {
				        	_AmbulanceVehicle  =new AmbulanceVehicleModel();

				        	 _AmbulanceVehicle.setVin(rs.getInt("Vin"));
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
					        _AmbulanceVehicle.setAssignedYPID(rs.getString("AssignedYPID"));
					        _AmbulanceVehicle.setVehicleStatus(rs.getString("VehicleStatus"));
				       
				        	Array.add(_AmbulanceVehicle);
				        }
				      
				        
				   			        
				       
				        
				        
			         }catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					try {
						conn.close();
						System.out.println("Connention Closed");
					} catch (SQLException e) {
						
						
						e.printStackTrace();
					}
				}
					
				
				return Array;
			}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////insert car///////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
				
				
	
	 
	 //New Car insertion
	 public static ServerResponse insertCar(AmbulanceVehicleModel Car)
	 {
			String SPsql = "EXEC usp_AmbulanceVehicle_Insert ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
			Connection conn = DBManager.getDBConn();
			ServerResponse _ServerResponse = new ServerResponse();
		
			try {


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
			        cstmt.setString(16,Car.getAssignedYPID());
			        cstmt.setString(17,Car.getVehicleStatus());
				    System.out.println(Car.getAssignedYPID());
			       
				    cstmt.registerOutParameter(18, Types.NVARCHAR);
					cstmt.registerOutParameter(19, Types.NVARCHAR);
					  cstmt.execute();

			       _ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));
			      
			       _ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));
						
				      
		         }catch (SQLException e) {
		        	 System.out.println("i hav error");
				
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					System.out.println("Connention Closed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			return _ServerResponse;
				
	
	 }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////Update  a Car///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 


	
	//Update  a Car insertion
	 public static ServerResponse UpdateCar (AmbulanceVehicleModel Car)
	 {
		 
		 String SPsql = "EXEC usp_AmbulanceVehicle_Update ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
			Connection conn = DBManager.getDBConn();
			ServerResponse _ServerResponse = new ServerResponse();
		
			try {


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
			        cstmt.setString(16,Car.getAssignedYPID());
			        cstmt.setString(17,Car.getVehicleStatus());

				    System.out.println(Car.getAssignedYPID());
			       cstmt.registerOutParameter(18, Types.NVARCHAR);
					cstmt.registerOutParameter(19, Types.NVARCHAR);
					  cstmt.execute();

			       _ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));
			      
			       _ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));
						
				      
		         }catch (SQLException e) {
		        	 System.out.println("i hav error");
				
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					System.out.println("Connention Closed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			return _ServerResponse;
				
		 
	 }
	 //delete car
	 public static ServerResponse DeleteCars(int vin)
	 {
		 
		
		 String SPsql = "EXEC usp_AmbulanceVehicle_Delete ?";	
			Connection conn = DBManager.getDBConn();
			ServerResponse _ServerResponse = new ServerResponse();

			try {


					CallableStatement cstmt  = conn.prepareCall(SPsql);
			       cstmt.registerOutParameter(1, Types.NVARCHAR);
					cstmt.registerOutParameter(2, Types.NVARCHAR);
					  cstmt.execute();
			       _ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));
			       _ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));
						
				      
		         }catch (SQLException e) {
		        	 System.out.println("i hav error");
				
				e.printStackTrace();
			}finally {
				try {
					conn.close();
					System.out.println("Connention Closed");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			return _ServerResponse;
				
	 }
	 
	 
	
}
