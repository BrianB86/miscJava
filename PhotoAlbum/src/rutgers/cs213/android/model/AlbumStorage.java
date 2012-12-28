package rutgers.cs213.android.model;

public interface AlbumStorage {

	/**
	 *
	 * @author Susan Hague
	 *
	 */
	
	/**
	 * Read User from disk
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param userId		Id of User
	 * 
	 * @return	User		User object
	 */
	User readUser(String userId);
	
	/**
	 * Write User to disk
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param user		User object
	 * 
	 * @return int		Error 0 = no error (success) or 1 (IO Error)
	 */
	int writeUser(User user);
	
	/**
	 * Delete User from disk
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param UserId	user Id
	 * 
	 * @return	int		Error 0 = no error (success), 2 (user doesn't exist), 3 (file doesn't exist) 0r 4 (unable to delete user file)
	 */
	int deleteUser(String userId);
	
	/**
	 * Return List of User Ids
	 * 
	 *
	 * @author Susan Hague
	 * 
	 * @return	String[]	User Ids
	 */
	 String[] getUserList();
	}
