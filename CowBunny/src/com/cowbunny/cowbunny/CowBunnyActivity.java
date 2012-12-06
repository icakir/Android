package com.cowbunny.cowbunny;

import android.app.Activity;
import android.os.Bundle;

public class CowBunnyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act3_pro_con);
    }
    
    
    
    @Override
	public void onStop() {
		super.onStop();
	}
    
}