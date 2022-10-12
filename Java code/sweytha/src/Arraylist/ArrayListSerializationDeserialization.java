package Arraylist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
 
public class ArrayListSerializationDeserialization
{
    public static void main(String[] args) throws Exception 
    {
        ArrayList<String> nameSerializeList = new ArrayList<String>();
         
        nameSerializeList.add("Samson");
        nameSerializeList.add("William");
        nameSerializeList.add("Adam");
 
        try
        {
            FileOutputStream fos = new FileOutputStream("/Users/sweythakannan/Desktop/listdata.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(nameSerializeList);
            oos.close();
            fos.close();
      
        
            ArrayList<String> nameDeserializeList = new ArrayList<String>();
        
       
            FileInputStream fis = new FileInputStream("listdata.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            nameDeserializeList = (ArrayList<String>) ois.readObject();
            for (String name : nameDeserializeList) {
                System.out.println(name);
            }
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class does not exist");
            c.printStackTrace();
            return;
        }
         
 
        
    }
}



