package com.Erik.SQLIteDatabase;

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
		String[] columns = new String[] { sqlHelper.BOOK_TITLE,
				sqlHelper.BOOK_AUTHOR, sqlHelper.BOOK_RATING };

		// start a cursor to move through the records
		Cursor cursor = db.query(sqlHelper.TABLE_NAME, columns, null, null,
				null, null, null);

		String result = "";
		// use the cursor to loop through the records
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			// I am just concatenating the records into a string
			// terminated by a line break
			result += cursor.getString(0) + ", " + cursor.getString(1) + "--"
					+ cursor.getInt(2) + "\n";
		}

		// assign the result to the textview
		TextView content = (TextView) findViewById(R.id.textView1);
		content.setText(result);
	}
}