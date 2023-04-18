import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileUtils {

    static int getLinesNumber(File file) {
        int lines = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku");
        }
        return lines;
    }

    static String[] getInputLines(File file, int lines) {
        String[] linesInput = new String[lines];
        try (Scanner scanner = new Scanner(file)) {
            for (int i = 0; i < lines; i++) {
                linesInput[i] = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku");
        }
        return linesInput;
    }

    static double[] getResult(int lines, String[] linesInput) {
        double[] result = new double[lines];
        for (int i = 0; i < lines; i++) {
            String[] input = linesInput[i].split(" ");
            result[i] = calculate((Double.parseDouble(input[0])), input[1], Double.parseDouble(input[2]));
        }
        return result;
    }

    private static double calculate(double x, String operator, double y) {
        double result = 0;
        switch (operator) {
            case "+" -> result = x + y;
            case "-" -> result = x - y;
            case "*" -> result = x * y;
            case "/" -> result = x / y;
            default -> System.out.println("operator nieznany");
        }
        return result;
    }

    static void printResultsToFile(File file, String[] linesInput, double[] result) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < linesInput.length; i++) {
            printWriter.write(getInput(linesInput[i]) + " = " + result[i] + "\n");
            System.out.println(getInput(linesInput[i]) + " = " + result[i] + "\n");
        }
        printWriter.close();
    }

    private static String getInput(String input) {
        String[] inputStrings = input.split(" ");
        return Double.parseDouble(inputStrings[0]) + " " + inputStrings[1] + " " + Double.parseDouble(inputStrings[2]);

    }
}
