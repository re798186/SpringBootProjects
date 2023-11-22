package in.reethu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserTransactionManager {
	
	@Pointcut("execution(public String in.reethu.dao.UserDao.saveUser())")
	public void p1() {
	}
	
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("TransactionManager.beginTransaction()");
	}
	@AfterReturning(value="p1()", returning = "obj")
	public void commitTransaction(String obj) {
		System.out.println("TransactionManager.commitTransaction() :" +obj);
	}

	@AfterThrowing(value="p1()" ,throwing = "obj")
	public void rollback(Throwable obj) {
		System.out.println("UserTransactionManager.rollback() :" +obj.getMessage());
	}
	
	@Around("p1()")
	public void aroundAdvice(ProceedingJoinPoint jp) {
		System.out.println("TransactionManager.begin ");
		try {
			Object obj = jp.proceed();
			System.out.println(obj);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TransactionManager.end ");
	}

	
}
