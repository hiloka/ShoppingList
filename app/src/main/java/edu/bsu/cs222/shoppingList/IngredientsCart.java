package edu.bsu.cs222.shoppingList;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IngredientsCart {
    private ArrayList ingredientsArray = new ArrayList();
    Multiset<String> myMultiset = HashMultiset.create();
    private ArrayList multiArray= new ArrayList();


    public void addItemToCart(String input){
        this.ingredientsArray.add(input);
        myMultiset.add(input);
        System.out.println(myMultiset.elementSet());
        System.out.println(myMultiset.entrySet());
        System.out.println("hi" + myMultiset.toString());
        System.out.println("go"+ myMultiset);
    }
    public void removeItemFromCart(){
        if(ingredientsArray.size()>0){
            Integer ArraySize=this.ingredientsArray.size();
            this.ingredientsArray.remove(ArraySize-1);
        }
        //// this is to test teh remove from multilist
        Integer ArraySize=this.ingredientsArray.size();
        String arrayLast= (String) ingredientsArray.get(ArraySize-1);
        myMultiset.remove(arrayLast);
        //
    }
    public Integer cartSize(){
        return this.ingredientsArray.size();
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
    public ArrayList getIngredientsArray(){//added after second iteration so i can see if i use the adapter

        return this.ingredientsArray;

    }
    public ArrayList getIngredientsArray2(){// temp added to see if i can return a multiset array
        multiArray.add(myMultiset.entrySet());// might put back after i remove iterator and this makes it so it returns an array with all the values multiple times
        //return myMultiset;
        return multiArray;//tem remove
        //return myMultiset.toArray(String);

    }
    public Multiset getIngredientsArray3(){// this one returns a multiset
        return myMultiset;
    }

}


