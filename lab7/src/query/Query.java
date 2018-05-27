package query;

import java.util.List;

public interface Query {

    void buildMySQLQuery();
    boolean isQueryValid();
    String getMySQLQuery();

    default String transformListToString(List<String> listOfStrings){
        StringBuilder stringBuilder = new StringBuilder();
        listOfStrings.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
