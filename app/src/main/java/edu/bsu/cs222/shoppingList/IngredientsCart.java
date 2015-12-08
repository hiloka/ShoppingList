package edu.bsu.cs222.shoppingList;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.ArrayList;
public class IngredientsCart {
    private ArrayList ingredientsArray = new ArrayList();
    Multiset<String> myMultiset = HashMultiset.create();
    public void addItemToCart(String input){
        this.ingredientsArray.add(input);
        myMultiset.add(input);
    }
    public void removeItemFromCart(String input){
            myMultiset.remove(input);
        }
    public Integer cartSize(){
        return this.myMultiset.size();
    }
    public Multiset returnCart(){
        return myMultiset;
    }

}


