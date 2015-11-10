package cajohnson7.cs222.bsu.edu.shoppinglist;


import java.util.ArrayList;

public class IngredientsCart {
    private String IngredientsInCart = "";
    private String newIngredients = "";
    private ArrayList storedArray;

    public void setStoredIngredients(String input) {
        this.IngredientsInCart = input;
    }

    public void addItemToCart(String input) {

        newIngredients = input;
    }

    public String returnedCart() {
        return IngredientsInCart + newIngredients + System.getProperty("line.separator");
    }

    public void addToArray(String input) {
        this.storedArray.add(input);
    }

    public void removeFromArray() {
        int size = this.storedArray.size();
        this.storedArray.remove(size);

    }

    public String ArrayOutput() {
        int i = 0;
        String ArrayToString = "";
        while (i < storedArray.size()) {
            ArrayToString += storedArray.get(i) + System.lineSeparator();
        }
        return ArrayToString;
    }
}