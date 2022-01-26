package Duke;

import Duke.Command.*;
import Duke.Parser.Parser;
import Duke.Storage.Storage;
import Duke.Task.*;
import Duke.Exception.*;
import Duke.TaskList.TaskList;
import Duke.Ui.Ui;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


public class Duke {

    private static Ui ui;
    private Ui uiDuke;
    private TaskList taskDataList;
    public Duke(String filePath) {
        ArrayList<Task> inputDatabase = (ArrayList<Task>) Storage.readFile();
        taskDataList = new TaskList(inputDatabase);
    }

    private static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }

    }

    public void run() {
        ui = new Ui();
        ui.hello();
        Scanner chatInput = new Scanner(System.in);
        String input = chatInput.nextLine();
        while (!input.equals("bye")) {
            try {
                Parser inputParser = new Parser(input);
                Command currCommand = inputParser.parse();
                currCommand.callCommand(this.taskDataList);
            } catch (DukeException e) {
                ui.showError(e);
            }
            input = chatInput.nextLine();
        }
        Storage.saveToFile(this.taskDataList.getTaskStore());
        ui.bye();
        chatInput.close();
    }

    public static void main(String[] args) throws DukeException {
        Duke chatBot = new Duke("src/main/java/TaskDatabase.ser");
        chatBot.run();
    }

    public static void writeDataInputToDisk(ArrayList<Task> inputTaskList) {
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

    public static int indexOfTask(String command) {
        int index = command.length() + 1;
        return index;
    }

    public static int endIndexOfTask(String input) {
        int index = input.indexOf("/");
        return index;
    }

}
