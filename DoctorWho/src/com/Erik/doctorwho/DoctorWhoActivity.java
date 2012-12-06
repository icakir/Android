package com.Erik.doctorwho;



import com.Erik.doctorwho.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DoctorWhoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnOverView;
        Button btnDoctors;
        
        btnOverView=(Button)findViewById(R.id.btn_Overview);
        btnOverView.setOnClickListener(new GetOverviewListener());
        
        btnDoctors=(Button)findViewById(R.id.btn_doctors);
        btnDoctors.setOnClickListener(new GetDoctorsListener());
        
    }
    private class GetOverviewListener implements View.OnClickListener{

		public void onClick(View v) {
			Intent i = new Intent(DoctorWhoActivity.this,OverViewActivity.class);
    		
    	
    		//start the new activity
    		startActivity(i);
			
		}
    	
    }
    
    private class GetDoctorsListener implements View.OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(DoctorWhoActivity.this,DoctorActivity.class);
    		
	    	
    		//start the new activity
    		startActivity(i);
		}
    	
    }
}