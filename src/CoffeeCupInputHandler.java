import java.util.Scanner;

public class CoffeeCupInputHandler {

    /*
    Gültige Äquivalenzklassen = >= 1
    Gültige Äquivalenzklassen <= int MAX
    Ungültige Äquivalenzklassen = 0
    Ungültige Äquivalenzklassen = > int Max
    Ungültige Äquivalenzklassen = negativ numbers
    Ungültige Äquivalenzklassen = Strings
    Ungültige Äquivalenzklassen = Double
    Custom return
     */
    public int getCupInput() {
        int inputValue;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the amount of cups you drank today:");
            try {
                if (!scanner.hasNextInt()) {
                    throw new InvalidInputException("Invalid input detected. Please enter only whole numbers.");
                }
                inputValue = scanner.nextInt();
                if (inputValue >= 1) {
                    return inputValue;
                } else {
                    throw new InvalidInputException("The number of cups cannot be zero or negative.");
                }
            } catch (InvalidInputException e) {
                throw e;
            } catch (Exception e) {
                System.out.println("Invalid Input!! Use only numbers! Try again.");
                scanner.next();
            }
        }
    }
}
