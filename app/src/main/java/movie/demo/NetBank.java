package movie.demo;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NetBank extends ListActivity {
	
	public static final String EXTRA_NAME = "example.bank.MESSAGE";

	public static final String EXTRA_AMT = "example.bank.MESSAGEAMT";

	public static final String EXTRA_MOVIE = "movie.demo.MOVIEMSG";

	public static final String EXTRA_DATE = "movie.demo.MOVIEDATE";

	public static final String EXTRA_TIME = "movie.demo.MOVIETIME";

	public static final String EXTRA_SEAT = "movie.demo.MOVIESEAT";

	int BANK_LOGO[]={R.drawable.hdfc,R.drawable.icici,R.drawable.pnb,R.drawable.sbi,R.drawable.axis};
	
	String BANK_NAME[]={"HDFC BANK","ICICI BANK","PNB BANK","SBI BANK","AXIS BANK"};
	
	Intent intent;
	TextView bname;
	
	String amt;
	String movieName;
	String date;
	String time;
	int seat;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_net_bank);
		
		intent=getIntent();
		amt=intent.getStringExtra(Bank.EXTRA_AMT);
		movieName=intent.getStringExtra(Bank.EXTRA_MOVIE);
		date=intent.getStringExtra(Bank.EXTRA_DATE);
		time=intent.getStringExtra(Bank.EXTRA_TIME);
		seat=intent.getIntExtra(Bank.EXTRA_SEAT, 1);
		
		
		setListAdapter(new MyAdapter());
	}
	
	public class MyAdapter extends ArrayAdapter<String>
	{
		public MyAdapter()
		{
			super(NetBank.this,R.layout.bank_list,BANK_NAME);
		}
		
		public View getView(int position,View convertView,ViewGroup parent)
		{
			View row=convertView;
			ViewHolder holder=null;
			if(row==null)
			{
				LayoutInflater inflater=getLayoutInflater();
				row=inflater.inflate(R.layout.bank_list, null);
				holder=new ViewHolder(row);
				row.setTag(holder);
			}
			else
			{
				holder=(ViewHolder)row.getTag();
			}
			

			
			holder.logo.setImageResource(BANK_LOGO[position]);
			
			holder.bname.setText(BANK_NAME[position]);
			
		return row;
		}
	}
	
	public class ViewHolder
	{
		ImageView logo;
		TextView bname;

		ViewHolder(View v)
		{
			logo=(ImageView)v.findViewById(R.id.bankImage);
			bname=(TextView)v.findViewById(R.id.bankText);
			
		}
	}

	
	public void onListItemClick(ListView l,View v,int position,long id)
	{
		
		intent=new Intent(this,BankLogin.class);
		intent.putExtra(EXTRA_NAME, BANK_NAME[position]);
		intent.putExtra(EXTRA_AMT, amt);
		intent.putExtra(EXTRA_MOVIE, movieName);
		intent.putExtra(EXTRA_DATE,date);
		intent.putExtra(EXTRA_TIME, time);
		intent.putExtra(EXTRA_SEAT, seat);
		startActivity(intent);
		
	}
	
}

