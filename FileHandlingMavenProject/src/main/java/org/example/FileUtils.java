package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.UUID;
import java.util.Scanner;
import java.io.FileWriter;


public class FileUtils {

    private static final String HOME = System.getProperty("user.dir"); //some other options are "user.home", "user.name"


    public static void main(String[] args) throws IOException {
//        File file1 = new File("treeguidelines.csv"); // specify the file name

        // To check if the Home path exists, we use the exists function
//        Path p = Paths.get(HOME);
//        System.out.println(p);
//        System.out.println(Files.exists(p));


        // Checking if the file exists
//        Path p1 = Paths.get(HOME + "/treeguidelines.csv");
//        System.out.println(Files.exists(p1));


        // Checking if the file does not exist
//        Path p2 = Paths.get(HOME + "/tree.csv"); // HOME/tree.csv
//        System.out.println(Files.notExists(p2));


        // Checking if a path is a directory or a regular file
//        System.out.println(Files.isRegularFile(p));
//        System.out.println(Files.isDirectory(p));

        // Checking if a path is readable/writable
//        System.out.println(Files.isReadable(p));
//        System.out.println(Files.isWritable(p));

        // Checking if two paths points to the same location
//        Path p1 = Paths.get(HOME + "/src");
//        System.out.println(Files.isSameFile(p,p1));


        // Creating a file
//        createFile();

        // Creating a Directory
//        createDirectory();

        // Delete a file
//        deleteFile();

        // Delete a Directory
//        deleteDir();

        // Reading a csv file
//        readFile2();

        // writing to file
        writeFile();

    }


    public static void createFile() throws IOException {

        // All the name elements in the path must exist, apart from the file name, otherwise it throws IOException

        String filename = "myfile_" + UUID.randomUUID().toString() + ".txt";
        Path p = Paths.get(HOME + "/" + filename);

        if (!Files.exists(p)){
            Files.createFile(p);
        }

        System.out.println(Files.exists(p));



    }

    public static void createDirectory() throws IOException {

        // All the name elements in the path must exist, apart from the file name, otherwise it throws IOException

        String dirName = "myDir_" + UUID.randomUUID().toString();
        Path p = Paths.get(HOME + "/" + dirName);

        if (!Files.exists(p)){
            Files.createDirectory(p);
        }

        System.out.println(Files.exists(p));
        System.out.println(Files.isRegularFile(p));
        System.out.println(Files.isDirectory(p));

    }

    public static void deleteFile() throws IOException {

        Path p = Paths.get(HOME + "/myfile_171170d0-f281-40ec-b631-a99b3f125d84.txt");
        if(!Files.exists(p)){
            Files.createFile(p);
        }

          System.out.println(Files.exists(p));
          Files.delete(p);
          System.out.println(Files.exists(p));

        // However, if a file is not existent in the file system, the delete operation will fail with an IOException:

        // We can avoid this scenario by using deleteIfExists which fail silently in case the file does not exist. This is important when multiple threads are performing this operation and we don't want a failure message simply because a thread performed the operation earlier than the current thread which has failed:

        Path p1 = Paths.get(HOME + "/inexistentFile.txt");
        System.out.println(Files.exists(p1));
        Files.deleteIfExists(p1);

    }


    public static void deleteDir() throws IOException {
        // When dealing with directories and not regular files, we should remember that the delete operation does not work recursively by default. So if a directory is not empty it will fail with an IOException:

        Path dir = Paths.get(HOME + "/myDir_f09ede91-b235-4e85-a775-218bed33599b");
//        Files.createDirectory(dir);
//        System.out.println(Files.exists(dir));

//        Path file = dir.resolve("file.txt"); dir/file.txt
//        Files.createFile(file);
        Files.delete(dir);
        System.out.println(Files.exists(dir));
    }

    public static void readFile1() throws FileNotFoundException {
        Path p = Paths.get(HOME + "/treeguidelines.csv");

        if (Files.exists(p)){
            Scanner scanner = new Scanner(new File(p.toUri()));
            System.out.println("Data available in file: ");
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
        }
    }

    public static void readFile2(){

        String filename = "treeguidelines.csv";
        String line = "";
        int count = 0;

        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                count += 1;
                if (count == 1) continue; //forget the header row
                String[] record = line.split(",");    // use comma as separator
                System.out.println(line);
//                if (count == 2){
//                    System.out.println(line);
//                    for (String s: record){
//                        System.out.println(s);
//                    }
//                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void writeFile() throws IOException {
        Path p = Paths.get(HOME + "/fileToWrite.txt");
        if (!Files.exists(p)){
            Files.createFile(p);
        }

        FileWriter writer = new FileWriter(new File(p.toUri()), true);
        writer.write("This is superb\n");
        writer.close();





    }








}
