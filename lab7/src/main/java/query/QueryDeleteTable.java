package query;

import java.util.List;

public class QueryDeleteTable implements Query{

    private List<String> queryParts;
    private String mySQLQuery;

    public QueryDeleteTable(List<String> queryParts){
        this.queryParts = queryParts;
        this.mySQLQuery = "";
    }

    @Override
    public void buildMySQLQuery() {
        if (isQueryValid()){
            String tableName = queryParts.get(2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DROP TABLE ");
            stringBuilder.append(tableName);
            mySQLQuery = stringBuilder.toString();
        }
        else {
            throw new IllegalArgumentException("Couldn't parse " + queryParts.toString() +" to CREATE TABLE query.");
        }
    }

    @Override
    public boolean isQueryValid() {
        if (queryParts.size() != 3){
            return false;
        }
        if (!queryParts.get(0).toUpperCase().equals("DELETE")){
            return false;
        }
        if (!queryParts.get(1).toUpperCase().equals("TABLE")){
            return false;
        }
        if (queryParts.get(2).charAt(queryParts.get(2).length()) != ';'){
            return false;
        }

        return true;
    }

    @Override
    public String getMySQLQuery() {
        return mySQLQuery;
    }
}
