package cajohnson7.cs222.bsu.edu.shoppinglist;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;



public class IngredientsCartTest {
    @Before
    public void setUp(){
       // IngredientsCart testIngredients= new IngredientsCart();
    }
    
    @Test
    public void testSetStoredIngredients() throws Exception {
        IngredientsCart testIngredients= new IngredientsCart();
        String testString="pop";
        //testIngredients.setStoredIngredients(testString);
        Assert.assertEquals("pop"+System.getProperty("line.separator"), testIngredients.returnedCart());
    }

    @Test
    public void testSetSelectedItem() throws Exception {
        IngredientsCart testIngredients= new IngredientsCart();
        String SelectItem="cake";
        testIngredients.addItemToCart(SelectItem);
        Assert.assertEquals("cake"+System.getProperty("line.separator"), testIngredients.returnedCart());

    }

    @Test
    public void testReturnedCart() throws Exception {
            IngredientsCart testIngredients= new IngredientsCart();
            //testIngredients.setStoredIngredients("pop");
            testIngredients.addItemToCart("cake");
            Assert.assertEquals("popcake"+System.getProperty("line.separator"), testIngredients.returnedCart());

    }
}