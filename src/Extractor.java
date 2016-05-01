
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael
 */
public class Extractor {

    private PemotongKata pk = new PemotongKata();
    private String asciiCode = new String();

    public void read(String stegoObject) {
        String[] temp = stegoObject.split(" ");
        String code = new String();
        int checker = 0;
        
        for (int i = 0; i < temp.length; i++) {
            char[] tempArr = temp[i].toCharArray();
            String tempKata = new String();
            for (int j = 0; j < tempArr.length; j++) {
                if (Character.isLetter(tempArr[j]) || tempArr[j] == '-') {
                    tempKata += tempArr[j];
                }
            }
            if (!tempKata.equalsIgnoreCase("")) {
                code += pk.getJumlahSukuKata(tempKata);
            }
        }

        for (int i = 0; i < code.length() - 7; i += 7) {
            this.asciiCode += "0" + code.substring(i, i + 7);
        }
    }

    public String extract(String stegoObject) {
        this.read(stegoObject);
        String res = new String();
        char nextChar;

        for (int i = 0; i < asciiCode.length() - 8; i += 8) {
            nextChar = (char) Integer.parseInt(asciiCode.substring(i, i + 8), 2);
            if ((int) nextChar > 31 && (int) nextChar < 127) {
                res += nextChar;
            }
        }
        return res;
    }

}
