package movie.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelperNet extends SQLiteOpenHelper{
	
	
	public static final String DATABASE_NAME="mNetBanking2.db";
	public static final int DATABASE_VERSION=1;
	
	public static final String NET_TABLE="netBank";
	public static final String NET_ACC="_id";
	public static final String NET_ID="userId";
	public static final String NET_PASS="password";
	public static final String NET_BAL="netamount";
	public static final String NET_NAME="userName";
	public static final String NET_BANK="bankName";
	public static final String NET_PHONE="phone";
	
	public int net_acc;
	public int nbal;
	public String uname;
	public String phoneNo;

	
	public String COLUMNS[]={NET_ACC,NET_ID,NET_PASS,NET_BAL,NET_NAME,NET_BANK,NET_PHONE};
	
	SQLiteDatabase db;
	
	
	public DatabaseHelperNet(Context context) {
		
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("CREATE TABLE "+NET_TABLE+"("+NET_ACC+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NET_ID+" TEXT,"+NET_NAME+" TEXT,"+NET_PASS+" INTEGER,"+NET_BAL+" INTEGER,"+NET_BANK+" TEXT,"+NET_PHONE+" TEXT)");
		ContentValues cv=new ContentValues();
		

		cv.put(NET_ID, "a1bcd");
		cv.put(NET_NAME, "Ria verma");
		cv.put(NET_PASS, 1234);
		cv.put(NET_BAL, 6000);
		cv.put(NET_BANK, "HDFC BANK");
		cv.put(NET_PHONE,"8558811605");
		
		db.insert(NET_TABLE, null, cv);
		
		
		cv.put(NET_ID, "a2bcd");
		cv.put(NET_NAME, "Sonakshi kapoor");
		cv.put(NET_PASS, 1234);
		cv.put(NET_BAL, 5000);
		cv.put(NET_BANK, "ICICI BANK");
		cv.put(NET_PHONE,"8558811605");
		
		db.insert(NET_TABLE, null, cv);
		
		cv.put(NET_ID, "a3bcd");
		cv.put(NET_NAME, "Neha ");
		cv.put(NET_PASS, 1234);
		cv.put(NET_BAL, 6000);
		cv.put(NET_BANK, "PNB BANK");
		cv.put(NET_PHONE,"8558811605");
		
		
		db.insert(NET_TABLE, null, cv);
		
		
		cv.put(NET_ID, "a4bcd");
		cv.put(NET_NAME, "Tanaya verma");
		cv.put(NET_PASS, 1234);
		cv.put(NET_BAL, 7000);
		cv.put(NET_BANK, "SBI BANK");
		cv.put(NET_PHONE,"8558811605");
		
		db.insert(NET_TABLE, null, cv);
		
		
		cv.put(NET_ID, "a5bcd");
		cv.put(NET_NAME, "sia kapoor");
		cv.put(NET_PASS,1234);
		cv.put(NET_BAL, 8000);
		cv.put(NET_BANK, "AXIS BANK");
		cv.put(NET_PHONE,"8558811605");
		
		db.insert(NET_TABLE, null, cv);
	
	}
	
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS "+NET_TABLE);
		onCreate(db);
	}
	
	
	public boolean netMatchDetails(String UID,String pass,String nbank)
	{
		db=getReadableDatabase();
		
		Cursor cursor=db.rawQuery("SELECT * FROM "+NET_TABLE+" WHERE userId=? and password=? and bankName=?",new String[]{UID,pass,nbank});
		if (cursor != null) {
			cursor.moveToFirst();
			if(cursor.getCount() > 0)
			{
			net_acc= cursor.getInt(0);
			this.uname=cursor.getString(cursor.getColumnIndex(NET_NAME));
			this.nbal=cursor.getInt(cursor.getColumnIndex(NET_BAL));
			this.phoneNo=cursor.getString(cursor.getColumnIndex(NET_PHONE));
			return true;
			}
		}
		db.close();
		return false;
	}
	
	public void updateNetBalance(int acc,int amt)
	{
		db=getWritableDatabase();
	
		ContentValues cv=new ContentValues();
		
		int amountt=nbal-amt;	
			cv.put(NET_BAL, amountt);
			db.update(NET_TABLE, cv, NET_ACC+"=?",new String[]{String.valueOf(acc)}); 
			Log.d("Now Balance--> ",String.valueOf(amountt));
			
      db.close();
	
	}
	
	public String getName()
	{
		return uname;
	}	
	
	public String getPhone()
	{
		return phoneNo;
	}
}