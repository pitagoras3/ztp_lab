package query;

import java.util.List;

// example
// set pk on TABLE_NAME as COLUMN_NAME;

public class QuerySetPrimaryKey implements Query {

    private static final int QUERY_LENGTH = 6;
    private List<String> queryParts;
    private String mySQLQuery;

    public QuerySetPrimaryKey(List<String> queryParts){
        this.queryParts = queryParts;
        this.mySQLQuery = "";
    }

    @Override
    public void buildMySQLQuery() {
        if(isQueryValid()){
            String tableName = queryParts.get(3);
            String columnName = queryParts.get(5).replace(";", "");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ALTER TABLE ");
            stringBuilder.append(tableName);
            stringBuilder.append("\n");
            stringBuilder.append("ADD PRIMARY KEY (");
            stringBuilder.append(columnName);
            stringBuilder.append(");");

            mySQLQuery = stringBuilder.toString();
        }
        else {
            throw new IllegalArgumentException("Couldn't parse " + queryParts.toString() +" to SET PRIMARY KEY query.");
        }
    }

    @Override
    public boolean isQueryValid() {
        if (queryParts.size() != QUERY_LENGTH){
            return false;
        }
        if (!queryParts.get(0).toUpperCase().equals("SET")){
            return false;
        }
        if (!queryParts.get(1).toUpperCase().equals("PK")){
            return false;
        }
        if (!queryParts.get(2).toUpperCase().equals("ON")){
            return false;
        }
        if (!queryParts.get(4).toUpperCase().equals("ON")){
            return false;
        }
        if (queryParts.get(5).charAt(queryParts.get(5).length() - 1) != ';'){
            return false;
        }

        return true;
    }

    @Override
    public String getMySQLQuery() {
        return mySQLQuery;
    }
}
