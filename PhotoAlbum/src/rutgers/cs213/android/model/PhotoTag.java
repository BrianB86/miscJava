package rutgers.cs213.android.model;

/**
 *
 * @author Susan Hague
 *
 */

public interface PhotoTag {

	/**
	 * Tag Type of photo 
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return	String	Tag Type
	 */
	String getTagType ();
	
	/**
	 * Tag Value of photo 
	 *
	 * @author Susan Hague
	 * 
	 * @return	String	Tag Value (data associated)
	 */
	String getTagValue ();
}
