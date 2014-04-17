package test.java.com.lenzi.cookie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import main.java.com.lenzi.cookie.CookieFarm;
import main.java.com.lenzi.cookie.CookieReader;
import main.java.com.lenzi.magic.Magician;

/**
 * @author rlenzi
 */
public class CookieTest {

    public static final String INPUT = "src/test/resources/cookie/submission/in/";
    public static final String OUTPUT = "src/test/resources/cookie/submission/out/";

    @Test
    public void testCookieEasy() {
        CookieFarm cookieFarm = new CookieFarm(50000.0, 2.0, 10.0);
        double calculate = cookieFarm.calculate();
        assertEquals(5.0, calculate, 0.0001);
    }

    @Test
    public void testCookieExample() {
        CookieFarm cookieFarm = new CookieFarm(500.0, 4.0, 2000.0);
        double calculate = cookieFarm.calculate();
        assertEquals(526.1904762, calculate, 0.0001);
    }

    @Test
    public void testCookie() throws IOException {
        CookieReader cookieReader = new CookieReader();

        cookieReader.calculate("src/test/resources/cookie/example.in", "src/test/resources/cookie/test.out");

//        File exampleFile = new File("src/test/resources/cookie/example.out");
//        File cookieFarmOutputFile = new File("src/test/resources/cookie/test.out");
//
//        assertTrue(FileUtils.contentEquals(exampleFile, cookieFarmOutputFile));
    }

    @Test
    public void generateOutput() throws IOException {


    }
}
