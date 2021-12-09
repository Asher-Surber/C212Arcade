package application.utils;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This reads a line from the console using the scanner
     */
    public static String readLineFromConsole() {
        String inputLine = scanner.nextLine();
        return inputLine;
    }

    /**
     * This method will read a line from the user using readLineFromConsole. It will try to parse this to an integer, and invoke the condition.
     * If the condition returns false, or else if this is not an integer, it will print the failure message and ask the user to input again.
     */
    public static int readIntegerLineFromConsoleOrElseComplainAndRetry(Function<Integer, Boolean> condition, String failureMessage) {
        try {
            Integer inputParsed = Integer.parseInt(readLineFromConsole());

            if (!condition.apply(inputParsed)){
                System.out.println(failureMessage);
                System.out.println("Try again");
                readIntegerLineFromConsoleOrElseComplainAndRetry(condition, failureMessage);
                return inputParsed;
            }
        }
        catch(NumberFormatException e) {
            System.out.println(failureMessage);
            System.out.println("Try again");
            readIntegerLineFromConsoleOrElseComplainAndRetry(condition, failureMessage);
        }
        return 0;
    }

    /**
     * This
     * @param menuTitle The title of the menu
     * @param options The options to choose from
     * @param shouldUserSelectAnOption If this is an informational menu (no reading user input, this should be false).
     * @param <T> The type of the options.
     * @return The selected option, if any, or else null.
     */
    public static <T> T printMenuToConsole(String menuTitle, List<T> options, boolean shouldUserSelectAnOption) {
        System.out.println("=========");
        System.out.println(menuTitle);
        for (int i = 0; i < options.size(); i++) System.out.println("" + (i + 1) + ": " + options.get(i));
        System.out.println("=========");

        if (shouldUserSelectAnOption) {
            System.out.println("Please select an option by its number:");
            int enteredIndex = readIntegerLineFromConsoleOrElseComplainAndRetry(number -> number - 1 >= 0 && number - 1 < options.size(), "You need to enter a valid option") - 1;
            return options.get(enteredIndex);
        } else return null;
    }
}
