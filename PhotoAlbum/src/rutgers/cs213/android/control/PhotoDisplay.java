package rutgers.cs213.android.control;

import java.util.ArrayList;
import java.util.Calendar;

import rutgers.cs213.android.model.Tag;

public interface PhotoDisplay {
	/**
	 * @author Brian Battell
	 * @author Susan Hague
	 *
	 */
	
	/**
	 * Name of the Photo 
	 *
	 * @author Brian Battell
	 * @author Susan Hague
	 * 
	 * @return	String	Photo name	
	 */
	String getFileName ();
	
	/**
	 * Name of the Album 
	 *
	 * @author Brian Battell
	 * @author Susan Hague
	 * 
	 * @return	String	Album name	
	 */
	ArrayList<String> getAlbumList ();
	
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
	 * Date of the photo 
	 * 
	 *
	 * @author Susan Hague
	 * 
	 * @return	String Date in output format	
	 */
	String getDate ();
	
	/**
	 * Date of the photo 
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return	Calendar date of photo	
	 */
	Calendar getCreated ();
	
	/**
	 * List of Tags for photo 
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return	ArrayList of Tag objects	
	 */
	ArrayList<Tag> getTags();
	
}
