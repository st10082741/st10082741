package canbanapp;

public class Login
{  
    final int MAX_USERNAME_LENGTH = 5;
    final int MIN_PASSWORD_LENGTH = 8;
    final String SPECIAL = " !@#$%^&*()_+-~`{}[]|\\:;''<>/?,.";
   //
    private String userName;
    private String password;
    private String name;
    private String surname;
   // If you don't want outside objects to access the inner strings, declare the string variables as private.

//This method ensures that the username contains special characters.
    
    public boolean checkHasSpecial(String inString)
    {
        boolean valid = false;
       //This loop ensures that the the username contains strictly one special character.
        for (int counter = 0; counter < SPECIAL.length(); counter++)
        {
            String inspect = Character.toString(SPECIAL.charAt(counter));
            if(inString.contains(inspect))
            {
                valid = true;
                break;
            }
        }
// The string inspect oversees the character by granting the string a success if indeed contains one character
        return valid;
    }
   
    public boolean checkHasUpper(String inString)
    {  
        boolean valid = false;
   
        for (int counter = 0; counter < inString.length(); counter++)
        {
            if (Character.isUpperCase(inString.charAt(counter)))
            {
                valid = true;
                break;
            }    
        }
        return valid;
    }
   
    public boolean checkHasDigit(String inString)
    {  
        boolean valid = false;
   
        for (int counter = 0; counter < inString.length(); counter++)
        {
            if (Character.isDigit(inString.charAt(counter)))
            {
                valid = true;
                break;
            }    
        }
        return valid;
    }
   
    public boolean checkNotEmpty(String inString)
    {
        boolean valid = false;
        if ( (inString != null) && (!inString.isEmpty()) )
        {
            valid = true;
        }
        return valid;
    }

    public boolean checkUserName(String inString)
    {
        boolean valid = false;
 

        final String UNDERSCORE = "_";
       //this method ensures that any username contains an underscore
        if (checkNotEmpty(inString))
        {
//The max_Username_ Length attribute/library specifies the maximum length of the username field.
            if (inString.length() <= MAX_USERNAME_LENGTH)
            {
                if (inString.contains(UNDERSCORE))
                {
//This method validates the instring if it contains an underscore.
                    valid = true;
                }
            }
        }
// The return function is to ensures that the inString method finishes its execution
        return valid;
    }
   
    // This method will check the password complexity
    public boolean checkPasswordComplexity(String inString)
    {  
        boolean valid = false;
    
        if ((checkNotEmpty(inString)) && (inString.length() >= MIN_PASSWORD_LENGTH))
        {  
            if (checkHasUpper(inString) && checkHasDigit(inString))
            {
                if (checkHasSpecial(inString))
                {
                    valid = true;
                }
            }  
        }
        return valid;
    }
       
       


    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }



   
}
