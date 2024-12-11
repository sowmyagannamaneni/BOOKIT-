package movie.demo;

import java.util.ArrayList;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;
import android.app.Activity;
import android.content.Intent;

public class DetailsActivity extends Activity {
	public static final String EXTRA_SCREENS ="movie.demo.MESSAGES";
	private static final String EXTRA_NAMEMOVIE ="movie.demo.MOVIENAME";
	private static final String EXTRA_COPY ="movie.demo.copyname";
	TextView text,dateText,timeText,dirText,genreText,langText;
	ImageView image;
	RatingBar rate;
	Button trailer,screenShots;
	VideoView videoView;
	String screen_name;
	String v;
	Intent i;
	Intent intent;
	ArrayList<String> screen;

	DatabaseHandler handler;
	String a;
	String movieNameCopy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);	text=(TextView)findViewById(R.id.textView1);
		image=(ImageView)findViewById(R.id.image);
		dateText=(TextView)findViewById(R.id.dateText);
		timeText=(TextView)findViewById(R.id.timeText);
		dirText=(TextView)findViewById(R.id.dirText);
		genreText=(TextView)findViewById(R.id.genreText);
		langText=(TextView)findViewById(R.id.langText);
		rate=(RatingBar)findViewById(R.id.ratingbar);
		trailer=(Button)findViewById(R.id.trailer);
		videoView=(VideoView)findViewById(R.id.videoView);
		screenShots=(Button)findViewById(R.id.screenShots);
		
		
		handler=new DatabaseHandler(this);
		 i= getIntent();
		
		 a=i.getStringExtra(Cinemas.EXTRA_MESSAGE);
		String b=i.getStringExtra(Cinemas.EXTRA_IMAGE);
		screen_name = b;
		String c=i.getStringExtra(Cinemas.EXTRA_MSG);
		String d=i.getStringExtra(Cinemas.EXTRA_TIME);
		String e=i.getStringExtra(Cinemas.EXTRA_DIR);
		String f=i.getStringExtra(Cinemas.EXTRA_GEN);
		String g=i.getStringExtra(Cinemas.EXTRA_LANG);
		
		 movieNameCopy=i.getStringExtra(CinemasCopy.EXTRA_MESSAGE);

		
		
		int h=i.getIntExtra(Cinemas.EXTRA_RATING,1);
		
		int idd = this.getResources().getIdentifier(b, "drawable", getPackageName());
		
		v=i.getStringExtra(Cinemas.EXTRA_VIDEO);
		
		if(a==null)
		{
			text.setText(movieNameCopy);
		}
		
		text.setText(a);
		dateText.setText(c);
		timeText.setText(d);
		dirText.setText(e);
		genreText.setText(f);
		langText.setText(g);
		rate.setRating(h);
		image.setImageResource(idd);
	}

	public void showTrailer(View view)
	{
		videoView.setVideoURI(Uri.parse(String.valueOf(intent= new Intent(Intent.ACTION_VIEW,Uri.parse(String.valueOf(v))))));
    	
    	startActivity(intent);
		 
		videoView.setMediaController(new MediaController(this)); 
		 
		videoView.requestFocus();
		 
		videoView.start();
	}
	
	public void screenShots(View view)
	{
		Intent intentt=new Intent(DetailsActivity.this,Screenshots.class);
		intentt.putExtra(EXTRA_SCREENS,screen_name);
		startActivity(intentt);
	}
	
	
	public void buttonClick(View v)
	{
		
		 intent=new Intent(DetailsActivity.this,MovieTimings.class);	 
		 intent.putExtra(EXTRA_NAMEMOVIE,a);
		 intent.putExtra(EXTRA_COPY,movieNameCopy);
		 startActivity(intent);
		 
	}


}