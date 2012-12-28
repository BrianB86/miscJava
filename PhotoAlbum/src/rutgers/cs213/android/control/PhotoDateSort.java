package rutgers.cs213.android.control;

import java.util.Comparator;
import rutgers.cs213.android.model.Photo;

/**
 * @author Susan Hague
 *
 */
public class PhotoDateSort implements Comparator<Photo> {
	/**
	 * Compares Photos based on date
	 * @author Susan Hague
	 * @param photo1	Photo object to compare	 
	 * @param photo2	Photo object to compare
	 * 
	 * @return	int		value of comparison
	 */
	public int compare(Photo photo1, Photo photo2) {
		
		if (photo1.getCreated().before(photo2.getCreated()))
			return -1;
		else {
			if (photo1.getCreated().after(photo2.getCreated()))
				return 1;
			else
				return 0;
		}
	}	
}
