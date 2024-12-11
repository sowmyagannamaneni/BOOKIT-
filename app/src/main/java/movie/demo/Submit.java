package movie.demo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Submit extends Activity {
	
TextView welUser;
TextView amount;

String b;
String phoneNumber;
Intent intent;

String amt;
String movieName;
String time;
String date;
int seat;


DatabaseHelperNet helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submit);
		welUser=(TextView)findViewById(R.id.welUser);
		amount=(TextView)findViewById(R.id.amount);
		
		helper=new DatabaseHelperNet(this);

		intent=getIntent();
		
		amt=intent.getStringExtra(BankLogin.EXTRA_AMT);
		movieName=intent.getStringExtra(BankLogin.EXTRA_MOVIE);
		time=intent.getStringExtra(BankLogin.EXTRA_TIME);
		date=intent.getStringExtra(BankLogin.EXTRA_DATE);
		seat=intent.getIntExtra(BankLogin.EXTRA_SEAT, 1);
		
		String a=intent.getStringExtra(BankLogin.EXTRA_NAME);
		phoneNumber=intent.getStringExtra(BankLogin.EXTRA_PHONE);

		welUser.setText(a);	
		amount.setText(amt);
		
		
	}
	
	public void payMethod(View view)
	{
		
	
		helper.updateNetBalance(helper.net_acc, Integer.parseInt(amount.getText().toString()));
		
		
		String phoneNumber =helper.getPhone();
		
		
		//SMS
		
		
		String msg_body = "Bookit Cinemas Ltd.   \n" +
				"Movie: "+movieName+"\n"+
				"Date: "+date+"\n"+
				"Timings: "+time+"\n"+
				"Amount: "+amt+"\n"+
				"No. of Tickets: "+seat+"\n"+
				"Enjoy!";
		
		try {
			SmsManager.getDefault().sendTextMessage(phoneNumber, null, msg_body, null, null);
		} catch (Exception e) {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
			AlertDialog dialog = alertDialogBuilder.create();
			dialog.setMessage(e.getMessage());
		dialog.show();
		}
		
		//EMail
		try {   
            LongOperation l=new LongOperation(this);
            l.setDetails(movieName, date, time, amt, seat);
            l.execute();
      
        } catch (Exception e) {   
            Log.e("SendMail", e.getMessage(), e);   
        } 
		
		
	}  
	
	public void onBackPressed()
	{
		new AlertDialog.Builder(this).setTitle("Cancel").setMessage("Do you want to cancel tickets?").setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					
					intent=new Intent(getApplicationContext(),Bookit.class);
					startActivity(intent);
					}
				}).setNegativeButton("No",null).show();
			
	}
	
	
}
