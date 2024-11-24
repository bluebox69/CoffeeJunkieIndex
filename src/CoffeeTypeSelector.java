import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CoffeeTypeSelector {
    private final String[] coffeeTypes = {"Americano", "Latte Macchiato", "Filterkaffee", "Cappuccino", "Espresso"};
    private final double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

    /*
     * Äquivalenzklassen:
     *
     * Parameter: cupAmount (int) - Anzahl der Kaffeetassen, die der Benutzer konsumiert hat
     * 1. Gültige Äquivalenzklasse:
     *    - cupAmount > 0 (mindestens eine Tasse getrunken)
     *    - InputChoice >0 & <6 (gültiger Eingabebereich)
     *    - InputChoice muss eine Ganzzahl sein
     *    - CupAmount muss eine Ganzzahl sein
     *
     * 2. Ungültige Äquivalenzklassen:
     *    - cupAmount <= 0 (keine oder negative Tassenanzahl ist unlogisch)
     *    - InputChoice <0 & >6 (ungültiger Eingabebereich)
     *    - InputChoice ist keine Ganzzahl (Float oder String)
     *    - CupAmount ist keine Ganzzahl (Float oder String)
     *
     * Benutzerinteraktion:
     * 1. Gültige Eingaben:
     *    - Kaffeeauswahl (1 = Americano --> done)
     *    - Anzahl der Tassen (1 <= cupsForThisType <= cupsLeft -->done)
     *
     * 2. Ungültige Eingaben:
     *    - Kaffeeauswahl außerhalb des Bereichs (z. B. 0 --> done, 6 --> done)
     *    - Ungültige Tassenanzahl (cupsInput) (z. B. negative Zahlen --> done, 0 oder mehr als cupsLeft)
     *    - Nicht-ganzzahlige Eingaben (z. B. "abc" --> done oder "1.5" --> done)
     *
     * Erwartetes Verhalten:
     * - Gültige Eingaben werden akzeptiert, und die Tassen werden korrekt erfasst.
     * - Ungültige Eingaben lösen entsprechende Exceptions aus (InvalidCoffeeTypeException, InvalidInputException, keine Custom Exception: NumberFormatException).
     */

    public int[] coffeeTypeInput(int cupAmount) {
        int[] coffeeCups = new int[coffeeTypes.length];
        int cupsLeft = cupAmount;
        int inputChoice = 0;
        int cupsForThisType = 0;

        while (cupsLeft > 0) {
            try {
                inputChoice = coffeeTypeInputChoice();
                cupsForThisType = numberCupsInputChoice(inputChoice, cupsLeft);
            } catch (InvalidCoffeeTypeException | InvalidInputException e) {
                System.out.println(e.getMessage());
            }
            coffeeCups[inputChoice] += cupsForThisType;
            cupsLeft -= cupsForThisType;
            System.out.printf("You have %d cups left.%n", cupsLeft);
        }
        return coffeeCups;
    }

    public int coffeeTypeInputChoice() throws InvalidCoffeeTypeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which coffee types did you have?");
        for (int i = 0; i < coffeeTypes.length; i++) {
            System.out.printf("Press %d for %s (Koffeingehalt: %.1f mg)%n", i + 1, coffeeTypes[i], caffeineContent[i]);
        }

        System.out.println("Enter the coffee type number:");

        int inputChoice = scanner.nextInt() - 1;

        // Wirf InvalidCoffeeTypeException bei ungültiger Auswahl
        if (inputChoice < 0 || inputChoice >= coffeeTypes.length) {
            throw new InvalidCoffeeTypeException("Invalid coffee type selected.");
        }

        return inputChoice;
    }

    public int numberCupsInputChoice(int inputChoice, int cupsLeft) throws InvalidInputException{
        Scanner scanner = new Scanner(System.in);
        System.out.printf("How many cups of %s did you drink? (You have %d cups left): %n", coffeeTypes[inputChoice], cupsLeft);

        String cupsInput = scanner.next();

        try {
            int cupsForThisType = Integer.parseInt(cupsInput); // Verarbeite Eingabe
            if (cupsForThisType < 1 || cupsForThisType > cupsLeft) {
                throw new InvalidInputException(String.format(
                        "Invalid number of cups. You have %d cups left. Please try again.", cupsLeft));
            }
            return cupsForThisType;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input detected. Please enter only whole numbers.");
        }
    }

    //Getter-Methoden
    public String[] getCoffeeTypes() {
        return coffeeTypes;
    }

    public double[] getCaffeineContent() {
        return caffeineContent;
    }

}
