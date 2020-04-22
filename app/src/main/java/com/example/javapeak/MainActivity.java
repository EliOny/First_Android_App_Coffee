/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.javapeak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;
/**

 This app displays an order form to order coffee.
 */



public class MainActivity extends AppCompatActivity {
    //declare global variable
    int noOfCoffee = 0;
    int priceOfCoffee = 5;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //create a new method for ORDER button
    public void submitOrder(View v) {
        //---------------------------------------------------------------------------------
            //TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        //calculate total price
        //int totalCost = noOfCoffee * priceOfCoffee;
        //display to display price
        //display(noOfCoffee);
            //priceTextView.setText("Total: $" + totalCost + "\n" + "Thank you!");
        //---------------------------------------------------------------------------------
        //Store username in a String
        EditText userName = (EditText) findViewById(R.id.userName);
        String name = userName.getText().toString();


        //Figure out if the user wants Whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox)
                findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //Figure out if the user wants Chocolate topping
        CheckBox chocolateCheckBox = (CheckBox)
                findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        //call the calculateTotalPrice() method
        int cost = calculateTotalPrice(hasWhippedCream, hasChocolate);
        String strCost = Integer.toString(cost);
        //Create the message String
        String message = "Name: "+name+"\n"+
                "Add whipped cream? "+hasWhippedCream+"\n"+
                "Add chocolate? "+hasChocolate+"\n"+
                "Quantity: "+noOfCoffee+"\n"+
                "Total: $"+cost+"\n"+
                "Thank You!";

        //create a new Explicit Intent to pass the Message
        Intent intent = new Intent(this, DisplayOrderDetails.class);
        intent.putExtra("name",name);
        intent.putExtra("sendMessage",message);
        intent.putExtra("cost",cost);
        startActivity(intent);
    }

    //Method to calculate the total price of coffee
    public int calculateTotalPrice (boolean whippedCream, boolean chocolate){
        if (whippedCream == true) {
            priceOfCoffee = priceOfCoffee + 2;
        }
        if(chocolate == true){
            priceOfCoffee = priceOfCoffee + 1;
        }
        int totalCost = priceOfCoffee * noOfCoffee;
        return totalCost;
    }


    //method to display
    public void display(int number) {
        //create objects of the TextView
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        quantityTextView.setText("" + number);
        //priceTextView.setText(number);
    }

    //declare a method to increase the noOfCoffee
    public void increment(View v) {
        noOfCoffee = noOfCoffee + 1;
        if (noOfCoffee >= 10){
            noOfCoffee = 10;
        }
        display(noOfCoffee);
    }

    public void decrement(View v) {
        noOfCoffee = noOfCoffee - 1;
        if (noOfCoffee <= 0){
            //reset the noOfCoffee to 0
            noOfCoffee = 0;
        }
        display(noOfCoffee);
    }



}