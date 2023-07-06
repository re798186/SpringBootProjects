package in.reethu;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

import in.reethu.comp.WishMessageGenerator;

@SpringBootApplication
public class SpringBoot1DiProjectApplication {

	@Bean(name = "dt")
	public LocalDateTime getSysDateTime() {
		System.out.println("AppConfig.getSysDateTime()");
		LocalDateTime date = LocalDateTime.now();
		return date;
	}
	
	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(SpringBoot1DiProjectApplication.class, args);
		
		WishMessageGenerator wmg = factory.getBean(WishMessageGenerator.class);
		System.out.println(wmg);
		
		String msg = wmg.greetMessage("kohli");
		System.out.println(msg);
		
		((AbstractApplicationContext) factory).close();
		System.out.println("\n*****Container closed*******");
	}

}
