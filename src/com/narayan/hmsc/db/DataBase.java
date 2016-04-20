package com.narayan.hmsc.db;

import com.narayan.hmsc.domain.Doctor;
import com.narayan.hmsc.domain.User;

/**
 * 
 * @author unmattavesa
 *
 */
public class DataBase {

	public static User[] users = new User[] {
			new User("user1", "pwd", "admin", "first user", 1),
			new User("user2", "pwd", "admin", "second user", 2),
			new User("user3", "pwd", "admin", "third user", 3),
			new Doctor("siva123", "pwd", "siva narayana", 24) {{
				setSpecialization("cardiaic");
				setExperience(2);
			}},
			new Doctor("shankar123", "pwd", "shankar narayana", 26) {{
				setSpecialization("neurology");
				setExperience(4);
			}}
	};
	
	 public static void save(User user) {
		 User[] _users = new User[users.length + 1];
		 for(int i=0; i<users.length; i++) {
			 _users[i] = users[i];
		 }
		 
		 _users[_users.length - 1] = user;
		 setUsers(_users);
	 }

	private static void setUsers(User[] _users) {
		users = _users;
	}
	
	public static boolean exists(User user) {
		for(User u : users) {
			if(u.equals(user)) return true;
		}
		return false;
	}
	
	public static boolean exists(String userId) {
		for(User u : users) {
			if(userId.equals(u.getUserid())) return true;
		}
		return false;
	}
	
	public static User find(String userId) {
		for(User u : users) {
			if(userId.equals(u.getUserid())) return u;
		}
		return null;
	}
	
	public static boolean delete(String userId) {
		if(exists(userId)) {
			User[] _users = new User[users.length - 1];
			 for(int i=0, j=0; i<users.length; i++) {
				 if(!userId.equals(users[i].getUserid())) {
					 _users[j++] = users[i];
				 }
			 }
			 setUsers(_users);
			 return true;
		}
		 return false;
	}
}
