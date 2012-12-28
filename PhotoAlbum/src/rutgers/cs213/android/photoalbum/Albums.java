package rutgers.cs213.android.photoalbum;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
//THIS IS A TEST VIEW NOT GOING INTO THE FINAL PRODUCT!!!
public class Albums extends ListActivity {

	public static final int ADD_SONG_ACTIVITY = 0;
	MyAlbumList albumList;
	private AlertDialog.Builder builder;
	private AlertDialog alert;
	private ArrayAdapter<String> adapter;
	private String selectedItem;
	private final Context context = this;

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		OnItemLongClickListener itemListener = new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View arg1,
					int position, long arg3) {

				selectedItem = parent.getItemAtPosition(position).toString();

				// stand in for menu
				builder.setMessage("Stand in for menu" + selectedItem);
				builder.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								adapter.remove(selectedItem);
								adapter.notifyDataSetChanged();

								Toast.makeText(getApplicationContext(),
										selectedItem + "has been removed",
										Toast.LENGTH_SHORT).show();

							}
						});
				builder.setNegativeButton("No",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

							}
						});

				builder.show();
				return true;

			}
		};

		ArrayList<String> list = new ArrayList<String>(Arrays.asList(test));
		
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);

		setListAdapter(adapter);

		getListView().setOnItemLongClickListener(itemListener);
		// Creating the alert dialog
		builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure you want to delete this photo?");
		builder.setCancelable(false);
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// Implement the delete functionality

				Toast.makeText(getApplicationContext(), "Deleted",
						Toast.LENGTH_SHORT);

			}
		});

		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();

			}
		});

		alert = builder.create();
		// alert.show(); in the delete menu button
		// End alert dialog

	}
}
