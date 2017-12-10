package com.sardegnaisoladicavalli.example.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = 5;
        int totalPrice = quantity*price;
        String thankYou = "Thank you!";
        String priceMessage = "You owe " + totalPrice + "$, dude! \n" + thankYou;
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the increment button is clicked.
     */

    public void increment (View view) {
        quantity = quantity +1;
        display(quantity);
    }

    /**
     * This method is called when the increment button is clicked.
     */

    public void decrement (View view) {
        quantity = quantity -1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
