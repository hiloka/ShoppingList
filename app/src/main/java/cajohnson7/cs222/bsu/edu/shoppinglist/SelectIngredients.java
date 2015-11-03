package cajohnson7.cs222.bsu.edu.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class SelectIngredients extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ingredients);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String[] ingredients = { "pop", "chicken", "tacos", "cake"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ingredients);
        Spinner spinner=
                (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);
        Button changeButton = (Button) findViewById(R.id.button);
         changeButton.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     IngredientsCart StoredIngredients= new IngredientsCart();
                     TextView myTextView =
                             (TextView) findViewById(R.id.textView2);
                     ScrollView myScrollView=(ScrollView) findViewById(R.id.scrollView);
                     myTextView.setMovementMethod(new ScrollingMovementMethod());
                     myScrollView.scrollTo(0,myTextView.getHeight());
                    Spinner getSpinner= (Spinner) findViewById(R.id.spinner);
                     String getSpinnerValue= (String) getSpinner.getSelectedItem();
                     String myValues=myTextView.getText().toString();
                     StoredIngredients.setStoredIngredients(myValues);
                     StoredIngredients.addItemToCart(getSpinnerValue);
                     myTextView.setText(StoredIngredients.returnedCart());
                 }
         });

        Button SubmitIt = (Button) findViewById(R.id.button2);
        SubmitIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView myTextView =
                        (TextView) findViewById(R.id.textView2);
                myTextView.setMovementMethod(new ScrollingMovementMethod());
                String SubmitValue=myTextView.getText().toString();
                Intent myIntent = new Intent(SelectIngredients.this, IngredientsSelectedView.class);
                myIntent.putExtra("SubmitValue",SubmitValue);
                startActivity(myIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_ingredients, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
