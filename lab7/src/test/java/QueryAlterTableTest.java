import application.IO;
import org.junit.Test;
import query.MyQL;
import query.QueryAlterTable;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class QueryAlterTableTest {

    public static final String TEST_FILE_PATH = "src/test/resources";

    private IO io;

    @Test
    public void alterTableCorrectlyTest(){
        io = new IO(TEST_FILE_PATH, "alterTableCorrectly.txt");
        String result = MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());


        String expectedResult = "ALTER TABLE Students\n" +
                "DROP COLUMN name;\n" +
                "\n" +
                "ALTER TABLE Students\n" +
                "ADD age int;\n" +
                "\n" +
                "ALTER TABLE Students\n" +
                "ADD surname varchar(255);";

        assertEquals(result, expectedResult);
    }

    @Test(expected = NoSuchElementException.class)
    public void alterTableEmptyBody(){
        io = new IO(TEST_FILE_PATH, "alterTableEmptyBody.txt");
        MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
    }

    @Test(expected = ClassCastException.class)
    public void alterTableWrongSyntax(){
        io = new IO(TEST_FILE_PATH, "alterTableWrongSyntax.txt");
        MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
    }
}
