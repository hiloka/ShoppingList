package edu.bsu.cs222.shoppingList;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;

import cajohnson7.cs222.bsu.edu.shoppinglist.R;

class ButtonEvent  implements View.OnClickListener {
    private IngredientsCart shoppingCart = new IngredientsCart();
    private  RelativeLayout myLayout;
    private Context tempContext;
    private AdapterClass4 myAdapter2;

    
    public void setLayOut(RelativeLayout input){
        this.myLayout=input;
    }
    @Override
    public void onClick(View v) {
        ListView itemsInCart =
                (ListView)this.myLayout.findViewById(R.id.listView2);
        TextView amountOfItems =
                (TextView)this.myLayout.findViewById(R.id.textView4);
        if(v.getId()==R.id.button){
            Spinner ingredientsSpinner = (Spinner) this.myLayout.findViewById(R.id.spinner);
            String getSpinnerValue = (String) ingredientsSpinner.getSelectedItem();
            myAdapter2.add(getSpinnerValue);
            System.out.println(myAdapter2.cartSize());
        }
        else if (v.getId()==R.id.button4){
            myAdapter2.remove();
        }
        else{
            amountOfItems.setText("no button");
        }
        itemsInCart.setAdapter(myAdapter2.mainAdapter());//used to be mainAdapter()
         amountOfItems.setText("you have " + myAdapter2.cartSize() + " items in the cart");
    }
    public void setContext(Context input){//temp add
        tempContext=input;
        //tempContext=this.myLayout.getContext();
        setUpAdapter();//added for myadapter2
    }
    private void setUpAdapter(){
        this.myAdapter2 = new AdapterClass4(tempContext,android.R.layout.simple_list_item_1);
    }

}

