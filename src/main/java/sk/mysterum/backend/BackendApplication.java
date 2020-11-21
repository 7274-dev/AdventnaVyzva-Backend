package sk.mysterum.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.mysterum.backend.uselessstuff.PrintLogo;

@SpringBootApplication
public class BackendApplication {
	private final static PrintLogo lgo = new PrintLogo();
	private static boolean isFirstTime = true;

	public static void main(String[] args){


		if (isFirstTime){
			lgo.print();
			isFirstTime = false;
		}
		SpringApplication.run(BackendApplication.class, args);


	}

}
