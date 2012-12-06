package com.Sjaastad.RecipeDatabase;



import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecipesActivity extends Activity {
	/*
	 * This activity adds records to the database. I purposefully kept this
	 * simple not breaking it into too many methods Consequently the AddRecord
	 * method does more than it probably should
	 */
	EditText txtName;
	EditText txtDescription;
	EditText txtIngredeints;
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
					AddRecipesActivity.this);
			SQLiteDatabase db = sqlHelper.getWritableDatabase();

			// get the values from the EditText controls

			txtName = (EditText) findViewById(R.id.editTextName);
			String name = txtName.getText().toString();

			txtDescription = (EditText) findViewById(R.id.editTextDescription);
			String description = txtDescription.getText().toString();

			txtIngredeints = (EditText) findViewById(R.id.editTextIngredeints);
			String ingredeints = txtIngredeints.getText().toString();

			// add the values from the EditViews to the columns
			ContentValues values = new ContentValues();
			values.put(SqlHelperClass.RECIPE_NAME, name);
			values.put(SqlHelperClass.RECIPE_DESCRIPTION, description);
			values.put(SqlHelperClass.RECIPE_INGREDEINTS, ingredeints);

			// Insert into the database
			long book_id = db.insert(SqlHelperClass.TABLE_NAME, null, values);
			db.close();

			// if the insert is successful
			if (book_id != -1) {
				// start a toast (a message)
				Toast toast = Toast.makeText(AddRecipesActivity.this,
						"Record Added", Toast.LENGTH_LONG);
				toast.show();
			} else {
				Toast toast = Toast.makeText(AddRecipesActivity.this,
						"Record failed to Insert", Toast.LENGTH_LONG);
				toast.show();
			}

			// clear for next record
			clearForm();

		}

	}

	private void clearForm() {
		txtName.setText("");
		txtDescription.setText("");
		txtIngredeints.setText("");
	}
}