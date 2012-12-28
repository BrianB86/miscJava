package rutgers.cs213.android.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author Susan Hague
 *
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** User Storage object 
	 * 
	 * 
	 */
	private String userId;
	private String userName;
	private ArrayList<Album> albumList;
	
	/** 
	 * Constructor for User
	 * @author Susan Hague
	 * @param Id		User Id
	 * @param Name		User Full Name
	 * 
	 */
	public User (String Id, String Name) {
		
		this.userId = Id;
		this.userName = Name;
		this.albumList = new ArrayList<Album>();
	}
	
	/** 
	 * Constructor for User
	 * @author Susan Hague
	 * @param Id		User Id
	 * @param Name		User Full Name
	 * @param Albums	List of Albums for User
	 * 
	 */
	public User (String Id, String Name, ArrayList<Album> Albums ) {
		
			this.userId = Id;
			this.userName = Name;
			this.albumList = Albums;
	}
	
	/**
	 * Get User Id
	 * @author Susan Hague
	 * @return String	User Id			
	 */
	public String getUserId () {
        return this.userId;
    }
	
	/**
	 * Get User Name
	 * @author Susan Hague
	 * @return String	User Full Name			
	 */
	public String getName () {
        return this.userName;
    }
	
	/**
	 * Get List of Albums
	 * @author Susan Hague
	 * @return ArrayList	Album objects	
	 */
	public ArrayList<Album> getAlbums () {
        return this.albumList;
    }
	
	/**
	 * Add an Album
	 * @author Susan Hague
	 * @param AlbumName		Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 5 (album already exists)
	 */
	public int AddAlbum(String AlbumName) {
		Album album = getAlbumByName(AlbumName);
		if (album == null) {
			ArrayList<Photo> Photos = new ArrayList<Photo>();
			album = new Album(AlbumName, Photos);
			this.albumList.add(album);
			return 0;
		}	
		else {
			return 5;
		}
	}
	
	/**
	 * Delete an Album
	 *
	 * @param AlbumName 	Name of album
	 * @author Susan Hague
	 * @return	int			Error 0 = no error (success) or 6 (album does not exist)
	 */
	public int DeleteAlbum(String AlbumName) {
		Album album = getAlbumByName(AlbumName);
		if (album == null) {
			return 6;
		}
		else {
			this.albumList.remove(album);
			return 0;
		}
		
	}
	
	/**
	 * Album object from Name
	 * @author Susan Hague
	 * @param AlbumName
	 *
	 * @return		Album object			
	 */
	public Album GetAlbum(String AlbumName) {
		
		Album album = getAlbumByName(AlbumName);
		return album;
		
	}
	
	/**
	 * Change Album Name
	 * @author Susan Hague
	 * @param OldAlbumName	Name to change from
	 * @param NewAlbumName	Name to change to
	 *
	 * @return int			Error 0 = no error (success) or 6 (album does not exist)		
	 */
    public int RenameAlbum(String OldAlbumName, String NewAlbumName) {
		
		Album album = getAlbumByName(OldAlbumName);
		if (album == null)
			return 6;
		else {
			album.setName(NewAlbumName);
			return 0;
		}	
		
	}

    /**
	 * Get a Album by Name
	 * @author Susan Hague
	 * @param AlbumName	Name of album 
	 * 
	 * @return	Album object
	 */
	private Album getAlbumByName(String AlbumName) {
		
		 Iterator<Album> iterator = this.albumList.iterator();
		 Album album = null;
		 
		 while(iterator.hasNext()) {
			 Album curr_album = iterator.next();
			 if (curr_album.getName().equalsIgnoreCase(AlbumName))
				 album = curr_album;
		 }
		 
		 return album;
	}
}
