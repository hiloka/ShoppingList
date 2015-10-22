package cajohnson7.cs222.bsu.edu.shoppinglist;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trey on 10/21/2015.
 */
public class myStringTestTest {

    @Test
    public void testGettingString() throws Exception {
    myStringTest getTest = new myStringTest();
        Assert.assertEquals("hi",getTest.gettingString());
    }
}