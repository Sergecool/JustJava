package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view){
        int price = calculatePrice();
        Log.d("MainActivity","hjhjhhj" + price);
        String priceMessage = createOrderSummary(price);
        this.displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     * @return total price
     */
    private int calculatePrice(){
        int price = quantity * 5;
        return price;
    }

    /**
     * Create summary oh the order.
     *
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price){
        String priceMessage = "Name: kaptain kunal";
        priceMessage = priceMessage + "\nAdd whipped cream? ";
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" +price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }

    public void plusButton(View view){
        this.displayQuantity(++quantity);
    }

    public void minusButton(View view){
        if (quantity == 0)
            return;
        this.displayQuantity(--quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void displayQuantity(int numberOfCoffee){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }

    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}