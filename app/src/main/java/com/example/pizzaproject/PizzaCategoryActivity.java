package com.example.pizzaproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PizzaCategoryActivity extends ListActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listPizza = getListView();

        ArrayAdapter<Pizza> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Pizza.pizza
        );
        listPizza.setAdapter(listAdapter);

        // Set up an item click listener
        listPizza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected Pizza item
                Pizza selectedPizza = (Pizza) parent.getItemAtPosition(position);

                // Create an Intent to start the next activity (replace NextActivity.class with the actual name of your next activity)
                Intent intent = new Intent(PizzaCategoryActivity.this, ConfirmSizeAndOrderActivity.class);

                // Pass any data you want to the next activity using extras (if needed)
                intent.putExtra("pizza_name", selectedPizza.getName());

                // Start the next activity
                startActivity(intent);
            }
        });
    }
}
