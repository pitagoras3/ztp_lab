package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IO {

    public static final String FILE_NAME = "query.txt";

    private Scanner scanner;

    public IO(){
        this.scanner = new Scanner(System.in);
    }

    public List<String> getQueryFromFileAsStringList() {
        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {

            return stream
                    .map(x -> x.replace("{", " {"))
                    .map(x -> x.replace("}", " }"))
                    .flatMap(x -> Arrays.stream(x.split("[ \n]")))
                    .filter(x -> !x.equals(""))
                    .collect(Collectors.toList());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void getUserSignal(){
        scanner.nextLine();
    }
}
