package multithreading;

/*Simple example of add Shutdown Hook*/

class Shutdownthread extends Thread{    
    public void run(){    
       System.out.println("shut down hook task completed.."); 
        //step 1: define what the run method has to do during shutdown of Java application
        //file save the changes
        //close the file and exit 
        //need to be executed by JVM when there is a shutdown of the application
    }    
}    
    
public class ThreadShutdown{    
public static void main(String[] args)throws Exception {  
	
	/*return the runtime object associated with the current java
	   application*/
	
	//step 2: Create runtime object to access the getRuntime() method
//Step 3: call addShutdownHook(Shutdownthread)
Runtime r=Runtime.getRuntime();   

/*The addShutdownHook() method of the Runtime class 
 is used to register the thread with the Virtual Machine.*/
r.addShutdownHook(new Shutdownthread());    
       
System.out.println("Now main sleeping... press ctrl+c to exit");    
try{
	Thread.sleep(10000);
	}catch (Exception e) {
		
	}    
}    
}    

public class ThreadShutdown{  
public static void main(String[] args)throws Exception {  
  
Runtime r=Runtime.getRuntime();  
  
r.addShutdownHook(new Thread(){  
public void run(){  
    System.out.println("shut down hook task completed..");  
    }  
}  
);  

      
System.out.println("Now main sleeping... press ctrl+c to exit");  
try{Thread.sleep(3000);}catch (Exception e) {}  
}  
}  
