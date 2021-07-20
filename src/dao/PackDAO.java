package dao;

import util.JDBCUtil;
import vo.PackVO;

public class PackDAO {
	private static PackDAO instance = new PackDAO();
	public static PackDAO getInstance() {
		return instance;
	}
	
	private PackDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertPack(PackVO vo) {
		String query = String.format("INSERT INTO PACK VALUES(SEQ_PACK.NEXTVAL,%d,%d,'%s','%d','%d',%d)"
				,vo.getTourNumber(),vo.getRoomNumber(),vo.getCarNumber(),vo.getStartDate(),vo.getEndDate(),vo.getPeople() );
		return jdbc.update(query);
	}
	
	public int getPackNumber() {
		String query = "SELECT A.PACK_NUMBER \r\n"
				+ "      FROM ( SELECT PACK_NUMBER FROM PACK\r\n"
				+ "              ORDER BY 1 DESC) A\r\n"
				+ "     WHERE ROWNUM = 1";
		return jdbc.selectint(query, "PACK_NUMBER");
	}
}
