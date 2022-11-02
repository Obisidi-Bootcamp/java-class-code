package com.bptn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.FileWriter;
import java.nio.file.Paths;


public class FileUtils {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final static String DIRECTORY_PATH = System.getProperty("user.dir") + "/";

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        String filePath = DIRECTORY_PATH + "test.txt";
        Path path = Paths.get(filePath);
        fileUtils.writeFile(path);
        fileUtils.updateFile(path);
    }

    public boolean isFileExist(Path path) {
        if (Files.exists(path)) {
            LOGGER.info("File exist at Path={} ", path);
            return true;
        } else {
            LOGGER.error("File doesn't exist at Path={}", path);
        }
        return false;
    }

    public boolean isFileExistsWithExceptionHandling(Path path) {
        File file = new File(path.toUri());
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            LOGGER.info("File exist at Path={} ", path);
        } catch (FileNotFoundException e) {
            LOGGER.error("File doesn't exist at Path={}, cause={}", path, e.getMessage());
            return false;
        }
        return true;
    }

    public boolean createFileIfNotExist(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
                LOGGER.info("File created at path={}", path);
            } catch (IOException e) {
                LOGGER.error("Unable to create the file cause={}", e.getMessage());
                e.printStackTrace();
            }
        } else {
            LOGGER.info("File already exist at path={}", path);
        }
        return Files.exists(path);
    }

    public void readFile(Path path) {
        if (isFileExist(path)) {
            try {
                Scanner scanner = new Scanner(new File(path.toUri()));
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    LOGGER.info("Data available in file : {}", data);
                }
            } catch (FileNotFoundException e) {
                LOGGER.error("Unable to read the file, cause={}", e.getMessage());
            }
        }
    }

    public void deleteFile(Path path) {
        if (Files.exists(path)) {
            try {
                Files.delete(path);
                LOGGER.info("File deleted at path={}", path);
            } catch (IOException e) {
                LOGGER.error("Unable to delete file at path={}, cause={}", path, e.getMessage());
            }
        } else {
            LOGGER.error("File doesn't exist at Path={}", path);
        }
    }

    public void writeFile(Path path) {
        if (isFileExist(path)) {
            try {
                FileWriter writer = new FileWriter(new File(path.toUri()));
                writer.write("I'm overwriting the file");
                writer.close();
                readFile(path);
            } catch (IOException e) {
                LOGGER.error("Unable to write the file cause={}", e.getMessage());
            }
        }
    }

    public void updateFile(Path path) {
        if (isFileExist(path)) {
            try {
                FileWriter writer = new FileWriter(new File(path.toUri()), true);
                writer.write("\r\n");
                writer.write("I'm updating the file");
                writer.close();
                readFile(path);
            } catch (IOException e) {
                LOGGER.error("Unable to update the file cause={}", e.getMessage());
            }
        }
    }

}
