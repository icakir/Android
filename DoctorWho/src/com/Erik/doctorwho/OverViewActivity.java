package com.Erik.doctorwho;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.Erik.doctorwho.R;

import android.util.*;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OverViewActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.overview);
		
		fillOverView();
		
		
		
	}
	
	private void fillOverView(){
		
		try{
			//create an Input stream to read the file
		InputStream overviewFile = getResources().openRawResource(R.raw.overview);
		//assign it to a string the method is down below
		String overviewData=inputStreamToString(overviewFile);
		
		//get the TextView
		TextView txtOverview=(TextView)findViewById(R.id.txtContent);
		//set the text
		txtOverview.setText(overviewData);
		
		}
		catch(IOException e)
		{
			Log.e("DEBUG","InputStreamToString failure");
		}
		
		
		
	}
	
	private String inputStreamToString(InputStream is) throws IOException{
		//create a buffer
		StringBuffer sBuffer = new StringBuffer();
		DataInputStream dataIO = new DataInputStream(is);
		String strLine=null;
		
		while((strLine=dataIO.readLine()) != null){
			sBuffer.append(strLine + "\n");
			
		}
		dataIO.close();
		is.close();
		return sBuffer.toString();
	}

}
