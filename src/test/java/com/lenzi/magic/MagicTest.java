package test.java.com.lenzi.magic;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import main.java.com.lenzi.magic.Magician;

/**
 * @author rlenzi
 */
public class MagicTest {

    public static final String INPUT = "src/test/resources/magic/submission/in/A-small-attempt0.in";
    public static final String OUTPUT = "src/test/resources/magic/submission/out/A-small-attempt0.out";

    @Test
    public void testMagic() throws IOException {
        Magician magician = new Magician();

        magician.doTheMagic("src/test/resources/magic/example.in","src/test/resources/magic/test.out");

        File exampleFile = new File("src/test/resources/magic/example.out");
        File magicianOutputFile = new File("src/test/resources/magic/test.out");

        assertTrue(FileUtils.contentEquals(exampleFile, magicianOutputFile));
    }

    @Test
    public void generateOutput() throws IOException {
        Magician magician = new Magician();

        magician.doTheMagic(INPUT, OUTPUT);

    }
}
