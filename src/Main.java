import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String[] coffeeTypes = {"Americano", "Latte Macchiato", "Filterkaffee", "Cappuccino", "Espresso"};
    private static double[] caffeineContent = {63.0, 11.0, 66.0, 27.0, 110.0};

    public static void main(String[] args) {

        System.out.println("Welcome to the Coffee Yunkie Index!");
        int cupAmount = cupInput();
        int coffeeType = coffeeTypeInput();

    }

    public static int cupInput() {
        System.out.println("Enter the amount of cups you drank today:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int coffeeTypeInput() {
        System.out.println("Select the type of coffee you drank today:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < coffeeTypes.length; i++) {
            System.out.printf("press %d for %s %n", i+1, coffeeTypes[i]);
        }
        int inputChoice = scanner.nextInt();
        return inputChoice;
    }

}

