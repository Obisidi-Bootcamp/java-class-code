package Arraylist;

import java.io.*;

public class Deserialization {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		
		Employee emp=null;
		
		try {
			FileInputStream filein=new FileInputStream("/Users/sweythakannan/Desktop/Java.txt");
			ObjectInputStream in=new ObjectInputStream(filein);
			emp=(Employee) in.readObject();
			
			in.close();
			filein.close();
		}
		finally {
			System.out.println("Deserializing employee ..");
			System.out.println("name of employee" + emp.name);
			System.out.println("address of employee" + emp.address);
			
		}

	}

}
