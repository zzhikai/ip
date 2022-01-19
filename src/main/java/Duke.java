import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {

        String input;
        // System.in.read() read one byte in the input stream
        // System.in() returns an input stream
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner chatInput = new Scanner( System.in );
        input = chatInput.nextLine();
        while (!input.equals("bye")) {
            System.out.println(input);
            input = chatInput.nextLine();
        }
        System.out.print("Bye. Hope to see you again soon!");
        chatInput.close();
    }
}
