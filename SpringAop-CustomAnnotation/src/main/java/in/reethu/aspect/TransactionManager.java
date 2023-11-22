package in.reethu.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManager {
	
	@Pointcut("@annotation(in.reethu.annotation.MyTransaction)")
	public void p1() {
	}
	
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("TransactionManager.beginTransaction()");
	}
	@After("p1()")
	public void commitTransaction() {
		System.out.println("TransactionManager.commitTransaction()");
	}
	

}
