package com.Erik.SQLIteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelperClass extends SQLiteOpenHelper {

	/*
	 * This class extends SqlLiteOpenHelper It creates the database and the
	 * tables and sets static constants that are used in the other classes
	 */

	// set database as priiate constatn
	private static final String DATABASE_NAME = "ProgramResources.db";
	private static final int DATABASE_VERSION = 1;

	// public constants
	// database table
	public static final String TABLE_NAME = "Book";

	// columns
	public static final String BOOK_ID = "bookId";
	public static final String BOOK_TITLE = "title";
	public static final String BOOK_AUTHOR = "author";
	public static final String BOOK_RATING = "Rating";

	// required constructor
	// takes the contest which is usually the current
	// activity, it also passes the database name and
	// version to the super class
	public SqlHelperClass(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// here we create the table
		String sql_Book = "CREATE TABLE " + TABLE_NAME + "(" + BOOK_ID
				+ " integer primary key autoincrement, " + BOOK_TITLE
				+ " text not null, " + BOOK_AUTHOR + " text not null, "
				+ BOOK_RATING + " int, " + "unique (" + BOOK_TITLE + "))";

		// add the table to the database
		db.execSQL(sql_Book);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// You should put code here to handle new versions of the database

	}

}