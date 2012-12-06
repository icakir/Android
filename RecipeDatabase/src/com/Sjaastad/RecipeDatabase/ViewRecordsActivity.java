package com.Sjaastad.RecipeDatabase;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ViewRecordsActivity extends Activity {

	/*
	 * Again, to make this simple, the getRecords method does more than one
	 * record should do
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_record);

		getRecords();
	}

	private void getRecords() {

		// initiate the SqlHeperClass and get the database
		SqlHelperClass sqlHelper = new SqlHelperClass(ViewRecordsActivity.this);
		SQLiteDatabase db = sqlHelper.getWritableDatabase();

		// create an array of the columns
		String[] columns = new String[] { sqlHelper.RECIPE_NAME,
				sqlHelper.RECIPE_DESCRIPTION, sqlHelper.RECIPE_INGREDEINTS };

		// start a cursor to move through the records
		Cursor cursor = db.query(sqlHelper.TABLE_NAME, columns, null, null,
				null, null, null);

		String result = "";
		// use the cursor to loop through the records
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			// I am just concatenating the records into a string
			// terminated by a line break
			result += "Recipe Name: " + cursor.getString(0) + "\n Description: " + cursor.getString(1) + "\n Ingredeints: "
					+ cursor.getString(2) + "\n\n";
		}

		// assign the result to the textview
		TextView content = (TextView) findViewById(R.id.textView1);
		content.setText(result);
	}
}