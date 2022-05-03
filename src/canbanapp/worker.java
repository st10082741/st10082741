
package canbanapp;

import javax.swing.JOptionPane;
import java.util.Scanner;
public class worker
{
    final static int MAX_USERS = 5; 
    final static int MAX_TASKS = 10;
    //KEEPS TRACK OF REGISTERED USERS
    static int numRegistered = 0;
    
    public int printLoginMenu()
    {
        String userInput;
        int selection = 0; 
        boolean valid = false;
         
        while (!valid)
        {  
            userInput = JOptionPane.showInputDialog(null, 
                "Please make a Selection\n" 
                + " \t1. Register a User\n"
                + "\t2. Login a User\n" + " \t3. Quit\n" ,
                "LOGIN DIALOG", 
                JOptionPane.QUESTION_MESSAGE);
             
            if (userInput == null)
            {
                selection = 3 ;
            }
            else {
                
                selection = Integer.parseInt(userInput);
            }
            
            if ((selection  > 0) && (selection < 4 ))
            {
                valid = true;
            }
            else
            {
                printInvalidError();
            }
        }
        return selection;
    }   
            
        
    public void  registerUser(Login[] user)
    {
        Scanner input = new Scanner(System.in);
        String userString = "";        
        Login candidate = new Login();
        
        
        System.out.println("----------------");    
        boolean valid = false;
        do
        {
            
        
        System.out.print("Enter wanated Username [max 5 Chars + ] : ");
        userString = input.next();
        if (candidate.checkUserName(userString))
        {
           valid = true; 
        }
        
        else
        {
            System.out.println("Error from POE");
        }
    }while(!valid);
      candidate.setUserName(userString);
      System.out.println("Username successfully captured");
  //-------------------------------------------------------     
     
   valid = false;
   do
   {
       System.out.print("Enter wanted Password[ min 8 Chars + Upper + special]    ");
       userString = input.next();
   if (candidate.checkPasswordComplexity(userString))
           {
               valid = true;
           }
   
   else
   {
       System.out.println("Error from POE");
   }
   
   }while(!valid);
   candidate.setPassword(userString);
   System.out.println("Password successfully captured");
  //-------------------------------------------------------
  
     System.out.print("Enter Firstname: ");
     userString = input.next();
     candidate.setName(userString);
     System.out.print("Enter Surname : ");
     userString = input.next();
     candidate.setSurname(userString);
     user[numRegistered] = candidate;
     numRegistered++;
  //-----
    }
  
   //----------------------
    
   public void loginUser(Login[] user )
    {
        boolean valid= false;
        Scanner input = new Scanner(System.in);
        String usr, psw;
        int index = 0;
        
        System.out.print("Username: ");
        usr = input.next();
        System.out.print("Password: ");
        psw = input.next();
        for (int counter = 0; counter < numRegistered; counter++)
        {
            if (user[counter].getUserName().equals(usr))
                
            {
                if(user[counter].getPassword().equals(psw))
                {
                    valid = true;
                    index = counter;
                    break;
                }
            }
        }
        if(!valid)
        {
            JOptionPane.showMessageDialog(null,
                    "Username or password icorrect,please try again",
                    "Login Failed", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
      else
        {
            JOptionPane.showMessageDialog(null, 
                    "Welcome" + user[index].getName() + ","
                     + user[index].getSurname() + 
                    "it is gret to see you again", 
                    "Login Success", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
  
  //---------------------
    public void mainThread()
    {
    int selection = 0; 
    
    boolean quit = false;
    
    //EMPTY ARRAYS !!!! = NEEDS TO BE POPULATED
    Login user[] = new Login[MAX_USERS];
    
    do
            {
             selection = printLoginMenu();
             switch (selection)
             {
                 case 1:
                     registerUser(user);
                     break;
                     
                 case 2:
                     
                     loginUser(user);
                           
                     break;
                     
                 default:
                     
                     quit = true;
             }

             System.out.println( "Registered users =  "   + numRegistered);
       
            }while(!quit);
            System.out.println("Thanks for using the app...");
    }

    private void printInvalidError()
    {

       JOptionPane.showMessageDialog(null, " Invalid selection please try again", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

}
