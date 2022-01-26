package Duke.Storage;

import Duke.Task.Task;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Storage {

    private static String filePath = "src/main/java/TaskDatabase.ser";

    public Storage(String path) {
        filePath = path;
    }

    public static ArrayList<Task> readFile() {
        // reading data file into current list
        try {
            FileInputStream databaseInputStream = new FileInputStream(filePath);
            ObjectInputStream readDataBaseStream = new ObjectInputStream(databaseInputStream);
            ArrayList inputDatabase = (ArrayList<Task>) readDataBaseStream.readObject();
            readDataBaseStream.close();
            System.out.println("Reading of database stopped");
            return inputDatabase;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Database is Empty!");
            return new ArrayList<>();
        }
    }

    public static void saveToFile(ArrayList<Task> inputTaskList) {
        try {
            FileOutputStream writeDatabaseInput = new FileOutputStream(filePath);
            ObjectOutputStream writeDatabaseStream = new ObjectOutputStream(writeDatabaseInput);
            writeDatabaseStream.writeObject(inputTaskList);
            writeDatabaseStream.flush();
            writeDatabaseStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
