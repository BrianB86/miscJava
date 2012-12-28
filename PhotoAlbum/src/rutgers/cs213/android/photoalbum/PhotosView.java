package rutgers.cs213.android.photoalbum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
// TO DO get Intent stuff working
// Fix action listener and implement switch case
// Fill in all appropriate areas
public class PhotosView extends Activity {
	private Gallery photoGallery;
	private ImageView photoView;
	final int CONTEXT_MENU_EDIT_PHOTO = 0;
	final int CONTEXT_MENU_DELETE = 1;
	final int CONTEXT_MENU_ADD_PHOTO = 2;
	final int CONTEXT_MENU_TAKE_A_PICTURE = 3;
	final int CONTEXT_MENU_SEARCH = 4;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		//Intent intent = getIntent();
		//if it is a string you stored use 
		//this to get it from AlbumView ----> String value = intent.getStringExtra(name);
		//add any more intent stuff here I will continue as if it was stand alone Activity.
		

		super.onCreate(savedInstanceState);
			
		setContentView(R.layout.photos);
		
		photoView = (ImageView)findViewById(R.id.PhotoViewer);
		photoView.setImageResource();//put Photos<---(here);
		
		photoGallery = (Gallery)findViewById(R.id.PhotoGallery);
		photoGallery.setAdapter(new AddPhotoAdp(this));
		
		public void onCreateContextMenu(ContextMenu photomenu, View v, ContextMenuInfo menuInfo){
			if(v.getId()==R.id.Photo_label){
				AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
				photomenu.setHeaderTitle(arg0); //Get Header from Albums
				String[] menuItems = getResources().getStringArray(R.array.photomenu);
				for (int i = 0; i<menuItems.length; i++){
					photomenu.add(Menu.NONE, i ,i, menuItems[i]);
				}
			}
		}
			//Should change to Long click listener since one click will display a bigger view of the image and a long click should display the menu.
		photoGallery.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView parent, View v, int position,long id){
				photoView.setImageResource(); //put Photo's Position<---(here);
				
				
		
			}
		});
	
		}
	
	
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		switch (item.getItemId()){
		case CONTEXT_MENU_EDIT_PHOTO:
			//add Edit Photo tags functionality
			//add a Dialog box with a text box as well as a confirm and cancel buttons
			return(true);
		case CONTEXT_MENU_DELETE:
			//Add Delete Photo functionality
			//Add an Alert dialog with "are you sure" yes and no
			return (true);
		case CONTEXT_MENU_ADD_PHOTO:
			//Add Add Photo functionality
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
	
	public class AddPhotoAdp extends BaseAdapter{
		int GalleryPhotoBag;
		private Context cont;
		
		public AddPhotoAdp(Context c){
			cont = c;
			
			TypedArray typeArray = obtainStyledAttributes(R.styleable.Gallery1);
			GalleryPhotoBag = typeArray.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 1);
			
			typeArray.recycle();
			
		}
		
		public int getCount(){
			return //The number of Photos
		}
		
		public Object getItem(int position){
			return position; //gets the position of the Photo
		}
		
		public long getItemId(int position){
			return position; //gets the position of the Photo's Id
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			ImageView photoView = new ImageView(cont);
			
			photoView.setImageResource(); //<-- return the Photo's position
			photoView.setLayoutParams(new Gallery.LayoutParams(80,70));
			photoView.setScaleType(ImageView.ScaleType.FIT_XY);
			photoView.setBackgroundResource(GalleryPhotoBag);
			
			return photoView;
		}
	}
		
		
		
	}


