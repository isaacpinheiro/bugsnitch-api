package br.ufabc.bugsnitch.resource;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.io.IOException;

public class App {
	
	public static final String HOST = "http://localhost:8080/bugsnitch/service/";
	
	public static HttpServer startServer(){
		final ResourceConfig rc = new ResourceConfig().packages("br.ufabc.bugsnitch.resource");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(HOST), rc);
	}
	
	public static void main(String args[]) throws IOException {
		final HttpServer server = startServer();
		System.out.println("BugSnitch API is working.");
	}
	
}
