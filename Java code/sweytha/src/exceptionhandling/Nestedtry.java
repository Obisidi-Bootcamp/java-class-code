package exceptionhandling;

/*Sometimes a situation may arise where a part of a block may cause one error 
 * and the entire block itself may cause another error. 
 * In such cases, exception handlers have to be nested.*/

/*Let's see an example where we 
place a try block within another try block for two different exceptions.*/

/*public class Nestedtry{    
 public static void main(String args[]){   
 //outer try block   
  try{    
	 String s=null;
	 System.out.println("the length of string is " + s.length()); //null pointer exception
  //inner try block 1  
    try{    
     System.out.println("going to divide by 0");    
     int b =39/0;    //arithmetic error
     }  
    //catch block of inner try block 1  
    catch(ArithmeticException e)  
    {  
      System.out.println("arithmetic error has occurred");  
    }    
       
    
    //inner try block 2  
    try{    
    	//array of size 5 //a[0],a[1],a[2],a[3],a[4]
      int a[]=new int[5];    
  
    //assigning the value out of array bounds  
     a[5]=4;    
     }  
  
    //catch block of inner try block 2  
    catch(ArrayIndexOutOfBoundsException e)  
    {  
       System.out.println(e);  
    }    
  
      
    System.out.println("other statement");    
  }  
  //catch block of outer try block  
  catch(Exception e)  
  {  
    System.out.println("handled the exception (outer catch)");  
  }    
    
  System.out.println("normal flow..");    
 }    
}  */

/*Let's consider the following example. 
 * Here the try block within nested try block (inner try block 2) do not handle the exception. 
 * The control is then transferred to its parent try block (inner try block 1). 
 * If it does not handle the exception, then the control is transferred to the 
 * main try block (outer try block) where the appropriate catch block handles the exception. 
 * It is termed as nesting.*/

/*public class Nestedtry {  
     
    public static void main(String args[])  
    {  
        // outer (main) try block  
        try {  
        	
            //inner try block 1   
            try {  
   
                // inner try block 2  
                try {  
                    int arr[] = { 1, 2, 3, 4 };  //4 elements
  
                    //printing the array element out of its bounds  
                    System.out.println(arr[10]);  
                }  
    
                // to handles ArithmeticException  
                catch (ArithmeticException e) {  
                    System.out.println("Arithmetic exception");  
                    System.out.println(" inner try block 2");  
                }  
            }  
    
            // to handle ArithmeticException   
            catch (ArithmeticException e) {  
                System.out.println("Arithmetic exception");  
                System.out.println("inner try block 1");  
            }  
        }  
    
        // to handle ArrayIndexOutOfBoundsException   
        catch (ArrayIndexOutOfBoundsException e4) {  
            System.out.print(e4);  
            System.out.println(" outer (main) try block");  
        }  
        catch (Exception e5) {  
            System.out.print("Exception");  
            System.out.println(" handled in main try-block");  
        }  
    }  
}  */

