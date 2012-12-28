package rutgers.cs213.android.util;

/**
 * @author Brian Battell
 *
 */
public class PhotoAlbumError {
	
	/** Provides translation of Error Codes used in the Photo Album
	 * 
	 * 
	 */
	public static String getErrorMsg(int ErrorCode) {
		String ErrorMsg;
		
		switch (ErrorCode) {
		case 0: ErrorMsg = "";
				break;
        case 1: ErrorMsg = "Unable to save data to disk";
                 break;
        case 2:  ErrorMsg = "User does not exist";
                 break;
        case 3:  ErrorMsg = "File does not exist";
                 break;
        case 4:  ErrorMsg = "File could not be deleted";
                 break;
        case 5:  ErrorMsg = "Album already exists";
                 break;
        case 6:  ErrorMsg = "Album does not exist";
                 break;
        case 7:  ErrorMsg = "User already exists";
                 break;
        case 8:  ErrorMsg = "Tag already exists";
                 break;
        case 9:  ErrorMsg = "Tag does not exist";
                 break;
        case 10: ErrorMsg = "Photo already in album";
                 break;
        case 11: ErrorMsg = "Photo not in album";
                 break;
        case 12: ErrorMsg = "Photo does not exist";
                 break;
        default: ErrorMsg = "Unknown Error";
                 break;
		}
		return ErrorMsg;
	}
}
