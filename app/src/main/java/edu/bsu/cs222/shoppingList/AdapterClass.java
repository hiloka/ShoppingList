package edu.bsu.cs222.shoppingList;

import android.content.Context;
import android.widget.ArrayAdapter;


public class AdapterClass extends ArrayAdapter {
    private Context myContext;
    private int myResource;
    private IngredientsCart shoppingCart = new IngredientsCart();

    public AdapterClass(Context context, int resource) {
        super(context, resource);
        this.myContext=context;
        this.myResource=resource;
    }
    public void add(String input){
        shoppingCart.addItemToCart(input);
    }
    public void remove(String input){
        shoppingCart.removeItemFromCart(input);
    }
    public int cartSize(){
        return shoppingCart.cartSize();
    }
    private String[] formatReturn(){
        String AdapterToString=shoppingCart.returnCart().toString();
        AdapterToString=AdapterToString.substring(1);
        AdapterToString=AdapterToString.substring(0,AdapterToString.length()-1);
        return AdapterToString.split(",");
    }
    public ArrayAdapter mainAdapter(){
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(myContext,myResource, formatReturn());
        return itemsAdapter;
    }
}
