package movie.demo;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Credit extends Activity implements OnCheckedChangeListener {
	Button pay;

	EditText cardno,cvv;

	public String get_card;
	public String get_cvv;
	TextView bal;
	RadioButton creditType,debitType;
	String a;
	public String cardType;
	int amountt;
	int keyDel;
	Intent intent;
	
	String amt;
	String movieName;
	String date;
	String time;
	String movieNameCopy;
	int seat;
	
	ProgressDialog pDialog;
	
	DatabaseHandlerCredit handler;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_credit);
			
			pay=(Button)findViewById(R.id.payButton);
			cardno=(EditText)findViewById(R.id.cardNo);
			RadioGroup grp=(RadioGroup)findViewById(R.id.radioGrp);
			creditType=(RadioButton)findViewById(R.id.creditType);
			debitType=(RadioButton)findViewById(R.id.debitType);
			grp.setOnCheckedChangeListener(this);
			cvv=(EditText)findViewById(R.id.cvv);
			bal=(TextView)findViewById(R.id.balance);
			handler=new DatabaseHandlerCredit(this);
			
			intent=getIntent();
			
			amt=intent.getStringExtra(Bank.EXTRA_AMT);
			movieName=intent.getStringExtra(Bank.EXTRA_MOVIE);
			date=intent.getStringExtra(Bank.EXTRA_DATE);
			time=intent.getStringExtra(Bank.EXTRA_TIME);
			seat=intent.getIntExtra(Bank.EXTRA_SEAT,1);
			movieNameCopy=intent.getStringExtra(Bank.EXTRA_MOVIECOPY);
			
			bal.setText(amt);
		
		
			cardno.addTextChangedListener(new TextWatcher() {

		            @Override
		            public void onTextChanged(CharSequence s, int start, int before, int count) {

		                boolean flag = true;
		                String eachBlock[] = cardno.getText().toString().split(" ");
		                for (int i = 0; i < eachBlock.length; i++) {
		                    if (eachBlock[i].length() > 4) {
		                        flag = false;
		                    }
		                }
		                if (flag) {

		                	cardno.setOnKeyListener(new OnKeyListener() {

								@Override
								public boolean onKey(View v, int keyCode,
										KeyEvent event) {
									// TODO Auto-generated method stub
									 if (keyCode == KeyEvent.KEYCODE_DEL)
			                                keyDel = 1;
									return false;
								}
		                    });

		                    if (keyDel == 0) {

		                        if (((cardno.getText().length() + 1) % 5) == 0) {

		                            if (cardno.getText().toString().split(" ").length <= 3) {
		                            	cardno.setText(cardno.getText() + " ");
		                            	cardno.setSelection(cardno.getText().length());
		                            }
		                        }
		                        a = cardno.getText().toString();
		                    } else {
		                        a = cardno.getText().toString();
		                        keyDel = 0;
		                    }

		                } else {
		                	cardno.setText(a);
		                }

		            }

		            @Override
		            public void beforeTextChanged(CharSequence s, int start, int count,
		                    int after) {
		                // TODO Auto-generated method stub

		            }

		            @Override
		            public void afterTextChanged(Editable s) {
		            }
		        });
		    }
		
		public void onCheckedChanged(RadioGroup grp,int position)
		{
			switch(position)
			{
			case R.id.creditType:
				
				cardType="credit";
		
				
				break;
				
			case R.id.debitType:
				
				cardType="debit";

				break;
			}
		}
		
		public void makePayment(View view)
		{
			
	
			
			get_card=cardno.getText().toString();
			get_cvv=cvv.getText().toString();
			
		
			if(get_card.length()>0 && get_cvv.length()>0)
			{
				
					if(handler.matchDetails(get_card,get_cvv,cardType))
					{

						handler.updateBalance(handler.acc,Integer.parseInt(bal.getText().toString()),cardType);
												
						
						//SMS
						
						
						
						String msg_body = "Bookit Cinemas Ltd.   \n" +
								"Movie: "+movieName+"\n"+
								"Date: "+date+"\n"+
								"Timings: "+time+"\n"+
								"Amount: "+amt+"\n"+
								"No. of Tickets: "+seat+"\n"+
								"Enjoy!";
						
						
						
						try {
							SmsManager.getDefault().sendTextMessage(String.valueOf(handler.getPhone()),null,msg_body,null, null);
						} catch (Exception e) {
							AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
							AlertDialog dialog = alertDialogBuilder.create();
							dialog.setMessage(e.getMessage());
							dialog.show();
						}
					
						
						//EMAIL
						
						try {   
				            LongOperation l=new LongOperation(this);
				            if(movieName==null)
				            	movieName=movieNameCopy;
				            l.setDetails(movieName, date, time, amt, seat);
				            l.execute();
				            
				        } catch (Exception e) {   
				            Log.e("SendMail", e.getMessage(), e);   
				        } 
							
											
					}
						
					else
					{
						 new AlertDialog.Builder(this).setTitle("Invalid").setMessage("Card Name or CVV Code is incorrect")
						 .setNeutralButton("OK",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								
								cardno.setText("");
								cvv.setText("");
							}
						}).show();
												
					}
			}		
			else
			{
				
		   new AlertDialog.Builder(this).setTitle("Empty Fields").setMessage("Card Name or CVV Code is empty")
		   .setNeutralButton("OK",null).show();
		   
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
						
				
				
