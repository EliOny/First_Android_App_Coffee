package com.example.javapeak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplaySalesDetails extends AppCompatActivity{
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_sales_details);
        //get the intent
        Intent intent = getIntent();
        message = intent.getStringExtra("db");
        // Capture the layout's TextView and set the string as its text
        TextView salesView = (TextView)findViewById(R.id.displayTextView);
        salesView.setText(message);
    }
    //method to return to the MainActivity
    public void reorder(View v){
        final Intent mainActivity = new Intent(this, MainActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainActivity);
    }
}
