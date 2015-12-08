package edu.bsu.cs222.shoppingList;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
public class IngredientsCart {
    Multiset<String> ingredientsMultiset = HashMultiset.create();
    public void addItemToCart(String input){
        ingredientsMultiset.add(input);
    }
    public void removeItemFromCart(String input){
            ingredientsMultiset.remove(input);
        }
    public Integer cartSize(){
        return this.ingredientsMultiset.size();
    }
    public Multiset returnCart(){
        return ingredientsMultiset;
    }

}


