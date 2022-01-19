import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String[] inputStore = new String[100];
        String input;
        int index = 0;

        hello();

        Scanner chatInput = new Scanner( System.in );

        input = chatInput.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                for (int i = 0; i < index; i++ ) {
                    System.out.println((i + 1) + ". " + inputStore[i]);
                }
                input = chatInput.nextLine();
                // move to next iteration
                continue;
            }
            inputStore[index++] = input;
            System.out.println("added: " + input);
            input = chatInput.nextLine();
        }

        System.out.print("Bye. Hope to see you again soon!");
        chatInput.close();
    }

    public static void hello() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }
}
