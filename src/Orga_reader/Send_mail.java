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
	protected String message_object = "Ask'IT - DIPNN";
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

		/*props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "mailhost.der.edf.fr");
		props.put("mail.smtp.port", "25");*/

		props.put("localhost", "25");

		// Create the object session
		session = Session.getDefaultInstance(props, null);
		session.setDebug(false);
		try {
			mesg = new MimeMessage(session);
			// from
			mesg.setFrom(new InternetAddress("DIPNN-DI-SIDL@edf.fr"));

			// Adress TO.
			InternetAddress toAddress = new InternetAddress(message_dest);
			mesg.addRecipient(Message.RecipientType.TO, toAddress);

			// Adresses CC.
			// InternetAddress ccAddress = new InternetAddress(message_cc);
			// mesg.addRecipient(Message.RecipientType.CC, ccAddress);

			message_body = "Bonjour, <br/>" + "<br/>"
					+ "Suite à la mise à disposition du nouvel outil ASK’iT pour le traitement de vos demandes de travaux SI, DOC et Logistique au sein de la Direction Industrielle, veuillez trouver vos identifiants afin de vous connecter au portail :\n"
					+ "<br/>" + "<br/>" + "<br/>"
					+ "Portail d’accès : <b><a href='http://10.182.115.151:8080/bonita'>ASK'iT</a></b> (sous Firefox exclusivement)<br/>"
					+ "<br/>" + "Utilisateur (Login) en Majuscule : <b>" + nni + "</b><br/>" + "Mot de passe : <b>"
					+ password + "</b><br/>" + "<br/>"
					+ "<b>&#9888 Ce mot de passe devra être changé une fois l’accès au portail effectué et via le menu « Changer son mot de passe » situé dans la barre des menus. &#9888</b><br/>"
					+ "<br/>" + "<br/>"
					+ "SIDL reste à votre disposition pour toutes informations complémentaires ou pour toutes anomalies rencontrées à l’adresse suivante : DIPNN-DI-DT@edf.fr <br/>"
					+ "<br/>" + "Cordialement.<br/>" + "<br/>" + "SIDL";

			/******************************************************************************************************************/
			mesg.setContent(message_body, "text/html; charset=utf-8");
			mesg.setHeader("Content-Type", "text/HTML; charset=utf-8");
			// Object
			mesg.setSubject(message_object);

			// mesg.setText(message_body); ATTENTION, EMPECHE E HTML DE SE METTRE EN PLACE
			Transport.send(mesg);
			System.out.println("--------------------------------------------------\nFrom : DIPPNN_DI_SIDL@edf.fr\nTo : "
					+ message_dest + "\nSubject : " + message_object + "\nMIME-Version : 1.0\nContent-Type :"
					+ mesg.getContentType() + "\n" + mesg.getAllHeaders() + "\nSent at : " + mesg.getSentDate()
					+ "\n--------------------------------------------------\n");
			@SuppressWarnings("unused")
			Logs_writer logs = new Logs_writer(
					"--------------------------------------------------\nFrom : Ask'IT-NoReply@edf.fr\nTo : "
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
