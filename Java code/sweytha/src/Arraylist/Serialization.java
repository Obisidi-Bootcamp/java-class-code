package Arraylist;


import java.io.*;

import java.util.*;
import java.io.Serializable;


//object created from the Emp class need to be converted to stream of bytes
class Employee implements Serializable{
	public String name;
	public String address;
}

public class Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//data of the object emp
		Employee emp=new Employee();
		emp.name="sweytha";
		emp.address="Canada";
		
		try {
			FileOutputStream fileout= new FileOutputStream("/Users/sweythakannan/Desktop/Java.txt");
			ObjectOutputStream out= new ObjectOutputStream(fileout);
			out.writeObject(emp);
			out.close();
			fileout.close();
			
			System.out.println("Serialized data is saved into Java.txt");
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
