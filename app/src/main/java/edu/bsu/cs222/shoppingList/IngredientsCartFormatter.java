package edu.bsu.cs222.shoppingList;

import android.content.Context;
import android.widget.ArrayAdapter;


public class IngredientsCartFormatter extends ArrayAdapter {
    private Context myContext;
    private int myResource;
    private IngredientsCart shoppingCart = new IngredientsCart();

    public IngredientsCartFormatter(Context context, int resource) {
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
        String adapterToString=shoppingCart.returnCart().toString();
        adapterToString=adapterToString.substring(1);
        adapterToString=adapterToString.substring(0,adapterToString.length()-1);
        return adapterToString.split(",");
    }
    public ArrayAdapter getAdapter(){
        return new ArrayAdapter<>(myContext,myResource, formatReturn());
    }
}
