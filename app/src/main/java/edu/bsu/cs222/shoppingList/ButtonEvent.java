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
    private AdapterClass myAdapter = new AdapterClass();// temp added to see if adapter works like shopping cart
    //temp add
    private Context tempContext;
    
    public void setLayOut(RelativeLayout input){
        this.myLayout=input;
    }
    @Override
    public void onClick(View v) {
       // this.myLayout.getContext(); this might be a way to get the View context into this class without the getContext method of this class
        ListView itemsInCart =
                (ListView)this.myLayout.findViewById(R.id.listView2);
        TextView amountOfItems =
                (TextView)this.myLayout.findViewById(R.id.textView4);
        if(v.getId()==R.id.button){
            Spinner ingredientsSpinner = (Spinner) this.myLayout.findViewById(R.id.spinner);
            String getSpinnerValue = (String) ingredientsSpinner.getSelectedItem();
            myAdapter.addingToCart(getSpinnerValue);
            //shoppingCart.addItemToCart(getSpinnerValue);
        }
        else if (v.getId()==R.id.button4){
            myAdapter.removeingFromCart();
            //shoppingCart.removeItemFromCart();
        }
        else{
            amountOfItems.setText("no button");
        }
        //ScrollView myScrollView = (ScrollView) this.myLayout.findViewById(R.id.scrollView);
       // ArrayAdapter<String> itemsAdapter =
            //    new ArrayAdapter<String>(tempContext, android.R.layout.simple_list_item_1, formatReturn());// myAdapter.returnshoppingList2 used to be returnShoppingList and cast a third piremeter
        /////diffrent ways to get the adapter
        //itemsInCart.setAdapter(itemsAdapter);// formatReturn() can be subsituded for myAdapter.returnShoppingList3().toString().split(",")
        itemsInCart.setAdapter(mainAdapter());
        /////
        // itemsInCart2.add(myAdapter.setArray());
        //amountOfItems.setText("you have " + shoppingCart.cartSize() + " items in the cart");
         amountOfItems.setText("you have " + getArraySize() + " items in the cart");//this might violate MVC but this way i know the items are added
        //amountOfItems.setText("you have "+ itemsAdapter.getCount()+" items in the cart");
        ////
        itemsInCart.setSelection(mainAdapter().getCount() - 1);
        //
    }
    public void setContext(Context input){//temp add
        tempContext=input;
        //tempContext=this.myLayout.getContext();
    }
    private String[] formatReturn(){
        String AdapterToString=myAdapter.returnShoppingList3().toString();
        AdapterToString.split(",");
        AdapterToString.replace("[","");
        AdapterToString.replace("]", "");
        AdapterToString.trim();
        System.out.println(AdapterToString+"to string");
        return AdapterToString.split(",");
    }
    private ArrayAdapter mainAdapter(){
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(tempContext, android.R.layout.simple_list_item_1, formatReturn());
        return itemsAdapter;

    }
    private Integer getArraySize(){// this replaces the myAdapter.amountInCart() method
        return myAdapter.amountInCart();
    }

}

