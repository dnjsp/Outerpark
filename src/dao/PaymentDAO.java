package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import vo.OuterparkUserVO;

public class PaymentDAO {
	private static PaymentDAO instance = new PaymentDAO(); 
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	private PaymentDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertPayment(String userId, int packNumber,int price) {
		String query = String.format("INSERT INTO PAYMENT VALUES(SEQ_PAYMENT.NEXTVAL,'%s',%d,SYSDATE,'결제대기',%d)"
				,userId,packNumber,price);
		return jdbc.update(query);
	}
	
	public ArrayList<HashMap<String, Object>> selectPayment (String userid) {
		String query = String.format("SELECT * FROM PAYMENT WHERE USER_ID = '%s'", userid);
		return jdbc.selectList(query);
	}
	
	public ArrayList<HashMap<String, Object>> selectDetail (String cartNumber) {
		String query = String.format("SELECT R.CITY ,"
				+ "	   PAC.PEOPLE ,"
				+ "	   PAC.START_DATE ,"
				+ "	   PAC.END_DATE ,"
				+ "	   PAY.PRICE "
				+ "  FROM PAYMENT PAY,PACK PAC,ROOM R"
				+ " WHERE PAY.PACK_NUMBER = PAC.PACK_NUMBER "
				+ "   AND PAC.ROOM_NUMBER = R.ROOM_NUMBER "
				+ "   AND PAY.CART_NUMBER = %s", cartNumber);
		return jdbc.selectList(query);
	}
	
	public int updateState(String state,String cartNumber) {
		String query = String.format("UPDATE PAYMENT SET STATE = '%s' WHERE CART_NUMBER = '%s'",
				state, cartNumber);
		return jdbc.update(query);
	}
	
	public int updateUser(OuterparkUserVO vo,String type ,String changeword) {
		String query = String.format("UPDATE OUTERPARK_USER SET %s = '%s' WHERE USER_ID = '%s'",
				type, changeword, vo.getUserId());
		return jdbc.update(query);
	}
}
