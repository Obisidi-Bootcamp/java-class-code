package exceptionhandling;


import java.util.Scanner;

public class Main {

   public static void main(String[] args) throws FileExtensionException {

       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the file name with correct extension i.e. .txt ");

       String fileName = scanner.nextLine();

       if (!fileName.endsWith(".txt")){
           throw new FileExtensionException("File doesn't have .txt extension");
       }

       System.out.println("Correct file name with extension .txt");
   }

   static class FileExtensionException extends Exception {

       //Calling constructor of Parent Class
       public FileExtensionException(String message) {
           super(message);
       }
   }
}
