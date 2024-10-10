import java.util.Scanner;

public class CoffeeTypeSelector {
    private final String[] coffeeTypes = {"Americano", "Latte Macchiato", "Filterkaffee", "Cappuccino", "Espresso"};
    private final double[] caffeineContent = {63.0, 11.5, 66.5, 27.5, 110.0};

    public int[] coffeeTypeInput(int cupAmount) {
        Scanner scanner = new Scanner(System.in);
        int[] coffeeCups = new int[coffeeTypes.length];  // Array, um die Anzahl der Tassen für jede Kaffeeart zu speichern

        int cupsLeft = cupAmount;

        System.out.printf("So you drank %d coffees today? %n", cupAmount);

        while (cupsLeft > 0) {
            System.out.println("Which coffee types did you have?");

            for (int i = 0; i < coffeeTypes.length; i++) {
                System.out.printf("Press %d for %s (Koffeingehalt: %.1f mg)%n", i + 1, coffeeTypes[i], caffeineContent[i]);
            }

            System.out.println("Enter the coffee type number:");
            int inputChoice = scanner.nextInt() - 1;

            // Validate
            if (inputChoice < 0 || inputChoice >= coffeeTypes.length) {
                System.out.println("Invalid choice. Please select a valid coffee type.");
                continue;
            }

            System.out.printf("How many cups of %s did you drink? (You have %d cups left): %n", coffeeTypes[inputChoice], cupsLeft);
            int cupsForThisType = scanner.nextInt();

            if (cupsForThisType < 1 || cupsForThisType > cupsLeft) {
                System.out.printf("Invalid number of cups. You have %d cups left. Try again.%n", cupsLeft);
                continue;
            }

            coffeeCups[inputChoice] += cupsForThisType;
            cupsLeft -= cupsForThisType;

            System.out.printf("You have %d cups left.%n", cupsLeft);
        }

        return coffeeCups;
    }

    // Getter-Methoden
    public String[] getCoffeeTypes() {
        return coffeeTypes;
    }

    public double[] getCaffeineContent() {
        return caffeineContent;
    }
}
