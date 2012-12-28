package rutgers.cs213.android.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;


/**
 * @author Susan Hague
 *
 */
public class Album implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Album Storage object 
	 * 
	 * 
	 */
	private String name;
	private ArrayList<Photo> photoList;
	
	/** 
	 * Constructor for Album
	 * @author Susan Hague
	 * @param Name		Album name
	 * 
	 */
	public Album (String Name) {
		this.name = Name;
                this.photoList = new ArrayList<Photo>();
	}
	/** 
	 * Constructor for Album
	 * @author Susan Hague
	 * @param Name		Album name
	 * @param Photos	List of photos
	 * 
	 */
	public Album (String Name, ArrayList<Photo> Photos) {
		
		this.name = Name;
		this.photoList = Photos;
	}
	
	/**
	 * Name of the Album 
	 * @author Susan Hague
	 * @return	String	Album name	
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Name of the Album 
	 * @author Susan Hague
	 * @param	String	Album name	
	 */
	public void setName(String AlbumName) {
		this.name = AlbumName;
	}
	
	/**
	 * Add an Photo to Album
	 * @author Susan Hague
	 * @param FileName		Name of photo
	 * @param Caption		Caption of photo
	 * 
	 * @return	int		Error 0 = no error (success) or 10 (photo does not exist)
	 */
	public int AddPhotoToAlbum(String FileName, String Caption) {
		if (getPhotoByName(FileName) == null) {
		    File photo_file = new File(FileName);
		    if (photo_file.exists()) {
		    	Photo photo = new Photo(FileName,Caption);
		    	this.photoList.add(photo);
		    	return 0;
		    }
		    else {
		    	return 3;
		    }
		}
		else
			return 10;
	}
	
	/**
	 * Remove a Photo from an Album
	 * @author Susan Hague
	 * @param FileName		Name of photo
	 * 
	 * @return	int		Error 0 = no error (success) or 11 (photo does not exist)
	 */
	public int RemovePhotoFromAlbum(String FileName) {
		Photo photo = getPhotoByName(FileName);
		if (photo == null)
			return 11;
		else {
			this.photoList.remove(photo);
			return 0;
		}
	}
	
	/**
	 * Gets a Photo from an Album
	 * @author Susan Hague
	 * @param FileName		Name of photo
	 * 
	 * @return	Photo		Photo object
	 */
	public Photo GetPhotoFromAlbum(String FileName) {
		Photo photo = getPhotoByName(FileName);
		return photo;
	}
	
	/**
	 * Change Caption of a photo
	 * @author Susan Hague
	 * @param FileName		Name of photo
	 * @param Caption		New caption of photo
	 * 
	 * @return	int		Error 0 = no error (success) or 12 (photo does not exist)
	 */
	public int RecaptionPhoto(String FileName, String NewCaption) {
		Photo photo = getPhotoByName(FileName);
		if (photo == null)
			return 12;
		else {
			photo.setCaption(NewCaption);
			return 0;
		}
	}
	
	/**
	 * Total number of Photos for an Album
	 * @author Susan Hague
	 * @return	int		count of photos
	 */
	public int GetPhotoCount() {
		
		return this.photoList.size();
	}
	
	/**
	 * Start date of Photos
	 * @author Susan Hague
	 * @return	Calendar	Oldest (first) Calendar of photos
	 */
	public Calendar GetStartDate() {
		
		Calendar date = null;
		Iterator<Photo> iterator = this.photoList.iterator();
		 
		while(iterator.hasNext()) {
			 Photo curr_photo = iterator.next();
			 Calendar curr_date = curr_photo.getCreated();
			 if (date == null)
				 date = curr_date;
			 else {
				 if (curr_date.before(date)) {
					 date = curr_date;
				 }
			 }
		}
		
		return date;
	}
	
	/**
	 * End date of Photos
	 * @author Susan Hague
	 * @return	Calendar	Newest (last) Calendar of photos
	 */
    public Calendar GetEndDate() {
		
		Calendar date = null;
		
		Iterator<Photo> iterator = this.photoList.iterator();
		 
		while(iterator.hasNext()) {
			 Photo curr_photo = iterator.next();
			 Calendar curr_date = curr_photo.getCreated();
			 if (date == null) {
				 date = Calendar.getInstance();
				 date.setTimeInMillis(curr_date.getTimeInMillis());
			 }
			 else {
				 if (curr_date.after(date))
					 date = curr_date;;
			 }
		}
		
		return date;
	}
    
    /**
	 * List of Photos
	 * @author Susan Hague
	 * @return	ArrayList	Photo objects
	 */
    public ArrayList<Photo> GetPhotoList() {
		
		Iterator<Photo> iterator = this.photoList.iterator();
		ArrayList<Photo> photos = new ArrayList<Photo>();
		 
		 while(iterator.hasNext()) {
			 Photo curr_photo = iterator.next();
			 photos.add(curr_photo);
		 }
		 
		 return photos;
		
	}

    /**
	 * Get Photo by name
	 * @author Susan Hague
	 * @param PhotoName	Name of photo
	 * @return Photo	Photo object
	 */
	private Photo getPhotoByName(String PhotoName) {
		 Iterator<Photo> iterator = this.photoList.iterator();
		 Photo photo = null;
		 
		 while(iterator.hasNext()) {
			 Photo curr_photo = iterator.next();
			 if (curr_photo.getFileName().equalsIgnoreCase(PhotoName))
				 photo = curr_photo;
		 }
		 
		 return photo;
	}
	
	/**
	 * Get equality of Album objects
	 * @author Susan Hague
	 * @return	 boolean;
	 */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Album))
            return false;  
        Album album = (Album)obj;
    	if (album.name.equals(this.name) &&
    		album.photoList.equals(this.photoList)) 
    			return true;
    	else
    		return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.photoList != null ? this.photoList.hashCode() : 0);
        return hash;
    }
}