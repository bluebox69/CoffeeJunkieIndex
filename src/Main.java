import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CoffeeTypeSelector coffeeTypeSelector = new CoffeeTypeSelector();
        CoffeeCupInputHandler coffeeCupInputHandler = new CoffeeCupInputHandler();

        System.out.println("Welcome to the Coffee Junkie Index!");
        System.out.println("-----------------------------------");
        //get input from User
        int cupAmount = coffeeCupInputHandler.getCupInput();
        int[] coffeeCups = coffeeTypeSelector.coffeeTypeInput(cupAmount);

        //berechne den Junkie Index → 1 to 10
        System.out.println(".... Calculating Junkie Index ....");
        int junkieIndex = calculateJunkieIndex(cupAmount, coffeeCups, coffeeTypeSelector.getCaffeineContent());

    }

    private static int calculateJunkieIndex(int cupAmount, int[] coffeeCups, double[] caffeineContent) {

        double totalCoffeinContent = getTotalCoffeinContent(coffeeCups, caffeineContent);

        double rawIndex = ((cupAmount * 10 * 2) + totalCoffeinContent) / 1000;
        double scaledIndex = Math.min(Math.max(rawIndex * 10, 1), 10);
        //System.out.printf("scaledIndex: %d %n", (int)scaledIndex);

        return (int)scaledIndex;

    }

    private static double getTotalCoffeinContent(int[] coffeeCups, double[] caffeineContent) {
        double totalCoffeinContent = 0;
        for (int i = 0; i < caffeineContent.length; i++) {
            totalCoffeinContent += (caffeineContent[i] * coffeeCups[i]);
            //System.out.printf("Total Koffeingehalt: %f %n", totalCoffeinContent);
        }
        return totalCoffeinContent;
    }


}

