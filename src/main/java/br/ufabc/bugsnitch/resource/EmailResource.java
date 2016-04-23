package br.ufabc.bugsnitch.resource;

import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;

import br.ufabc.bugsnitch.model.Email;

@Path("email")
public class EmailResource {
	
	@POST
	@Consumes("application/json")
	public void send(Email e){
		
		Email email = new Email(e.getTo(), e.getFrom(), e.getHost(), e.getSubject(), e.getText());
		email.send();
		
	}
	
}
