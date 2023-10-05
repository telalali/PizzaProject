package com.example.pizzaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmSizeAndOrderActivity extends AppCompatActivity {
    /**
     * This app displays an order form to order coffee.
     */
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmsize_andorder);

    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Find the user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String value = nameField.getText().toString();
        //Figure out if the user wants whipped cream topping
        CheckBox smallCheckBox = (CheckBox) findViewById(R.id.small_checkbox);
        boolean hasSmall = smallCheckBox.isChecked();
        CheckBox mediumCheckBox = (CheckBox) findViewById(R.id.medium_checkbox);
        boolean hasMedium = mediumCheckBox.isChecked();
        //Figure out if the user wants chocolate topping
        CheckBox largeCheckBox = (CheckBox) findViewById(R.id.large_checkbox);
        boolean hasLarge = largeCheckBox.isChecked();
        int price = calculatePrice(hasSmall, hasMedium, hasLarge);
        String priceMessage = createOrderSummary(value, price, hasSmall, hasMedium, hasLarge );
        displayMessage(priceMessage);
    }

    /**
     * This method calculates the total price.
     */
    private int calculatePrice(boolean addSmall, boolean addMedium, boolean addLarge) {
        //Price of 1 cup of coffee
        int basePrice = 7;
        //Add $1 if the user wants small
        if (addSmall) {
            basePrice = basePrice + 1;
        }
        //Add $2 if the user wants medium
        if (addMedium) {
            basePrice = basePrice + 2;
        }
        if (addLarge) {
            basePrice = basePrice + 3;
        }
        //Calculate the total order price
        return quantity * basePrice;
    }

    /**
     * This method creates a summary of order.
     */
    private String createOrderSummary(String name, int price, boolean addSmall, boolean addMedium, boolean addLarge) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd small? " + addSmall;
        priceMessage += "\nAdd medium? " + addMedium;
        priceMessage += "\nAdd large? " + addLarge;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfPizza) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfPizza);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);
    }
}