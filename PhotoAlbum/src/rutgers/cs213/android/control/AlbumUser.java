package rutgers.cs213.android.control;

import java.util.ArrayList;
import java.util.Date;

import rutgers.cs213.android.model.Album;
import rutgers.cs213.android.model.Tag;
import rutgers.cs213.android.model.User;

public interface AlbumUser {
	/**
	 * @author Brian Battell
	 *
	 *
	 */
	/**
	 * User object
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @return		User object	
	 */
	User GetUser();
	
	/**
	 * Album object from Name
	 *
	 * @author Brian Battell
	 *
	 * 
	 *@param AlbumName
	 *
	 * @return		Album object			
	 */
	Album GetAlbum(String AlbumName);
	
	/**
	 * Add an Album to User
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param AlbumName		Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 5 (album already exists)
	 */
	int AddAlbum(String AlbumName);
	
	/**
	 * Delete an Album from User
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param AlbumName 	Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 6 (album does not exist)
	 */
	int DeleteAlbum(String AlbumName);
	
	/**
	 * Add an Photo to Album
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param FileName		Name of photo
	 * @param Caption		Caption of photo
	 * @param AlbumName		Name of Album
	 * 
	 * @return	int		Error 0 = no error (success) or 6 (album does not exist)
	 */
	int AddPhotoToAlbum(String FileName, String Caption, String AlbumName);
	
	/**
	 * Move Photo from one Album to another
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param FileName		Name of photo
	 * @param OldAlbumName	Name of album to move from
	 * @param NewAlbumName	Name of album to move to
	 * 
	 * @return	int		Error 0 = no error (success), 6 (album does not exist) or 12 (photo does not exist)
	 */
	int MoveFromAlbumToAlbum(String FileName, String OldAlbumName, String NewAlbumName); 
	
	/**
	 * Remove a Photo from an Album
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param FileName		Name of photo
	 * @param AlbumName		Name of Album
	 * 
	 * @return	int		Error 0 = no error (success) or 6 (album does not exist)
	 */
	int RemovePhotoFromAlbum(String FileName, String AlbumName);

	/**
	 * Add a Tag to Photo
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param FileName		Name of photo
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 12 (photo does not exist)
	 */
	int AddTagToPhoto(String FileName, String TagType, String TagValue);
	
	/**
	 * Remove a Tag from Photo
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param FileName		Name of photo
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 12 (photo does not exist)
	 */
	int RemoveTagFromPhoto(String FileName, String TagType, String TagValue);
	
	/**
	 * List of AlbumDetails (formated for display)
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @return	ArrayList of AlbumDetails for user
	 */
	ArrayList<AlbumDetail> GetAlbumDetails();
	
	/**
	 * PhotoDetail for a photo (formatted for display)
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param FileName		Name of photo
	 * 
	 * @return	PhotoDetail	object
	 */
	PhotoDetail GetPhotoDetails(String PhotoFileName);
	
	/**
	 * List of PhotoDetails (formated for display) for Album
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param AlbumName	Name of Album 
	 * 
	 * @return	ArrayList of PhotoDetails for Album
	 */
	ArrayList<PhotoDetail> GetPhotoDetailsByAlbum(String AlbumName);

	/**
	 * List of PhotoDetails (formated for display) for Date Range
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param StartDate	Oldest (first) date to filter list by	 
	 * @param EndDate Newest (last) date to filter list by	
	 * 
	 * @return	ArrayList of PhotoDetails by Date
	 */
	ArrayList<PhotoDetail> GetPhotoDetailsByDate(Date StartDate, Date EndDate);

	/**
	 * List of PhotoDetails (formated for display) for selected Tags
	 *
	 * @author Brian Battell
	 *
	 * 
	 * @param Tags	Array of Tag objects (Tag Type/Tag Value pairs)	 
	 * 
	 * @return	ArrayList of PhotoDetails filtered by Tag
	 */
	ArrayList<PhotoDetail> GetPhotoDetailsByTag(Tag[] tags);

}
