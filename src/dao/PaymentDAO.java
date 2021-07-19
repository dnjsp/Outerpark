package dao;

import util.JDBCUtil;

public class PaymentDAO {
	private static PaymentDAO instance = new PaymentDAO(); 
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private PaymentDAO() {}
	
	public int insertPayment(String userId, int packNumber,int price) {
		String query = String.format("INSERT INTO PAYMENT VALUES(SEQ_PAYMENT.NEXTVAL,'%s',%d,SYSDATE,'결제대기',%d)"
				,userId,packNumber,price);
		return jdbc.Update(query);
	}
}
