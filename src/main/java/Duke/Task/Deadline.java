package Duke.Task;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Deadline extends Task{
    protected String by;
    protected LocalDate date;
    // need to fix null pointer where description is empty
    public Deadline(String description, String by) throws NullPointerException {
        super(description);
        this.by = by;
        List<String> dateFormats = Arrays.asList("yyyy-MM-dd","dd-MM-yyyy", "dd/MM/yyyy", "dd:MM:yyyy");

        DateTimeFormatter formatToParse;
            for (int i = 0; i <= dateFormats.size(); i++) {
                try {
                    formatToParse = DateTimeFormatter.ofPattern(dateFormats.get(i));
                    this.date = LocalDate.parse(by, formatToParse);
                    break;
                } catch (NullPointerException e) {
                    throw e;
                    // System.out.println("Wrong date format");
                } catch (Exception wrongFormat) {
                    // resolve issue about not catch DateTimeException
                    if (i == dateFormats.size()) {
                        throw new DateTimeException("Date invalid");
                    }
                    continue;
                }
            }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"))  + ")";
    }
}
