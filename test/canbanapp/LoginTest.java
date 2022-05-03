/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canbanapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ST10082741
 */
public class LoginTest
{
    
    public LoginTest()
    {
    }
    
   

    /**
     * Test of checkUsername method, of class Login.
     */
    @Test
    public void testCheckUsername()
    {
        System.out.println("checkUsername - kyl_1");
        String str = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //--------------------------------
         System.out.println("checkUsername - kyl!!!!!!!");
         str = "kyl!!!!!!!";
         result = instance.checkUserName(str);        
         System.out.println("Should be false: " + result); 
         assertFalse(result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity()
    {
        System.out.println("checkPasswordComplexity - Ch&&sec@ke99");
        String inString = "Ch&&sec@ke99";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(inString);
        assertEquals(expResult, result);
    }
    
}
