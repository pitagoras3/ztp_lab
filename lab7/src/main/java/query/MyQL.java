package query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyQL {

    public static final String QUERY_TYPE_CREATE = "CREATE";
    public static final String QUERY_TYPE_DELETE = "DELETE";

    public static final String QUERY_TYPE_ALTER = "ALTER";
    public static final String STRUCTURE_TYPE_TABLE = "TABLE";

    public static final String QUERY_TYPE_SET_PK = "SET";

    // TODO change DATA_TYPES to Map containing Key - javaType, Value - MySQLType
    public static final ArrayList<String> DATA_TYPES;
    public static final HashMap<String, String> SQL_DATA_TYPES;

    static {
        DATA_TYPES = new ArrayList<>();
        DATA_TYPES.add("int");
        DATA_TYPES.add("String");
        DATA_TYPES.add("Double");

        SQL_DATA_TYPES = new HashMap<>();
        SQL_DATA_TYPES.put("int", "int");
        SQL_DATA_TYPES.put("String", "varchar(255)");
    }

    public static MyQL castStringListToMyQL(List<String> queryParts){

        String queryType = queryParts.get(0);

        if (queryType.toUpperCase().equals(QUERY_TYPE_CREATE)) {
            QueryCreateTable createTable = new QueryCreateTable(queryParts);
            createTable.buildMySQLQuery();
            System.out.println(createTable.getMySQLQuery());
        }
        else if (queryType.toUpperCase().equals(QUERY_TYPE_ALTER)){
            QueryAlterTable alterTable = new QueryAlterTable(queryParts);
            alterTable.buildMySQLQuery();
            System.out.println(alterTable.getMySQLQuery());
        }
        else if (queryType.toUpperCase().equals(QUERY_TYPE_SET_PK)){
            QuerySetPrimaryKey setPrimaryKey = new QuerySetPrimaryKey(queryParts);
            setPrimaryKey.buildMySQLQuery();
            System.out.println(setPrimaryKey.getMySQLQuery());
        }
        else {
            throw new ClassCastException(queryType + "is not a MyQL statement.");
        }

        return null;
    }
}
