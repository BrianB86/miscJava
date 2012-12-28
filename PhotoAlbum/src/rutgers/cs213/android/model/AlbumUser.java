package rutgers.cs213.android.model;

import java.util.ArrayList;

public interface AlbumUser {
	/**
	 *
	 * @author Susan Hague
	 *
	 */
	
	/**
	 * Get User Id
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return String	User Id			
	 */
	String getUserId ();
	
	/**
	 * Get User Name
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return String	User Full Name			
	 */
	String getName ();
	
	/**
	 * Get List of Albums
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @return ArrayList	Album objects	
	 */
	ArrayList<Album> getAlbums ();
	
	/**
	 * Add an Album
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param AlbumName		Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 5 (album already exists)
	 */
	int addAlbum(String albumName);
	
	/**
	 * Delete an Album
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param AlbumName 	Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 6 (album does not exist)
	 */
	int deleteAlbum(String albumName);
	
	/**
	 * Album object from Name
	 *
	 *
	 * @author Susan Hague
	 * 
	 *@param AlbumName
	 *
	 * @return		Album object			
	 */
	Album getAlbum(String albumName);
	
	/**
	 * Change Album Name
	 *
	 *
	 * @author Susan Hague
	 * 
	 *@param OldAlbumName	Name to change from
	 *@param NewAlbumName	Name to change to
	 *
	 * @return int			Error 0 = no error (success) or 6 (album does not exist)		
	 */
    int renameAlbum(String oldAlbumName, String newAlbumName);

    /**
	 * Get a Album by Name
	 *
	 *
	 * @author Susan Hague
	 * 
	 * @param AlbumName	Name of album 
	 * 
	 * @return	Album object
	 */
}
