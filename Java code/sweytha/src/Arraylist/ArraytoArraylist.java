package Arraylist;



import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
 
public class ArraytoArraylist
{
    
    public static  List<String> convertArrayToList(String[] inputArray)
    {
   
        List<String> arrayList = new ArrayList<>();
 
        
        for (String i: inputArray) {
            arrayList.add(i);
        }

        return arrayList;
    }
 
   
    public static void main(String[] args)
    {
    Scanner scanner=new Scanner(System.in);

        String[] str = new String[4];
        
System.out.println("Enter elements to String array");
for (int i=0; i<str.length; i++)
{
str[i]=scanner.next();
}  
        List<String> arraylist = convertArrayToList(str);
 
   
      
        System.out.println(arraylist);
       
        
        scanner.close();
    }


	private static char[] typeof(List<String> arraylist) {
		// TODO Auto-generated method stub
		return null;
	}
}

