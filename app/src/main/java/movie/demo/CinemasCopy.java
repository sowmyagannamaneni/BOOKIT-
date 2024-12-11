package movie.demo;

import java.util.ArrayList;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

import android.content.Intent;

public class CinemasCopy extends ListActivity {

	public static final String EXTRA_MESSAGE ="movie.demo.MOVIENAME";
	public static final String EXTRA_ID ="movie.demo._ID";
	public static final String EXTRA_IMAGE ="movie.demo.MESSAGE1";
	public static final String EXTRA_MSG = "movie.demo.MESSAGE2";
	public static final String EXTRA_TIME = "movie.demo.MESSAGE3";
	public static final String EXTRA_DIR = "movie.demo.MESSAGE4";
	public static final String EXTRA_GEN = "movie.demo.MESSAGE5";
	public static final String EXTRA_LANG = "movie.demo.MESSAGE6";
	public static final String EXTRA_RATING ="movie.demo.MESSAGE7";
	public static final String EXTRA_VIDEO="movie.demo.MESSAGE8";
	public static final String EXTRA_CINEMA="movie.demo.MESSAGE9";
	
	ArrayList<String> movie_names;
	ArrayList<String> poster;

	String i;
	Intent intent;
	
	DatabaseHandler handler;
	ListView list;
	
	Button cinemaButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.copy_activity_cinemas);
		cinemaButton=(Button)findViewById(R.id.cinemaButton);
		
		handler=new DatabaseHandler(this);
		
		movie_names=handler.getValues();
		poster=handler.getImages();
		
		
		setListAdapter(new MyAdapter());
	}
	
	public class MyAdapter extends ArrayAdapter<String>
	{
		public MyAdapter()
		{
			super(CinemasCopy.this,R.layout.copy_list_row,movie_names);
		}
		
		public View getView(int position,View convertView,ViewGroup parent)
		{
			View row=convertView;
			ViewHolder holder=null;
			if(row==null)
			{
				LayoutInflater inflater=getLayoutInflater();
				row=inflater.inflate(R.layout.copy_list_row, null);
				holder=new ViewHolder(row);
				row.setTag(holder);
			}
			else
			{
				holder=(ViewHolder)row.getTag();
			}
			
			i = poster.get(position);
			
			int idd = CinemasCopy.this.getResources().getIdentifier(i, "drawable", getPackageName());
			
			holder.poster.setImageResource(idd);
			
			holder.movieName.setText(movie_names.get(position));
			
			row.setBackgroundResource(R.drawable.list_design);
			
			return row;
		}
	}
	
	public class ViewHolder
	{
		ImageView poster;
		TextView movieName;
		Button bookButton;
		ViewHolder(View v)
		{
			poster=(ImageView)v.findViewById(R.id.poster);
			movieName=(TextView)v.findViewById(R.id.movieName);
			
			
		}
	}
	public void onListItemClick(ListView l,View v,int position,long id)
	{
		intent=new Intent(this,DetailsActivity.class);
		handler.getDetails(id);
		intent.putExtra(EXTRA_ID,String.valueOf(id));
		intent.putExtra(EXTRA_MESSAGE,String.valueOf(handler.getName()));
		intent.putExtra(EXTRA_IMAGE,String.valueOf(handler.getImage()));
		intent.putExtra(EXTRA_MSG, String.valueOf(handler.getDate()));
		intent.putExtra(EXTRA_TIME, String.valueOf(handler.getTime()));
		intent.putExtra(EXTRA_DIR, String.valueOf(handler.getDirector()));
		intent.putExtra(EXTRA_GEN, String.valueOf(handler.getGenre()));
		intent.putExtra(EXTRA_LANG, String.valueOf(handler.getLang()));
		intent.putExtra(EXTRA_RATING, handler.getRating());
		intent.putExtra(EXTRA_VIDEO, handler.getVideo());
		
		
		
		startActivity(intent);
		
	}
	
	public void cinemaBook(View v)
	{
		intent=new Intent(this,CopyMainActivity.class);
		intent.putExtra(EXTRA_MESSAGE,String.valueOf(handler.getName()));
		startActivity(intent);
		 
	}
	

	
}
