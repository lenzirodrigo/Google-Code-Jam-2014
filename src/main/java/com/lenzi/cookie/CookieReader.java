package main.java.com.lenzi.cookie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rlenzi
 */
public class CookieReader {
    private List<Double> timesToGoals;

    public CookieReader() {
        timesToGoals = new ArrayList<Double>();
    }

    public void calculate(String fileInput, String fileOutput) {
        calculateTimes(fileInput);
        writeTimesToFile(fileOutput);
    }

    private void calculateTimes(String fileInput) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileInput));
            int cookieTests = Integer.parseInt(br.readLine());
            for(int test = 0; test < cookieTests; test++){
                clickForCookies(br);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clickForCookies(BufferedReader br) throws IOException {
        String testParams = br.readLine();
        String[] params = testParams.split("\\s+");

        float C = Float.parseFloat(params[0]);
        float F = Float.parseFloat(params[1]);
        float X = Float.parseFloat(params[2]);

        CookieFarm cookieFarm = new CookieFarm(C, F, X);
        timesToGoals.add(cookieFarm.calculate());
    }

    private void writeTimesToFile(String fileOutput) {
        try {
            FileWriter fileWriter = new FileWriter(fileOutput);
            BufferedWriter br = new BufferedWriter(fileWriter);
            for (int caseNumber = 1; caseNumber <= timesToGoals.size(); caseNumber++) {
                br.write("Case #" + caseNumber + ": " + timesToGoals.get(caseNumber - 1) + "\n");
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
