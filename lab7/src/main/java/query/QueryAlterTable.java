package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class QueryAlterTable implements Query {

    private List<String> queryParts;
    private List<String> queryBody;
    private String mySQLQuery;

    public QueryAlterTable(List<String> queryParts){
        this.queryParts = queryParts;

        // TODO here creating query with size lower than 4 will fail with Exception
        this.queryBody = queryParts.subList(4, queryParts.size() - 1);
        this.mySQLQuery = "";
    }

    @Override
    public void buildMySQLQuery() {
        if (isQueryValid()){
            mySQLQuery = transformBodyToMySQL();
        }
        else {
            throw new IllegalArgumentException("Couldn't parse " + queryParts.toString() +" to ALTER TABLE query.");
        }
    }

    @Override
    public boolean isQueryValid() {
        return validateAlterTableQuery() && validateBody();
    }

    // Validation

    private boolean validateAlterTableQuery(){
        if (!queryParts.get(0).toUpperCase().equals(MyQL.QUERY_TYPE_ALTER)){
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
        int counter = 0;

        // TODO extract ADD / DELETE to MyQL class.
        while(counter < queryBody.size()){
            if (queryBody.get(counter).toUpperCase().equals("ADD")){

                // TODO xDDDDD correct that stuff.
                if(counter + 2 >= queryBody.size() || MyQL.SQL_DATA_TYPES.keySet().contains(queryBody.get(counter + 1)) && queryBody.get(counter + 2).charAt(queryBody.get(counter + 2).length() - 1) != ';'){
                    return false;
                }
                counter += 3;
            }
            else if (queryBody.get(counter).toUpperCase().equals("DELETE")){
                if(counter + 1 >= queryBody.size() || queryBody.get(counter + 1).charAt(queryBody.get(counter + 1).length() - 1) != ';'){
                    return false;
                }
                counter +=2;
            }
            else{
                return false;
            }
        }

        if (counter == 0){
            throw new NoSuchElementException("Didn't found any field to add / delete in query.");
        }

        return true;
    }

    // Transformation

    private String transformBodyToMySQL(){

        List<List<String>> argumentsToAdd = new ArrayList<>();
        List<String> argumentsToDelete = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        int counter = 0;

        while(counter < queryBody.size()){
            if (queryBody.get(counter).toUpperCase().equals("ADD")){
                List<String> argumentToAdd = Arrays.asList(queryBody.get(counter + 2).replace(";", ""), MyQL.SQL_DATA_TYPES.get(queryBody.get(counter + 1)) + ";");
                argumentsToAdd.add(argumentToAdd);
                counter += 3;
            }
            else if (queryBody.get(counter).toUpperCase().equals("DELETE")){
                String argumentToDelete = queryBody.get(counter + 1);
                counter += 2;
                argumentsToDelete.add(argumentToDelete);
            }
        }

        argumentsToDelete.forEach(argument -> {
            stringBuilder.append("ALTER TABLE ");
            stringBuilder.append(queryParts.get(2));
            stringBuilder.append("\n");
            stringBuilder.append("DROP COLUMN ");
            stringBuilder.append(argument);
            stringBuilder.append("\n\n");
        });

        argumentsToAdd.forEach(argument -> {
            stringBuilder.append("ALTER TABLE ");
            stringBuilder.append(queryParts.get(2));
            stringBuilder.append("\n");
            stringBuilder.append("ADD ");
            stringBuilder.append(argument.get(0));
            stringBuilder.append(" ");
            stringBuilder.append(argument.get(1));
            stringBuilder.append("\n\n");
        });

        if (stringBuilder.length() > 2){
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        return stringBuilder.toString();
    }

    @Override
    public String getMySQLQuery() {
        return mySQLQuery;
    }
}
