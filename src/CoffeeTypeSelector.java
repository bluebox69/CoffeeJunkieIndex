import java.util.Scanner;

public class CoffeeTypeSelector {
    private final String[] coffeeTypes = {"Americano", "Latte Macchiato", "Filterkaffee", "Cappuccino", "Espresso"};
    private final double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

    // Diese neue Methode verarbeitet nur eine Eingabe
    public int processCoffeeInput(String input, int cupsLeft) {
        try {
            int cupsForThisType = Integer.parseInt(input); // Verarbeite Eingabe
            if (cupsForThisType < 1 || cupsForThisType > cupsLeft) {
                throw new InvalidInputException(String.format(
                        "Invalid number of cups. You have %d cups left. Please try again.", cupsLeft));
            }
            return cupsForThisType;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input detected. Please enter only whole numbers.");
        }
    }

    public int[] coffeeTypeInput(int cupAmount) {
        Scanner scanner = new Scanner(System.in);
        int[] coffeeCups = new int[coffeeTypes.length];
        int cupsLeft = cupAmount;

        while (cupsLeft > 0) {
            System.out.println("Which coffee types did you have?");
            for (int i = 0; i < coffeeTypes.length; i++) {
                System.out.printf("Press %d for %s (Koffeingehalt: %.1f mg)%n", i + 1, coffeeTypes[i], caffeineContent[i]);
            }

            System.out.println("Enter the coffee type number:");
            int inputChoice = scanner.nextInt() - 1;

            if (inputChoice < 0 || inputChoice >= coffeeTypes.length) {
                System.out.println("Invalid choice. Please select a valid coffee type.");
                continue;
            }

            System.out.printf("How many cups of %s did you drink? (You have %d cups left): %n", coffeeTypes[inputChoice], cupsLeft);
            String cupsInput = scanner.next();

            try {
                int cupsForThisType = processCoffeeInput(cupsInput, cupsLeft);
                coffeeCups[inputChoice] += cupsForThisType;
                cupsLeft -= cupsForThisType;

                System.out.printf("You have %d cups left.%n", cupsLeft);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return coffeeCups;
    }
    //Getter-Methoden
    public String[] getCoffeeTypes() {
        return coffeeTypes;
    }

    public double[] getCaffeineContent() {
        return caffeineContent;
    }

}
