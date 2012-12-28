package rutgers.cs213.android.photoalbum;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;
//THIS IS A TEST VIEW NOT GOING INTO THE FINAL PRODUCT!!!
public class Photos extends ListActivity {
	
	String[] test = {"THIS", "IS", "A", "TEST"};
	AlertDialog.Builder builder;
	AlertDialog alert;
	
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,test);
        
        setListAdapter(adapter);
      //Creating the alert dialog  
        builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this photo?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Implement the delete functionality
				
				Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT);
				
			}
		});
        
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        	
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				
			}
		});
        
        alert = builder.create();
        //alert.show(); in the delete menu button
      //End alert dialog
    }
}
