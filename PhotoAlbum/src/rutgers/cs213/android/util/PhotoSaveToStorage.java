package rutgers.cs213.android.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.os.Environment;

public class PhotoSaveToStorage {

	public PhotoSaveToStorage() {
		
	}
	
	public int Save(Bitmap bitmap, String directory, String file) {
		
		FileOutputStream file_stream = null;
		
		try {
				String file_name = Environment.getExternalStorageDirectory().getAbsolutePath() + directory + "/" + file;
				File bitmap_file = new File(file_name);
				if (!bitmap_file.isFile()) {
					File bitmap_dir = new File(directory);
					if (!bitmap_dir.exists())
						bitmap_dir.mkdir();
				}
				file_stream = new FileOutputStream(bitmap_file);
				bitmap.compress(Bitmap.CompressFormat.JPEG, 80, file_stream);
                file_stream.flush();
                file_stream.close();
			 return 0;
		 }
		 catch (IOException ex) {
			return 1;
		 }
	}
}
