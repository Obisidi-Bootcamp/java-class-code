package multithreading;

//Understanding the problem without Synchronization
/*In this example, 
there is no synchronization, so output is inconsistent. Let's see the example*/

/*class Table{  
void printTable(int n){//method not synchronized  
   for(int i=1;i<=5;i++){  
     System.out.println(n*i);  
     try{  
      Thread.sleep(400);  
     }catch(Exception e){System.out.println(e);}  
   }  
  
 }  
}  
  
class MyThread1 extends Thread{  
Table t;  
MyThread1(Table t){  
this.t=t;  
}  
public void run(){  
t.printTable(5);  
}  
  
}  
class MyThread2 extends Thread{  
Table t;  
MyThread2(Table t){  
this.t=t;  
}  
public void run(){  
t.printTable(100);  
}  
}  
  
class ThreadSynchonization{  
public static void main(String args[]){  
Table obj = new Table();//only one object  
MyThread1 t1=new MyThread1(obj);  
MyThread2 t2=new MyThread2(obj);  
t1.start();  
t2.start();  
}  
}  */


//Java Synchronized Method

/*If you declare any method as synchronized, it is known as synchronized method.
Synchronized method is used to lock an object for any shared resource.
When a thread invokes a synchronized method, 
it automatically acquires the lock for that object and 
releases it when the thread completes its task.*/

//example of java synchronized method  

/*class Table{  
 synchronized void printTable(int n){//synchronized method  
   for(int i=1;i<=5;i++){  
     System.out.println(n*i);  
     try{  
      Thread.sleep(400);  
     }catch(Exception e){System.out.println(e);}  
   }  
  
 }  
}  
  
class MyThread1 extends Thread{  
Table t;  
MyThread1(Table t){  
this.t=t;  
}  
public void run(){  
t.printTable(5);  
}  
  
}  
class MyThread2 extends Thread{  
Table t;  
MyThread2(Table t){  
this.t=t;  
}  
public void run(){  
t.printTable(100);  
}  
}  
  
class ThreadSynchonization{  
public static void main(String args[]){  
Table obj = new Table();//only one object  
MyThread1 t1=new MyThread1(obj);  
MyThread2 t2=new MyThread2(obj);  
t1.start();  
t2.start();  
}  
}  */

/*class Table  
{      
void printTable(int n){    
  synchronized(this){//synchronized block    
    for(int i=1;i<=5;i++){    
     System.out.println(n*i);    
     try{    
      Thread.sleep(400);    
     }catch(Exception e){System.out.println(e);}    
    }    
  }    
}//end of the method    

}    
   
class MyThread1 extends Thread{    
Table t;    
MyThread1(Table t){    
this.t=t;    
}    
public void run(){    
t.printTable(5);    
}    
   
}    
class MyThread2 extends Thread{    
Table t;    
MyThread2(Table t){    
this.t=t;    
}    
public void run(){    
t.printTable(100);    
}    
}    
   
public class ThreadSynchonization{    
public static void main(String args[]){    
Table obj = new Table();//only one object    
MyThread1 t1=new MyThread1(obj);    
MyThread2 t2=new MyThread2(obj);    
t1.start();    
t2.start();    
}    
}    */

class Thread1 extends Thread
{
    SampleCode obj;
    Thread1(SampleCode obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        obj.printTestsample();
    }
}
class Thread2 extends Thread
{
    SampleCode obj;
    Thread2(SampleCode obj)
    {
        this.obj=obj;
    }
    public void run()
    {
        obj.printTestsample();
    }
}

class SampleCode
{
    void printTestsample()
    {
        // lock the object
        synchronized(this)
        {
            System.out.println("Inside of the synchronized block.");
            for( int i=0 ; i<5 ; i++ )
            {
                System.out.println(i+1);
                try
                {
                    Thread.sleep(500);
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        }
    }
}
public class ThreadSynchonization
{
    public static void main(String args[])
    {
        // use same object in both thread
        SampleCode ob = new SampleCode();
        Thread1 t1=new Thread1(ob);
        Thread2 t2=new Thread2(ob);
        //start the threads t1 and t2
        System.out.println("Start thread1");
        t1.start();
        System.out.println("Start thread2");
        t2.start();
    }  }

