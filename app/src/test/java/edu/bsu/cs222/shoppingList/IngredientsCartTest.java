package edu.bsu.cs222.shoppingList;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


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
    @Test
    public void testEmptyIngredientsCart() throws Exception{
        Assert.assertEquals(cartOfIngredients.returnCart().isEmpty(), true);
    }
    @Test
    public void testEmptyIngredientsCartSize() throws Exception{
        Assert.assertEquals(cartOfIngredients.returnCart().size(),0);
    }
    @Test
    public void testAddToIngredientsCart() throws Exception{
        cartOfIngredients.addItemToCart("pop");
        Assert.assertEquals(cartOfIngredients.returnCart().contains("pop"),true);
    }
    public void testAddToIngredientsCartAmount() throws Exception{
        cartOfIngredients.addItemToCart("pop");
        Assert.assertEquals(cartOfIngredients.returnCart().count("pop"),1);
    }
    @Test
    public void testAddMultipleIngredientsToCart() throws Exception{
        addMultiplePopToCart();
        Assert.assertEquals(cartOfIngredients.returnCart().count("pop"), 2);
    }
    @Test
    public  void testAddDifferentIngredientsToCart1()throws Exception{
        addDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.returnCart().contains("pop"), true);
    }
    @Test
    public void testAddDifferentIngredientsToCart2() throws Exception{
        addDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.returnCart().contains("soda"),true);
    }
    @Test
    public void testRemoveIngredientsFromCart() throws Exception {
        cartOfIngredients.addItemToCart("pop");
        cartOfIngredients.removeItemFromCart("pop");
        Assert.assertEquals(cartOfIngredients.returnCart().isEmpty(),true);
    }
    @Test
    public void testRemainingIngredientsAfterRemove() throws Exception{
        addMultiplePopToCart();
        cartOfIngredients.removeItemFromCart("pop");
        Assert.assertEquals(cartOfIngredients.returnCart().count("pop"),1);

    }
    @Test
    public void testAddMoreThanOneItemToCart() throws Exception{
        addDifferentAmountOfDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.returnCart().contains("soda"), true);
    }
    @Test
    public void testTotalAmountOfItemsInCart() throws Exception{
        addDifferentAmountOfDifferentIngredients();
        Assert.assertEquals(cartOfIngredients.returnCart().size(),3);
    }
}