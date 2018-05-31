import application.IO;
import org.junit.Test;
import query.QueryCreateTable;

import static org.junit.Assert.assertEquals;

public class QueryCreateTableTest {

    public static final String TEST_FILE_PATH = "src/test/resources";
    private IO io;

    @Test
    public void createCorrectTableTest(){
        io = new IO(TEST_FILE_PATH, "createCorrectTable.txt");
        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
        createTable.buildMySQLQuery();

        String expectedResult = "CREATE TABLE Students (\n" +
                "\tage int,\n" +
                "\tname String\n" +
                ");";

        assertEquals(createTable.getMySQLQuery(), expectedResult);
    }

    // TODO specify Exception class
    @Test(expected = Exception.class)
    public void createEmptyTableTest(){
        io = new IO(TEST_FILE_PATH, "createEmptyTable.txt");
        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
        createTable.buildMySQLQuery();
    }

    @Test
    public void createTableWithUnknownArgumentTest(){

    }
}
