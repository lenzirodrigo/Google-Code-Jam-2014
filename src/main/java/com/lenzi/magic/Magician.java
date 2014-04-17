package main.java.com.lenzi.magic;

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
public class Magician {

    private List<MagicTrick> magicTricks;
    public Magician() {
        magicTricks = new ArrayList<MagicTrick>();
    }

    public void doTheMagic(String fileInput, String fileOutput) {
        readMagicTricks(fileInput);
        solveMagicTricks(fileOutput);
    }

    private void readMagicTricks(String fileInput) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileInput));
            int magicTrickCount = Integer.parseInt(br.readLine());
            for(int trick = 0; trick < magicTrickCount; trick++){
                readMagicTrick(br);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMagicTrick(BufferedReader br) throws IOException {
        MagicTrick magicTrick = new MagicTrick();
        magicTrick.setAnswerA(Integer.valueOf(br.readLine()));
        magicTrick.setArrangeA(readArrange(br));
        magicTrick.setAnswerB(Integer.valueOf(br.readLine()));
        magicTrick.setArrangeB(readArrange(br));
        magicTricks.add(magicTrick);
    }

    private CardArranging readArrange(BufferedReader br) throws IOException {
        CardArranging arrange = new CardArranging();
        for(int r = 0; r < 4; r++){
            String row = br.readLine();
            String[] cards = row.split("\\s+");
            arrange.addRow(r, cards);
        }
        return arrange;
    }

    private void solveMagicTricks(String fileOutput) {
        try {
            FileWriter fileWriter = new FileWriter(fileOutput);
            BufferedWriter br = new BufferedWriter(fileWriter);
            for (int caseNumber = 1; caseNumber <= magicTricks.size(); caseNumber++) {
                br.write("Case #" + caseNumber + ": " + magicTricks.get(caseNumber-1).solve() + "\n");
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
