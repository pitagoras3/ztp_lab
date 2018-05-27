package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MyQL {

    public static final String QUERY_TYPE_CREATE = "CREATE";
    public static final String QUERY_TYPE_ALTER = "ALTER";
    public static final String STRUCTURE_TYPE_TABLE = "TABLE";
    public static final ArrayList<String> DATA_TYPES;

    static {
        DATA_TYPES = new ArrayList<>();
        DATA_TYPES.add("int");
        DATA_TYPES.add("String");
        DATA_TYPES.add("Double");
    }

    private String query;

    private MyQL(String query){
        this.query = query;
    }

    public static MyQL castStringArrayToMyQL(List<String> queryParts){
        MyQL myQL;
        System.out.println(queryParts);
        String queryType = queryParts.get(0);

        if (queryType.toUpperCase().equals(QUERY_TYPE_CREATE)) {
            String query = buildCreateTableQuery(queryParts);
            System.out.println(query);
        }
        else if (queryType.toUpperCase().equals(QUERY_TYPE_ALTER)){
            System.out.println("ALTER");
        }
        else {
            throw new ClassCastException(queryType + "is not a MyQL statement.");
        }

        return null;
    }

    private static String buildCreateTableQuery(List<String> queryParts){

        // Validate query, if ok - create, if not - return message
        List<String> body = queryParts.subList(4, queryParts.size() - 1);

        if (validateCreateTableQuery(queryParts) && validateBody(body)){
            String tableName = queryParts.get(2);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE ");
            stringBuilder.append(tableName);
            stringBuilder.append(" (\n");

            List<String> bodyArgumentList = transformBodyToMySQL(body);
            stringBuilder.append(transformListToString(bodyArgumentList));
            stringBuilder.append("\n);");

            return stringBuilder.toString();
        }
        else {
            return "CANNOT BUILD QUERY (VALIDATION FAIL)";
        }
    }

    private static boolean validateCreateTableQuery(List<String> query){
        if (!query.get(0).toUpperCase().equals(QUERY_TYPE_CREATE)){
            return false;
        }
        if (!query.get(1).toUpperCase().equals(STRUCTURE_TYPE_TABLE)){
            return false;
        }
        if (!query.get(3).equals("{")){
            return false;
        }
        if (!query.get(query.size() - 1).equals("}")){
            return false;
        }

        return true;
    }

    private static boolean validateBody(List<String> body){
        List<List<String>> arguments = new ArrayList<>();

        for (int i = 0; i < body.size(); i += 2){
            arguments.add(Arrays.asList(body.get(i), body.get(i + 1)));
        }

        for (List<String> argument : arguments){
            if (!DATA_TYPES.contains(argument.get(0))){
                return false;
            }
            if (argument.get(1).charAt(argument.get(1).length() - 1) != ';'){
                return false;
            }
        }

        return true;
    }

    private static List<String> transformBodyToMySQL(List<String> body){

        // CAN EXTRACT THAT LINES INTO SEPARATE FUNCTION
        List<List<String>> arguments = new ArrayList<>();

        for (int i = 0; i < body.size(); i += 2){
            arguments.add(new LinkedList<>(Arrays.asList(body.get(i), body.get(i + 1).replace(";", ""))));
        }

        // Revert order: From int age; to age int,
        for (List<String> argument : arguments){
            String type = argument.get(0);
            String name = argument.get(1);

            name = "\t" + name + " ";
            type += ",\n";

            argument.clear();
            argument.add(name);
            argument.add(type);
        }

        // Remove last added comma
        String lastArg = arguments
                .get(arguments.size() - 1)
                .get(1)
                .replace(",\n", "");

        arguments.get(arguments.size() - 1).set(1, lastArg);

        return arguments.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
    }

    private static String transformListToString(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
