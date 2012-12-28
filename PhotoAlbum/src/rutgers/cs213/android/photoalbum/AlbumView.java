package rutgers.cs213.android.photoalbum;

import java.util.ArrayList;
import java.util.Iterator;

import rutgers.cs213.android.control.AlbumDetail;
import rutgers.cs213.android.control.CurrentUser;
import rutgers.cs213.android.model.User;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AlbumView extends Activity {
	// TO DO find out where to check if the List in empty. Already in the xml form.id:empty
	// Create a Listener for the Album List and add Context menu to it so it opens the menu
	private String selectedItem;
	AlertDialog.Builder builder;
	AlertDialog alert;
	
	final int CONTEXT_MENU_EDIT_ALBUM_NAME = 0;
	final int CONTEXT_MENU_DELETE = 1;
	final int CONTEXT_MENU_OPEN = 2;
	final int CONTEXT_MENU_CREATE_ALBUM = 3;
	final int CONTEXT_MENU_TAKE_A_PICTURE = 4;
	final int CONTEXT_MENU_SEARCH = 5;
	
	Object[][] data = getData(User);

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.album_view);
		
		ListView lv = (ListView)findViewById(R.id.Album_label);
		//Get Albums list from Albums
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.album_view,getData(User)));
		lv.setAdapter(adapter);
		lv.setTextFilterEnabled(true);
		registerForContextMenu(lv);
		
	}
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
		if(v.getId()==R.id.Album_label){
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
			menu.setHeaderTitle(arg0); //Get Header from Albums
			String[] menuItems = getResources().getStringArray(R.array.menu);
			for (int i = 0; i<menuItems.length; i++){
				menu.add(Menu.NONE, i ,i, menuItems[i]);
			}
		}
	}
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		switch (item.getItemId()){
		case CONTEXT_MENU_EDIT_ALBUM_NAME:
			//add Edit album name functionality
			
			
			
			
			return(true);
		case CONTEXT_MENU_DELETE:
			//Add Delete Album functionality
			//Add an Alert dialog with "are you sure" yes and no
			return (true);
		case CONTEXT_MENU_OPEN:
			//Add Open Album functionality
			//Go to the PhotoView Activity
			Intent PhotoIntent = new Intent(AlbumView.this, PhotosView.class);
			AlbumView.this.startActivity(PhotoIntent);
			// to Pass information use ---> PhotoIntent.putExtra(name, value);
			return(true);
		case CONTEXT_MENU_CREATE_ALBUM:
			//Add create Album functionality
			//add a Dialog box with a text box as well as a confirm and cancel buttons
			return(true);
		case CONTEXT_MENU_TAKE_A_PICTURE:
			//add taking a picture functionality
			//Goes to an internal activity which can be called.
		case CONTEXT_MENU_SEARCH:
			//Add Search Functionality
			//Sends the user to the Search Activity
			return(true);
		}
	return(super.onOptionsItemSelected(item));
		
	}
	 private Object[][] getData(CurrentUser User) {
         Object[][] data = null;
         
         ArrayList<AlbumDetail> albums = User.GetAlbumDetails();

         if (!albums.isEmpty()) {
                 int count = albums.size();
                 data = new Object[count][];
                 int i = 0;
                 Iterator<AlbumDetail> iterator = albums.iterator();
                 while (iterator.hasNext()) {
                         AlbumDetail album = iterator.next();
                         Object[] row = {album.getName(), album.getName(), album.GetPhotoCount(), album.GetStartDate(), album.GetEndDate()};
                 data[i++] = row;
                 }
         }
         return data;
 }
 


}
