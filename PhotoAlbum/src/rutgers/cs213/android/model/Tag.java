package rutgers.cs213.android.model;

import java.io.Serializable;

/**
 * @author Susan Hague
 *
 */
public class Tag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Tag Storage object 
	 * 
	 * 
	 */
	private String type;
	private String value;
	
	/** 
	 * Constructor for Tag
	 * @author Susan Hague
	 * @param Type		Type of tag
	 * @param Caption	Value of tag (data for)
	 * 
	 */
	public Tag(String Type, String Value){
	
		this.type = Type;
		this.value = Value;
	}
	
	public String getTagType () {
        return this.type;
    }
	
	public String getTagValue () {
        return this.value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 83 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }
	
	/**
	 * Get equality of Tag objects
	 * @author Susan Hague
	 * @return	 boolean;
	 */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tag))
            return false; 
        Tag tag = (Tag)obj;
    	if (tag.type.equals(this.type) &&
    		tag.value.equals(this.value)) 
    			return true;
    	else
    		return false;
    }
	
}
