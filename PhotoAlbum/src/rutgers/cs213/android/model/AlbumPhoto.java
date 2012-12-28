package rutgers.cs213.android.model;

import java.util.ArrayList;
import java.util.Calendar;

public interface AlbumPhoto {
	/**
	*
	 * @author Susan Hague
	 *
	 */
	/**
	 * Name of the Photo 
	 *
	*
	 * @author Susan Hague
	 * 
	 * @return	String	Photo name	
	 */
	String getFileName ();
	
	/**
	 * Caption of photo 
	 * 
	*
	 * @author Susan Hague
	 * 
	 * @return	String	Caption	
	 */
	String getCaption ();
	
	/**
	 * Caption of photo 
	 * 
	*
	 * @author Susan Hague
	 * 
	 * @param	String	Caption	
	 */
	
	Calendar getCreated ();
	
	/**
	 * Add a Tag to Photo
	 *
	*
	 * @author Susan Hague
	 * 
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 8 (tag already exists)
	 */
	int addTag(String Type, String Value);
	
	/**
	 * Remove a Tag from Photo
	 *
	*
	 * @author Susan Hague
	 * 
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 9 (tag doesn't exist)
	 */
	int removeTag(String Type, String Value);
	
	/**
	 * Get Tag from Photo
	 *
	*
	 * @author Susan Hague
	 * 
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	Tag			Tag object
	 */
	Tag getTag(String Type, String Value);
	
	/**
	 * List of Tags for photo
	 * 
	*
	 * @author Susan Hague
	 * 
	 * @return	ArraryList		Tag objects
	 */
	ArrayList<Tag> getTags();
	
}
