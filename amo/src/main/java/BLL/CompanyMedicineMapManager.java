package BLL;

import java.util.ArrayList;

import DAL.CompanyMedicineMapDAL;
import Models.ServerResponse;
import Models.Medicine.CompanyMedicineMap;

public class CompanyMedicineMapManager {

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////INSERT ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse insertRelation(CompanyMedicineMap Map) {
		ArrayList<CompanyMedicineMap> Array = new ArrayList<CompanyMedicineMap>();
		Array = CompanyMedicineMapDAL.getCompanyMedicineMap(Map);
		System.out.println(Map.getCompID());
		if (Array.size() != 0)

		{
			System.out.println(Map.getCompID());
			if (Array.get(0).getMapStatus().equals("FF")) {
				return CompanyMedicineMapDAL.UpdateRelationStatus(Array.get(0), "00");
			} else {
				ServerResponse S = new ServerResponse();
				S.setResponseHexCode("01");
				S.setResponseMsg("You already have this medicine in database");
				return S;
			}
		}

		return CompanyMedicineMapDAL.insertRelation(Map);

	}

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////DELETE ///////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////

	public static ServerResponse DeleteRelation(CompanyMedicineMap Map) {
		ArrayList<CompanyMedicineMap> Array = new ArrayList<CompanyMedicineMap>();
		Array = CompanyMedicineMapDAL.getCompanyMedicineMap(Map);
		if (Array.size() == 0)

		{

			ServerResponse S = new ServerResponse();
			S.setResponseHexCode("FF");
			S.setResponseMsg("this Relation was not found in database");
			return S;

		}

		return CompanyMedicineMapDAL.DeleteRelation(Map);

	}

}