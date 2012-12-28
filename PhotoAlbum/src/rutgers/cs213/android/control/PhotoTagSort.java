package rutgers.cs213.android.control;

import java.util.Comparator;
import rutgers.cs213.android.model.Tag;

/**
 * @author Brian Battell
 * @author Susan Hague
 *
 */
public class PhotoTagSort implements Comparator<Tag> {
	/**
	 * Compares Tags based on Type and Value
	 *
	 * @param tag1		Tag object to compare	 
	 * @param tag2		Tag object to compare
	 * 
	 * @return	int		value of comparison
	 */
	 @Override
	public int compare(Tag tag1, Tag tag2) {
		
		int result = 0;
		
		if (tag1.getTagType().equalsIgnoreCase("location")) {
			if (tag2.getTagType().equalsIgnoreCase("location")) {
				result = tag1.getTagValue().compareTo(tag1.getTagValue());
			}
			else {
				result = -1;
			}
		}
		else if (tag1.getTagType().equalsIgnoreCase("people")) {
			if (tag2.getTagType().equalsIgnoreCase("location")) {
				result = 1;
			}
			else if (tag2.getTagType().equalsIgnoreCase("people")) {
				result = tag1.getTagValue().compareTo(tag1.getTagValue());
			}
			else {
				result = -1;
			}
		}
		else {
			if (tag2.getTagType().equalsIgnoreCase("location") || tag2.getTagType().equalsIgnoreCase("people"))
				result = 1;
			else {
				int temp_result = tag1.getTagType().compareTo(tag1.getTagType());
				if (temp_result == 0) {
					result = tag1.getTagValue().compareTo(tag1.getTagValue());
				}
				else
					result = temp_result;
			}
		}
		
		return result;
		
	}
}
