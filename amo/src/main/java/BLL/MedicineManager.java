package BLL;

import DAL.MedicineDAL;
import Models.ServerResponse;
import Models.Data.DataArrayModel;
import Models.Medicine.Medicine;

public class MedicineManager {

	public static DataArrayModel<Medicine> getAllMedicines() {

		return MedicineDAL.getAllMedicines();
	}

	 public static  Medicine getMedicineByBC(String BarCode)
	 {	
			return MedicineDAL.getMedicineByBC(BarCode);	 
	 }
	
	public static Medicine getMedicineByName(String Name)
	{
	return MedicineDAL.getMedicineByName(Name);
	}

	public static DataArrayModel<Medicine> getMedicineByStatus(String Status) {
		return MedicineDAL.getMedicineByStatus(Status);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// GET  Medicines by Active Component //////////////////////////////////////

	public static DataArrayModel<Medicine> getMedicineByActiveComponent(String ActiveComponent) {
		return MedicineDAL.getMedicineByActiveComponent(ActiveComponent);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////// GET  Medicines by Company Name //////////////////////////////////////

	public static DataArrayModel<Medicine> getMedicineByCompanyName(String CompanyName) {
		return MedicineDAL.getMedicineByCompanyName(CompanyName);
	}

	public static DataArrayModel<Medicine> getMedicineByCompanyStatus(String CompanyStatus) {
		return MedicineDAL.getMedicineByCompanyStatus(CompanyStatus);
	}

	public static DataArrayModel<Medicine> getMedicineByContactPerson(String ContactPerson) {
		return MedicineDAL.getMedicineByContactPerson(ContactPerson);
	}

	 public static ServerResponse insertMedicine(Medicine MED)
	 {	 
		 Medicine Array =new Medicine();
		 Array = MedicineDAL.getMedicineByBC(MED.getBarCode());
		if (Array != null)			
		{ 
			if (Array.getMedicineStatus().equals("FF"))
			{ 
				return MedicineDAL.UpdateMedicineStatus(Array.getBarCode(), "00");
			}
			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("01");
			S.setResponseMsg("You already have this medicine in database");
			return S;
		}
		return MedicineDAL.insertMedicine(MED);
	}

	 public static ServerResponse UpdateMedicine (Medicine MED)
	 {
		 // check if the medicine with this bar code exists 
		 Medicine Array =new Medicine();
		 Array = MedicineDAL.getMedicineByBC(MED.getBarCode());
		if (Array.equals(null))
		{
			 ServerResponse S =new ServerResponse(); 
				S.setResponseHexCode("FF");
				S.setResponseMsg("Not found medicine in database");
				return S;	
				
		}
		return MedicineDAL.UpdateMedicine(MED);
	}
 
	 public static ServerResponse DeleteMedicine(String BarCode)
	 {
		 Medicine Array =new Medicine();
		 Array = MedicineDAL.getMedicineByBC(BarCode);
		if (Array.equals(null))
		{
			 ServerResponse S =new ServerResponse(); 
				S.setResponseHexCode("FF");
				S.setResponseMsg("Not found medicine in database");
				return S;
			}
		 return MedicineDAL.DeleteMedicine(BarCode);
	 }
	  
}
