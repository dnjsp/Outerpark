package outerpark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import outerparkuser.*;
import util.JDBCUtil;

public class OuterparkApplication {
	public static void main(String[] args) {
		OuterparkUserDAO userdao = OuterparkUserDAO.getInstance();
		OuterparkUserVO uservo = new OuterparkUserVO("master","master", "master", "master", "show5116@naver.com", "host");
		userdao.insertUser(uservo);
	}
}

