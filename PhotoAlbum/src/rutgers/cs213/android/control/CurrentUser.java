package rutgers.cs213.android.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import rutgers.cs213.android.model.Album;
import rutgers.cs213.android.model.Photo;
import rutgers.cs213.android.model.Tag;
import rutgers.cs213.android.model.User;
import rutgers.cs213.android.model.Backend;

/**
 * @author Brian Battell
 */
public class CurrentUser {
	/** Provides Interface to PhotoAlbum data  
	 * 
	 * 
	 */
	private User user;
	
	/**
	 * Constructor CurrentUser 
	 * @author Brian Battell
	 * @param		String UserId to be used for current session;
	 */
	public CurrentUser(String UserId) {
		
		Backend storage = new Backend();
        this.user = storage.ReadUser(UserId);
	}

	/**
	 * User object
	 * @author Brian Battell
	 * @return		User object	
	 */
	public User GetUser() {
		return this.user;
	}
	
	/**
	 * Album object from Name
	 * @author Brian Battell
	 * @param AlbumName
	 *
	 * @return		Album object			
	 */
	public Album GetAlbum(String AlbumName) {
		
		Album album = this.user.GetAlbum(AlbumName);
		return album;
		
	}
	
	/**
	 * Add an Album to User
	 * @author Brian Battell
	 * @param AlbumName		Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 5 (album already exists)
	 */
	public int AddAlbum(String AlbumName) {
		
		Album album = this.user.GetAlbum(AlbumName);;
		if (album == null) {
			this.user.AddAlbum(AlbumName);
			return 0;
		}	
		else {
			return 5;
		}
	}
	
	/**
	 * Delete an Album from User
	 * @author Brian Battell
	 * @param AlbumName 	Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 6 (album does not exist)
	 */
	public int DeleteAlbum(String AlbumName) {
		
		Album album = this.user.GetAlbum(AlbumName);
		if (album == null) {
			return 6;
		}
		else {
			this.user.DeleteAlbum(AlbumName);
			return 0;
		}
	}
	
	/**
	 * Rename an Album
	 * @author Brian Battell
	 * @param AlbumName 	Name of album
	 * 
	 * @return	int			Error 0 = no error (success) or 6 (album does not exist)
	 */
	public int RenameAlbum(String AlbumName, String NewAlbumName) {
		
		Album album = this.user.GetAlbum(AlbumName);
		if (album == null) {
			return 6;
		}
		else {
			album.setName(NewAlbumName);
			return 0;
		}
	}
	
	/**
	 * Add an Photo to Album
	 * @author Brian Battell
	 * @param FileName		Name of photo
	 * @param Caption		Caption of photo
	 * @param AlbumName		Name of Album
	 * 
	 * @return	int		Error 0 = no error (success) or 6 (album does not exist)
	 */
	public int AddPhotoToAlbum(String FileName, String Caption, String AlbumName) {
		
		Album album = this.user.GetAlbum(AlbumName);
		if (album != null) {
			Photo photo = GetPhoto(FileName);
			if (photo != null)
				Caption = photo.getCaption();
			return album.AddPhotoToAlbum(FileName, Caption);
		}
		else
			return 6;
	}
	
	/**
	 * Move Photo from one Album to another
	 * @author Brian Battell
	 * @param FileName		Name of photo
	 * @param OldAlbumName	Name of album to move from
	 * @param NewAlbumName	Name of album to move to
	 * 
	 * @return	int		Error 0 = no error (success), 6 (album does not exist) or 12 (photo does not exist)
	 */
	public int MoveFromAlbumToAlbum(String FileName, String OldAlbumName, String NewAlbumName) {
		
		Photo photo = this.GetPhoto(FileName);
		if (photo == null)
			return 12;
		
		Album oldalbum = this.user.GetAlbum(OldAlbumName);
		if (oldalbum == null)
			return 6;
		
	    Album newalbum = this.user.GetAlbum(NewAlbumName);
		if (newalbum == null)
			return 6;
		
		int err = newalbum.AddPhotoToAlbum(FileName, photo.getCaption());
		if (err == 0) {
			err = oldalbum.RemovePhotoFromAlbum(FileName);
			return err;
		}
		else
			return err;
	}
	
	/**
	 * Remove a Photo from an Album
	 * @author Brian Battell
	 * @param FileName		Name of photo
	 * @param AlbumName		Name of Album
	 * 
	 * @return	int		Error 0 = no error (success) or 6 (album does not exist)
	 */
	public int RemovePhotoFromAlbum(String FileName, String AlbumName) {
		Album album = this.user.GetAlbum(AlbumName);
		if (album == null)
			return 6;
		else {
			return album.RemovePhotoFromAlbum(FileName);
		}
	}
    
	/**
	 * Change Photo Caption
	 * @author Brian Battell
	 * @param FileName		Name of photo
	 * @param Caption		New Caption
	 * 
	 * @return	int		Error 0 = no error (success) or 12 (photo does not exist)
	 */
	public int ChangePhotoCaption(String FileName, String Caption) {
		Photo photo = GetPhoto(FileName);
		if (photo != null) {
			return photo.changeCaption(Caption);
		}
		else
			return 12;
	}
	
	/**
	 * Add a Tag to Photo
	 * @author Brian Battell
	 * @param FileName		Name of photo
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 12 (photo does not exist)
	 */
	public int AddTagToPhoto(String FileName, String TagType, String TagValue) {
		Photo photo = GetPhoto(FileName);
		if (photo != null) {
			return photo.addTag(TagType, TagValue);
		}
		else
			return 12;
	}
	
	/**
	 * Remove a Tag from Photo
	 * @author Brian Battell
	 * @param FileName		Name of photo
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 12 (photo does not exist)
	 */
	public int RemoveTagFromPhoto(String FileName, String TagType, String TagValue) {
		Photo photo = GetPhoto(FileName);
		if (photo != null) {
			return photo.removeTag(TagType, TagValue);
		}
		else
			return 12;
	}
	
	/**
	 * List of AlbumDetails (formated for display)
	 *
	 * @author Brian Battell
	 * @return	ArrayList of AlbumDetails for user
	 */
	public ArrayList<AlbumDetail> GetAlbumDetails() {
		
		ArrayList<AlbumDetail> details = new ArrayList<AlbumDetail>();
		ArrayList<Album> albums = this.user.getAlbums();
		Iterator<Album> iterator = albums.iterator();
		
		while(iterator.hasNext()) {
			Album curr_album = iterator.next();
			details.add(new AlbumDetail(curr_album));
		}
		return details;
	}
	
	/**
	 * PhotoDetail for a photo (formatted for display)
	 * @author Brian Battell
	 * @param FileName		Name of photo
	 * 
	 * @return	PhotoDetail	object
	 */
	public PhotoDetail GetPhotoDetails(String PhotoFileName) {
		
		PhotoDetail detail = null;
        ArrayList<Album> albums = this.user.getAlbums();
        ArrayList<String> albumNames = new ArrayList<String>();
        Iterator<Album> iterator = albums.iterator();
        Photo photo = null;
        
        while(iterator.hasNext()) {
                Album curr_album = iterator.next();
                ArrayList<Photo> photos = curr_album.GetPhotoList();
                Iterator<Photo> iter_photo = photos.iterator();
                while(iter_photo.hasNext()) {
                        Photo curr_photo = iter_photo.next();
                        if (curr_photo.getFileName().equalsIgnoreCase(PhotoFileName)) {
                                albumNames.add(curr_album.getName());
                                photo = curr_photo;
                        }
                                
                }
        }
        
        if (photo != null)
                detail = new PhotoDetail(photo, albumNames);
        
        return detail;
	}
	
	/**
	 * List of PhotoDetails (formated for display) for Album
	 * @author Brian Battell
	 * @param AlbumName	Name of Album 
	 * 
	 * @return	ArrayList of PhotoDetails for Album
	 */
	
	public ArrayList<PhotoDetail> GetPhotoDetailsByAlbum(String AlbumName) {
        
        ArrayList<PhotoDetail> details = new ArrayList<PhotoDetail>();
        Album album = this.user.GetAlbum(AlbumName);
        ArrayList<String> albumNames = new ArrayList<String>();
        
        if (album == null)
                return details;
        
        albumNames.add(AlbumName);
        ArrayList<Photo> photos = album.GetPhotoList();
        Iterator<Photo> iterator = photos.iterator();
        
        while(iterator.hasNext()) {
                Photo curr_photo = iterator.next();
                details.add(new PhotoDetail(curr_photo, albumNames));
        }
        
        return details;
}

	/**
	 * List of PhotoDetails (formated for display) for Date Range
	 * @author Brian Battell
	 * @param StartDate	Oldest (first) date to filter list by	 
	 * @param EndDate Newest (last) date to filter list by	
	 * 
	 * @return	ArrayList of PhotoDetails by Date
	 */
	
	public ArrayList<PhotoDetail> GetPhotoDetailsByDate(Date StartDate, Date EndDate) {
        
        ArrayList<PhotoDetail> details = new ArrayList<PhotoDetail>();
        ArrayList<Photo> photos = getAllPhotos();
        Iterator<Photo> iterator = photos.iterator();
        
        while(iterator.hasNext()) {
                Photo curr_photo = iterator.next();
                boolean ok = true;
                if (((curr_photo.getCreated().getTime().after(EndDate)) || (curr_photo.getCreated().getTime().before(StartDate))))
                     ok = false;
                if (ok)
                	 details.add(new PhotoDetail(curr_photo, getAlbums(curr_photo)));
        }
        return details;
}

	/**
	 * List of PhotoDetails (formated for display) for selected Tags
	 * @author Brian Battell
	 * @param Tags	Array of Tag objects (Tag Type/Tag Value pairs)	 
	 * 
	 * @return	ArrayList of PhotoDetails filtered by Tag
	 */
	public ArrayList<PhotoDetail> GetPhotoDetailsByTag(Tag[] tags) {
        
		ArrayList<PhotoDetail> details = new ArrayList<PhotoDetail>();
        ArrayList<Photo> photos = getAllPhotos();
        Iterator<Photo> iterator = photos.iterator();
        
        while(iterator.hasNext()) {
            Photo curr_photo = iterator.next();
            for(int i = 0; i < tags.length; i++) {
            	Tag curr_tag = (Tag)tags[i];
            	Tag has_tag = curr_photo.getTag(curr_tag.getTagType(), curr_tag.getTagValue());
            	if (has_tag != null) {           
                    details.add(new PhotoDetail(curr_photo, getAlbums(curr_photo)));
                    break;
            	}
            }
        }
        return details;
	}	


 	 /**
	 * Get a Photo by Name
	 * @author Brian Battell
	 * @param PhotoFileName	Name of photo 
	 * 
	 * @return	Photo object
	 */
	private Photo GetPhoto(String PhotoFileName) {
		
		Photo photo = null;
		ArrayList<Album> albums = this.user.getAlbums();
		Iterator<Album> iterator = albums.iterator();
		
		while(iterator.hasNext()) {
			Album curr_album = iterator.next();
			ArrayList<Photo> photos = curr_album.GetPhotoList();
			Iterator<Photo> iter_photo = photos.iterator();
			while(iter_photo.hasNext()) {
				Photo curr_photo = iter_photo.next();
				if (curr_photo.getFileName().equalsIgnoreCase(PhotoFileName))
					photo = curr_photo;
			}
		}
		return photo;
	}
	
	private ArrayList<String> getAlbums(Photo photo) {
		
		ArrayList<Album> albums = this.user.getAlbums();
        Iterator<Album> iterator = albums.iterator();
        ArrayList<String> albumNames = new ArrayList<String>();
        
        while(iterator.hasNext()) {
            Album curr_album = iterator.next();
            ArrayList<Photo> photos = curr_album.GetPhotoList();
            Iterator<Photo> iter_photo = photos.iterator();
            while(iter_photo.hasNext()) {
                    Photo curr_photo = iter_photo.next();
                    if (photo.equals(curr_photo)) {
                    	albumNames.add(curr_album.getName());
                    	break;
                    }
            }
    	}
        return albumNames;
	}
	
	private ArrayList<Photo> getAllPhotos() {
		
		ArrayList<Album> albums = this.user.getAlbums();
        Iterator<Album> iterator = albums.iterator();
        ArrayList<Photo> photoList = new ArrayList<Photo>();
        
        while(iterator.hasNext()) {
            Album curr_album = iterator.next();
            ArrayList<Photo> photos = curr_album.GetPhotoList();
            Iterator<Photo> iter_photo = photos.iterator();
            while(iter_photo.hasNext()) {
                Photo curr_photo = iter_photo.next();
                if (!photoList.contains(curr_photo)) {
                	photoList.add(curr_photo);
                }
            }
    	}
        return photoList;
	}

}
