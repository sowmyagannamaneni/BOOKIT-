package movie.demo;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class FrontPage extends Activity {
	int delay=3000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_front_page);
		Handler handler=new Handler();
		handler.postDelayed(new Runnable()
		{
			public void run()
			{
				Intent i=new Intent(FrontPage.this,Bookit.class);
				startActivity(i);
				finish();
			}
		},delay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.front_page, menu);
		return true;
	}

}
