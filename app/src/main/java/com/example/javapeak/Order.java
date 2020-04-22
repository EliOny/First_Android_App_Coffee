package com.example.javapeak;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class Order {
    //attributes of every order
    private int _id;
    private String _custName;
    private int _saleAmount;

    //default constructor
    public Order(){
        _id = 0;
        _custName = null;
        _saleAmount = 0;
    }

    //2nd constructor
    public Order(String custName, int saleAmount){
        custName = custName;
        saleAmount = saleAmount;
    }

    //get method
    public int get_id() { return _id; }
    public String get_custName() {return _custName; }
    public double get_saleAmount() {return _saleAmount; }
    //set methods

    public void set_id(int id) { _id = id; }
    public void set_custName(String custName) { _custName = custName; }
    public void set_saleAmount(int saleAmount) { _saleAmount = saleAmount; }

    /*public void addOrder(Order order){
        contentValues values = new ContentValues();
        values.put(COLUMN_CUSTOMERNAME, order.get_custName());
        values.put(COLUMN_SALEAMOUNT, order.get_saleAmount());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_COFFEE, null, values);
        db.close();


    }
   */
}
