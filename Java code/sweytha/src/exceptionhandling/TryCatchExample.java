package exceptionhandling;

//Problem without exception handling
/*public class TryCatchExample {  
	  
    public static void main(String[] args) {  
          
        int data=50/0; //may throw exception   
          
        System.out.println("rest of the code");  
          
    }  
      
} */



//Solution by exception handling

/*public class TryCatchExample{  
	  
    public static void main(String[] args) {  
    	
    	//all the statements to be executed
        try  
        {  
        int data=50/0; //may throw exception   
        }  
            //handling the exception  
        catch(ArithmeticException e)  
        {  
            System.out.println(e);  
        }  
        
        System.out.println("rest of the code");  
    }  
      
}*/

//we also kept the code in a try block that will not throw an exception.


/*public class TryCatchExample {  

public static void main(String[] args) {  
    try  
    {  
    int data=50/0; //may throw exception   
           
    // if exception occurs, the remaining statement will not execute  
    System.out.println("rest of the code");
    }  
         // handling the exception   
    catch(ArithmeticException e)  
    {  
        System.out.println(e);  
    }  
    
      
}  
  
}  */

//we handle the exception using the parent class exception.

/*public class TryCatchExample {  

public static void main(String[] args) {  
    try  
    {  
    	
    int data=50/0; //may throw exception   
    
    }  
        // handling the exception by using Exception class      
    catch(Exception e)  
    {  
        System.out.println(e);  
    }  
    System.out.println("rest of the code");  
}  
  
}  */


//print a custom message on exception.

/*public class TryCatchExample {  

public static void main(String[] args) {  
    try  
    {  
    int data=50/0; //may throw exception   
    }  
         // handling the exception  
    catch(Exception e)  
    {  
              // displaying the custom message  
        System.out.println("Can't divided by zero");  
    }  
}  
  
}  */

//example to resolve the exception in a catch block.


/*public class TryCatchExample {  

public static void main(String[] args) {  
	//variables
    int i=50;  
    int j=0;  
    int data;  
    try  
    {  
    data=i/j; //may throw exception   
    }  
        // handling the exception  
    catch(Exception e)  
    {  
         // resolving the exception in catch block  
        System.out.println(i/(j+2));  
    }  
}  
} */
//example to handle another unchecked exception.
/*public class TryCatchExample {  

public static void main(String[] args) {  
    try  
    {  
    int arr[]= {1,3,5,7};  
    System.out.println(arr[10]); //may throw exception   
    }  
        // handling the array exception  
    catch(ArrayIndexOutOfBoundsException e)  
    {  
       // System.out.println(e);  
    	System.out.println("index 10 is out of bound for array with length 4");
    }  
    System.out.println("rest of the code");  
}  
  
}  */
