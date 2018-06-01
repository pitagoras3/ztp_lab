import application.IO;
import org.junit.Test;
import query.QueryAlterTable;

import static org.junit.Assert.assertEquals;

public class QueryAlterTableTest {

    public static final String TEST_FILE_PATH = "src/test/resources";

    private IO io;

    @Test
    public void alterTableCorrectlyTest(){
        io = new IO(TEST_FILE_PATH, "alterTableCorrectly.txt");
        QueryAlterTable alterT = new QueryAlterTable(io.getQueryFromFileAsStringList());
        alterT.buildMySQLQuery();

        String expectedResult = "ALTER TABLE Students\n" +
                "DROP COLUMN name;\n" +
                "\n" +
                "ALTER TABLE Students\n" +
                "ADD age int;\n" +
                "\n" +
                "ALTER TABLE Students\n" +
                "ADD surname varchar(255);";

        assertEquals(alterT.getMySQLQuery(), expectedResult);
    }

//    @Test
//    public void createEmptyTableTest(){
//        io = new IO(TEST_FILE_PATH, "createEmptyTable.txt");
//        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
//        createTable.buildMySQLQuery();
//        String expectedResult = "CREATE TABLE Students ();";
//        assertEquals(createTable.getMySQLQuery(), expectedResult);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void createTableWithUnknownArgumentTest(){
//        io = new IO(TEST_FILE_PATH, "createTableUnknownArgument.txt");
//        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
//        createTable.buildMySQLQuery();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void createTableWrongSyntaxTest(){
//        io = new IO(TEST_FILE_PATH, "createTableWrongSyntax.txt");
//        QueryCreateTable createTable = new QueryCreateTable(io.getQueryFromFileAsStringList());
//        createTable.buildMySQLQuery();
//    }
}
