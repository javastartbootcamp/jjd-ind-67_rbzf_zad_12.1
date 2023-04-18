import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {
    public static final String OUTPUT_FILE_NAME = "solutions.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String inputFileName = "operations.txt";
        File file = new File(inputFileName);

        int lines = FileUtils.getLinesNumber(file);
        String[] inputLines = FileUtils.getInputLines(file, lines);

        double[] result = FileUtils.getResult(lines, inputLines);

        File outputFile = new File(OUTPUT_FILE_NAME);
        FileUtils.printResultsToFile(outputFile, inputLines, result);
    }
}
