package DataStructures;



import java.util.ArrayList;
import java.util.Iterator;

//The iterator() method can be used to get an Iterator for any collection:
/*public class JavaIterator {
	 public static void main(String[] args) {
	  
	    // Make a collection
	    ArrayList<Integer> cars = new ArrayList<Integer>();
	    cars.add(10);
	    cars.add(20);
	    cars.add(30);
	    cars.add(40);
	  
	    // Get the iterator
	    Iterator<Integer> it = cars.iterator();
	  
	    // Print the first item
	    System.out.println(it.next());
	  }
}*/




/*public class JavaIterator {
  public static void main(String[] args) {
  
    // Make a collection
    ArrayList<Integer> cars = new ArrayList<Integer>();
    cars.add(10);
    cars.add(20);
    cars.add(30);
    cars.add(40);
  
    // Get the iterator
    Iterator<Integer> it = cars.iterator();
    
    // Loop through a collection
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}*/




/*public class JavaIterator {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(12);
    numbers.add(8);
    numbers.add(2);
    numbers.add(23);
    Iterator<Integer> it = numbers.iterator();
    while(it.hasNext()) {
      Integer i = it.next();
      if(i < 10) {
        it.remove();
      }
    }
    System.out.println(numbers);
  }
}*/



/*List iterator is used to loop through list collections such as Arraylist and linkedlist
 * it provides bi-directional iteration using hasNext(),next(),hasPrevious(),previous()
 * other methods: nextIndex(),previousIndex(),remove()
 */

/*iterator is used to loop through any java collection
 * it provides uni-directional iteration and use hasNext(),next(),remove() methods
 */
 

import java.util.*;
public class JavaIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> newList = new ArrayList<String>();
		
		newList.add("Mango");
		newList.add("Apple");
		newList.add("Banana");
		newList.add("Orange");
		
		System.out.println("List: " + newList);
		
		ListIterator<String> i = newList.listIterator();
		
		while(i.hasNext()) {
			System.out.println("Value at " + i.nextIndex() +" is: " + i.next());
		}
	}

}


