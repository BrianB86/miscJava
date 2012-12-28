package rutgers.cs213.android.photoalbum;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class Search extends Activity {
	//Add more Search functionality UI partially implemented
	Button search;
	MultiAutoCompleteTextView tag;
	Button cancel;
	CheckBox checkLocation;
	CheckBox checkPerson;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		checkLocation = (CheckBox)findViewById(R.id.check_location);
		checkPerson = (CheckBox)findViewById(R.id.check_person);
		cancel = (Button)findViewById(R.id.cancel_button);
		search = (Button)findViewById(R.id.searchButton);
		tag = (MultiAutoCompleteTextView)findViewById(R.id.tagAutoCompleteBox);

		tag.setSingleLine();

		search.setOnClickListener(new OnClickListener() {	

			@Override
			public void onClick(View v) {
				CharSequence cs;
				int duration;
		//		if(/*there is no queries that match*/)
		//		{
		//			cs = "There is no match for your tag" + tag.getText();
		//			duration = Toast.LENGTH_SHORT;
		//		}
				if(checkLocation.isChecked())
				{
					//Search by location only
				}else if(checkPerson.isChecked())
				{
					//Searches by person only
				}else
				{
					//Search by both

				}

			//	Toast.makeText(getApplicationContext(),cs, duration).show();
			}
		});
		cancel.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				//Cancels Search goes back to Album View

			}
		});
	}
}
