package in.reethu.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PdfCommandRunner implements CommandLineRunner {
	
	@Value("${spring.application.name}")
	private String name;
	@Override
	public void run(String... args) throws Exception {

		System.out.println(Arrays.asList(args));
		System.out.println("Command:Name :"+name);	
	}

}
