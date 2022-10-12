package multithreading;

//difference between calling run and start method
/*Example 1: call the run() method using the start() method*/

/*public class ThreadRun implements Runnable  
{    
public void run()  
{    
    System.out.println("Thread is running...");    
}    
public static void main(String args[])  
{    
    ThreadRun r1=new ThreadRun();    
    Thread t1 =new Thread(r1);    
    // this will call run() method   
    t1.start();    
}    
}  */

/*Example 2: call the run() method using the run() method itself*/

/*public class ThreadRun extends Thread  
{    
public void run()  
{    
    System.out.println(Thread.currentThread().getName());    
}    
public static void main(String args[])  
{    
    ThreadRun t1=new ThreadRun (); 
    ThreadRun t2=new ThreadRun ();
    // It does not start a separate call stack   ,it calls main itself,do not create a new thread
    t1.run();
    
}    
}   */


