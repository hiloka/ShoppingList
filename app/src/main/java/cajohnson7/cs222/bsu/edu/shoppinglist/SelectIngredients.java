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
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class SelectIngredients extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ingredients);
        String[] ingredients = { "pop", "chicken", "tacos", "cake"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        ingredients);
        Spinner spinner=
                (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);
        RelativeLayout myLayout= (RelativeLayout) findViewById(R.id.myFrame);
        myListener2 listening = new myListener2();
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
                Intent myIntent = new Intent(SelectIngredients.this, IngredientsSelectedView.class);
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
class myListener2 implements View.OnClickListener {
    ArrayList myArray = new ArrayList();
    IngredientsCart myCart= new IngredientsCart();
    RelativeLayout myLayout;
    public void setLayOut(RelativeLayout input){
        this.myLayout=input;
        System.out.println("added layout");
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            System.out.println("button4");
            Spinner getSpinner = (Spinner) this.myLayout.findViewById(R.id.spinner);
            String getSpinnerValue = (String) getSpinner.getSelectedItem();
            myCart.addItemToCart(getSpinnerValue);
            System.out.println(getSpinnerValue);
            TextView myTextView =
                    (TextView)this.myLayout.findViewById(R.id.textView2);
            TextView myTextView2 =
                    (TextView)this.myLayout.findViewById(R.id.textView4);
            ScrollView myScrollView = (ScrollView) this.myLayout.findViewById(R.id.scrollView);
            myTextView.setMovementMethod(new ScrollingMovementMethod());
            myScrollView.scrollTo(0, myTextView.getHeight());
         myTextView.setText(myCart.returnedCart());
            myTextView2.setText("you have "+myCart.cartSize()+" items in the cart");
        }
        else if (v.getId()==R.id.button4){
            System.out.println("button");
            myCart.removeItemFromCart();
            TextView myTextView =
                    (TextView)this.myLayout.findViewById(R.id.textView2);
            TextView myTextView2 =
                    (TextView)this.myLayout.findViewById(R.id.textView4);
            myTextView.setText(myCart.returnedCart());
            myTextView2.setText("you have "+myCart.cartSize()+" items in the cart");
            ScrollView myScrollView = (ScrollView) this.myLayout.findViewById(R.id.scrollView);
            myTextView.setMovementMethod(new ScrollingMovementMethod());
            myScrollView.scrollTo(0, myTextView.getHeight());
        }
        else if(v.getId()==R.id.button2){
        }
        else{
            System.out.println("no button");
        }
    }
}
