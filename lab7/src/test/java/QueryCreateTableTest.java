import application.IO;
import org.junit.Test;
import query.MyQL;
import query.QueryCreateTable;

import static org.junit.Assert.assertEquals;

public class QueryCreateTableTest {

    public static final String TEST_FILE_PATH = "src/test/resources";

    private IO io;

    @Test
    public void createCorrectTableTest(){
        io = new IO(TEST_FILE_PATH, "createCorrectTable.txt");
        String result = MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
        String expectedResult = "CREATE TABLE Students (\n" +
                "\tage int,\n" +
                "\tname varchar(255)\n" +
                ");";

        assertEquals(result, expectedResult);
    }

    @Test
    public void createEmptyTableTest(){
        io = new IO(TEST_FILE_PATH, "createEmptyTable.txt");
        String result = MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
        String expectedResult = "CREATE TABLE Students ();";
        assertEquals(result, expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTableWithUnknownArgumentTest(){
        io = new IO(TEST_FILE_PATH, "createTableUnknownArgument.txt");
        MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
    }

    @Test(expected = ClassCastException.class)
    public void createTableWrongSyntaxTest(){
        io = new IO(TEST_FILE_PATH, "createTableWrongSyntax.txt");
        MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
    }
}
