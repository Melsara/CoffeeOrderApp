package com.sardegnaisoladicavalli.example.justjava;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    int quantity = 1;
    int price = 5;
    int calculatedPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Handles the state of the Whipped Cream topping checkbox.
     * @return isChecked_1
     *
     */

    private boolean topping1State () {
        CheckBox topping1 = (CheckBox) findViewById(R.id.topping_1);
        Boolean isChecked_1 = topping1.isChecked();
        return isChecked_1;
    }

    /**
     * Handles the state of the Chocolate topping checkbox.
     * @return isChecked_2
     *
     */

    private boolean topping2State () {
        CheckBox topping2 = (CheckBox) findViewById(R.id.topping_2);
        Boolean isChecked_2 = topping2.isChecked();
        return isChecked_2;
    }

    /**
     * Calculates the price of the order.
     * @param isChecked_1 (for whipped cream)
     * @param isChecked_2 (for chocolate)
     * @return calculated price of the order
     *
     */
    private int calculatePrice(boolean isChecked_1, boolean isChecked_2) {
        int baseprice = 0;
        if (isChecked_1 && isChecked_2) {
            baseprice = 3;
        } else if (isChecked_1) {
            baseprice = 1;
        } else if (isChecked_2) {
            baseprice = 2;
        }

        calculatedPrice = quantity * (price + baseprice);
        return calculatedPrice;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        Boolean submitChecked_1 = topping1State();
        Boolean submitChecked_2 = topping2State();
        calculatePrice(submitChecked_1, submitChecked_2);
        String message = createOrderSummary(calculatedPrice);
        displayMessage(message);
    }


    /** Creates the order summary.
     * @param calculatedPrice
     * @return orderSummary
     */

    private String createOrderSummary (int calculatedPrice) {
        Boolean isChecked_1 = topping1State();
        Boolean isChecked_2 = topping2State();
        String topping1Y = isChecked_1 ? "Yes" : "No";
        String topping2Y = isChecked_2 ? "Yes" : "No";
        EditText userName = (EditText) findViewById(R.id.userName);
        String userNameString = userName.getText().toString();
        String orderSummary = "Name: " + userNameString + "\n";
        orderSummary += "Add whipped cream? " + topping1Y + "\n";
        orderSummary += "Add chocolate topping? " + topping2Y + "\n";
        orderSummary += "Quantity: " + quantity + "\n";
        orderSummary += "Total: " + calculatedPrice + "\n";
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(orderSummary);
        return orderSummary;
    }


    public void displayToast (CharSequence toastText) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }


    /**
     * This method is called when the increment button is clicked.
     */

    public void increment (View view) {
        quantity = quantity +1;
        if (quantity>=10) {
            quantity = 10;
            displayToast("Cannot order more than 10 coffees");
        }
        displayQuantity (quantity);
    }

    /**
     * This method is called when the increment button is clicked.
     */

    public void decrement (View view) {
        quantity = quantity -1;
        if (quantity==1 | quantity<1) {
            quantity = 1;
            displayToast("Cannot order less than 1 coffee");
        }
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
