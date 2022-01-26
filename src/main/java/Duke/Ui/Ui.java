package Duke.Ui;

public class Ui {
    public Ui() { }

    public void hello() {
        System.out.println("Hello! Welcome, I'm Duke");
        System.out.println("What can I do for you?");
    }

    public void bye() {
        System.out.print("Bye. Hope to see you again soon!");
    }

    public void showError(Exception e) {
        System.out.println(e.getMessage());
    }
}
