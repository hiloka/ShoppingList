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
    private void addDifferentIngredients(){
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("soda");
    }
    private void addDifferentAmountOfDifferentIngredients(){
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("soda");
        cartOfIngredients.addItemToCart("pop");
    }
    private void addMultiplePopToCart(){
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.addItemToCart("pop");
    }
    ///
    @Test
    public void testEmptyIngredientsCart() throws Exception{
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().isEmpty(), true);
    }
    @Test
    public void testEmptyIngredientsCartSize() throws Exception{
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().size(),0);
    }
    @Test
    public void testAddToIngredientsCart() throws Exception{
        cartOfIngredients.addItemToCart("pop");
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().contains("pop"),true);
    }
    @Test
    public void testAddMultipleIngredientsToCart() throws Exception{
        addMultiplePopToCart();
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().count("pop"), 2);
    }
    @Test
    public  void testAddDifferentIngredientsToCart1()throws Exception{
        addDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().contains("pop"), true);
    }
    @Test
    public void testAddDifferentIngredientsToCart2() throws Exception{
        addDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().contains("soda"),true);
    }
    @Test
    public void testRemoveIngredientsFromCart() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.removeItemFromCart();
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().isEmpty(),true);
    }
    @Test
    public void testRemainingIngredientsAfterRemove() throws Exception{
        addMultiplePopToCart();
        cartOfIngredients.removeItemFromCart();
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().count("pop"),1);

    }
    @Test
    public void testAddMoreThanOneItemToCart() throws Exception{
        addDifferentAmountOfDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().contains("soda"), true);
    }
    @Test
    public void testTotalAmountOfItemsInCart() throws Exception{
        addDifferentAmountOfDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.getIngredientsArray3().size(),3);
    }

    ///
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