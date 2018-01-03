package com.sardegnaisoladicavalli.example.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        CheckBox topping1 = (CheckBox) findViewById(R.id.topping_1);
        Boolean isChecked_1 = topping1.isChecked();
        String topping1Y = isChecked_1 ? "Yes" : "No";
        CheckBox topping2 = (CheckBox) findViewById(R.id.topping_2);
        Boolean isChecked_2 = topping2.isChecked();
        String topping2Y = isChecked_2 ? "Yes" : "No";
        EditText userName = (EditText) findViewById(R.id.userName);
        String userNameString = userName.getText().toString();
        String message = createOrderSummary(calculatedPrice, topping1Y, topping2Y, userNameString);
        displayMessage(message);
    }


    /** Creates the order summary.
     *
     * @param calculatedPrice (price of the order)
     * @param topping1Y (whipped cream topping)
     * @param topping2Y (chocolate topping)
     * @return orderSummary
     */

    private String createOrderSummary (int calculatedPrice, String topping1Y, String topping2Y, String userNameString) {
        String orderSummary = userNameString + "\n";
        orderSummary += "Add whipped cream? " + topping1Y + "\n";
        orderSummary += "Add chocolate topping? " + topping2Y + "\n";
        orderSummary += "Quantity: " + quantity + "\n";
        orderSummary += "Total: " + calculatedPrice + "\n";
        //String orderSummary = "Name: " + name + surname + "\nQuantity: " + quantity + "\nTotal: " + calculatedPrice + "\n"  + thankYou;
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(orderSummary);
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
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

}
