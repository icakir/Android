package com.Erik.doctorwho;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.Erik.doctorwho.R;

public class DoctorActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctors);
		try
		{
			getDoctors();
		}
		catch(Exception e){
		 Log.e("DEBUG", "Failed to load Doctors",e);
		}
	}

	private void getDoctors()throws XmlPullParserException, IOException{
		TableLayout doctorTable=(TableLayout)findViewById(R.id.tableLayout_doctors);
		
		XmlResourceParser doctorsXML=getResources().getXml(R.xml.doctorlist);
		
		int eventType=-1;
		
		while (eventType != XmlResourceParser.END_DOCUMENT){
			if (eventType==XmlResourceParser.START_TAG){
				String strName=doctorsXML.getName();
				
				if (strName.equals("doctor")){
					String doctorNumber=doctorsXML.getAttributeValue(null,"number");
					String doctorName=doctorsXML.getAttributeValue(null,"name");
					String doctorTenure=doctorsXML.getAttributeValue(null,"tenure");
					insertDoctorRow(doctorTable, doctorNumber, doctorName, doctorTenure);
				}
			}
			eventType=doctorsXML.next();
		}
		
	}
	
	private void insertDoctorRow(final TableLayout doctorTable, String doctorNumber, String doctorName, String doctorTenure){
		
		final TableRow newRow=new TableRow(this);
		addTextToRowWithValues(newRow, doctorNumber);
		addTextToRowWithValues(newRow, doctorName);
		addTextToRowWithValues(newRow, doctorTenure);
		
		doctorTable.addView(newRow);
	}
	
	private void addTextToRowWithValues(final TableRow tableRow, String text){
		TextView textView = new TextView(this);
		textView.setText(text);
		tableRow.addView(textView);
	}
	
	@Override
	public void onStop(){
		super.onStop();
	}
}
