import java.util.Scanner;

public class CoffeeCupInputHandler {

    //Gültige Äquivalenzklassen = 1 bis 5
    //Ungültige Äquivalenzklassen = <=0, >=6
    //Ungültige Äquivalenzklassen = Strings
    //Custom return
    public int getCupInput() {
        int inputValue = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the amount of cups you drank today:");
            try {
                inputValue = scanner.nextInt();
                if (inputValue >= 1) {
                    break;
                } else {
                    System.out.println("Impossible!! Try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!! Use only numbers! Try again.");
                scanner.next();
            }
        }
        return inputValue;
    }
}
