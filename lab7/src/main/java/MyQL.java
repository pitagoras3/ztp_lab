public class MyQL {

    private String query;
    private String[] queryParts;

    public MyQL(String query){
        this.query = query;
        this.queryParts = query.split(" ");
    }

    public String getQuery() {
        return query;
    }

    public String[] getQueryParts() {
        return queryParts;
    }
}
