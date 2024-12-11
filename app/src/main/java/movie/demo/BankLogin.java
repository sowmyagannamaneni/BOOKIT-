package movie.demo;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BankLogin extends Activity {
	public static final String EXTRA_NAME = "example.bank.MESSAGE";
	public static final String EXTRA_PHONE = "example.bank.MESSAGE2";
	public static final String EXTRA_AMT ="example.bank.MESSAGE3" ;
	public static final String EXTRA_MOVIE ="movie.demo.MESSAGEMOV" ;
	public static final String EXTRA_DATE = "movie.demo.MSGDATE";
	public static final String EXTRA_TIME = "movie.demo.MSGTIME";
	public static final String EXTRA_SEAT = "movie.demo.MSGSEAT";
	
	
	TextView bname;
	Button submit;
	EditText userId,password;
	String a;
	DatabaseHelperNet helper;
	Intent intent;

	String amt;
	String movieName;
	String date;
	String time;
	int seat;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bank_login);
		bname=(TextView)findViewById(R.id.bankName);
		submit=(Button)findViewById(R.id.submit);
		userId=(EditText)findViewById(R.id.userId);
		password=(EditText)findViewById(R.id.password);
		helper=new DatabaseHelperNet(this);
		Intent intent=getIntent();
		a=intent.getStringExtra(NetBank.EXTRA_NAME);
		bname.setText(a);
		
		intent=getIntent();
		amt=intent.getStringExtra(NetBank.EXTRA_AMT);
		movieName=intent.getStringExtra(NetBank.EXTRA_MOVIE);
		date=intent.getStringExtra(NetBank.EXTRA_DATE);
		time=intent.getStringExtra(NetBank.EXTRA_TIME);
		seat=intent.getIntExtra(NetBank.EXTRA_SEAT, 1);
		
		
	}
	
	public void submit(View view)
	{
		
		String u=userId.getText().toString();
		String p=password.getText().toString();
		
		
		if(u.length()>0 && p.length()>0)
		{
		
				if(helper.netMatchDetails(u, p,a))
				{
				 intent=new Intent(BankLogin.this,Submit.class);
				 intent.putExtra(EXTRA_NAME,String.valueOf(helper.getName()));
				 intent.putExtra(EXTRA_PHONE,String.valueOf(helper.getPhone()));
				 intent.putExtra(EXTRA_AMT, amt);
				 intent.putExtra(EXTRA_MOVIE, movieName);
				 intent.putExtra(EXTRA_DATE, date);
				 intent.putExtra(EXTRA_TIME,time);
				 intent.putExtra(EXTRA_SEAT,seat);
				 startActivity(intent);
				}	
				else
				{
					new AlertDialog.Builder(this).setTitle("Invalid").setMessage("User Name or Password is incorrect")
					 .setNeutralButton("OK",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							userId.setText("");
							password.setText("");
						}
					}).show();
				}
			
		}
		else
		{
			new AlertDialog.Builder(this).setTitle("Empty Fields").setMessage("User Name or Password is empty")
			   .setNeutralButton("OK",null).show();
		}

	}

	

}
