package edu.bsu.cs222.shoppingList;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import cajohnson7.cs222.bsu.edu.shoppinglist.R;

public class PickIngredient extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_ingredient);
        String[] ingredients = {"pop","soda","meat","onions","milk"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ingredients);
        Spinner ingredientSpinner=
                (Spinner)findViewById(R.id.spinner);
        ingredientSpinner.setAdapter(stringArrayAdapter);
        RelativeLayout myLayout= (RelativeLayout) findViewById(R.id.myFrame);
        ButtonEvent buttonEventListener = new ButtonEvent();
        ////
        buttonEventListener.setContext(this);

        ///
        buttonEventListener.setLayOut(myLayout);
        Button addToCartButton = (Button) findViewById(R.id.button4);
        addToCartButton.setOnClickListener(buttonEventListener);
        Button removeFromCartButton = (Button) findViewById(R.id.button);
        removeFromCartButton.setOnClickListener(buttonEventListener);
        Button submitItButton = (Button)findViewById(R.id.button2);
        submitItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // temp remove all of this
                //TextView myTextView =
                       // (TextView) findViewById(R.id.textView2);
                //myTextView.setMovementMethod(new ScrollingMovementMethod());
                //String SubmitValue = myTextView.getText().toString();
                //Intent myIntent = new Intent(PickIngredient.this, IngredientSelector.class);
                //myIntent.putExtra("SubmitValue", SubmitValue);
                //startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_ingredients, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
