package outerpark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import outerparkuser.*;
import util.JDBCUtil;

public class OuterparkApplication {
	public static void main(String[] args) {
		OuterparkUserDAO userdao = OuterparkUserDAO.getInstance();
		OuterparkUserVO uservo = new OuterparkUserVO(null,"show511611", "유영진11", "퐁당퐁당", "show5116@naver.com", "host");
		System.out.println(userdao.idfoundUser(uservo));
	}
}

