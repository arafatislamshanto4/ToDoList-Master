package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNewItem;
    private Button btnAddItem;
    private ListView lvItems;
    private ArrayAdapter<String> itemsAdapter;
    private ArrayList<String> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etNewItem = findViewById(R.id.et_new_item);
        btnAddItem = findViewById(R.id.btn_add_item);
        lvItems = findViewById(R.id.lv_items);

        // Initialize the ArrayList and ArrayAdapter
        itemsList = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemsList);

        // Set the adapter to the ListView
        lvItems.setAdapter(itemsAdapter);

        // Set up the button click listener
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = etNewItem.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    // Add item to the list and update the adapter
                    itemsList.add(newItem);
                    itemsAdapter.notifyDataSetChanged();
                    etNewItem.setText("");  // Clear the input field
                    Toast.makeText(MainActivity.this, "Item added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter text", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
