package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryCreateTable implements Query {

    private List<String> queryParts;
    private List<String> queryBody;
    private String mySQLQuery;

    public QueryCreateTable(List<String> queryParts){
        this.queryParts = queryParts;

        this.queryBody = new ArrayList<>();
        this.mySQLQuery = "";
    }

    @Override
    public void buildMySQLQuery() {
        if (isQueryValid()){
            String tableName = queryParts.get(2);
            List<String> bodyArgumentList = transformBodyToMySQL();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE ");
            stringBuilder.append(tableName);
            stringBuilder.append(" (");

            if (!bodyArgumentList.isEmpty()){
                stringBuilder.append("\n");
                stringBuilder.append(transformListToString(bodyArgumentList));
                stringBuilder.append("\n");
            }
            stringBuilder.append(");");

            mySQLQuery = stringBuilder.toString();
        }

        else {
            throw new IllegalArgumentException("Couldn't parse " + queryParts.toString() +" to CREATE TABLE query.");
        }
    }

    @Override
    public boolean isQueryValid() {
        try{
            return validateCreateTableQuery() && validateTableName(queryParts.get(2)) && validateBody();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String getMySQLQuery() {
        return mySQLQuery;
    }

    // Validation methods

    private boolean validateCreateTableQuery(){

        if (queryParts.size() < 4){
            return false;
        }
        if (!queryParts.get(0).toUpperCase().equals(MyQL.QUERY_TYPE_CREATE)){
            return false;
        }
        if (!queryParts.get(1).toUpperCase().equals(MyQL.STRUCTURE_TYPE_TABLE)){
            return false;
        }
        if (!queryParts.get(3).equals("{")){
            return false;
        }
        if (!queryParts.get(queryParts.size() - 1).equals("}")){
            return false;
        }

        return true;
    }
    private boolean validateBody() throws IllegalArgumentException{
        this.queryBody = queryParts.subList(4, queryParts.size() - 1);

        List<List<String>> arguments = new ArrayList<>();

        try{

            for (int i = 0; i < queryBody.size(); i += 2){
                arguments.add(Arrays.asList(queryBody.get(i), queryBody.get(i + 1)));
            }

            for (List<String> argument : arguments){
                if (!MyQL.SQL_DATA_TYPES.keySet().contains(argument.get(0))){
                    return false;
                }
                if (argument.get(1).charAt(argument.get(1).length() - 1) != ';'){
                    return false;
                }
            }

            return true;
        }
        catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Line in body has odd amount of arguments.");
        }
    }

    // Transform body

    private List<String> transformBodyToMySQL(){

        List<List<String>> arguments = new ArrayList<>();

        for (int i = 0; i < queryBody.size(); i += 2){
            arguments.add(new LinkedList<>(Arrays.asList(queryBody.get(i), queryBody.get(i + 1).replace(";", ""))));
        }

        if (arguments.isEmpty()){
            return new ArrayList<>();
        }

        // Revert order: From int age; to age int,
        for (List<String> argument : arguments){
            String type = MyQL.SQL_DATA_TYPES.get(argument.get(0));
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

    private boolean validateTableName(String tableName){
        if (tableName.matches("[a-zA-Z][a-zA-Z0-9]*")){
            return true;
        }
        else throw new IllegalArgumentException(tableName + "is not correct table name.");
    }
}
