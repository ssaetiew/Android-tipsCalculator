package com.example.tipscalculator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
 
	EditText billTotalEditText;
	EditText tipPercentageEditText;
	TextView tipTotal;
	TextView amount;
	Button viewTip;
	double bill = 0;
	double total = 0;
	double percentage = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		billTotalEditText = (EditText) findViewById(R.id.billTotalEditText);
		tipPercentageEditText = (EditText) findViewById(R.id.tipPercentageEditText);
		tipTotal = (TextView) findViewById(R.id.tipTotal);
		amount = (TextView) findViewById(R.id.tipTotalTv);
		viewTip = (Button) findViewById(R.id.tipButton);
		
		billTotalEditText.addTextChangedListener(billWatcher);
		tipPercentageEditText.addTextChangedListener(tipWatcher);
		
		viewTip.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String url = "http://www.ehow.com/how_4764007_calculate-tips-head.html";
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				startActivity(intent);
			}
		});
	}
	TextWatcher billWatcher = new TextWatcher(){
		
		 @Override
		    public void afterTextChanged(Editable editable) {
			 bill = Double.parseDouble(billTotalEditText.getText().toString());
		  calculate();  
		 }

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			
		}
		
		
		
	};
	TextWatcher tipWatcher = new TextWatcher(){

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			percentage = Double.parseDouble(tipPercentageEditText.getText().toString());
			calculate();
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			
		}
		
		
	};

	private void calculate(){
		
		
		total = bill * (percentage/100);
		
		String tip = String.format("%.02f",total);
		
		total += bill;
		
		String pay = String.format("%.02f", total);
		tipTotal.setText("$"+tip);
		amount.setText("$"+pay);
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
