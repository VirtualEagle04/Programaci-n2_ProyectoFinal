package co.edu.unbosque.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.Usuario;

@Service
public class EmailService {

	@Autowired
	private final JavaMailSender emailSender;
	
	public EmailService(JavaMailSender mailSender) {
		this.emailSender = mailSender;
	}
	
	@Async
	public void sendEmail(Usuario usuario) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("fvargasr@unbosque.edu.co");
		message.setFrom("fvargasr@unbosque.edu.co");
		message.setSubject("Notificación de Usuario");
		message.setText("A ocurrido una nueva acción:\nUsuario: " + usuario.getLogin() + "\nID: " + usuario.getId());
		
		emailSender.send(message);
	}
	
	
	
}
