package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import view.LoginService;
import vo.OuterparkUserVO;
import vo.TourVO;

public class TourDAO {
	private static TourDAO instance = new TourDAO();
	public static TourDAO getInstance() {
		return instance;
	}
	
	private TourDAO() {}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertTour(TourVO vo) {
		String query = String.format("INSERT INTO TOUR VALUES (%s,'%s','%s','%s',%d,'%s','%s')"
				, "SEQ_TOUR.NEXTVAL", vo.getUserId(), vo.getTourName(), vo.getTourTime(), vo.getTourPrice(), vo.getCity(), vo.getExplanation() );
		return jdbc.Update(query);
	}
	
	public int deleteTour(TourVO vo) {
		String query = String.format("DELETE FROM CAR WHERE TOUR_NUMBER = %d AND USER_ID = '%s'", vo.getTourNumber(),LoginService.loginId.getUserId());
		return jdbc.Update(query);
	}

	public ArrayList<HashMap<String, Object>> select(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM TOUR WHERE USER_ID = '%s'", vo.getUserId());
		return jdbc.selectList(query);
	}
}
