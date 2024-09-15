import Controller.Controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            Controller controller = new Controller();
            controller.start();

            System.out.print("Do you want to start again? (Y/N): ");
            userInput = sc.nextLine().trim().toUpperCase();  

        } while (userInput.equals("Y"));  // only Y & N not include ตัวอื่น

        System.out.println("Game Over");
        sc.close();  
    }
}
