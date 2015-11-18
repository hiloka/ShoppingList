package cajohnson7.cs222.bsu.edu.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IngredientSelecter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_selected_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView myTextView;
        myTextView = (TextView) findViewById(R.id.textView3);
        int viewBottom=myTextView.getBottom();
        myTextView.scrollTo(0,viewBottom);
        myTextView.setMovementMethod(new ScrollingMovementMethod());
        Bundle extras = getIntent().getExtras();
        if(extras.get("SubmitValue")!=null) {
            String myShoppingList;
            myShoppingList = extras.get("SubmitValue").toString();
            myTextView.setText(myShoppingList);
        }
        Button backButton = (Button) findViewById(R.id.button3);
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(IngredientSelecter.this, PickIngredient.class));
            }
        });
    }
}

