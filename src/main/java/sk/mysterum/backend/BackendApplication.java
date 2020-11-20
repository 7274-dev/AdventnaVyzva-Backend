package sk.mysterum.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.mysterum.backend.services.PrintLogo;

@SpringBootApplication
public class BackendApplication {
	private final static PrintLogo lgo = new PrintLogo();

	public static void main(String[] args){


		SpringApplication.run(BackendApplication.class, args);
		lgo.print();

	}

}
