package online.solution;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailDemoAction implements com.opensymphony.xwork2.Action {

	static Properties properties = new Properties();

	public static void setProperties(Properties properties) {
		EmailDemoAction.properties = properties;
	}

	public static Properties getProperties() {
		return properties;
	}

	static {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}

	private final String from = "bhushanlilapara.uvpce@gmail.com";
	private final String password = "bhushanlilapara";
	private final String subject = "Hi... Strut2_Email demo by Online Solution";
	private final String body = "Thank you for  using service..";
	private String to;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String execute() throws Exception {
		try {
			javax.mail.Session session = javax.mail.Session.getDefaultInstance(
					properties, new javax.mail.Authenticator() {
						@Override
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication(from,
									password);
						}
					});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
			return SUCCESS;
		}
		catch (Exception exception) {
			System.out.println("Exception -> " + exception);
			return ERROR;
		}
	}

}
