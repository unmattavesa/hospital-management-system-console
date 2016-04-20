package com.wipro.hmsc.db;

import com.wipro.hmsc.domain.User;

public class DataBase {

	public static User[] users = new User[] {
			new User("user1", "pwd", "admin", "first user", 1),
			new User("user2", "pwd", "admin", "second user", 2),
			new User("user3", "pwd", "admin", "third user", 3),
			new User("user4", "pwd", "doctor", "fourth user", 4),
	};
	
	 public static void insertUser(User user) {
		 User[] users = new User[DataBase.users.length + 1];
		 for(int i=0; i<DataBase.users.length; i++) {
			 users[i] = DataBase.users[i];
		 }
		 
		 users[users.length - 1] = user;
		 setUsers(users);
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
}
