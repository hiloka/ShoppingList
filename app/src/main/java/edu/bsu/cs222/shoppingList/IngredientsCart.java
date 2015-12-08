package edu.bsu.cs222.shoppingList;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IngredientsCart {
    private ArrayList ingredientsArray = new ArrayList();
    Multiset<String> myMultiset = HashMultiset.create();

    public void addItemToCart(String input){
        this.ingredientsArray.add(input);
        myMultiset.add(input);
        System.out.println(myMultiset.elementSet());
        System.out.println(myMultiset.entrySet());
        System.out.println("hi" + myMultiset.toString());
        System.out.println("go"+ myMultiset);
        System.out.println(myMultiset.entrySet().size()+"SIZE OF MULTISET");
    }
    public void removeItemFromCart(){
        if(ingredientsArray.size()>0){
            Integer arraySize=this.ingredientsArray.size();//arraySize changed from ArraySize
            //this.ingredientsArray.remove(ArraySize-1);
            //Integer ArraySize=this.ingredientsArray.size();
            String arrayLast= (String) ingredientsArray.get(arraySize-1);
            myMultiset.remove(arrayLast);
            this.ingredientsArray.remove(arraySize-1);
        }
    }
    public Integer cartSize(){
        return this.ingredientsArray.size();
    }
    public Integer cartSize2(){
        return this.myMultiset.size();
    }
    public String returnedCart(){
        String ingredientsInCart ="";
        Integer i = 0;
        Integer s=this.ingredientsArray.size();
        while(i < s){
            ingredientsInCart = ingredientsInCart +this.ingredientsArray.get(i).toString();
            ingredientsInCart = ingredientsInCart +System.getProperty("line.separator");
            i++;
        }
        return ingredientsInCart;
    }
    public Multiset getIngredientsArray3(){// this one returns a multiset
        return myMultiset;
    }

}


