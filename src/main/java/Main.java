import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "operations.txt";
        File file = FileUtils.createNewFile(fileName);

        int lines = FileUtils.getLinesNumber(file);
        Scanner scanner = new Scanner(file);
        String[] inputLines = FileUtils.getInputLines(scanner, lines);

        double[] result = FileUtils.getResult(lines, inputLines);

        fileName = "solutions.txt";
        file = FileUtils.createNewFile(fileName);
        FileUtils.printResultsToFile(file, lines, inputLines, result);
    }
}
