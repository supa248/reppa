package com.lti.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

	

	private List<User> users;
	
	
	
	public UserService(){
		
		users=new ArrayList<User>();
		users.add(new User("sharma","123",true));
		users.add(new User("sharmaBIG","13",true));
		users.add(new User("sharmaCute","123",true));
		users.add(new User("sharmaLike","123",true));
		users.add(new User("shifara","123",true));
		System.out.println(users);	
	}
	
	public boolean isValidUser(String username,String password){
		
		/*for(int i=0;i<users.size();i++)
		{
			
			
		
		if(users.contains(username))
		{
		if(users.get(i).equals(password) && users.isAllowed() )
		{
			return true;
		}
		return false;
		
	}
		
		return false;
	}
	}
	*/
		
		for(User user:users){
			if(user.getUsername().equals(username) )
					if(user.getPassword().equals(password))
					if(user.isAllowed())
					return true;
		}//return false;
return false;
		
	}
	
}


