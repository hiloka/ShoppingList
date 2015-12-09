package edu.bsu.cs222.shoppingList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import cajohnson7.cs222.bsu.edu.shoppinglist.R;

public class ShoppingListCreator extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_creator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String[] ingredients = {"pop","soda","meat","onions","milk"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ingredients);
        Spinner ingredientSpinner=
                (Spinner)findViewById(R.id.spinner);
        ingredientSpinner.setAdapter(stringArrayAdapter);
        RelativeLayout myLayout= (RelativeLayout) findViewById(R.id.myFrame);
        ButtonListener buttonEventListener = new ButtonListener();
        buttonEventListener.setContext(this);
        buttonEventListener.setLayOut(myLayout);
        Button addToCartButton = (Button) findViewById(R.id.removeButton);
        addToCartButton.setOnClickListener(buttonEventListener);
        Button removeFromCartButton = (Button) findViewById(R.id.addButton);
        removeFromCartButton.setOnClickListener(buttonEventListener);
    }
}
