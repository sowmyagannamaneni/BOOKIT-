package movie.demo;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


public class SeatPlan extends Activity implements View.OnClickListener{
	


	public static final String EXTRA_AMT ="movie.demo.MESSAGEAMT";
	public static final String EXTRA_MOVIE ="movie.demo.MESSAGEMOVIE";
	public static final String EXTRA_DATE = "movie.demo.MESSAGEDATE";
	public static final String EXTRA_TIME = "movie.demo.MESSAGETIME";
	public static final String EXTRA_SEAT = "movie.demo.MESSAGESEAT";
	public static final String EXTRA_MOVIECOPY ="movie.demo.MESSAGECOPY";
	
	int no_of_seats; // should be retrieved from user's choice.
	int no_of_choosen_seats = 0;
	
	ImageButton[][] seatButton=new ImageButton[6][6];
	
	boolean flag_case0 , flag_case1 , flag_case2 , flag_case3, flag_case4, flag_case5, flag_case10 , flag_case11 , 
	flag_case12 , flag_case13 ,flag_case14, flag_case15, flag_case20 , flag_case21, flag_case22, flag_case23, flag_case24,
	flag_case25, flag_case30, flag_case31, flag_case32, flag_case33, flag_case34, flag_case35,
	 flag_case40, flag_case41, flag_case42, flag_case43, flag_case44, flag_case45,
	 flag_case50, flag_case51, flag_case52, flag_case53, flag_case54, flag_case55;
	
	int i,j;
	
	String amt;
	String movieName;
	String date;
	String time;
	String movieNameCopy;
	
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seat_plan);
		
		
		intent=getIntent();
		no_of_seats=intent.getIntExtra(MyShow.EXTRA_SEAT, 1);
		
		amt=intent.getStringExtra(MyShow.EXTRA_AMT);
		movieName=intent.getStringExtra(MyShow.EXTRA_MOVIE);
		date=intent.getStringExtra(MyShow.EXTRA_DATE);
		time=intent.getStringExtra(MyShow.EXTRA_TIME);
		movieNameCopy=intent.getStringExtra(MyShow.EXTRA_MOVIECOPY);
		
		
		
		TableLayout seatTable=new TableLayout(this);
		
	    seatTable.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
	    seatTable.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL);
	    seatTable.setPadding(100, 0, 60, 0);
	    TableRow[] seatRow=new TableRow[6];
	    
	    for (i = 0; i < 6; i++) {
	    	
	        seatRow[i]=new TableRow(this);
	        seatRow[i].setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
	        
	        for (j = 0; j < 6; j++) {
	        	
	            seatButton[i][j]=new ImageButton(this);
	            
	            seatButton[i][j].setOnClickListener(this);
	            
	            seatButton[i][j].setId((i*10)+j);
	            
	            seatButton[i][j].setImageResource(R.drawable.white);
	            	            
	            seatRow[i].addView(seatButton[i][j]);
	        }
	        
	        seatTable.addView(seatRow[i]);
	        
	        
	        
	    }
	    
	    RelativeLayout lin=(RelativeLayout)findViewById(R.id.linLayout);
	    
	    lin.addView(seatTable);
	    
	    lin.invalidate();
	    
	    seatButton[0][2].setImageResource(R.drawable.grey);
		seatButton[0][2].setEnabled(false);
		
		seatButton[0][3].setImageResource(R.drawable.grey);
		seatButton[0][3].setEnabled(false);
		
		
		seatButton[1][4].setImageResource(R.drawable.grey);
		seatButton[1][4].setEnabled(false);
		
		seatButton[1][3].setImageResource(R.drawable.grey);
		seatButton[1][3].setEnabled(false);
		
		
	}

	public void onClick(View view)
	{
		switch(view.getId())
		{
			case 0:
				
				if(flag_case0)  // for true
				{
					seatButton[0][0].setImageResource(R.drawable.white);
					flag_case0 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[0][0].setImageResource(R.drawable.green);
					flag_case0 = true;
					no_of_choosen_seats++;
				}
				break;
				
		 case 1:
			 
				if(flag_case1)
				{
					seatButton[0][1].setImageResource(R.drawable.white);
					flag_case1 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[0][1].setImageResource(R.drawable.green);
					flag_case1 = true;
					no_of_choosen_seats++;
				}
					break;
					
//		case 2:
//				
//				if(flag_case2)
//				{
//					seatButton[0][2].setImageResource(R.drawable.white);
//					flag_case2 = false;
//					no_of_choosen_seats--;
//				}
//				else if(no_of_choosen_seats < no_of_seats)
//				{
//					seatButton[0][2].setImageResource(R.drawable.green);
//					flag_case2 = true;
//					no_of_choosen_seats++;
//				}
//					break;
//					
//		case 3:
//			
//			if(flag_case3)
//			{
//				seatButton[0][3].setImageResource(R.drawable.white);
//				flag_case3 = false;
//				no_of_choosen_seats--;
//			}
//			else if(no_of_choosen_seats < no_of_seats)
//			{
//				seatButton[0][3].setImageResource(R.drawable.green);
//				flag_case3 = true;
//				no_of_choosen_seats++;
//			}
//				break;
					
		 case 4:
				
				if(flag_case4)  // for true
				{
					seatButton[0][4].setImageResource(R.drawable.white);
					flag_case4 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[0][4].setImageResource(R.drawable.green);
					flag_case4 = true;
					no_of_choosen_seats++;
				}
				break;
				
		 case 5:
			 
				if(flag_case5)
				{
					seatButton[0][5].setImageResource(R.drawable.white);
					flag_case5 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[0][5].setImageResource(R.drawable.green);
					flag_case5 = true;
					no_of_choosen_seats++;
				}
					break;
					
		case 10:
						
				if(flag_case10)
				{
					seatButton[1][0].setImageResource(R.drawable.white);
					flag_case10 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[1][0].setImageResource(R.drawable.green);
					flag_case10 = true;
					no_of_choosen_seats++;
				}
					break;
					
		case 11:
				
				if(flag_case11)
				{
					seatButton[1][1].setImageResource(R.drawable.white);
					flag_case11 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[1][1].setImageResource(R.drawable.green);
					flag_case11 = true;
					no_of_choosen_seats++;
				}
					break;
					
		case 12:
				
				if(flag_case12)
				{
					seatButton[1][2].setImageResource(R.drawable.white);
					flag_case12 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[1][2].setImageResource(R.drawable.green);
					flag_case12 = true;
					no_of_choosen_seats++;
				}
					break;
					
					
//		case 13:
//			
//			if(flag_case13)
//			{
//				seatButton[1][3].setImageResource(R.drawable.white);
//				flag_case13 = false;
//				no_of_choosen_seats--;
//			}
//			else if(no_of_choosen_seats < no_of_seats)
//			{
//				seatButton[1][3].setImageResource(R.drawable.green);
//				flag_case13 = true;
//				no_of_choosen_seats++;
//			}
//				break;
//				
//		case 14:
//			
//			if(flag_case10)
//			{
//				seatButton[1][4].setImageResource(R.drawable.white);
//				flag_case14 = false;
//				no_of_choosen_seats--;
//			}
//			else if(no_of_choosen_seats < no_of_seats)
//			{
//				seatButton[1][4].setImageResource(R.drawable.green);
//				flag_case14 = true;
//				no_of_choosen_seats++;
//			}
//				break;
				
	case 15:
			
			if(flag_case15)
			{
				seatButton[1][5].setImageResource(R.drawable.white);
				flag_case15 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[1][5].setImageResource(R.drawable.green);
				flag_case15 = true;
				no_of_choosen_seats++;
			}
				break;
				
		case 20:
				
				if(flag_case20)
				{
					seatButton[2][0].setImageResource(R.drawable.white);
					flag_case20 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[2][0].setImageResource(R.drawable.green);
					flag_case20 = true;
					no_of_choosen_seats++;
				}
					break;
					
		case 21:
				
				if(flag_case21)
				{
					seatButton[2][1].setImageResource(R.drawable.white);
					flag_case21 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[2][1].setImageResource(R.drawable.green);
					flag_case21 = true;
					no_of_choosen_seats++;
				}
				break;
					
		case 22:
				
				if(flag_case22)
				{
					seatButton[2][2].setImageResource(R.drawable.white);
					flag_case22 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[2][2].setImageResource(R.drawable.green);
					flag_case22 = true;
					no_of_choosen_seats++;
				}
					break;
					
		case 23:
			
			if(flag_case23)
			{
				seatButton[2][3].setImageResource(R.drawable.white);
				flag_case23 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[2][3].setImageResource(R.drawable.green);
				flag_case23 = true;
				no_of_choosen_seats++;
			}
				break;
					
				
		case 24:
			
			if(flag_case24)
			{
				seatButton[2][4].setImageResource(R.drawable.white);
				flag_case24 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[2][4].setImageResource(R.drawable.green);
				flag_case24 = true;
				no_of_choosen_seats++;
			}
				break;
				
	case 25:
			
			if(flag_case25)
			{
				seatButton[2][5].setImageResource(R.drawable.white);
				flag_case25 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[2][5].setImageResource(R.drawable.green);
				flag_case25 = true;
				no_of_choosen_seats++;
			}
			break;
				
				
        case 30:
				
				if(flag_case30)
				{
					seatButton[3][0].setImageResource(R.drawable.white);
					flag_case30 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[3][0].setImageResource(R.drawable.green);
					flag_case30 = true;
					no_of_choosen_seats++;
				}
					break;
					
		case 31:
	
				if(flag_case31)
				{
					seatButton[3][1].setImageResource(R.drawable.white);
					flag_case31 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[3][1].setImageResource(R.drawable.green);
					flag_case31 = true;
					no_of_choosen_seats++;
				}
				break;
				
		case 32:
	
			if(flag_case32)
			{
				seatButton[3][2].setImageResource(R.drawable.white);
				flag_case32 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[3][2].setImageResource(R.drawable.green);
				flag_case32 = true;
				no_of_choosen_seats++;
			}
			break;
			
		case 33:
			
			if(flag_case33)
			{
				seatButton[3][3].setImageResource(R.drawable.white);
				flag_case33 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[3][3].setImageResource(R.drawable.green);
				flag_case33 = true;
				no_of_choosen_seats++;
			}
			break;
			
		 case 34:
				
				if(flag_case34)
				{
					seatButton[3][4].setImageResource(R.drawable.white);
					flag_case34 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[3][4].setImageResource(R.drawable.green);
					flag_case34 = true;
					no_of_choosen_seats++;
				}
					break;
					
		case 35:
	
				if(flag_case35)
				{
					seatButton[3][5].setImageResource(R.drawable.white);
					flag_case35 = false;
					no_of_choosen_seats--;
				}
				else if(no_of_choosen_seats < no_of_seats)
				{
					seatButton[3][5].setImageResource(R.drawable.green);
					flag_case35 = true;
					no_of_choosen_seats++;
				}
				break;
				
				
		case 40:
			
			if(flag_case40)  // for true
			{
				seatButton[4][0].setImageResource(R.drawable.white);
				flag_case40 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[4][0].setImageResource(R.drawable.green);
				flag_case40 = true;
				no_of_choosen_seats++;
			}
			break;
			
	 case 41:
		 
			if(flag_case41)
			{
				seatButton[4][1].setImageResource(R.drawable.white);
				flag_case41 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[4][1].setImageResource(R.drawable.green);
				flag_case41 = true;
				no_of_choosen_seats++;
			}
				break;
				
	case 42:
			
			if(flag_case42)
			{
				seatButton[4][2].setImageResource(R.drawable.white);
				flag_case42 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[4][2].setImageResource(R.drawable.green);
				flag_case42 = true;
				no_of_choosen_seats++;
			}
				break;
				
	case 43:
		
		if(flag_case43)
		{
			seatButton[4][3].setImageResource(R.drawable.white);
			flag_case43 = false;
			no_of_choosen_seats--;
		}
		else if(no_of_choosen_seats < no_of_seats)
		{
			seatButton[4][3].setImageResource(R.drawable.green);
			flag_case43 = true;
			no_of_choosen_seats++;
		}
			break;
				
	 case 44:
			
			if(flag_case44)  // for true
			{
				seatButton[4][4].setImageResource(R.drawable.white);
				flag_case44 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[4][4].setImageResource(R.drawable.green);
				flag_case44 = true;
				no_of_choosen_seats++;
			}
			break;
			
	 case 45:
		 
			if(flag_case45)
			{
				seatButton[4][5].setImageResource(R.drawable.white);
				flag_case45 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[4][5].setImageResource(R.drawable.green);
				flag_case45 = true;
				no_of_choosen_seats++;
			}
				break;
				
				
				
	 case 50:
			
			if(flag_case50)  // for true
			{
				seatButton[5][0].setImageResource(R.drawable.white);
				flag_case50 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[5][0].setImageResource(R.drawable.green);
				flag_case50 = true;
				no_of_choosen_seats++;
			}
			break;
			
	 case 51:
		 
			if(flag_case51)
			{
				seatButton[5][1].setImageResource(R.drawable.white);
				flag_case51 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[5][1].setImageResource(R.drawable.green);
				flag_case51 = true;
				no_of_choosen_seats++;
			}
				break;
				
	case 52:
			
			if(flag_case52)
			{
				seatButton[5][2].setImageResource(R.drawable.white);
				flag_case52 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[5][2].setImageResource(R.drawable.green);
				flag_case52 = true;
				no_of_choosen_seats++;
			}
				break;
				
	case 53:
		
		if(flag_case53)
		{
			seatButton[5][3].setImageResource(R.drawable.white);
			flag_case53 = false;
			no_of_choosen_seats--;
		}
		else if(no_of_choosen_seats < no_of_seats)
		{
			seatButton[5][3].setImageResource(R.drawable.green);
			flag_case53 = true;
			no_of_choosen_seats++;
		}
			break;
				
	 case 54:
			
			if(flag_case54)  // for true
			{
				seatButton[5][4].setImageResource(R.drawable.white);
				flag_case54 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[5][4].setImageResource(R.drawable.green);
				flag_case54 = true;
				no_of_choosen_seats++;
			}
			break;
			
	 case 55:
		 
			if(flag_case55)
			{
				seatButton[5][5].setImageResource(R.drawable.white);
				flag_case55 = false;
				no_of_choosen_seats--;
			}
			else if(no_of_choosen_seats < no_of_seats)
			{
				seatButton[5][5].setImageResource(R.drawable.green);
				flag_case55 = true;
				no_of_choosen_seats++;
			}
				break;
			

		}
		
	}
	
	public void makePayment(View view)
	{
		if(no_of_choosen_seats == no_of_seats)
		{
		intent=new Intent(this,Bank.class);
		intent.putExtra(EXTRA_AMT, amt);
		intent.putExtra(EXTRA_MOVIE, movieName);
		intent.putExtra(EXTRA_DATE, date);
		intent.putExtra(EXTRA_TIME, time);
		intent.putExtra(EXTRA_SEAT, no_of_seats);
		intent.putExtra(EXTRA_MOVIECOPY, movieNameCopy);

		startActivity(intent);
		}
		else
		{
			new AlertDialog.Builder(this).setTitle("Invalid").setMessage("Please choose "+no_of_seats+" seats")
			   .setNeutralButton("OK",null).show();
		}
	}
	
}

