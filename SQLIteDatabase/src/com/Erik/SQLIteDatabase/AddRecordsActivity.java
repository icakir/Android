package com.Erik.SQLIteDatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecordsActivity extends Activity {
	/*
	 * This activity adds records to the database. I purposefully kept this
	 * simple not breaking it into too many methods Consequently the AddRecord
	 * method does more than it probably should
	 */
	EditText txtTitle;
	EditText txtAuthor;
	EditText txtRating;
	Button btnSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_record);

		btnSave = (Button) findViewById(R.id.button1);
		btnSave.setOnClickListener(new AddRecordListener());
	}

	private class AddRecordListener implements View.OnClickListener {

		public void onClick(View v) {

			// get database
			SqlHelperClass sqlHelper = new SqlHelperClass(
					AddRecordsActivity.this);
			SQLiteDatabase db = sqlHelper.getWritableDatabase();

			// get the values from the EditText controls

			txtTitle = (EditText) findViewById(R.id.editTextTitle);
			String title = txtTitle.getText().toString();

			txtAuthor = (EditText) findViewById(R.id.editTextAuthor);
			String author = txtAuthor.getText().toString();

			txtRating = (EditText) findViewById(R.id.editTextRating);
			String ratingString = txtRating.getText().toString();
			int rating = Integer.parseInt(ratingString);

			// add the values from the EditViews to the columns
			ContentValues values = new ContentValues();
			values.put(SqlHelperClass.BOOK_TITLE, title);
			values.put(SqlHelperClass.BOOK_AUTHOR, author);
			values.put(SqlHelperClass.BOOK_RATING, rating);

			// Insert into the database
			long book_id = db.insert(SqlHelperClass.TABLE_NAME, null, values);
			db.close();

			// if the insert is successful
			if (book_id != -1) {
				// start a toast (a message)
				Toast toast = Toast.makeText(AddRecordsActivity.this,
						"Record Added", Toast.LENGTH_LONG);
				toast.show();
			} else {
				Toast toast = Toast.makeText(AddRecordsActivity.this,
						"Record failed to Insert", Toast.LENGTH_LONG);
				toast.show();
			}

			// clear for next record
			clearForm();

		}

	}

	private void clearForm() {
		txtTitle.setText("");
		txtAuthor.setText("");
		txtRating.setText("");
	}
}