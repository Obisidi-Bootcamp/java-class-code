package exceptionhandling;

//example 1-custom exception
//class representing custom exception  
/*class InvalidAgeException  extends Exception  
{  
 public InvalidAgeException (String str)  
 {  
     // calling the constructor of parent Exception  
     super(str);  
 }  
}  
 
//class that uses custom exception InvalidAgeException  
public class Customexception
{  

 // method to check the age  
 static void validate (int age) throws InvalidAgeException{    
    if(age < 18){  

     // throw an object of user defined exception  
     throw new InvalidAgeException("age is not valid to vote");    
 }  
    else {   
     System.out.println("welcome to vote");   
     }   
  }    

 // main method  
 public static void main(String args[])  
 {  
     try  
     {  
         // calling the method   
         validate(10);  
     }  
     catch (InvalidAgeException ex)  
     {  
         System.out.println("Caught the exception");  
 
         // printing the message from InvalidAgeException object  
         System.out.println("Exception occured: " + ex);  
     }  

     System.out.println("rest of the code...");    
 }  
}  */


//example 2-custom exception //if number is positive or negative

// class representing custom exception  
/*class NumberException extends Exception  
{  
	 public NumberException (String str)  
	 {  
	     // calling the constructor of parent Exception  
	     super(str);  
	 }  
}  
    
// class that uses custom exception NumberException  
public class Customexception
{  
	//check if the number if positive/negative
	public static void validate(int num) throws NumberException{
		
		if(num<0) {
			throw new NumberException("Number is negative");    
		}
		else {
			System.out.println("the number is positive");
		}
		
	}
    // main method  
    public static void main(String args[])  
    {  
        try  
        {  
            // throw an object of user defined exception  
            validate(-20);
        }  
        catch (NumberException ex)  
        {  
            System.out.println("Caught the exception");  
            System.out.println(ex.getMessage());  
        }  
  
        System.out.println("rest of the code...");    
    }  
}  */
