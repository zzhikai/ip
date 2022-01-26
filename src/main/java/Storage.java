import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;

public class Storage {

    private static String filePath;

    public Storage(String path) {
        filePath = path;
    }
    private static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }

    }

    public ArrayList<Task> readFile() {
        // reading data file into current list
        try {
            FileInputStream databaseInputStream = new FileInputStream("src/main/java/TaskDatabase.ser");
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

    public void saveToFile(ArrayList<Task> inputTaskList) {
        try {
            FileOutputStream writeDatabaseInput = new FileOutputStream("src/main/java/TaskDatabase.ser");
            ObjectOutputStream writeDatabaseStream = new ObjectOutputStream(writeDatabaseInput);
            writeDatabaseStream.writeObject(inputTaskList);
            writeDatabaseStream.flush();
            writeDatabaseStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
