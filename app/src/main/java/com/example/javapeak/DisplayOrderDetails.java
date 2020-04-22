package com.example.javapeak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayOrderDetails extends AppCompatActivity {
    Intent intent;
    String message;
    String name;
    String totalCost;
    CoffeeDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHandler = new CoffeeDBHandler(this, null, null, 1);
        setContentView(R.layout.activity_display_order_details);
        //Catch the message that's been sent and display the details
        intent = getIntent();
        name = intent.getStringExtra("name");
        message = getIntent().getStringExtra("sendMessage");
        totalCost = intent.getStringExtra("cost");
        //Display the message in this Activity
        TextView displayText = (TextView)findViewById(R.id.displayText);
        displayText.setText(message);
    }

    //Method to display the Email
        public void emailOrder(View v){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "coffee order by"+name);
            intent.putExtra(Intent.EXTRA_TEXT,message);

            if (intent.resolveActivity(getPackageManager()) !=null){
                startActivity(intent);
            }
    }

    //a new method to save the record in a database
    public void addButtonClicked(View view){
        // start the new intent here
        int intTotalCost = Integer.parseInt(totalCost);
        Order order = new Order(name,intTotalCost);
        dbHandler.addOrder(order);
        Toast.makeText(getApplicationContext(), "Data Saved!",Toast.LENGTH_SHORT).show();
    }
    //method that will help to generate a report on a new activity
    public void salesReport(View view){
        //read the details from hte database to produce the report
        String dbString = dbHandler.databaseToString();
        //start the new intent here
        Intent salesIntent = new Intent(this, DisplaySalesDetails.class);
        salesIntent.putExtra("db", dbString);
        startActivity(salesIntent);
    }
}
