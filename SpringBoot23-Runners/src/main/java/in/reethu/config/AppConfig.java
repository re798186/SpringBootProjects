package in.reethu.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.reethu.methodRef.RunnerMethodRef;

@Configuration
public class AppConfig {
	
	@Bean 
	public CommandLineRunner runA() {
		return (args)-> System.out.println("Lamda:  "+Arrays.asList(args));
	}
	@Bean 
	public CommandLineRunner runB() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.out.println("InnerClass:  "+Arrays.asList(args));
				
			}
		};
	}
	@Bean 
	public CommandLineRunner runC() {
		return RunnerMethodRef::test;
	}

}
