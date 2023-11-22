package in.reethu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManager {
	
	@Pointcut("execution(public * in.reethu.dao.EmployeeDao.saveEmployee())")
	public void savePoint() {
	}
	@Pointcut("execution(public * in.reethu.dao.EmployeeDao.deleteEmployee())")
	public void deletePoint() {
	}
	@Pointcut("savePoint() || deletePoint()")
	public void pointcut() {
	}
	
	@Before("pointcut()")
	public void beginTransaction() {
		System.out.println("TransactionManager.beginTransaction()");
	}
	@After("pointcut()")
	public void commitTransaction() {
		System.out.println("TransactionManager.commitTransaction()");
	}
	@Around("pointcut()")
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
