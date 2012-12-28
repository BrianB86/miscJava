package rutgers.cs213.android.control;

import rutgers.cs213.android.model.Backend;
import rutgers.cs213.android.model.User;

/**
 * @author Brian Battell
 * @author Susan Hague
 *
 */
public class Users {
	/** Provides Interface to User data  
	 * 
	 * 
	 */
	
	/**
	 * User List
	 * 
	 * @return	String[]	List of User Ids
	 */
	public static String[] GetUserList() {
		
		Backend storage = new Backend();
		String[] users = storage.GetUserList();
		return users;
		
	}
	/**
	 * Add a User
	 *
	 * @param UserId		Id of User
	 * @param UserName		Full Name of User
	 * 
	 * @return	int			Error 0 = no error (success) or 7 (user already exists)
	 */
	public static int AddUser(String UserId, String UserName) {
		Backend storage = new Backend();
		if (storage.ReadUser(UserId) == null) {
			User user = new User(UserId, UserName);
			int err = storage.WriteUser(user);
			return err;
		}
		else
			return 7;
	}
	
	/**
	 * Delete a User
	 *
	 * @param UserId		Id of User
	 * 
	 * @return	int			Error 0 = no error (success) or 2 (user does not exist)
	 */
	public static int DeleteUser(String UserId) {
		
		Backend storage = new Backend();
		if (storage.ReadUser(UserId) == null){
			return 2;
		}
		else {
			int err = storage.DeleteUser(UserId);
			return err;
		}
	}
}

