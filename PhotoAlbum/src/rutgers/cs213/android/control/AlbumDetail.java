package rutgers.cs213.android.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import rutgers.cs213.android.model.Album;
import rutgers.cs213.android.model.Photo;

/**
 * @author Susan Hague
 */
public class AlbumDetail {
	/** Provides Album Detail ready for display  
	 * 
	 * @author Susan Hague
	 */
	private String name;
	private ArrayList<Photo> photoList;
	private int photo_count;
	private String start_date;
	private String end_date;
	
	/** 
	 * Constructor for AlbumDetail(Album album)
	 * @author Susan Hague
	 * @param Album		Album to create Album Detail from
	 * 
	 */
	public AlbumDetail (Album album) {
		this.name = album.getName();
		this.photoList = album.GetPhotoList();
		this.photo_count = album.GetPhotoCount();
		SimpleDateFormat dateformatter = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
		Calendar StartDate = album.GetStartDate();
		Calendar EndDate = album.GetEndDate();
		if (StartDate != null)
			this.start_date = dateformatter.format(StartDate.getTime());
		if (EndDate != null)
		this.end_date = dateformatter.format(EndDate.getTime());
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
	 * Number of Photos in Album
	 * @author Susan Hague
	 * @return		int Photo count
	 */
	public int GetPhotoCount() {
		return this.photo_count;
	}
	
	/**
	 * Get Start (oldest) date of photos 
	 * @author Susan Hague
	 * @return		String date formatted for output;
	 */
	public String GetStartDate() {
		
		return this.start_date;
	}
	
	/**
	 * Get End (newest) date of photos 
	 * @author Susan Hague
	 * @return		String date formatted for output;
	 */
    public String GetEndDate() {
		
		return this.end_date;
	}
    
    /**
	 * Get list of photo objects
	 * @author Susan Hague
	 * @return		ArrayList of Photo;
	 */
    public ArrayList<Photo> GetPhotos() {
    	
    	return this.photoList;
    }
    
    
}