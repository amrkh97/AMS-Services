package BLL;

import java.sql.Connection;
import java.sql.SQLException;

import DAL.YelloPadDAL;
import DB.DBManager;
import Models.ServerResponse;
import Models.YelloPad.YelloPadArray;
import Models.YelloPad.YelloPadModel;

public class YelloPadManager {
	
	public static YelloPadArray getAllYelloPads() {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadArray model = new YelloPadArray();
		try {
			model = YelloPadDAL.getAllYelloPads(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static YelloPadArray getAllActiveYelloPads() {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadArray model = new YelloPadArray();
		try {
			model = YelloPadDAL.getAllActiveYelloPads(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return model;
	}

	public static YelloPadArray getAllInActiveYelloPads() {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadArray model = new YelloPadArray();
		try {
			model = YelloPadDAL.getAllInActiveYelloPads(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return model;
	}

	public static YelloPadModel searchYelloPad(String ID) {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadModel model = new YelloPadModel();
		try {
			model = YelloPadDAL.searchYelloPad(ID,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return model;
	}

	public static YelloPadModel getYelloPadStatus(String ID) {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadModel model = new YelloPadModel();
		try {
			model = YelloPadDAL.getYelloPadStatus(ID,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return model;
	}

	public static YelloPadModel getYelloPadNetworkCardNo(String ID) {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadModel model = new YelloPadModel();
		try {
			model = YelloPadDAL.getYelloPadNetworkCardNo(ID,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return model;
	}

	public static YelloPadArray getNotAssignedYelloPads() {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadArray model = new YelloPadArray();
		try {
			model = YelloPadDAL.getNotAssignedYelloPads(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
	
	public static YelloPadArray getAssignedYelloPads() {
		Connection intermediateConnection = DBManager.getDBConn();
		YelloPadArray model = new YelloPadArray();
		try {
			model = YelloPadDAL.getAssignedYelloPads(intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

	public static ServerResponse insertYelloPad(YelloPadModel yelloPad) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = YelloPadDAL.insertYelloPad(yelloPad,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
	
	public static ServerResponse updateYelloPadLocation(YelloPadModel yelloPad) {
		Connection intermediateConnection = DBManager.getDBConn();
		ServerResponse model = new ServerResponse();
		try {
			model = YelloPadDAL.updateYelloPadLocation(yelloPad,intermediateConnection);
		} finally {
			try {
				intermediateConnection.close();
				System.out.println("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return model;
	}

}
