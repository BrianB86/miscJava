package rutgers.cs213.android.model;

import java.util.ArrayList;
import java.util.Calendar;

public interface PhotoAlbum {
	/**
	 *
	 * @author Susan Hague
	 *
	 */
	 
	/**
	 * Name of the Album 
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return	String	Album name	
	 */
	String getName();
	
	/**
	 * Name of the Album 
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param	String	Album name	
	 */
	 
	 int getPhotoCount();
	
	/**
	 * Start date of Photos
	 *
	 *
	 * @author Susan Hague
	 *  
	 * @return	Calendar	Oldest (first) Calendar of photos
	 */
	Calendar getStartDate(); 
	
	/**
	 * End date of Photos
	 *
	 *
	 * @author Susan Hague
	 *  
	 * @return	Calendar	Newest (last) Calendar of photos
	 */
    Calendar getEndDate();
	    
	/**
	 * Add an Photo to Album
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param FileName		Name of photo
	 * @param Caption		Caption of photo
	 * 
	 * @return	int		Error 0 = no error (success) or 10 (photo does not exist)
	 */
	 int addPhotoToAlbum(String fileName, String caption); 
	
	/**
	 * Remove a Photo from an Album
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param FileName		Name of photo
	 * 
	 * @return	int		Error 0 = no error (success) or 11 (photo does not exist)
	 */
	 int removePhotoFromAlbum(String fileName);
	
	/**
	 * Gets a Photo from an Album
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param FileName		Name of photo
	 * 
	 * @return	Photo		Photo object
	 */
	 Photo getPhotoFromAlbum(String fileName);
	
	/**
	 * Change Caption of a photo
	 * 
	 *
	 * @author Susan Hague
	 * 
	 * @param FileName		Name of photo
	 * @param Caption		New caption of photo
	 * 
	 * @return	int		Error 0 = no error (success) or 12 (photo does not exist)
	 */
	 int recaptionPhoto(String fileName, String newCaption);
    
    /**
	 * List of Photos
	 *
	 *
	 * @author Susan Hague
	 *  
	 * @return	ArrayList	Photo objects
	 */
    ArrayList<Photo> getPhotoList();
}
