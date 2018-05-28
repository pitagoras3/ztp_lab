import application.IO;
import org.junit.BeforeClass;
import org.junit.Test;
import query.QueryCreateTable;

import java.util.List;

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

    @Test
    public void createEmptyTableTest(){
//        List<String> queryParts =
//        QueryCreateTable createTable = new QueryCreateTable();
    }
}
