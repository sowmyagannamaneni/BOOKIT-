package movie.demo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Bank extends Activity implements View.OnClickListener{
	
	public static final String EXTRA_AMT = "movie.demo.MSGAMT";
	public static final String EXTRA_MOVIE ="movie.demo.MSGMOVIE";
	public static final String EXTRA_DATE ="movie.demo.MSGADATE";
	public static final String EXTRA_TIME = "movie.demo.MSGTIME";
	public static final String EXTRA_SEAT = "movie.demo.MSGSEAT";
	public static final String EXTRA_MOVIECOPY ="movie.demo.MSGCOPY";
	
	Button creditButton,netButton;
	Intent intent;
	
	String amt;
	String movieName;
	String date;
	String time;
	int seat;
	String movieNameCopy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bank);
	
		
		creditButton=(Button)findViewById(R.id.creditButton);
		netButton=(Button)findViewById(R.id.netButton);
		
		creditButton.setOnClickListener(this);
		netButton.setOnClickListener(this);
	
		
		intent=getIntent();
		
		amt=intent.getStringExtra(SeatPlan.EXTRA_AMT);
		movieName=intent.getStringExtra(SeatPlan.EXTRA_MOVIE);
		movieNameCopy=intent.getStringExtra(SeatPlan.EXTRA_MOVIECOPY);
		date=intent.getStringExtra(SeatPlan.EXTRA_DATE);
		time=intent.getStringExtra(SeatPlan.EXTRA_TIME);
		seat=intent.getIntExtra(SeatPlan.EXTRA_SEAT,1);
		movieNameCopy=intent.getStringExtra(SeatPlan.EXTRA_MOVIECOPY);
		
		
		
	}
	
	public void onClick(View view)
	{
		switch(view.getId())
		{
		case R.id.creditButton:
			intent=new Intent(Bank.this,Credit.class);
			intent.putExtra(EXTRA_AMT, amt);
			intent.putExtra(EXTRA_MOVIE, movieName);
			intent.putExtra(EXTRA_MOVIECOPY, movieNameCopy);
			intent.putExtra(EXTRA_DATE, date);
			intent.putExtra(EXTRA_TIME, time);
			intent.putExtra(EXTRA_SEAT, seat);
			startActivity(intent);
			break;
		case R.id.netButton:
			intent=new Intent(Bank.this,NetBank.class);
			intent.putExtra(EXTRA_AMT, amt);
			intent.putExtra(EXTRA_MOVIE, movieName);
			intent.putExtra(EXTRA_MOVIECOPY, movieNameCopy);
			intent.putExtra(EXTRA_DATE, date);
			intent.putExtra(EXTRA_TIME, time);
			intent.putExtra(EXTRA_SEAT, seat);
			startActivity(intent);
			break;
		}
	}

	

}
