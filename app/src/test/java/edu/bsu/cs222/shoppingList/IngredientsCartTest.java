package edu.bsu.cs222.shoppingList;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.bsu.cs222.shoppingList.IngredientsCart;

public class IngredientsCartTest {
    private IngredientsCart cartOfIngredients;
    @Before
    public void setUp(){
        cartOfIngredients = new IngredientsCart();
    }
    @Test
    public void testSetStoredIngredients() throws Exception {
        String testString="pop";
        cartOfIngredients.addItemToCart(testString);
        Assert.assertEquals("pop" + System.getProperty("line.separator"), cartOfIngredients.returnedCart());
    }
    @Test
    public void testSetSelectedItem() throws Exception {
        String SelectItem="cake";
        cartOfIngredients.addItemToCart(SelectItem);
        Assert.assertEquals("cake" + System.getProperty("line.separator"), cartOfIngredients.returnedCart());
    }
    @Test
    public void testReturnedCart() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("cake");
            Assert.assertEquals("pop" + System.getProperty("line.separator") + "cake" + System.getProperty("line.separator"), cartOfIngredients.returnedCart());
    }
    @Test
    public void testRemoveFromCart() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("cake");
        cartOfIngredients.removeItemFromCart();
        Assert.assertEquals("pop" + System.getProperty("line.separator"), cartOfIngredients.returnedCart());
    }
    @Test
    public void testRemoveFromCartMultiple() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("cake");
        cartOfIngredients.removeItemFromCart();
        cartOfIngredients.removeItemFromCart();
        Assert.assertEquals("", cartOfIngredients.returnedCart());
    }
    @Test
    public void testRemoveFromCartMoreThanInCart() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("cake");
        cartOfIngredients.removeItemFromCart();
        cartOfIngredients.removeItemFromCart();
        cartOfIngredients.removeItemFromCart();
        Assert.assertEquals("", cartOfIngredients.returnedCart());
    }
    @Test
    public void testReturnedCartSizeEmpty() throws Exception {
        Assert.assertEquals("0", cartOfIngredients.cartSize().toString());
    }
    @Test
    public void testReturnedCartSize() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("cake");
        Assert.assertEquals("2", cartOfIngredients.cartSize().toString());
    }
    @Test
    public void testReturnedCartSizeWithRemoval() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("cake");
        cartOfIngredients.removeItemFromCart();
        Assert.assertEquals("1", cartOfIngredients.cartSize().toString());
    }

}