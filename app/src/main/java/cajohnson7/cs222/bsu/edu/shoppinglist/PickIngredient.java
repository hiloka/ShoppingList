package cajohnson7.cs222.bsu.edu.shoppinglist;
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

public class PickIngredient extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_ingredient);
        String[] ingredients = { "pop", "chicken", "tacos", "cake"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ingredients);
        Spinner spinner=
                (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);
        RelativeLayout myLayout= (RelativeLayout) findViewById(R.id.myFrame);
        ButtonEvent listening = new ButtonEvent();
        listening.setLayOut(myLayout);
        Button changeButton = (Button) findViewById(R.id.button4);
        changeButton.setOnClickListener(listening);
        Button changeButton2 = (Button) findViewById(R.id.button);
        changeButton2.setOnClickListener(listening);
        Button submitIt = (Button)findViewById(R.id.button2);
        submitIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView myTextView =
                        (TextView) findViewById(R.id.textView2);
                myTextView.setMovementMethod(new ScrollingMovementMethod());
                String SubmitValue = myTextView.getText().toString();
                Intent myIntent = new Intent(PickIngredient.this, IngredientsSelectedView.class);
                myIntent.putExtra("SubmitValue", SubmitValue);
                startActivity(myIntent);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
