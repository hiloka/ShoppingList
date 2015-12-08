package edu.bsu.cs222.shoppingList;

import android.content.Context;
import android.widget.ArrayAdapter;


public class AdapterClass4 extends ArrayAdapter {
    private Context myContext;
    private int myResource;
    private IngredientsCart shoppingCart = new IngredientsCart();

    public AdapterClass4(Context context, int resource) {
        super(context, resource);
        this.myContext=context;
        this.myResource=resource;
    }
    public void add(String input){
        shoppingCart.addItemToCart(input);
    }
    public void remove(){
        shoppingCart.removeItemFromCart();
    }
    public int cartSize(){
        return shoppingCart.cartSize2();
    }
    private String[] formatReturn(){
        String AdapterToString=shoppingCart.getIngredientsArray3().toString();
        System.out.println(AdapterToString+"to string");
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
