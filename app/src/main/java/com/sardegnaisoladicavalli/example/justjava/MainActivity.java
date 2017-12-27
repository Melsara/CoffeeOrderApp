package com.sardegnaisoladicavalli.example.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    int quantity;
    int price = 5;
    int calculatedPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        calculatePrice();
        //String priceMessage = "You owe " + calculatedPrice + "$, dude! \n" + thankYou;
        createOrderSummary(calculatedPrice);
    }


    /** Creates the order summary.
     *
     * @params calculatedPrice
     */

    private String createOrderSummary (int calculatedPrice) {
        String name = "name ";
        String surname = "surname";
        String thankYou = "Thank you!";
        String orderSummary = "Name: " + name + surname + "\nQuantity: " + quantity + "\nTotal: " + calculatedPrice + "\n"  + thankYou;
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(orderSummary);
        return orderSummary;
    }

    /**
     * Calculates the price of the order.
     * 
     * @return calculated price of the order
     *
     */
    private int calculatePrice() {
        calculatedPrice = quantity * price;
        return calculatedPrice;
    }

    /**
     * This method is called when the increment button is clicked.
     */

    public void increment (View view) {
        quantity = quantity +1;
        displayQuantity (quantity);
    }

    /**
     * This method is called when the increment button is clicked.
     */

    public void decrement (View view) {
        quantity = quantity -1;
        displayQuantity (quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity (int coffeeQuantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + coffeeQuantity);
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
