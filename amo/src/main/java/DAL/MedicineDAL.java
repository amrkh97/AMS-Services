package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import DB.DBManager;
import Models.ServerResponse;
import Models.AmbulanceVehicle.AmbulanceVehicleModel;
import Models.Medicine.Medicine;

/*private String BarCode;
private String MedicineName;
private String Price;
private String CountInStock;
private String Implications;
private String MedicineUsage ;
private String SideEffects;
private String ActiveComponent;
private String MedicineStatus ;
*/
public class MedicineDAL {

	 public static ArrayList<Medicine> getAllMedicines()
	 {
		 

		 String SPsql = "USE KAN_AMO; EXEC usp_Medicines_SelectAll";
		 Connection conn = DBManager.getDBConn();
		ArrayList<Medicine>  Array=  new 	ArrayList<Medicine>()  ;
		 	
	
		     Medicine _Medicine  =new Medicine();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
			        ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_Medicine  =new Medicine();
			        	_Medicine.setBarCode(rs.getString("BarCode"));
			        	_Medicine.setPrice(rs.getString("Price"));
			        	_Medicine.setCountInStock(rs.getString("CountInStock"));
			        	_Medicine.setImplications(rs.getString("Implications"));
			        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
			        	_Medicine.setSideEffects(rs.getString("SideEffects"));
			        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
			        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
			        	_Medicine.setMedicineName(rs.getString("MedicineName"));
			        	Array.add(_Medicine);
			        }
			      
			        
			   			        
			       
			        
			        
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
				
			
			return Array;
		}

	//Get all Car by ID
		 public static Medicine getMedicineByBC(String BarCode)
		 {
			 
			

			 String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByBCode ?";
			 Connection conn = DBManager.getDBConn();

			     Medicine _Medicine  =new Medicine();
				try {
						CallableStatement cstmt  = conn.prepareCall(SPsql);
					     cstmt.setString(1,BarCode);
					      
				        ResultSet rs = cstmt.executeQuery();
				        rs.next();
				        	_Medicine.setBarCode(rs.getString("BarCode"));
				        	_Medicine.setPrice(rs.getString("Price"));
				        	_Medicine.setCountInStock(rs.getString("CountInStock"));
				        	_Medicine.setImplications(rs.getString("Implications"));
				        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
				        	_Medicine.setSideEffects(rs.getString("SideEffects"));
				        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
				        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
				        	_Medicine.setMedicineName(rs.getString("MedicineName"));
				
				        
				   			        
				       
				        
				        
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
					
				
				return  _Medicine;
			}

	 //New Car insertion
	 public static ServerResponse insertMedicine(Medicine _Medicine)
	 {
		
			String SPsql = "EXEC usp_Medicine_Insert ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
				Connection conn = DBManager.getDBConn();
				ServerResponse _ServerResponse = new ServerResponse();
			
				try {


						CallableStatement cstmt  = conn.prepareCall(SPsql);
						
				    
						
			
					    cstmt.setString(2, _Medicine.getBarCode());
				        cstmt.setString(3, _Medicine.getMedicineName());
				        cstmt.setString(4, _Medicine.getPrice());
				        cstmt.setNString(5, _Medicine.getCountInStock());
				        cstmt.setString(6, _Medicine.getImplications());
				        cstmt.setString(7, _Medicine.getMedicineUsage());
				        cstmt.setString(8, _Medicine.getSideEffects());
				        cstmt.setString(9, _Medicine.getActiveComponent());
				        cstmt.setString(10,_Medicine.getMedicineStatus()));
				        
			//		    cstmt.registerOutParameter(18, Types.NVARCHAR);
				//		cstmt.registerOutParameter(19, Types.NVARCHAR);
						  cstmt.execute();

				  //     _ServerResponse.setResponseHexCode(cstmt.getString("responseCode"));
				      
				    //   _ServerResponse.setResponseMsg(cstmt.getString("responseMessage"));
							
					      
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
	 public static ServerResponse UpdateMedicine (Medicine MED)
	 {
		 
		
		return null;
		 
	 }
	 //delete car
	 public static ServerResponse DeleteMedicine(String BarCode)
	 {
		 
		
		return null;
		 
	 }
	 public static  ArrayList<Medicine>  getMedicineByActiveComponent(String ActiveComponent)
	 {
	       

		 String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByActiveComponent ?";
		 Connection conn = DBManager.getDBConn();
		ArrayList<Medicine>  Array=  new 	ArrayList<Medicine>()  ;

	
		     Medicine _Medicine  =new Medicine();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
				     cstmt.setString( 1 , ActiveComponent);
					ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_Medicine  =new Medicine();
			        	_Medicine.setBarCode(rs.getString("BarCode"));
			        	_Medicine.setPrice(rs.getString("Price"));
			        	_Medicine.setCountInStock(rs.getString("CountInStock"));
			        	_Medicine.setImplications(rs.getString("Implications"));
			        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
			        	_Medicine.setSideEffects(rs.getString("SideEffects"));
			        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
			        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
			        	_Medicine.setMedicineName(rs.getString("MedicineName"));
			        	Array.add(_Medicine);
			        }
			      
			        
			   			        
			       
			        
			        
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
				
			
			return Array;
		}
	 public static ArrayList<Medicine>    getMedicineByCompanyName(String CompanyName)
	 {

		 String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByCompanyName ?";
		 Connection conn = DBManager.getDBConn();
		ArrayList<Medicine>  Array=  new 	ArrayList<Medicine>()  ;

	
		     Medicine _Medicine  =new Medicine();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
				     cstmt.setString( 1 , CompanyName);
					ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_Medicine  =new Medicine();
			        	_Medicine.setBarCode(rs.getString("BarCode"));
			        	_Medicine.setPrice(rs.getString("Price"));
			        	_Medicine.setCountInStock(rs.getString("CountInStock"));
			        	_Medicine.setImplications(rs.getString("Implications"));
			        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
			        	_Medicine.setSideEffects(rs.getString("SideEffects"));
			        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
			        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
			        	_Medicine.setMedicineName(rs.getString("MedicineName"));
			        	Array.add(_Medicine);
			        }
			      
			        
			   			        
			       
			        
			        
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
				
			
			return Array;
		}
	 public static ArrayList<Medicine>    getMedicineByCompanyStatus(String CompanyStatus)
	 {

		 String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByCompanyStatus ?";
		 Connection conn = DBManager.getDBConn();
		ArrayList<Medicine>  Array=  new 	ArrayList<Medicine>()  ;

	
		     Medicine _Medicine  =new Medicine();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
				     cstmt.setString( 1 , CompanyStatus);
					ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_Medicine  =new Medicine();
			        	_Medicine.setBarCode(rs.getString("BarCode"));
			        	_Medicine.setPrice(rs.getString("Price"));
			        	_Medicine.setCountInStock(rs.getString("CountInStock"));
			        	_Medicine.setImplications(rs.getString("Implications"));
			        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
			        	_Medicine.setSideEffects(rs.getString("SideEffects"));
			        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
			        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
			        	_Medicine.setMedicineName(rs.getString("MedicineName"));
			        	Array.add(_Medicine);
			        }
			      
			        
			   			        
			       
			        
			        
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
				
			
			return Array;
		}
	 public static ArrayList<Medicine>    getMedicineByContactPerson(String ContactPerson)
	 {

		 String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByContactPerson ?";
		 Connection conn = DBManager.getDBConn();
		ArrayList<Medicine>  Array=  new 	ArrayList<Medicine>()  ;

	
		     Medicine _Medicine  =new Medicine();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
				     cstmt.setString( 1 , ContactPerson);
					ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_Medicine  =new Medicine();
			        	_Medicine.setBarCode(rs.getString("BarCode"));
			        	_Medicine.setPrice(rs.getString("Price"));
			        	_Medicine.setCountInStock(rs.getString("CountInStock"));
			        	_Medicine.setImplications(rs.getString("Implications"));
			        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
			        	_Medicine.setSideEffects(rs.getString("SideEffects"));
			        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
			        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
			        	_Medicine.setMedicineName(rs.getString("MedicineName"));
			        	Array.add(_Medicine);
			        }
			      
			        
			   			        
			       
			        
			        
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
				
			
			return Array;
		}
	 public static ArrayList<Medicine>    getMedicineByName(String Name)
	 {

		 String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectByName ?";
		 Connection conn = DBManager.getDBConn();
		ArrayList<Medicine>  Array=  new 	ArrayList<Medicine>()  ;

	
		     Medicine _Medicine  =new Medicine();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
				     cstmt.setString( 1 , Name);
					ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_Medicine  =new Medicine();
			        	_Medicine.setBarCode(rs.getString("BarCode"));
			        	_Medicine.setPrice(rs.getString("Price"));
			        	_Medicine.setCountInStock(rs.getString("CountInStock"));
			        	_Medicine.setImplications(rs.getString("Implications"));
			        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
			        	_Medicine.setSideEffects(rs.getString("SideEffects"));
			        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
			        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
			        	_Medicine.setMedicineName(rs.getString("MedicineName"));
			        	Array.add(_Medicine);
			        }
			      
			        
			   			        
			       
			        
			        
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
				
			
			return Array;
		}
	 public static ArrayList<Medicine>    getMedicineByStatus(String Status)
	 {

		 String SPsql = "USE KAN_AMO; EXEC usp_Medicine_SelectBySts ?";
		 Connection conn = DBManager.getDBConn();
		ArrayList<Medicine>  Array=  new 	ArrayList<Medicine>()  ;

	
		     Medicine _Medicine  =new Medicine();
			try {
					CallableStatement cstmt  = conn.prepareCall(SPsql);
				     cstmt.setString( 1 , Status);
					ResultSet rs = cstmt.executeQuery();
			     
			        while(rs.next()) {
			        	_Medicine  =new Medicine();
			        	_Medicine.setBarCode(rs.getString("BarCode"));
			        	_Medicine.setPrice(rs.getString("Price"));
			        	_Medicine.setCountInStock(rs.getString("CountInStock"));
			        	_Medicine.setImplications(rs.getString("Implications"));
			        	_Medicine.setMedicineUsage(rs.getString("MedicineUsage"));
			        	_Medicine.setSideEffects(rs.getString("SideEffects"));
			        	_Medicine.setActiveComponent(rs.getString("ActiveComponent"));
			        	_Medicine.setMedicineStatus(rs.getString("MedicineStatus"));
			        	_Medicine.setMedicineName(rs.getString("MedicineName"));
			        	Array.add(_Medicine);
			        }
			      
			        
			   			        
			       
			        
			        
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
				
			
			return Array;
		}

}
