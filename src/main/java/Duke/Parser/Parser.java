package Duke.Parser;

import Duke.Command.*;
import Duke.Exception.DukeException;
import Duke.Exception.InvalidCommandException;
import Duke.Task.Task;

public class Parser {
    // Parser to return the action to do maybe the command to do
    // input : String
    // from that input we will split the words into command / description / datetime
    private String userInputLine;
    public Parser(String userInputLine) {
        this.userInputLine = userInputLine;
        // this.taskList = taskList;
    }
    // parse should throw exception or command should throw exception, each command has its condition
    public Command parse() throws DukeException {
        // split command away
        String[] inputStrings = this.userInputLine.trim().split(" ",2);
        String inputCommand = inputStrings[0];
        // has command and body
        String inputBody = inputStrings.length == 2 ? inputStrings[1] : "";
        Task task;
        switch (inputCommand) {
            case "list":
                return new ListCommand("");
            case "deadline":
                return new DeadlineCommand(inputBody);
            case "todo":
                return new TodoCommand(inputBody);
            case "event":
                return new EventCommand(inputBody);
            case "mark":
                return new MarkCommand(inputBody);
            case "unmark":
                return new UnmarkCommand(inputBody);
            case "delete":
                return new DeleteCommand(inputBody);
            case "find":
                return new FindCommand(inputBody);
            default:
            throw new InvalidCommandException("OOPS!!! I'm sorry, but i don't know what that means :-(");
        }
    }

}
