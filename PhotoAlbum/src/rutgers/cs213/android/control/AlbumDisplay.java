package rutgers.cs213.android.control;

import java.util.ArrayList;

import rutgers.cs213.android.model.Photo;

public interface AlbumDisplay {
	/**
	 * @author Susan Hague
	 *
	 */
	String getName();
	
	/**
	 * Number of Photos in Album
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return		int Photo count
	 */
	int GetPhotoCount();
	
	/**
	 * Get Start (oldest) date of photos 
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return		String date formatted for output;
	 */
	String GetStartDate();
	/**
	 * Get End (newest) date of photos 
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return		String date formatted for output;
	 */
     String GetEndDate();
    
    /**
	 * Get list of photo objects
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return		ArrayList of Photo;
	 */
    ArrayList<Photo> GetPhotos();
}
