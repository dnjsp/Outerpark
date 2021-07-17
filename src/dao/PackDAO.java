package dao;

import util.JDBCUtil;

public class PackDAO {
	private static PackDAO instance = new PackDAO();
	public static PackDAO getInstance() {
		return instance;
	}
	
	private PackDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
}
