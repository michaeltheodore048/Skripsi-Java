
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

    public String extract(String stegoObject) {
        String secret = new String();
        String[] temp = stegoObject.split(" ");
        String code = new String();
        char nextChar;

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

            if (code.length() == 7) {
                nextChar = (char) Integer.parseInt("0" + code, 2);
                if ((int) nextChar > 31 && (int) nextChar < 127) {
                    secret += nextChar;
                    if (nextChar == '#') {
                        i = temp.length;
                    }
                }
                code = "";
            }
        }
        if (!secret.contains("#")) {
            secret = "Stego-object tidak mengandung pesan rahasia!";
        }
        return secret;
    }
}
