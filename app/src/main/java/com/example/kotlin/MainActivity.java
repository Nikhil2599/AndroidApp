package com.example.kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
        EditText etContact;
        TextView tvHome;
        public static String TAG = MainActivity.class.getSimpleName();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                int a=10;
                setContentView(R.layout.activity_main);
                etContact = findViewById(R.id.etName);
                tvHome = findViewById(R.id.tvMain);
       // etContact = findViewById(R.id.etContact);
       // tvHome = findViewById(R.id.tvHome);
         /* String name = getIntent().getExtras().getString("nkey");
       tvHome.setText("hello "+name);*/
        }

        public void handleClicks(View viewClicked) {
                //get the data to be sent
                String contactData = etContact.getText().toString();
                //send the data to the parent activity
                Intent dIntent = new Intent();
                dIntent.putExtra("con",contactData);
                setResult(RESULT_OK,dIntent); //smell-headsup to inform the parent activity
                //close this activity
                finish();

        }
}


