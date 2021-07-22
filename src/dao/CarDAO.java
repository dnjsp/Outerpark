package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import view.LoginService;
import vo.CarVO;
import vo.OuterparkUserVO;

public class CarDAO {
	private static CarDAO instance = new CarDAO(); 
	public static CarDAO getInstance() {
		return instance;
	}
	
	private CarDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	 
	public int insertCar(CarVO vo) {
		String query = String.format("INSERT INTO CAR VALUES ('%s','%s','%s',%d,%d,'%s','%s')"
				, vo.getCarNumber(), vo.getUserId(), vo.getCarKind(), vo.getCarPrice()
				, vo.getCarSeats(), vo.getCity(), vo.getCarColor());
		return jdbc.update(query);
	}
	
	public int deleteCar(CarVO vo) {
		String query = String.format("DELETE FROM CAR WHERE CAR_NUMBER = '%s' AND USER_ID = '%s'", 
				vo.getCarNumber(),LoginService.loginId.getUserId());
		return jdbc.update(query);
	}
	
	public ArrayList<HashMap<String, Object>> select(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM CAR WHERE USER_ID = '%s'", vo.getUserId());
		return jdbc.selectList(query);
	}
	
	public ArrayList<HashMap<String, Object>> selectCar (CarVO vo) {
		String query = String.format("SELECT * FROM CAR WHERE CITY = '%s' AND CAR_SEATS >= %d", vo.getCity(), vo.getCarSeats());
		return jdbc.selectList(query);
	}
	
	public int selectCarPrice(String carNumber) {
		String query = String.format("SELECT CAR_PRICE FROM CAR WHERE CAR_NUMBER = '%s'", carNumber);
		return jdbc.selectint(query, "CAR_PRICE");
	}
	
	public ArrayList<HashMap<String, Object>> carDetail (String cartNum) {
		String query = String.format("SELECT C.CAR_KIND,"
				+ "	   C.CAR_SEATS"
				+ "  FROM PAYMENT PAY,PACK PAC,CAR C"
				+ " WHERE PAY.PACK_NUMBER = PAC.PACK_NUMBER"
				+ "   AND PAC.CAR_NUMBER = C.CAR_NUMBER"
				+ "   AND PAY.CART_NUMBER = %s", cartNum);
		return jdbc.selectList(query);
	}
}
