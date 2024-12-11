package movie.demo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class MyShow extends Activity implements AdapterView.OnItemSelectedListener{
	
	public static final String EXTRA_SEAT = "movie.demo.SEATMSG";
	public static final String EXTRA_AMT = "movie.demo.MESSAGE";
	public static final String EXTRA_MOVIE ="movie.demo.MOVIE";
	public static final String EXTRA_DATE = "movie.demo.DATE";
	public static final String EXTRA_TIME = "movie.demo.TIME";
	public static final String EXTRA_MOVIECOPY ="movie.demo.MOVIECOPY";
	
	public static String DATE="date";
	public static String TIME="time";
	TextView txtdate,txttime,total_tickets,paycount;
	int gold=300,prime=175,normal=125;
	Spinner timing;
	SeekBar seekBar;
	int progress;
	String totalpay;
	
	String movieName;
	String date;
	String time;
	String movieNameCopy;
	
	Intent intent;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_my_show);
			txtdate=(TextView)findViewById(R.id.txtdate);
			txttime=(TextView)findViewById(R.id.txttime);
			timing=(Spinner)findViewById(R.id.timing);
			total_tickets=(TextView)findViewById(R.id.total_tickets);
			seekBar=(SeekBar)findViewById(R.id.seekBar);
			paycount=(TextView)findViewById(R.id.paycount);
			
			paycount.setText("0");
			
			intent=getIntent();
			
			date=intent.getStringExtra(DATE);
			time=intent.getStringExtra(TIME);
			movieName=intent.getStringExtra(MovieTimings.EXTRA_MOVIE);
			movieNameCopy=intent.getStringExtra(MovieTimings.EXTRA_MOVIECOPY);
			
			
			txtdate.setText(date);
			txttime.setText(time);
			
			ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
			spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			timing.setAdapter(spinnerAdapter);
			
			spinnerAdapter.add("GOLD(Rs.300)");
			spinnerAdapter.add("PRIME(Rs.175)");
			spinnerAdapter.add("NORMAL(Rs.125)");
			spinnerAdapter.notifyDataSetChanged();
			
			seekBar.setOnSeekBarChangeListener(
	                new OnSeekBarChangeListener() {
	               
	        @Override
	      public void onProgressChanged(SeekBar seekBar,int progresValue, boolean fromUser) {
	        progress = progresValue;
	        
	        if(timing.getSelectedItemPosition()==0){  //Gold
				int pay= progress*gold;
				totalpay=String.valueOf(pay);
				paycount.setText(totalpay);
				
			}
			else if(timing.getSelectedItemPosition()==1){  //Prime
				int pay=progress*prime;
				totalpay=String.valueOf(pay);
				paycount.setText(totalpay);
			}
			else if(timing.getSelectedItemPosition()==2){  //Normal
				int pay=progress*normal;
				totalpay=String.valueOf(pay);
				paycount.setText(totalpay);
			}
	      }

	      @Override
	      public void onStartTrackingTouch(SeekBar seekBar) {
	      }

	      @Override
	      public void onStopTrackingTouch(SeekBar seekBar) {
	        total_tickets.setText(progress + "/" + seekBar.getMax());
	      }
	  });
			
		}
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
		}
		
		
		public void chooseSeats(View view)
		{
			if(progress!=0)
			{
			intent=new Intent(this,SeatPlan.class);
			
			intent.putExtra(EXTRA_SEAT, progress);
			intent.putExtra(EXTRA_AMT,String.valueOf(paycount.getText()));
			intent.putExtra(EXTRA_MOVIE, movieName);
			intent.putExtra(EXTRA_MOVIECOPY,movieNameCopy);
			intent.putExtra(EXTRA_DATE, date);
			intent.putExtra(EXTRA_TIME, time);
			
			Log.d("total amt",paycount.getText().toString());
			startActivity(intent);
			}
			
			else
			{
				new AlertDialog.Builder(this).setTitle("Invalid").setMessage("Please choose tickets")
				   .setNeutralButton("OK",null).show();
				   
			}
		}
		
}

