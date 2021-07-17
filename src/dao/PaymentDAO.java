package dao;

import util.JDBCUtil;

public class PaymentDAO {
	private static PaymentDAO instance = new PaymentDAO(); 
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private PaymentDAO() {}
}
