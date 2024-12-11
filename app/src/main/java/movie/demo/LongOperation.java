package movie.demo;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;




public class LongOperation extends AsyncTask<Void, Void, String> {
	String mname, mdate, mtime, mamount;
	int mtickets;
	String email_body;
	public Context context;

	ProgressDialog pDialog;
	
	public LongOperation(Context context)
	{
		this.context=context;
	}
	
	
	public void setDetails(String n, String d, String tim, String a, int t){
		mname = n;
		mdate=d;
		mtime=tim;
		mamount=a;
		mtickets=t;
		email_body = "Bookit Cinemas Ltd.   \n" +
				"Movie: "+mname+"\n"+
				"Date: "+mdate+"\n"+
				"Timings: "+mtime+"\n"+
				"Amount: "+mamount+"\n"+
				"No. of Tickets: "+mtickets+"\n"+
				"Enjoy!";
	}
	@Override
	protected String doInBackground(Void... params) {
		try{
			
		GMailSender sender = new GMailSender("app.bookit.android@gmail.com","bookitandroid"); // (username,password)
        sender.sendMail("Bookit - Token for Movie", email_body, "app.bookit.android@gmail.com","chetansharma.smile@gmail.com");
		}
		catch(Exception e){
			//Log.e("error",e.getMessage(),e);return "Email Not Sent";
			}
		return "Email Sent";
	}

	@Override
	protected void onPostExecute(String result) 
	{
		
		pDialog.dismiss();
		
		new AlertDialog.Builder(context).setTitle("Paid").setMessage("your payment has been made")
		   .setNeutralButton("OK",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent=new Intent(context,Bookit.class);
				context.startActivity(intent);
				//finish();
				
		}
		}).show();
	}
	
	@Override
	protected void onPreExecute() 
	{
		
		super.onPreExecute();
		pDialog = new ProgressDialog(context);
		pDialog.setMessage(Html.fromHtml("<b>Processing</b><br/><br/>Please wait"));
		pDialog.setIndeterminate(false);
		pDialog.setCancelable(false);
		pDialog.show();
		
	}
	
	@Override
	protected void onProgressUpdate(Void... values) 
	{
	}
}