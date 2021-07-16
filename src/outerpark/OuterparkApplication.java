package outerpark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import outerparkuser.*;
import util.JDBCUtil;

public class OuterparkApplication {
	public static void main(String[] args) {
		OuterparkUserDAO userdao = OuterparkUserDAO.getInstance();
		OuterparkUserVO uservo = new OuterparkUserVO("sdf","master", "master", "master", "show5116@naver.com", "host");
		uservo = userdao.selectid(uservo);
		System.out.println(uservo.getUserMail());
	}
}

