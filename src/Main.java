import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inputfile = new File("File");
        Scanner scanner = new Scanner(inputfile);

        File outputFile = new File("output1");
        PrintWriter printWriter = new PrintWriter(outputFile);

        String line = "";

        while (scanner.hasNextLine()){
            line += scanner.nextLine();
        }

        scanner.close();

        List<String> list = Stream.of(line.split("[^A-Za-zА-Яа-я]+"))
                .map(String::toLowerCase).filter(x -> x.length() <= 30)
                .distinct().collect(Collectors.toList());

        for (String elem: list
             ) {
            if (countUniqueCharacters(elem) == elem.length()){
                printWriter.print(elem + " ");
            }
        }

        printWriter.close();
    }

    public static long countUniqueCharacters(String input) {
        return input.chars()
                .distinct()
                .count();
    }
}
