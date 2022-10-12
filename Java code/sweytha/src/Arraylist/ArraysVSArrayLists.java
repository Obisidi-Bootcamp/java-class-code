package Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class ArraysVSArrayLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//need to mention size while declaring array
		//arrays can hold primitive data types such as int,double,float as well as objects such as string/user defined objects
	//	String[] arrayName=new String[5];
		
		String[] arrayDay= {"Monday","Tuesday","Wednesday","Thursday"};
	
		
		//no need to mention size for declaration of arraylists //dynamic sizing
		
		
	
		
		ArrayList<String> arrayListMonth= new ArrayList<>(Arrays.asList("Jan","feb","mar","april"));
		
		//Arraylists can hold objects but holds wrapper class to support primitive data types
		//Integer for int ,L for long, B for boolean and so on
	   //	ArrayList<Integer> arrayList=new ArrayList<>();
		
		
		//getting a value from arrays
		
//		System.out.println(arrayDay[1]);
		
		//getting a value from arraylist
		
//		System.out.println(arrayListMonth.get(1));
//		
		//length of array
		
//		System.out.println("length of array " +arrayDay.length);
		
		//size of arraylist
		
//		System.out.println("size of array "+ arrayListMonth.size());
//		
//		//adding an element is not possible with arrays
//		//arrays have a fixed size
//		
//		//adding an element with arraylists
//		//arraylists have dynamic size
//		
//		arrayListMonth.add(0,"may");
//		System.out.println(arrayListMonth);
//		System.out.println(arrayListMonth.get(0));
//		
//		//set an element in arrays
//		arrayDay[3]="Friday";
//		System.out.println(arrayDay[3]);
//		
//		//set an element in arraylists
//		
//		System.out.println(arrayListMonth);
//		arrayListMonth.set(0, "June");
//		System.out.println(arrayListMonth.get(0));
//		System.out.println(arrayListMonth);
		
		//removing an element is not possible in arrays
		//removing an element in arraylists
		//remove can accept index/element name
		
		
//		arrayListMonth.remove(1);
//		System.out.println(arrayListMonth.get(1));
//		System.out.println(arrayListMonth);
////		
		
		//print arrays (this can be done using for loop)
		//print memory address of the java
//		System.out.println(arrayDay);
//		
////		//print arraylist
//		System.out.println(arrayListMonth);
//		
		
		//looping through an arraylist using for loop
		
//		
//		for(int i=0;i<arrayListMonth.size();i++) {
//			System.out.println(arrayListMonth.get(i));
//		}
		
		//looping through an arraylist using for-each loop
		//speeds up code execution
		
		for(String element:arrayListMonth) {
			System.out.println(element);
		}
		
		//looping through an arraylist using iterator
		
//		Iterator<String> myObj= arrayList.iterator();
//		
//		//looping through a collection using hasNext and next methods
//		while(myObj.hasNext()) {
//			System.out.println(myObj.next());
//		}
//		
		

	}

}
