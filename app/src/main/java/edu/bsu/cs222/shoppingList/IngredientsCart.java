package edu.bsu.cs222.shoppingList;

import java.util.ArrayList;

public class IngredientsCart {
    private ArrayList ingredientsArray = new ArrayList();

    public void addItemToCart(String input){
        this.ingredientsArray.add(input);
    }
    public void removeItemFromCart(){
        if(ingredientsArray.size()>0){
            Integer ArraySize=this.ingredientsArray.size();
            this.ingredientsArray.remove(ArraySize-1);
        }
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
}
