package util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	static final String FROM = "show5116@naver.com";
    static final String FROMNAME = "2팀 서비스";
    static final String SMTP_USERNAME = "show5116@naver.com";
    static final String SMTP_PASSWORD = "Yyj14161091!";
    static final String HOST = "smtp.naver.com";
    static final int PORT = 465;
    static final String SUBJECT = "임시 비밀번호 발급";

    public SendMail(){}
    
    public static void ToSendMail(String mail,String password) {
    	String BODY = String.join(
    	        System.getProperty("line.separator"),
    	        "<h1>안녕하세요 2팀입니다.</h1>",
    	        "<p>임시 비밀번호는",
    	        password,
    	        " 입니다.</p>"
    	);
    	Properties props = System.getProperties();
    	props.put("mail.smtp.host", "smtp.naver.com");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.ssl.enable", "true");
    	props.put("mail.smtp.ssl.trust", "smtp.naver.com");
    	Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        try {        	
        	msg.setFrom(new InternetAddress(FROM, FROMNAME));
        	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
        	msg.setSubject(SUBJECT);
        	msg.setContent(BODY, "text/html;charset=euc-kr");
        	Transport transport = session.getTransport();
        	transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	transport.sendMessage(msg, msg.getAllRecipients());
        	transport.close();
        }catch(Exception e) {
        	e.printStackTrace();        	
        }
    }
}
