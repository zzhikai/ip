package Duke;


import Duke.Command.Command;
import Duke.Command.TodoCommand;
import Duke.Exception.DukeException;
import Duke.Parser.Parser;
import Duke.Task.Task;
import Duke.Task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    @Test
    public void dummyTest(){

        assertEquals(2, 2);
    }

    @Test
    public void todoEmptyDescriptionTest() {
        try {
            String input = "todo";
            Command currCommand = new TodoCommand(input);
        } catch (Exception e) {
            assertEquals("OOPS!!! The description of a todo cannot be empty.", e.getMessage());
        }
    }

    @Test
    public void TaskStringTest() {
        Task task = new Todo("Run");
        assertEquals("[T][ ] Run", task.toString());
    }

    @Test
    public void ParserTestWithEmptyDescription() {
        String input = "deadline";
        Parser inputParser = new Parser(input);
        Command currCommand = null;
        try {
            currCommand = inputParser.parse();
        } catch (DukeException e) {
            assertEquals("Please enter Task Description", e.getMessage());
        }
    }
    @Test
    public void ParserTestWithInvalidCommand() {
        String input = "gibberish";
        Parser inputParser = new Parser(input);
        Command currCommand = null;
        try {
            currCommand = inputParser.parse();
        } catch (DukeException e) {
            assertEquals("OOPS!!! I'm sorry, but i don't know what that means :-(", e.getMessage());
        }
    }
}
