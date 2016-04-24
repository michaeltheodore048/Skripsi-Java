
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael
 */
public class DatabaseReader {

    private FileReader fr;
    private PemotongKata pk = new PemotongKata();
    private BufferedReader br;

    public DatabaseReader() throws FileNotFoundException {
    }

    public String findSynonym(String input) throws IOException {
        this.fr = new FileReader("Tesaurus.txt");
        br = new BufferedReader(fr);
        String line = br.readLine();
        String[] lineArr;
        String synonyms = new String();
        String res = "";

        while (line != null) {
            lineArr = line.split(" ");
            if (lineArr[0].equalsIgnoreCase(input)) {
                synonyms += lineArr[1] + ",";
                line = br.readLine();
            } else {
                line = br.readLine();
            }
        }

        String[] arrOfSynonym = synonyms.split(",");
        ArrayList<String> tempForRandSynonym = new ArrayList();

        for (int i = 0; i < arrOfSynonym.length; i++) {
            if (pk.getJumlahSukuKata(arrOfSynonym[i]) != pk.getJumlahSukuKata(input)) {
                tempForRandSynonym.add(arrOfSynonym[i]);
            }
        }

        if (tempForRandSynonym.size() == 0) {
            res = "tidak ditemukan";
        } else {
            Random rg = new Random();
            res = tempForRandSynonym.get(rg.nextInt(tempForRandSynonym.size()));
        }

        br.close();
        return res;
    }

}
