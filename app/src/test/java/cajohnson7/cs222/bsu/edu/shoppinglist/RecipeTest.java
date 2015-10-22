package cajohnson7.cs222.bsu.edu.shoppinglist;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trey on 10/21/2015.
 */
public class RecipeTest {
    Recipe myRecipe = new Recipe();
    @Test
    public void testNameRecipe() throws Exception {
        myRecipe.nameRecipe("chicken");
        Assert.assertEquals("chicken",myRecipe.RecipeName());
    }

    @Test
    public void testRecipeName() throws Exception {
    myRecipe.nameRecipe("pie");
        Assert.assertEquals("pie", myRecipe.RecipeName());
    }

    @Test
    public void testSetCookTime() throws Exception {

    }

    @Test
    public void testGetCookTime() throws Exception {

    }

    @Test
    public void testSetServing() throws Exception {

    }

    @Test
    public void testGetServing() throws Exception {

    }
}