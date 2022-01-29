package Duke.Storage;

import Duke.Task.Task;

import java.io.*;
import java.util.ArrayList;

public class Storage {

    private static String filePath = "src/main/java/TaskDatabase.ser";

    public Storage(String path) {
        filePath = path;
    }


    //@@author zzhikai-reused
    //Reused from https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java
    // with minor modification
    public static ArrayList<Task> readFile() {
        // reading data file into current list
        try {
            FileInputStream databaseInputStream = new FileInputStream(filePath);
            ObjectInputStream readDataBaseStream = new ObjectInputStream(databaseInputStream);
            ArrayList inputDatabase = (ArrayList<Task>) readDataBaseStream.readObject();
            readDataBaseStream.close();
            return inputDatabase;
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    //@@author zzhikai-reused
    //Reused from https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java
    // with minor modification
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
