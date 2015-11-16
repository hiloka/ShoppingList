package cajohnson7.cs222.bsu.edu.shoppinglist;

import java.util.ArrayList;

public class IngredientsCart {
    private String ingredientsInCart ="";
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
        System.out.println(ingredientsArray.size() + "hi");
        return this.ingredientsArray.size();

    }
    public String returnedCart(){
        Integer i = 0;
        Integer s=this.ingredientsArray.size();
        this.ingredientsInCart ="";
        while(i < s){
            ingredientsInCart = ingredientsInCart +this.ingredientsArray.get(i).toString();
            ingredientsInCart = ingredientsInCart +System.getProperty("line.separator");
            i++;
        }
        return ingredientsInCart;
    }
}
