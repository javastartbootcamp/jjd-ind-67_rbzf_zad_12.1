import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileUtils {

    static File createNewFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Pliku nie udalo sie utworzyc.");
        }
        return file;
    }

    static int getLinesNumber(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        scanner.close();
        return lines;
    }

    static String[] getInputLines(Scanner scanner, int lines) {
        String[] linesInput = new String[lines];
        for (int i = 0; i < lines; i++) {
            linesInput[i] = scanner.nextLine();
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
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:
                System.out.println("operator nieznany");
        }
        return result;
    }

    static void printResultsToFile(File file, int lines, String[] linesInput, double[] result) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        for (int i = 0; i < lines; i++) {
            printWriter.write(linesInput[i] + " = " + String.valueOf(result[i]) + "\n");
        }
        printWriter.close();
    }
}
