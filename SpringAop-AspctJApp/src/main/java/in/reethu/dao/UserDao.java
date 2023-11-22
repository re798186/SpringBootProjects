package in.reethu.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	public String saveUser() {
		boolean x = false;
		if(x){
		throw new RuntimeException("User Exception");
		}
		System.out.println("save user");
		return "User saved with ID 2";
	}
	
}
