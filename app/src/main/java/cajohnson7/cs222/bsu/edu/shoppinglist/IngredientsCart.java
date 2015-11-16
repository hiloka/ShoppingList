package cajohnson7.cs222.bsu.edu.shoppinglist;

import java.util.ArrayList;

public class IngredientsCart {
    private String IngredientsInCart ="";
    private String newIngredients="";
    private ArrayList IngredientsInCart2 = new ArrayList();



    public void setStoredIngredients(String input) {
            //this.IngredientsInCart = input;
        System.out.println("this is Ingredient In Cart 2"+ IngredientsInCart2.size());
            this.IngredientsInCart2.add(input);

    }
    // might want to remove
    public void addItemToCart(String input){
        //newIngredients=input;
        //this.IngredientsInCart2.add("hi");
        this.IngredientsInCart2.add(input);
    }
    public void removeItemFromCart(){
        // added this method so check name
        if(IngredientsInCart2.size()>0){
            Integer ArraySize=this.IngredientsInCart2.size();
            this.IngredientsInCart2.remove(ArraySize-1);
        }
    }
    public Integer cartSize(){
        System.out.println(IngredientsInCart2.size()+"hi");
        return this.IngredientsInCart2.size();

    }
    public String returnedCart(){
        Integer i = 0;
        Integer s=this.IngredientsInCart2.size();
        this.IngredientsInCart="";
        System.out.println("Made it this far");
        while(i < s){
            IngredientsInCart=IngredientsInCart+this.IngredientsInCart2.get(i).toString();
            IngredientsInCart=IngredientsInCart+System.getProperty("line.separator");
            i++;
          //this.IngredientsInCart= s.toString();// temp added
        }
        return IngredientsInCart;

        //return IngredientsInCart +newIngredients+System.getProperty("line.separator");
    }
}
