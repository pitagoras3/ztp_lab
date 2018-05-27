package query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            String tableName = queryParts.get(2);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ALTER TABLE ");
            stringBuilder.append(tableName);
            stringBuilder.append("\n");

//            List<String> bodyArgumentList = transformBodyToMySQL();
//            stringBuilder.append(transformListToString(bodyArgumentList));
            stringBuilder.append("\n);");

            mySQLQuery = stringBuilder.toString();
        }
    }

    @Override
    public boolean isQueryValid() {
        return validateAlterTableQuery() && validateBody();
    }

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

                counter += 2;
                if(counter >= queryBody.size() || queryBody.get(counter).charAt(queryBody.get(counter).length() - 1) != ';'){
                    return false;
                }
            }
            else if (queryBody.get(counter).toUpperCase().equals("DELETE")){
                counter ++;
                if(counter >= queryBody.size() || queryBody.get(counter).charAt(queryBody.get(counter).length() - 1) != ';'){
                    return false;
                }
            }
            else{
                return false;
            }
        }

        return true;
    }



    @Override
    public String getMySQLQuery() {
        return null;
    }
}
