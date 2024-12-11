package movie.demo;

import java.util.ArrayList;
import java.util.Iterator;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class Screenshots extends Activity implements AdapterView.OnItemClickListener{
	ImageView image;
	Gallery gallery;
	
	ArrayList<String> names;
	DatabaseHandler handler;
	
	int imgid[] = {};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screenshots);
		image=(ImageView)findViewById(R.id.image);
		gallery=(Gallery)findViewById(R.id.gallery);
		handler=new DatabaseHandler(this);
		
		Intent intent=getIntent();
		String screen_name = intent.getStringExtra(DetailsActivity.EXTRA_SCREENS);
		
		names = new ArrayList();
		names.add(screen_name);
		names.add(screen_name+"1");
		names.add(screen_name+"2");
		names.add(screen_name+"3");
		names.add(screen_name+"4");
	
		Iterator it = names.iterator();
		imgid = new int[names.size()];
		int i = 0;
		while(it.hasNext() && i<imgid.length)
		{
			int idd = Screenshots.this.getResources().getIdentifier(it.next().toString(), "drawable", getPackageName());
			   imgid[i] = idd;
			   i++;
		}
		
		image.setImageResource(imgid[0]);
		
		gallery.setOnItemClickListener(this);
		gallery.setAdapter(new ImageAdapter(this));
	}
	public void onItemClick(AdapterView parent,View v,int position,long id)
	{
		image.setImageResource(imgid[position]);
		
	}

	public class ImageAdapter extends BaseAdapter
	{
		   int GalItemBg;

	        private Context cont;


	        public ImageAdapter(Context c) {

	            cont = c;

	            TypedArray typArray = obtainStyledAttributes(R.styleable.GalleryTheme);

	            GalItemBg = typArray.getResourceId(R.styleable.GalleryTheme_android_galleryItemBackground,0);

	            typArray.recycle();

	        }


	        public int getCount() {

	            return imgid.length;

	        }


	        public Object getItem(int position) {

	            return position;

	        }


	        public long getItemId(int position) {

	            return position;

	        }


	        public View getView(int position, View convertView, ViewGroup parent) {

	            ImageView imgView = new ImageView(cont);


	            imgView.setImageResource(imgid[position]);

	            imgView.setLayoutParams(new Gallery.LayoutParams(80, 70));

	            imgView.setScaleType(ImageView.ScaleType.FIT_XY);

	            imgView.setBackgroundResource(GalItemBg);


	            return imgView;

	        }

	    }
}