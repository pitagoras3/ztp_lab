package application;

import query.MyQL;

public class Application {

    public static final String FILE_NAME = "query.txt";
    public static final String FILE_PATH = "src/main/resources";

    public static final String INPUT_MESSAGE = "\n========================================\n" +
            "Click enter to convert MyQL to MySQL." +
            "\n========================================";

    public static void main(String[] args){

        IO io = new IO(FILE_PATH, FILE_NAME);

        while (true){
            System.out.println(INPUT_MESSAGE);
            io.getUserSignal();
            MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
        }
    }

    private static void showMenu(){
        System.out.println("Available operations and syntax:");
        System.out.println("================================");
        System.out.println("Create new table: create table_name");
        System.out.println("================================");
    }
}
