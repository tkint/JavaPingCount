package fr.epsi.i4.pingcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.epsi.i4.pingcount.ws.PingCount;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		System.out.println("Disponible à l'adresse http://localhost:8080" + PingCount.basePath);
	}
}
