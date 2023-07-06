package in.reethu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class AlertServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AlertServiceRunner.run()");
		for (String a : args) {
			System.out.println(a);
		}
	}

}
