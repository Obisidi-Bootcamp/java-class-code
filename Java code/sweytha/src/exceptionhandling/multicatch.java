package exceptionhandling;

//Let's see a simple example of java multi-catch block.
/*public class multicatch {  
	  
    public static void main(String[] args) {  
          
           try{    
        	   //array with size 5 //a[0],a[1],a[2],a[3],a[4]
                int a[]=new int[5];    
                a[5]=30/0;    
               }    
               catch(ArithmeticException e)  
                  {  
                   System.out.println("Arithmetic exception has occurred");  
                  }    
               catch(ArrayIndexOutOfBoundsException e)  
                  {  
                   System.out.println("ArrayIndexOutOfBounds Exception occurs");  
                  }    
               catch(Exception e)  
                  {  
                   System.out.println(e);  
                  }             
               System.out.println("rest of the code");    
    }  
}  */

//another example of multi-catch block
/*public class multicatch {  
	  
    public static void main(String[] args) {  
          
           try{   
        	   //size of array =5, a[0],a[1],a[2],a[3],a[4]
                int a[]=new int[5];    
                
                System.out.println(a[10]);  
            
               }    

              catch(ArithmeticException e)  
                  {  
                   System.out.println("Arithmetic Exception occurs");  
                  }    
              catch(ArrayIndexOutOfBoundsException e)  
                  {  
                   System.out.println("ArrayIndexOutOfBounds Exception occurs");  
                  } 
              catch(Exception e)  
               {  
               System.out.println(e);  
               }  
           
           System.out.println("rest of the code");
                          
                 
    }  
}  */

/*In this example, try block contains two exceptions. But at a time only one exception occurs 
and its corresponding catch block is executed.*/

/*public class multicatch {  

public static void main(String[] args) {  
      
       try{    
       //size of array 5 //a[0],a[1],a[2],a[3],a[4]
            int a[]=new int[5];    
            a[5]=30/0;    //arithmetic error
            System.out.println(a[10]);   //index error
           }    
          catch(ArithmeticException e)  
              {  
               System.out.println("Arithmetic Exception occurs");  
              }   
         catch(ArrayIndexOutOfBoundsException e)  
           {  
           System.out.println("ArrayIndexOutOfBounds Exception occurs");  
           } 
    
           catch(Exception e)  
              {  
               System.out.println("Parent Exception occurs");  
              }             
           System.out.println("rest of the code");    
}  
}  */

/*In this example, we generate NullPointerException, but didn't provide the corresponding exception type. 
 *In such case, the catch block containing the parent exception class Exception will invoked.*/


/*public class multicatch {  

public static void main(String[] args) {  
      
       try{    
            String s=null;  
            System.out.println(s.length());  
           }    
           catch(ArithmeticException e)  
              {  
               System.out.println("Arithmetic Exception occurs");  
              }    
           catch(ArrayIndexOutOfBoundsException e)  
              {  
               System.out.println("ArrayIndexOutOfBounds Exception occurs");  
              }   
           catch(Exception e)  
              {  
               System.out.println(e);  
              }             
           System.out.println("rest of the code");    
}  
}  */

/*Let's see an example, to handle the exception without maintaining the order of exceptions 
 * (i.e. from most specific to most general).*/

/*class multicatch{    
  public static void main(String args[]){    
   try{    
    int a[]=new int[5];    
    a[5]=30/0;    
   }    
   catch(Exception e){
	   System.out.println("common task completed");
	   }   
   catch(ArithmeticException e){
   System.out.println("task1 is completed");
   }    
   catch(ArrayIndexOutOfBoundsException e){
   System.out.println("task 2 completed");
   }    
   System.out.println("rest of the code...");    
 }    
}   */
 