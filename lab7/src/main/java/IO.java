import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

public class IO {

    private Scanner scanner;

    public IO(){
        this.scanner = new Scanner(System.in);
    }

    public void tryReadAndExecuteQueries(){
        String userInput = readInputFromUser();

        try{
            MyQL query = castStringToMyQL(userInput);
        }
        catch (ClassCastException e){
            System.out.println("Cannot cast user input to query.");
        }
    }

    private String readInputFromUser(){
        String input = scanner.nextLine();
        return input;
    }

    private MyQL castStringToMyQL(String input) throws ClassCastException {
        String[] queryParts = input.split(" ");
        // Some kind of switch case to check if commands are ok
        throw new NotImplementedException();
    }

}
