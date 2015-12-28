package com.gp.epsample;

import com.gp.controller.Utils;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

	EditText ed_email,ed_password;
	Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
		ed_email=(EditText)findViewById(R.id.ed_email);
		ed_password=(EditText)findViewById(R.id.ed_password);
		btn_login=(Button)findViewById(R.id.button1);

		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (!ed_email.getText().toString().equals("") && Utils.isValidEmail(ed_email.getText().toString().trim())) {
					// login
					if (ed_email.getText().toString().trim().equals("admin@admin.com") && 
							ed_password.getText().toString().equals("123123")) {
						Intent log=new Intent(getApplicationContext(), PlacePickerActivity.class);
						startActivity(log);
					}else{
						Toast.makeText(getApplicationContext(), "Please Enter correct details",  Toast.LENGTH_LONG).show();
					}
					
				}else
				{
					Toast.makeText(getApplicationContext(), "Please fill all field", Toast.LENGTH_LONG).show();
				}
					
				
			}
		});
		
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch (item.getItemId()) {
		case R.id.action_theme_ligth:
			Utils.changeToTheme(MainActivity.this,0);
			return true;
		case R.id.action_theme_dark:
			Utils.changeToTheme(MainActivity.this,1);
			return true;
		case R.id.action_theme_custom:
			Utils.changeToTheme(MainActivity.this,0);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	getMenuInflater().inflate(R.menu.main, menu);
		return true;
    }
}
