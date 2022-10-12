package multithreading;

//Example 1
/*As you know that at a time only one thread is executed. 
 * If you sleep a thread for the specified time, 
 * the thread scheduler picks up another thread and so on.*/
public class ThreadSleep extends Thread  
{    
    public void run()  
    {    
        for(int i=1;i<5;i++)  
        {    
            try  
            {  
                Thread.sleep(500); 
            }catch(InterruptedException e){
            	System.out.println(e);
            	}    
            System.out.println(i);    
        }    
    }    
    public static void main(String args[])  
    {    
    	ThreadSleep t1=new ThreadSleep();    
    	ThreadSleep t2=new ThreadSleep();    
        t1.start();    
        t2.start();    
    }    
}  

//Example 2: when sleep time is negative
/*public class ThreadSleep extends Thread  
{    
public void run()  
{    
    for(int i=1;i<5;i++)  
    {    
        try  
        {  
            Thread.sleep(1000); // sleep time is negative  
        }catch(InterruptedException e){
        	System.out.println(e);
        	}    
        System.out.println(i);    
    }    
}    
public static void main(String args[])  
{    
    ThreadSleep t1=new ThreadSleep();    
    ThreadSleep t2=new ThreadSleep();    
    t1.start();    
    t2.start();    
}    
}  */