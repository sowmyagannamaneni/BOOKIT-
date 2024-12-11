package movie.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandlerCredit extends SQLiteOpenHelper{
	
	
	public static final String DATABASE_NAME="myBBank.db";
	public static final int DATABASE_VERSION=4;
	
	public static final String CREDIT_TABLE="creditTable";
	public static final String ACC_NO="_id";
	public static final String CARD_NUMBER="cardNumber";
	public static final String CVV="cvvCode";
	public static final String CARD_NAME="cardName";
	public static final String BALANCE="balance";
	public static final String PHONE="phoneno";
	public static final String TYPE="type";
	

	
	
	public String COLUMNS[]={ACC_NO,CARD_NUMBER,CVV,CARD_NAME,BALANCE,TYPE,PHONE};
	
	public  int acc;
	public String cardNo;
	public String cvvNo;
	public int bal;
	public String cType;
	public String phn;
	
	Cursor cursor;
	SQLiteDatabase db;
	
	public DatabaseHandlerCredit(Context context)
	{
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}
	
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("CREATE TABLE "+CREDIT_TABLE+"("+ACC_NO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CARD_NUMBER+" INTEGER,"+CVV+" INTEGER,"+CARD_NAME+" TEXT,"+BALANCE+" INTEGER,"+TYPE+", TEXT,"+PHONE+" TEXT)");
		
		ContentValues cv=new ContentValues();
		
		cv.put(CARD_NUMBER,"1234 5678 9012 3456");
		cv.put(CVV, 1234);
		cv.put(CARD_NAME,"credit card");
		cv.put(BALANCE, 4000);
		cv.put(TYPE, "credit");
		cv.put(PHONE, "8558811605");
		
		db.insert(CREDIT_TABLE,null,cv);
		
		cv.put(CARD_NUMBER,"0987 6543 2109 8765");
		cv.put(CVV, 4321);
		cv.put(CARD_NAME,"credit card");
		cv.put(BALANCE, 5000);
		cv.put(TYPE,"debit");
		cv.put(PHONE, "8558811605");
		
		db.insert(CREDIT_TABLE,null,cv);
		
	}
	
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS "+CREDIT_TABLE);
		onCreate(db);
	}
	
	
	public boolean matchDetails(String cardNo,String cvvNo,String cttype)
	{
		db=getReadableDatabase();
		
		Cursor cursor=db.rawQuery("SELECT * FROM "+CREDIT_TABLE+" WHERE cardNumber=? and cvvCode=? and type=?",new String[]{cardNo,cvvNo,cttype});
		if (cursor != null) {
			cursor.moveToFirst();
			if(cursor.getCount() > 0)
			{
			acc= cursor.getInt(0);

			this.bal=cursor.getInt(cursor.getColumnIndex(BALANCE));
			this.cType=cursor.getString(cursor.getColumnIndex(TYPE));
			this.phn=cursor.getString(cursor.getColumnIndex(PHONE));
			return true;
			}
		}
		db.close();
		return false;
	}

	public void updateBalance(int acc,int amount,String cardT)
	{
		db=getWritableDatabase();
		amount();
		ContentValues cv=new ContentValues();
		int amountt;
		
		if(cardT.equals("credit")){
			amountt=bal+amount;
			cv.put(BALANCE, amountt);
			db.update(CREDIT_TABLE, cv, ACC_NO+"=?",new String[]{String.valueOf(acc)}); 
			Log.d("Balance",String.valueOf(amountt));
		}
		
		if(cardT.equals("debit"))
		{
			amountt=bal-amount;	
			cv.put(BALANCE, amountt);
			db.update(CREDIT_TABLE, cv, ACC_NO+"=?",new String[]{String.valueOf(acc)}); 
			Log.d("Balance",String.valueOf(amountt));
		}
			
      db.close();
	
	}
	
	public String getCard()
	{
		return cardNo;
	}
	
	public String getCvv()
	{
		return cvvNo;
	}
	
	public int amount()
	{
		return bal;
	}
	
	public String getCardType()
	{
		return cType;
	}
	
	public String getPhone()
	{
		return phn;
	}
	
}
