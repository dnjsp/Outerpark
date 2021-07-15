package outerpark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import OuterparkUser.*;
import util.JDBCUtil;

public class OuterparkApplication {
	public static void main(String[] args) {
		OuterparkUserDAO userdao = OuterparkUserDAO.getInstance();
		OuterparkUserVO uservo = new OuterparkUserVO("show5116","show5116", "유영진", "퐁당퐁당", "show5116@naver.com", "host");
		userdao.insertUser(uservo);
	}
}

