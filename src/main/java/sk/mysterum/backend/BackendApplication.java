package sk.mysterum.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sk.mysterum.backend.services.MailService;

import javax.mail.MessagingException;

@EnableJpaRepositories
@SpringBootApplication
public class BackendApplication {

	private static boolean isFirstTime = true;


	public static void main(String[] args) throws MessagingException {


		if (isFirstTime){

			//****************LOGO*******************//
			System.out.println("\n" +
					"\n" +
					"77777777777777777777 222222222222222    77777777777777777777   444444444  \n" +
					"7::::::::::::::::::72:::::::::::::::22  7::::::::::::::::::7  4::::::::4  \n" +
					"7::::::::::::::::::72::::::222222:::::2 7::::::::::::::::::7 4:::::::::4  \n" +
					"777777777777:::::::72222222     2:::::2 777777777777:::::::74::::44::::4  \n" +
					"           7::::::7             2:::::2            7::::::74::::4 4::::4  \n" +
					"          7::::::7              2:::::2           7::::::74::::4  4::::4  \n" +
					"         7::::::7            2222::::2           7::::::74::::4   4::::4  \n" +
					"        7::::::7        22222::::::22           7::::::74::::444444::::444\n" +
					"       7::::::7       22::::::::222            7::::::7 4::::::::::::::::4\n" +
					"      7::::::7       2:::::22222              7::::::7  4444444444:::::444\n" +
					"     7::::::7       2:::::2                  7::::::7             4::::4  \n" +
					"    7::::::7        2:::::2                 7::::::7              4::::4  \n" +
					"   7::::::7         2:::::2       222222   7::::::7               4::::4  \n" +
					"  7::::::7          2::::::2222222:::::2  7::::::7              44::::::44\n" +
					" 7::::::7           2::::::::::::::::::2 7::::::7               4::::::::4\n" +
					"77777777            2222222222222222222277777777                4444444444\n" +
					"\n" +
					" _____   _______ _    _ \n" +
					"(____ \\ (_______) |  | |\n" +
					" _   \\ \\ _____  | |  | |\n" +
					"| |   | |  ___)  \\ \\/ / \n" +
					"| |__/ /| |_____  \\  /  \n" +
					"|_____/ |_______)  \\/  ");
			isFirstTime = false;
		}
		//SpringApplication.run(BackendApplication.class, args);
		

	}

}
