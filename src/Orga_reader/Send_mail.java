package Orga_reader;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send_mail {

	/** Destinataire du message. */
	protected String message_dest;
	/* Objet du message. */
	protected String message_object = "**********N";
	/** Destinataire du message en copie (CC). */
	// protected String message_cc = "dest@hotmail.com";
	/** Texte du message. */
	protected String message_body;

	/** Objet session de JavaMail. */
	protected Session session;
	/** Objet message de JavaMail. */
	protected Message mesg;

	public void send(String nni, String password, String dest) {
		message_dest = dest;
		Properties props = new Properties();

		/*props.put("", "smtp");
		props.put("", "");
		props.put("mail.smtp.port", "25");*/

		props.put("localhost", "25");

		// Create the object session
		session = Session.getDefaultInstance(props, null);
		session.setDebug(false);
		try {
			mesg = new MimeMessage(session);
			// from
			mesg.setFrom(new InternetAddress("yourmail@mail.com"));

			// Adress TO.
			InternetAddress toAddress = new InternetAddress(message_dest);
			mesg.addRecipient(Message.RecipientType.TO, toAddress);

			// Adresses CC.
			// InternetAddress ccAddress = new InternetAddress(message_cc);
			// mesg.addRecipient(Message.RecipientType.CC, ccAddress);

			message_body = "Whatever you want";

			/******************************************************************************************************************/
			mesg.setContent(message_body, "text/html; charset=utf-8");
			mesg.setHeader("Content-Type", "text/HTML; charset=utf-8");
			// Object
			mesg.setSubject(message_object);

			// mesg.setText(message_body); ATTENTION, EMPECHE E HTML DE SE METTRE EN PLACE
			Transport.send(mesg);
			System.out.println("--------------------------------------------------\nFrom : **********\nTo : "
					+ message_dest + "\nSubject : " + message_object + "\nMIME-Version : 1.0\nContent-Type :"
					+ mesg.getContentType() + "\n" + mesg.getAllHeaders() + "\nSent at : " + mesg.getSentDate()
					+ "\n--------------------------------------------------\n");
			@SuppressWarnings("unused")
			Logs_writer logs = new Logs_writer(
					"--------------------------------------------------\nFrom :**********\nTo : "
							+ message_dest + "\nSubject : " + message_object + "\nMIME-Version : 1.0\nContent-Type :"
							+ mesg.getContentType() + "\n" + mesg.getAllHeaders() + "\nSent at : " + mesg.getSentDate()
							+ "\n--------------------------------------------------\n");
		} catch (MessagingException ex) {
			while ((ex = (MessagingException) ex.getNextException()) != null) {
				ex.printStackTrace();
			}
		}
	}
}
