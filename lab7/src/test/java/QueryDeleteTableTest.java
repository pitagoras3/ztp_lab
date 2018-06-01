import application.IO;
import org.junit.Test;
import query.MyQL;

import static org.junit.Assert.assertEquals;

public class QueryDeleteTableTest {

    public static final String TEST_FILE_PATH = "src/test/resources";

    private IO io;

    @Test
    public void deleteTableCorrectlyTest(){
        io = new IO(TEST_FILE_PATH, "deleteTableCorrectly.txt");
        String result = MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
        String expectedResult = "DROP TABLE Students;";
        assertEquals(result, expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteTableNoTableTest(){
        io = new IO(TEST_FILE_PATH, "deleteTableNoTable.txt");
        MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
    }
}
