import application.IO;
import org.junit.Test;
import query.QueryCreateTable;

import static org.junit.Assert.assertEquals;

public class QueryCreateTableTest {

    public static final String TEST_FILE_PATH = "src/test/resources";
    public static final String TEST_FILE_CREATE_CORRECT_TABLE = "";
    public static final String TEST_FILE_CREATE_EMPTY_TABLE = "";
    public static final String TEST_FILE_CREATE_TABLE_UNKNOWN_ARGUMENT = "";

    private IO io;

    @Test
    public void createCorrectTableTest(){
        io = new IO(TEST_FILE_PATH, "createCorrectTable.txt");
        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
        createTable.buildMySQLQuery();

        String expectedResult = "CREATE TABLE Students (\n" +
                "\tage int,\n" +
                "\tname varchar(255)\n" +
                ");";

        assertEquals(createTable.getMySQLQuery(), expectedResult);
    }

    @Test
    public void createEmptyTableTest(){
        io = new IO(TEST_FILE_PATH, "createEmptyTable.txt");
        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
        createTable.buildMySQLQuery();
        String expectedResult = "CREATE TABLE Students ();";
        assertEquals(createTable.getMySQLQuery(), expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTableWithUnknownArgumentTest(){
        io = new IO(TEST_FILE_PATH, "createTableUnknownArgument.txt");
        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
        createTable.buildMySQLQuery();
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTableWrongSyntaxTest(){
        io = new IO(TEST_FILE_PATH, "createTableWrongSyntax.txt");
        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
        createTable.buildMySQLQuery();
    }
}
