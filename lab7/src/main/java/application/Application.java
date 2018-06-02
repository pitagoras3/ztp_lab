package application;

import query.MyQL;

public class Application {

    public static final String FILE_NAME = "query.txt";
    public static final String FILE_PATH = "src/main/resources";

    public static final String INPUT_MESSAGE = "\n========================================\n" +
            "Click enter to convert MyQL to MySQL." +
            "\n========================================";

    public static void main(String[] args) {

        IO io = new IO(FILE_PATH, FILE_NAME);

        while (true) {
            System.out.println(INPUT_MESSAGE);
            io.getUserSignal();

            try {
                String myQLquery = MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
                System.out.println(myQLquery);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
