package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
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
		String query = String.format("INSERT INTO TOUR VALUES (%d,'%s','%s','%s',%d,'%s','%s')"
				, vo.getTourNumber(), vo.getUserId(), vo.getTourName(), vo.getTourTime(), vo.getTourPrice(), vo.getCity(), vo.getExplanation() );
		return jdbc.Update(query);
	}
	
	public int deleteTour(TourVO vo) {
		String query = String.format("DELETE FROM CAR WHERE TOUR_NUMBER = %d", vo.getTourNumber());
		return jdbc.Update(query);
	}

	public ArrayList<HashMap<String, Object>> select(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM TOUR WHERE USER_ID = '%s'", vo.getUserId());
		return jdbc.selectList(query);
	}
}
