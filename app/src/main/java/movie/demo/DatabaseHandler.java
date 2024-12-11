package movie.demo;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	
	public static final String DATABASE_NAME="Movie.db";
	public static final int DATABASE_VERSION=1;

	public static final String TABLE_NAME="MovieTable";
	public static final String COL_ID="_id";
	public static final String MOVIE_NAME="movieName";
	public static final String MOVIE_POSTER="poster";
	public static final String RELEASE_DATE="ReleaseDate";
	public static final String RUNTIME="Runtime";
	public static final String DIRECTOR="Director";
	public static final String GENRE="genre";
	public static final String LANGUAGE="language";
	public static final String RATING="rating";
	public static final String TRAILER="trailer";
	

	
	public String COLUMNS[]={COL_ID,MOVIE_NAME,MOVIE_POSTER,RELEASE_DATE,RUNTIME,DIRECTOR,GENRE,LANGUAGE,RATING,TRAILER};
	
	SQLiteDatabase db;
	ArrayList<String> posters;
	ArrayList<String> movie_names;
	
	public String name;
	public String date;
	public String time;
	public String director;
	public String genre;
	public String lang;
	public String image;
	public String video;
	public String screens;

	public int rate;
	

	public DatabaseHandler(Context context)
	{
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("CREATE TABLE "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY ,"+MOVIE_NAME+" TEXT,"+MOVIE_POSTER+" TEXT," 
	+RELEASE_DATE+" TEXT,"+RUNTIME+" TEXT,"+DIRECTOR+" TEXT,"+GENRE+" TEXT,"+LANGUAGE+" TEXT,"+RATING+" INTEGER,"+TRAILER+" TEXT)");
		
		ContentValues cv=new ContentValues();
		cv.put(COL_ID, 0);
		cv.put(MOVIE_NAME,"2 States");
		cv.put(MOVIE_POSTER, "states");
		cv.put(RELEASE_DATE, " 18 April 2014");
		cv.put(RUNTIME,"2 hrs 29 min");
		cv.put(DIRECTOR, "Abhishek Verma");
		cv.put(GENRE, "Comedy, Romance");
		cv.put(LANGUAGE, "Hindi");
		cv.put(RATING, 4);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=smbmkAbU5ao");	
		
		db.insert(TABLE_NAME,null,cv);
		
		cv.put(COL_ID, 1);
		cv.put(MOVIE_NAME,"The Amazing Spider-Man 2");
		cv.put(MOVIE_POSTER, "spiderm");
		cv.put(RELEASE_DATE, " 1 May 2014");
		cv.put(RUNTIME,"2 hrs 22 min");
		cv.put(DIRECTOR, "Marc webb");
		cv.put(GENRE, "Action, Fantasy, Adventure");
		cv.put(LANGUAGE, "English");
		cv.put(RATING, 4);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=nbp3Ra3Yp74");
		
		
		
		db.insert(TABLE_NAME,null,cv);
		
		
		cv.put(COL_ID, 2);
		cv.put(MOVIE_NAME,"Hawaa Hawaai");
		cv.put(MOVIE_POSTER, "hawaa");
		cv.put(RELEASE_DATE, "9 May 2014");
		cv.put(RUNTIME,"2 hrs 13 min");
		cv.put(DIRECTOR, "Amole Gupte");
		cv.put(GENRE, "Drama, Sports");
		cv.put(LANGUAGE, "Hindi");
		cv.put(RATING, 3);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=L8WEqUvoJw4");
		
		db.insert(TABLE_NAME,null,cv);
		
		
		cv.put(COL_ID, 3);
		cv.put(MOVIE_NAME,"Jatt James Bond");
		cv.put(MOVIE_POSTER, "jjames");
		cv.put(RELEASE_DATE, " 5 May 2014");
		cv.put(RUNTIME,"2 hrs 29 min");
		cv.put(DIRECTOR, "Rohit Jugraj");
		cv.put(GENRE, "Action, Thriller");
		cv.put(LANGUAGE, "Punjabi");
		cv.put(RATING, 4);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=LJWKjsTKrhI");
		
		db.insert(TABLE_NAME,null,cv);
		
		
		cv.put(COL_ID, 4);
		cv.put(MOVIE_NAME,"Dil Vil Pyaar Vyaar");
		cv.put(MOVIE_POSTER, "dil");
		cv.put(RELEASE_DATE, " 1 May 2014");
		cv.put(RUNTIME,"2 hrs 26 min");
		cv.put(DIRECTOR, "Manjeet Mann");
		cv.put(GENRE, "Drama,Family");
		cv.put(LANGUAGE, "Punjabi");
		cv.put(RATING, 4);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=mfmfE5MbhJE");
		
		db.insert(TABLE_NAME,null,cv);
		
		cv.put(COL_ID, 5);
		cv.put(MOVIE_NAME,"Rio 2 (3D)");
		cv.put(MOVIE_POSTER, "rio");
		cv.put(RELEASE_DATE, " 28 April 2014");
		cv.put(RUNTIME,"1 hrs 42 min");
		cv.put(DIRECTOR, "Carlos Saldanha");
		cv.put(GENRE, "Comedy, Advanture, Animation");
		cv.put(LANGUAGE, "English");
		cv.put(RATING, 3);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=IkZM1Zc0mBU");

		db.insert(TABLE_NAME,null,cv);
		
		
		cv.put(COL_ID, 6);
		cv.put(MOVIE_NAME,"Myself Ghaint");
		cv.put(MOVIE_POSTER, "myself");
		cv.put(RELEASE_DATE, " 9 May 2014");
		cv.put(RUNTIME,"1 hr 54 min");
		cv.put(DIRECTOR, "Akaashdeep singh");
		cv.put(GENRE, "Comedy, Romance");
		cv.put(LANGUAGE, "Punjabi");
		cv.put(RATING, 2);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=sVHdanJEH3U");

		db.insert(TABLE_NAME,null,cv);
		
		
		cv.put(COL_ID, 7);
		cv.put(MOVIE_NAME,"Million Dollar Arm");
		cv.put(MOVIE_POSTER, "million");
		cv.put(RELEASE_DATE, " 9 May 2014");
		cv.put(RUNTIME,"2 hrs 2 min");
		cv.put(DIRECTOR, "Craig Gillespie");
		cv.put(GENRE, "Drama, Sports");
		cv.put(LANGUAGE, "English");
		cv.put(RATING, 3);
		cv.put(TRAILER, "http://www.youtube.com/watch?v=EiC8o7i_ZqE");

		db.insert(TABLE_NAME,null,cv);
		
	}
	
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
		onCreate(db);
	}
	
	public ArrayList<String> getValues()
	{
		db=getReadableDatabase();
		Cursor cursor=db.query(TABLE_NAME, COLUMNS,null, null, null, null, null);
		
		 movie_names=new ArrayList<String>();
		posters=new ArrayList<String>();
	
		
		cursor.moveToFirst();
		
		while(!cursor.isAfterLast())
		{
			String a=cursor.getString(cursor.getColumnIndex(MOVIE_NAME));
			String b= cursor.getString(cursor.getColumnIndex(MOVIE_POSTER));
			
			
			cursor.moveToNext();
			
			movie_names.add(a);
			posters.add(b);
		}
		
		return movie_names;
	}
	
	public void getDetails(long id)
	{
		db=getReadableDatabase();
		Cursor cursor=db.query(TABLE_NAME,COLUMNS,COL_ID+"=?",new String[]{String.valueOf(id)},null,null,null);
		
		if(!cursor.isAfterLast())
		{
			cursor.moveToFirst();
			this.name=cursor.getString(cursor.getColumnIndex(MOVIE_NAME));
			this.date=cursor.getString(cursor.getColumnIndex(RELEASE_DATE));
			this.time=cursor.getString(cursor.getColumnIndex(RUNTIME));
			this.director=cursor.getString(cursor.getColumnIndex(DIRECTOR));
			this.genre=cursor.getString(cursor.getColumnIndex(GENRE));
			this.lang=cursor.getString(cursor.getColumnIndex(LANGUAGE));
			this.rate=cursor.getInt(cursor.getColumnIndex(RATING));
			this.image=cursor.getString(cursor.getColumnIndex(MOVIE_POSTER));
			this.video=cursor.getString(cursor.getColumnIndex(TRAILER));
	
		}
		cursor.close();
		db.close();
	}
	
	public ArrayList<String> getImages()
	{
		return posters;
	}
	
	public String getImage()
	{
		return image;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public String getDirector()
	{
		return director;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public String getLang()
	{
		return lang;
	}
	
	public int getRating()
	{
		return rate;
	}
	
	public String getVideo()
	{
		return video;
	}

	
}
