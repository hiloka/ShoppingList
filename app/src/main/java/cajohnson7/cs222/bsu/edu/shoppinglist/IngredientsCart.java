package cajohnson7.cs222.bsu.edu.shoppinglist;
public class IngredientsCart {
    private String IngredientsInCart ="";
    private String newIngredients="";
    public void setStoredIngredients(String input){
            this.IngredientsInCart = input;
    }
    public void addItemToCart(String input){
        newIngredients=input;
    }
    public String returnedCart(){
        return IngredientsInCart +newIngredients+System.getProperty("line.separator");
    }
}
