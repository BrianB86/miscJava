package rutgers.cs213.android.model;

import java.util.ArrayList;
import java.io.File;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Environment;

/**
 * @author Susan Hague
 *
 */
public class Backend {
	/** Provides Interface to read/write data  
	 * 
	 * 
	 */
	
	/**
	 * Read User from disk
	 * @author Susan Hague
	 * @param UserId		Id of User
	 * 
	 * @return	User		User object
	 */
	
	
	public User ReadUser(String UserId) {
		User user = null;
		FileInputStream file_stream = null;
		ObjectInputStream in_stream = null;
		try {
			String file_name =  Environment.getExternalStorageDirectory().getAbsolutePath()  + "photodata/" + UserId + "_user.ser";
		    File user_file = new File(file_name);
		    if (user_file.exists()) {
		    	file_stream = new FileInputStream(user_file);
		    	in_stream = new ObjectInputStream(file_stream);
		    	user = (User)in_stream.readObject();
		    	in_stream.close();
		    }
		    else
		    	return user;
		} 
		catch (IOException ex) {
			return user;
		}
		catch (ClassNotFoundException ex) {
			return user;
		}
		
		return user;
	}
	
	/**
	 * Write User to disk
	 * @author Susan Hague
	 * @param User		User object
	 * 
	 * @return int		Error 0 = no error (success) or 1 (IO Error)
	 */
	public int WriteUser(User user) {
		
		 FileOutputStream file_stream = null;
		 ObjectOutputStream out_stream = null;
		 try {
			 String file_name = Environment.getExternalStorageDirectory().getAbsolutePath() +  "photodata/" + user.getUserId() + "_user.ser";
			 File user_file = new File(file_name);
			 if (!user_file.isFile()) {
				 File data = new File("photodata");
				 if (!data.exists())
					 data.mkdir();
			 }
			 file_stream = new FileOutputStream(user_file, false);
			 out_stream = new ObjectOutputStream(file_stream);
			 out_stream.writeObject(user);
                         out_stream.flush();
			 out_stream.close();
			 return 0;
		 }
		 catch (IOException ex) {
			return 1;
		 }
	}
	
	/**
	 * Delete User from disk
	 * @author Susan Hague
	 * @param UserId	User Id
	 * 
	 * @return	int		Error 0 = no error (success), 2 (user doesn't exist), 3 (file doesn't exist) 0r 4 (unable to delete user file)
	 */
	public int DeleteUser(String UserId) {
		
		User user = ReadUser(UserId);

		if (user == null)
			return 2;
		else {
			File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "photodata/" + user.getUserId() + "_user.ser");
			if (file.exists() && file.isFile()) {
				if (file.delete())
					return 0;
				else
					return 4;
			}
			else
				return 3;
		}
	}
	
	/**
	 * Return List of User Ids
	 * @author Susan Hague
	 * @return	String[]	User Ids
	 */
	public String[] GetUserList() {
		
		ArrayList<String> users = new ArrayList<String>();
		String[] arr_users = new String[0];
		FileInputStream file_stream = null;
		ObjectInputStream in_stream = null;
		
		File data_dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "photodata");
		String[] files = data_dir.list();
		
		if (files == null) {
		    return null;
		} 
		else {
			 
			FilenameFilter filter = new FilenameFilter() {
			    public boolean accept(File dir, String name) {
			        return name.endsWith("user.ser");
			    }
			};
			
			files = data_dir.list(filter);
			
			if (files.length > 0) {
		
			    for (int i=0; i < files.length; i++) {
			    	
			    	try {
			    		File user_file = new File( Environment.getExternalStorageDirectory().getAbsolutePath() + "photodata/" + files[i]);
					    if (user_file.exists()) {
					    	file_stream = new FileInputStream(user_file);
					    	in_stream = new ObjectInputStream(file_stream);
					    	User user = (User)in_stream.readObject();
					    	users.add(user.getUserId());
					    	in_stream.close();
					    }
			    	}
			    	catch (IOException ex) {
						// ignore try any remaining
					 }
			    	catch (ClassNotFoundException ex ) {
			    		return arr_users;
			    	}
			    }
		    
			    arr_users = new String[users.size()];
				users.toArray(arr_users);
				return arr_users;
			}
			else {
				return arr_users;
			}
		}
	}

	/**
	 * Return List of Users
	 * @author Susan Hague
	 * @param	Users		String[] List of User Ids
	 * 
	 * @return	ArrayList	User objects
	 */
	public ArrayList<User> GetUsers(String[] Users) {
		
		ArrayList<User> users = new ArrayList<User>();;
		
		for(int i = 0; i < Users.length; i++) {
			User user = ReadUser(Users[i]);
			users.add(user);
		}
		
		return users;
	}
}
