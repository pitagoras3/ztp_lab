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

        // TODO here creating query with size lower than 4 will fail with Exception
        this.queryBody = queryParts.subList(4, queryParts.size() - 1);
        mySQLQuery = "";
    }

    @Override
    public void buildMySQLQuery() {

        // Validate query, if ok - create, if not - return message

        if (isQueryValid()){
            String tableName = queryParts.get(2);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE ");
            stringBuilder.append(tableName);
            stringBuilder.append(" (\n");

            List<String> bodyArgumentList = transformBodyToMySQL();
            stringBuilder.append(transformListToString(bodyArgumentList));
            stringBuilder.append("\n);");

            mySQLQuery = stringBuilder.toString();
        }
    }

    @Override
    public boolean isQueryValid() {
        return validateCreateTableQuery() && validateBody();
    }

    @Override
    public String getMySQLQuery() {
        return mySQLQuery;
    }

    // Validation methods

    private boolean validateCreateTableQuery(){

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
    private boolean validateBody(){
        List<List<String>> arguments = new ArrayList<>();

        for (int i = 0; i < queryBody.size(); i += 2){
            arguments.add(Arrays.asList(queryBody.get(i), queryBody.get(i + 1)));
        }

        for (List<String> argument : arguments){
            if (!MyQL.DATA_TYPES.contains(argument.get(0))){
                return false;
            }
            if (argument.get(1).charAt(argument.get(1).length() - 1) != ';'){
                return false;
            }
        }

        return true;
    }

    // Transform body

    private List<String> transformBodyToMySQL(){

        List<List<String>> arguments = new ArrayList<>();

        for (int i = 0; i < queryBody.size(); i += 2){
            arguments.add(new LinkedList<>(Arrays.asList(queryBody.get(i), queryBody.get(i + 1).replace(";", ""))));
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
}
