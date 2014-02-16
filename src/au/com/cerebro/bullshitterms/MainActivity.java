package au.com.cerebro.bullshitterms;

import java.util.Random;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	Button generateTermButton;
	TextView generatedTermTitle;
	TextView generatedTermDisplay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		generateTermButton = (Button) findViewById(R.id.generate_term_button);
		generatedTermTitle = (TextView) findViewById(R.id.term_display_text_title);
		generatedTermDisplay = (TextView) findViewById(R.id.term_display_text_display);
		
		generateTermButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.menu_settings:
				//ToDo Code for click
				//Do explicit intent
				
				
				//Accept click and return
				return true;
				
			default:
				//pass on click and return
				return false;
		}
	}

	@Override
	public void onClick(View v) {
		updateTerm();
	}
	
	public void updateTerm(){
		generatedTermDisplay.setText(generateRandomTerms());
	}
	
	public String generateRandomTerms(){
		String result = "";
		
		Resources res = getResources();
		String[] verbs = res.getStringArray(R.array.verbs);
		String[] adjectives = res.getStringArray(R.array.adjectives);
		String[] nouns = res.getStringArray(R.array.nouns);
		
		result  = verbs[new Random().nextInt(verbs.length)]  + " " + adjectives[new Random().nextInt(adjectives.length)] +" " + nouns[new Random().nextInt(nouns.length)]; 
		return result;
	}

}
