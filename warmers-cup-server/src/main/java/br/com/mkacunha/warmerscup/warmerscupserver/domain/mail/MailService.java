package br.com.mkacunha.warmerscup.warmerscupserver.domain.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class MailService {

	private final JavaMailSender emailSender;

	public MailService(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	@Async
	public void send(String message, String mail) {
		try {
			System.out.println("Enviando E-mail para " + mail);
			MimeMessage mimeMessage = emailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			mimeMessageHelper.setSubject("Copa dos Agasalhos :):)");
			mimeMessageHelper.setTo(mail);
			mimeMessageHelper.setText(message, true);
			emailSender.send(mimeMessage);
			System.out.println("Email enviado para " + mail);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Async
	public void send(Mail mail) {
		send(mail.getEmailBody(), mail.getEmail());
	}
}
