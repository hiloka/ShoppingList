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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectIngredients extends AppCompatActivity {
   public  static String spinnerString="hi";
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

        String[] ingrediants = { "pop", "chicken", "tacos", "cake"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ingrediants);
        Spinner spinner=
                (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);
        Button changeButton = (Button) findViewById(R.id.button);
         changeButton.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     ingredientsList myIngredients= new ingredientsList();
                     TextView myTextView =
                             (TextView) findViewById(R.id.textView2);
                     myTextView.setMovementMethod(new ScrollingMovementMethod());
                    Spinner getSpinner= (Spinner) findViewById(R.id.spinner);
                     String getSpinnerValue= (String) getSpinner.getSelectedItem();
                     String myValues=myTextView.getText().toString();
                     myValues=myValues+getSpinnerValue.toString()+System.getProperty("line.separator");
                     if(getSpinnerValue=="tacos"){
                        // myValues=myValues+"you selected"+myIngredients.getTaco();
                     }
                     System.out.println("hi");
                     System.out.println(myValues);
                     System.out.println(getSpinnerValue);
                     myTextView.setText(myValues.toString());
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
                Intent myIntent = new Intent(SelectIngredients.this, SecondActivity.class);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
