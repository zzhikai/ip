import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String[] inputStore = new String[100];
        String input;
        int index = 1;
        // System.in.read() read one byte in the input stream
        // System.in() returns an input stream
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        Scanner chatInput = new Scanner( System.in );

        input = chatInput.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                for (int i = 1; i < index; i++ ) {
                    System.out.println(i + "." + " " + inputStore[i]);
                }
                input = chatInput.nextLine();
            }
            if (input.equals("bye")) {
                break;
            }
            inputStore[index++] = input;
            System.out.println("added: " + input);
            input = chatInput.nextLine();
        }

        System.out.print("Bye. Hope to see you again soon!");
        chatInput.close();
    }
}
