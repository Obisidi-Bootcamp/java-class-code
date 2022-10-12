package multithreading;



/*1. public void start()

It starts the execution of the thread and then calls the run() on this Thread object.*/

/*Example 1: By Extending thread class*/
/*public class ThreadExample extends Thread  
{   
	
	//override the run method within the parent Thread
    public void run()  
    {    
        System.out.println("Thread is being created and executed");    
    }    
    public static void main(String args[])  
    {    
    	ThreadExample t1=new ThreadExample();    
        // this will call run() method  
        t1.start();    
    }    
}  */




/*Example 2: By Implementing Runnable Interface*/


/*public class ThreadExample implements Runnable  
{    
	
	//one single method which is run method
public void run()  
{    
    System.out.println("Thread is running...");    
}    
public static void main(String args[])  
{    
    ThreadExample  m1=new ThreadExample ();    
    Thread t1 =new Thread(m1);    
    // this will call run() method  
    t1.start();    
}    
}  */

/*Example 3: When you call the start() method more than one time*/

/*public class ThreadExample extends Thread  
{    
public void run()  
{    
System.out.println("First thread running...");    
}    
public static void main(String args[])  
{    
    ThreadExample t1=new ThreadExample(); 
   
    t1.start();    
    // It will through an exception because you are calling start() method more than one time   
    t1.start();    
}    
}   */ 