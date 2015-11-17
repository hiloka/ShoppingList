package cajohnson7.cs222.bsu.edu.shoppinglist;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class IngredientsCartTest {
    private  IngredientsCart cartOfIngredients;
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
    public void testRemoveFromEmptyCart() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("cake");
        cartOfIngredients.removeItemFromCart();
        cartOfIngredients.removeItemFromCart();
        cartOfIngredients.removeItemFromCart();
        Assert.assertEquals("", cartOfIngredients.returnedCart());
    }
    @Test
    public void testReturnedCartSize() throws Exception {
        Assert.assertEquals("0", cartOfIngredients.cartSize());
    }
}