package rutgers.cs213.android.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import rutgers.cs213.android.model.Photo;
import rutgers.cs213.android.model.Tag;

/**
 * @author Susan Hague
 *
 */
public class PhotoDetail {
	/** Provides Photo Detail ready for display  
	 * 
	 * 
	 */
	private String fileName;
	private String caption;
	private Calendar created;
	private String date;
	private ArrayList<Tag> tagList;
	private ArrayList<String> albumNameList;
	
	/** 
	 * Constructor for PhotoDetail
	 * @author Susan Hague
	 * @param Photo		Photo to create PhotoDetail from
	 * @param AlbumName	Name of album photo is in (can by more than one)
	 * 
	 */
	public PhotoDetail(Photo photo, ArrayList<String> AlbumNameList) {
        
        this.fileName = photo.getFileName();
        this.caption = photo.getCaption();
        this.created = photo.getCreated();
        this.tagList = photo.getTags();
        this.albumNameList = AlbumNameList;
        SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
        this.date = dateformatter.format(this.created.getTime());
}
	
	/**
	 * Name of the Photo 
	 * @author Susan Hague
	 * @return	String	Photo name	
	 */
	public String getFileName () {
        return this.fileName;
    }
	
	/**
	 * Name of the Album 
	 * @author Susan Hague
	 * @return	String	Album name	
	 */
	 public ArrayList<String> getAlbumList () {
	        return this.albumNameList;
	    }
	
	/**
	 * Caption of photo 
	 * @author Susan Hague
	 * @return	String	Caption	
	 */
	public String getCaption () {
        return this.caption;
    }
	
	/**
	 * Date of the photo 
	 * @author Susan Hague
	 * @return	String Date in output format	
	 */
	public String getDate () {
        return this.date;
    }
	
	/**
	 * Date of the photo 
	 * @author Susan Hague
	 * @return	Calendar date of photo	
	 */
	public Calendar getCreated () {
        return this.created;
    }
	
	/**
	 * List of Tags for photo 
	 * @author Susan Hague
	 * @return	ArrayList of Tag objects	
	 */
	public ArrayList<Tag> getTags() {
		Collections.sort(this.tagList, new PhotoTagSort());
		return this.tagList;
	}
	

}
