package kr.kh.final_project.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {

	private final JavaMailSender jMailSender;
	
	
	@Async
	public boolean sendMail() throws Exception {
		boolean msg = false;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo("mi087033@gmail.com"); //상대방 이메일 주소
		simpleMailMessage.setSubject("제목");
		simpleMailMessage.setText("내용");
		try {
			jMailSender.send(simpleMailMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return msg;
		}
	
		return true;
	}
}
