package com.Sjaastad.RecipeDatabase;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipeDatabaseActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button btnAdd = (Button)findViewById(R.id.button1);
		btnAdd.setOnClickListener(new AddRecordListener());
		
		Button btnView = (Button)findViewById(R.id.button2);
		btnView.setOnClickListener(new ViewRecordListener());
	}
	
	private class AddRecordListener implements View.OnClickListener{
		public void onClick(View V){
			Intent i = new Intent(RecipeDatabaseActivity.this, AddRecipesActivity.class);
			startActivity(i);
		}
	}
	
	private class ViewRecordListener implements View.OnClickListener{
		public void onClick(View V){
			Intent i = new Intent(RecipeDatabaseActivity.this, ViewRecordsActivity.class);
			startActivity(i);
		}
	}
}