package rutgers.cs213.android.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;


/**
 * @author Susan Hague
 *
 */
public class Photo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Photo Storage object 
	 * 
	 * 
	 */
	private String fileName;
	private String caption;
	private Calendar created;
	private ArrayList<Tag> tagList;
	
	/** 
	 * Constructor for Photo
	 * @author Susan Hague
	 * @param Name		Photo name
	 * @param Caption	Photo caption
	 * 
	 */
	public Photo(String FileName, String Caption) {
		
		this.fileName = FileName;
		this.caption = Caption;
		this.created = getFileDateTime(FileName);
		this.created.set(Calendar.MILLISECOND,0);
		this.tagList = new ArrayList<Tag>();
	}
	
	/** 
	 * Constructor for Photo
	 * @author Susan Hague
	 * @param Name		Photo name
	 * @param Caption	Photo caption
	 * @param Tags		ArrayList of Tag objects
	 * 
	 */
	public Photo(String FileName, String Caption, ArrayList<Tag> Tags) {
		
		this.fileName = FileName;
		this.caption = Caption;
		this.created = getFileDateTime(FileName);
		this.created.set(Calendar.MILLISECOND,0);
		this.tagList = Tags;
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
	 * Name of the Photo 
	 * @author Susan Hague
	 * @param	String	Photo name	
	 */
	public void setFileName (String FileName) {
        this.fileName = FileName;
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
	 * Caption of photo 
	 * @author Susan Hague
	 * @param	String	Caption	
	 */
	public void setCaption (String Caption) {
        this.caption = Caption;
    }
	
	/**
	 * Date of photo (from file)
	 * @author Susan Hague
	 * @return	Calendar date	
	 */
	public Calendar getCreated () {
        return this.created;
    }
	
	/**
	 * Add a Tag to Photo
	 * @author Susan Hague
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 8 (tag already exists)
	 */
	public int addTag(String Type, String Value) {
		if (getTagByNameValuePair(Type,Value) == null) {
			Tag tag = new Tag(Type, Value);
			this.tagList.add(tag);
			return 0;
		}
		else {
			return 8;
		}	
	}
	
	/**
	 * Remove a Tag from Photo
	 * @author Susan Hague
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	int		Error 0 = no error (success) or 9 (tag doesn't exist)
	 */
	public int removeTag(String Type, String Value) {
		Tag tag = getTagByNameValuePair(Type,Value);
		if (tag == null) 
			return 9;
		else {
				this.tagList.remove(tag);
				return 0;
		}
	}
	
	/**
	 * Get Tag from Photo
	 * @author Susan Hague
	 * @param TagType		Type of tag (location, person or other)
	 * @param TagValue		Data associated with tag
	 * 
	 * @return	Tag			Tag object
	 */
	public Tag getTag(String Type, String Value) {
		Tag tag = getTagByNameValuePair(Type,Value);
		return tag;
	}
	
	public ArrayList<Tag> getTags() {
		return this.tagList;
	}
	
	/**
	 * Change Caption of Photo
	 * @author Susan Hague
	 * @param String  Caption
	 * 
	 * @return	int		Error 0 = no error (success)
	 */
	public int changeCaption(String Caption) {
		this.caption = Caption;
		return 0;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.fileName != null ? this.fileName.hashCode() : 0);
        hash = 97 * hash + (this.caption != null ? this.caption.hashCode() : 0);
        hash = 97 * hash + (this.created != null ? this.created.hashCode() : 0);
        hash = 97 * hash + (this.tagList != null ? this.tagList.hashCode() : 0);
        return hash;
    }
	
	/**
	 * Get equality of Photo objects
	 * @author Susan Hague
	 * @return	 boolean;
	 */
    @Override
	public boolean equals(Object obj) {
            if (!(obj instanceof Photo))
                return false;
            Photo photo = (Photo)obj;
            if (photo.fileName.equals(this.fileName) &&
                    photo.caption.equals(this.caption) &&
                    photo.created.equals(this.created) &&
                    photo.tagList.equals(this.tagList))
                            return true;
            else
                    return false;
        }
	
	private Tag getTagByNameValuePair(String TagType, String TagValue) {
		 Iterator<Tag> iterator = this.tagList.iterator();
		 Tag tag = null;
		 
		 while(iterator.hasNext()) {
			 Tag curr_tag = iterator.next();
			 if (TagType.equals("") && curr_tag.getTagValue().equalsIgnoreCase(TagValue))
				 tag = curr_tag;	 
			 else if (curr_tag.getTagType().equalsIgnoreCase(TagType) && curr_tag.getTagValue().equalsIgnoreCase(TagValue))
				 tag = curr_tag;
		 }
		 
		 return tag;
	}

	private Calendar getFileDateTime(String FileName) {
		Calendar FileDate = Calendar.getInstance();
	    File photo_file = new File(FileName);
	    if (photo_file.exists()) {
	    	long milliseconds = photo_file.lastModified();
	    	FileDate.setTimeInMillis(milliseconds);
	    }
	    return FileDate;
	}

}
