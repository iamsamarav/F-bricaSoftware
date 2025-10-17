package com.fabrica.avabank.avabank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fabrica.avabank.avabank.entities.Cliente;
import com.fabrica.avabank.avabank.repositories.ClienteRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	
	public void notificarCliente(Cliente cliente, long conta, String agencia) {
	    String assunto = "AVABANK: Seu banco digital está pronto para você!";
	    
	    StringBuilder mensagemBuilder = new StringBuilder();
	    mensagemBuilder.append("<!DOCTYPE html>")
	    .append("<html lang=\"pt-BR\">")
	    .append("<head>")
	    .append("<meta charset=\"UTF-8\">")
	    .append("<style>")
	    .append("body { font-family: Arial, sans-serif; max-width: 600px; margin: 0 auto; padding: 0; line-height: 1.6; color: #333; }")
	    .append(".header { text-align: center; margin-bottom: 20px; }")
	    .append(".title { color: #540d6e; text-align: center; border-bottom: 2px solid #540d6e; padding-bottom: 10px; font-size: 24px; }")
	    .append(".content { background-color: #f4f4f4; border-radius: 10px; padding: 20px; }")
	    .append(".footer { margin-top: 20px; font-size: 0.8em; color: #69605c; text-align: center; }")
	    .append("</style>")
	    .append("</head>")
	    .append("<body>")
	    .append("<div class=\"content\">")
	    .append("<div class=\"header\">")
	    .append("<img src=\"https://raw.githubusercontent.com/FinTECH-Grupo-1/avabank/refs/heads/Frontend/frontend/avabank/src/app/assets/images/Start-Coins.png?token=GHSAT0AAAAAAC5IUCGLXSAPX2CKPU5MOZXAZ42SDJQ\" alt=\"Logo AVABANK\" style=\"max-width: 100px;\">")
	    .append("</div>")
	    .append("<h1 class=\"title\">Bem vindo(a) ao AVABANK !</h1>")
	    .append("<p>Olá, <strong>").append(cliente.getNome()).append("</strong>,</p>")
	    .append("<p>É com grande satisfação que damos as boas vindas a você como um novo cliente. Agora você tem uma conta no AVABANK. Aqui estão seus dados de acesso:</p>")
	    .append("<ul>")
	    .append("<li><strong>Agência:</strong> ").append(agencia).append("</li>")
	    .append("<li><strong>Conta:</strong> ").append(conta).append("</li>")
	    .append("<li><strong>Senha provisória:</strong> Os primeiros 5 dígitos do seu CPF.</li>")
	    .append("</ul>")
	    .append("<p>Para sua segurança, recomendamos que altere a senha após o primeiro acesso.</p>")
	    .append("<p style=\"margin-top: 20px; color: #540d6e; font-weight: bold; text-align: center;\">Agora você pode começar a usar todos os serviços do AVABANK!</p>")
	    .append("<p class=\"footer\">Este é um e-mail automático gerado pelo sistema. Por favor, não responda.</p>")
	    .append("</div>")
	    .append("</body>")
	    .append("</html>");

	    
	    String mensagem = mensagemBuilder.toString();

	    try {
	        MimeMessage email = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(email, true, "UTF-8"); 
	        
	        helper.setTo(cliente.getEmail());
	        helper.setSubject(assunto);
	        helper.setText(mensagem, true);
	        
	        javaMailSender.send(email);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
}
