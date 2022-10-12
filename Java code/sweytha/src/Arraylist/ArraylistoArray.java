package Arraylist;

import java.util.ArrayList;
import java.util.List;
public class ArraylistoArray {

    public static void main(String[] args) {
        
       List<String> nameList = new ArrayList<String>();

      
       nameList.add("Robert");
       nameList.add("Samson");
       nameList.add("Alex");
       nameList.add("William");
       


      
        System.out.println("Elements of List: " + nameList);

       
        String[]output = new String [nameList.size()];

   
        for (int i = 0 ; i < output. length; i++){
        	output[i] = nameList.get(i);
        }

      
        System.out.print("Elements of Array: ");
        for (int i = 0 ; i < output. length ; i++){
            System.out.print(output[i] + "  ");
        }
    }
}

