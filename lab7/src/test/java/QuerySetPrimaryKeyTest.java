import application.IO;
import org.junit.Test;
import query.MyQL;

import static org.junit.Assert.assertEquals;

public class QuerySetPrimaryKeyTest {

    public static final String TEST_FILE_PATH = "src/test/resources";
    private IO io;

    @Test
    public void setPrimaryKeyCorrectlyTest(){
        io = new IO(TEST_FILE_PATH, "setPrimaryKeyCorrectly.txt");
        String result = MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());

        String expectedResult = "ALTER TABLE Students\n" +
                "ADD PRIMARY KEY (age);";

        assertEquals(result, expectedResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPrimaryKeyWrongSyntaxTest(){
        io = new IO(TEST_FILE_PATH, "setPrimaryKeyWrongSyntax.txt");
        MyQL.castStringListToMyQL(io.getQueryFromFileAsStringList());
    }
}
