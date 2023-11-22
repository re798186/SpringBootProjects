package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.reethu.mailsender.EmailSender;
import jakarta.mail.MessagingException;

@SpringBootApplication
public class SpringMailAppApplication {

	public static void main(String[] args) throws MessagingException {
		ApplicationContext context =SpringApplication.run(SpringMailAppApplication.class, args);
		EmailSender sender = context.getBean(EmailSender.class);
		sender.sendEmail(new String[] {"kewljaaz@gmail.com"});
				
	}

}
