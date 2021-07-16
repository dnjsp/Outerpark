package dao;

import util.JDBCUtil;
import vo.OuterparkUserVO;

public class OuterparkUserDAO {
	private static OuterparkUserDAO instance = new OuterparkUserDAO();
	public static OuterparkUserDAO getInstance() {
		return instance;
	}

	private OuterparkUserDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertUser(OuterparkUserVO vo) {
		String query = String.format("INSERT INTO OUTERPARK_USER VALUES ('%s','%s','%s','%s','%s','%s')"
				,vo.getUserId(),vo.getUserPassword(),vo.getUserName(),vo.getUserNickname(),vo.getUserMail(),vo.getUsertype());
		return jdbc.Update(query);
	}
	
	public int deleteUser(OuterparkUserVO vo) {
		String query = String.format("DELETE FROM OUTERPARK_USER WHERE USER_ID = '%s'", vo.getUserId());
		return jdbc.Update(query);
	}
	
	public int updatePassword(OuterparkUserVO vo, String changePassword) {
		String query = String.format("UPDATE OUTERPARK_USER SET USER_PASSWORD = '%s'"
				+ " WHERE USER_ID = '%s' AND USER_PASSWORD = '%s'", changePassword, vo.getUserId(), vo.getUserPassword());
		return jdbc.Update(query);
	}
	
	public int updateNickname(OuterparkUserVO vo) {
		String query = String.format("UPDATE OUTERPARK_USER SET USER_NICKNAME = '%s'"
				+ " WHERE USER_ID = '%s' AND USER_PASSWORD = '%s'", vo.getUserNickname(), vo.getUserId(), vo.getUserPassword());
		return jdbc.Update(query);
	}
	
	public boolean loginUser(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM OUTERPARK_USER WHERE USER_ID = '%s' AND USER_PASSWORD = '%s'"
				,vo.getUserId(),vo.getUserPassword());	
		return jdbc.SelectBoolean(query);
	}
	
	public String idfoundUser(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM OUTERPARK_USER WHERE USER_NAME = '%s' AND USER_MAIL = '%s' AND USER_NICKNAME = '%s'"
				,vo.getUserName(),vo.getUserMail(), vo.getUserNickname());
		return jdbc.SelectString(query, "USER_ID");
	}
	
	public String referenceType(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM OUTERPARK_USER WHERE USER_ID = '%s'"
				,vo.getUserId());
		return jdbc.SelectString(query, "USER_TYPE");
	}

	
}