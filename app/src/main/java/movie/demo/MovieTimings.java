package movie.demo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MovieTimings extends Activity implements AdapterView.OnItemSelectedListener{
	
	
	public static final String EXTRA_MOVIE ="movie.demo.MOVIENAME";

	public static final String EXTRA_MOVIECOPY = "movie.demo.MOVIENAMECOPY";
	
	String[] dates={"15 MAY 2014","16 MAY 2014","17 MAY 2014"};
	RadioGroup rbtn;
	Spinner spin;
	Intent intent;
	
	String movieName;
	String movieNameCopy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie_timings);
		spin=(Spinner)findViewById(R.id.spinner);
		rbtn=(RadioGroup)findViewById(R.id.rbtn);
		
		rbtn.setSelected(true);
		spin.setOnItemSelectedListener(this);
		
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dates);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(aa);
		
		intent=getIntent();
		movieName=intent.getStringExtra(Cinemas.EXTRA_NAMEMOVIE);
		movieNameCopy=intent.getStringExtra(CinemasCopy.EXTRA_MESSAGE);
				
		
		}

	public void displayMyShow(View v){

			
		try
		{
			String mydate=spin.getSelectedItem().toString();
			int selected=rbtn.getCheckedRadioButtonId();
			RadioButton b = (RadioButton) findViewById(selected);
			String mytime=b.getText().toString();
			 intent=new Intent(this,MyShow.class);
			intent.putExtra("date", mydate);
			intent.putExtra("time", mytime);
			intent.putExtra(EXTRA_MOVIE, movieName);
			intent.putExtra(EXTRA_MOVIECOPY, movieNameCopy);
			
			startActivity(intent);
	}
		catch(Exception e)
		{
			new AlertDialog.Builder(this).setTitle("Invalid").setMessage("Please choose a Show")
			   .setNeutralButton("OK",null).show();
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


}

