package com.Sjaastad.RecipeDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlHelperClass extends SQLiteOpenHelper {

	/*
	 * This class extends SqlLiteOpenHelper It creates the database and the
	 * tables and sets static constants that are used in the other classes
	 */

	// set database as priiate constatn
	private static final String DATABASE_NAME = "RecipeResources.db";
	private static final int DATABASE_VERSION = 1;

	// public constants
	// database table
	public static final String TABLE_NAME = "Recipe";

	// columns
	public static final String RECIPE_ID = "recipeId";
	public static final String RECIPE_NAME = "Name";
	public static final String RECIPE_DESCRIPTION = "Description";
	public static final String RECIPE_INGREDEINTS = "Ingredeints";

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
		String sql_Recipe = "CREATE TABLE " + TABLE_NAME + "(" + RECIPE_ID
				+ " integer primary key autoincrement, " + RECIPE_NAME
				+ " text not null, " + RECIPE_DESCRIPTION + " text not null, "
				+ RECIPE_INGREDEINTS + " text blob, " + "unique (" + RECIPE_NAME + "))";
//for assignment 6
//change "int" to "text blob"
		
		// add the table to the database
		db.execSQL(sql_Recipe);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// You should put code here to handle new versions of the database

	}

}