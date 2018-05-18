public class Application {

    public static void main(String[] args){

        IO io = new IO();
        while(true){
            io.tryReadAndExecuteQueries();
        }
    }

    private static void showMenu(){
        System.out.println("Available operations and syntax:");
        System.out.println("================================");
        System.out.println("create table: create table_name");
        System.out.println("================================");
    }
}
