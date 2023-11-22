package in.reethu.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PdfApplicationRunner implements ApplicationRunner {
	
	@Value("${spring.application.name}")
	private String name;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(args.getNonOptionArgs());
		System.out.println(args.getOptionNames());
		System.out.println("Source :"+Arrays.asList(args.getSourceArgs()));
		System.out.println("Application:Name :"+name);
	}

}
