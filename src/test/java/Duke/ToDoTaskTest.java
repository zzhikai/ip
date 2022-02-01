package Duke;


import Duke.Command.Command;
import Duke.Command.TodoCommand;
import Duke.Task.Task;
import Duke.Task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTaskTest {
    @Test
    public void dummyTest() {

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
    public void todoTaskStringTest() {
        Task task = new Todo("Run");
        assertEquals("[T][ ] Run", task.toString());
    }

}
