package br.ufabc.bugsnitch.model;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {
	
	private String to;
	private String from;
	private String host;
	private String subject;
	private String text;
	
	public Email(){
		
	}
	
	public Email(String to, String from, String host, String subject, String text){
		this.to = to;
		this.from = from;
		this.host = host;
		this.subject = subject;
		this.text = text;
	}
	
	public void setTo(String to){
		this.to = to;
	}
	
	public String getTo(){
		return this.to;
	}
	
	public void setFrom(String from){
		this.from = from;
	}
	
	public String getFrom(){
		return this.from;
	}
	
	public void setHost(String host){
		this.host = host;
	}
	
	public String getHost(){
		return this.host;
	}
	
	public void setSubject(String subject){
		this.subject = subject;
	}
	
	public String getSubject(){
		return this.subject;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public String getText(){
		return this.text;
	}
	
	public void send(){
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", getHost());
		Session session = Session.getDefaultInstance(properties);
		
		try{
			
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(getFrom()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(getTo()));
			message.setSubject(getSubject());
			message.setText(getText());
			
			Transport.send(message);
			System.out.println("Mensagem enviada com sucesso.");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
