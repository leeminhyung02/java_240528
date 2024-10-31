package kr.kh.final_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kr.kh.final_project.model.vo.Mail;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {

	@Autowired
	public JavaMailSender mailSender;

	public void mailSend(Mail mail) {
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper msg_Helper = new MimeMessageHelper(msg, false, "UTF-8");
			msg_Helper.setTo(mail.getTo());
			msg_Helper.setSubject(mail.getTitle());
			msg_Helper.setText(mail.getContent(), true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
