package edu.bsu.cs222.shoppingList;



import android.R;
import android.content.Context;
import android.widget.ArrayAdapter;

import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdapterClass {
    //private ArrayList arrayToAdapter = new ArrayList();
    private Context myContext;
    private IngredientsCart shoppingCart = new IngredientsCart();


    public void addingToCart(String input){//this method is if i remove the IngredientsCart from the ButtonEvent i need to access it somehow
        shoppingCart.addItemToCart(input);

    }
    public void removeingFromCart(){//Added for same reason as addingToCart
        shoppingCart.removeItemFromCart();
    }

    public Integer amountInCart(){//added for same reason as addingToCart
        return shoppingCart.cartSize();
    }

    public ArrayAdapter setArray(){//might want to fix typeing issue were i can just take any list as input remove the input temp to see if it work with out it
        //this.arrayToAdapter=input; //changed from this.arrayToAdapter=input to this.arrayToAdapter=shoppingCart.returnArray
        //be careful i think the myContext will be blank or null when i run it i might have to change it or take a view as input
       // ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(myContext,android.R.layout.simple_list_item_1,arrayToAdapter);
        //return myAdapter;
        return null;

    }
    public ArrayList returnShoppingList(){
        return shoppingCart.getIngredientsArray();
    }

    public ArrayList returnShoppingList2(){
        return shoppingCart.getIngredientsArray2();
    }// used to return a type of multiset

    public Multiset returnShoppingList3(){//added to return multiset
        return shoppingCart.getIngredientsArray3();
    }
    private Multiset returnShoppingList4(){
        return shoppingCart.getIngredientsArray3();
    }






}
