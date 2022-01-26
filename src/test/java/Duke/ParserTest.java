package Duke;


import Duke.Command.Command;
import Duke.Exception.DukeException;
import Duke.Parser.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void dummyTest(){

        assertEquals(2, 2);
    }

    @Test
    public void ParserTestWithDeadlineEmptyDescription() {
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
