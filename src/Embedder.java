
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
public class Embedder {

    private DatabaseReader dr;
    private PemotongKata pk;
    private FileReader fr;
    private BufferedReader br;

    public Embedder(String stegoFileName) throws FileNotFoundException, IOException {
        this.dr = new DatabaseReader();
        this.pk = new PemotongKata();
        this.fr = new FileReader("stegoCover/" + stegoFileName);
        this.br = new BufferedReader(fr);
    }

    public Embedder() throws FileNotFoundException {
        this.dr = new DatabaseReader();
        this.pk = new PemotongKata();
    }

    public String stringToBinaryCode(String input) {
        char[] temp = input.toCharArray();
        String res = new String();

        for (int i = 0; i < temp.length; i++) {
            res += this.toBinaryString(temp[i]);
        }

        return res + "0100011";
    }

    public String toBinaryString(char in) {
        String res = new String();
        int dec = (int) in;

        for (int i = 6; i >= 0; i--) {
            if (dec >= Math.pow(2, i)) {
                dec -= Math.pow(2, i);
                res += "1";
            } else {
                res += "0";
            }
        }
        return res;
    }

    public String embed(String secret) throws IOException {
        String binerCode = this.stringToBinaryCode(secret);
        String errLog = new String();
        String stegoObject = new String();
        String line = br.readLine();
        char[] binerArray = binerCode.toCharArray();
        int ctBiner = 0;

        while (line != null) {
            if (line.length() > 0) {
                String[] temp = line.split(" ");

                for (int i = 0; i < temp.length; i++) {
                    String res = new String();
                    String kataTemp = "";
                    String tempTandaBacaAkhir = new String();
                    char[] tempArr = temp[i].toCharArray();

                    if (ctBiner < binerArray.length) {
                        for (int j = 0; j < tempArr.length; j++) {
                            if (Character.isLetter(tempArr[j]) || tempArr[j] == '-') {
                                kataTemp += tempArr[j];
                            } else if (!Character.isLetter(tempArr[j]) && kataTemp.isEmpty()) {
                                stegoObject += tempArr[j];
                            } else if (!kataTemp.isEmpty() && !Character.isLetter(tempArr[j])) {
                                tempTandaBacaAkhir += tempArr[j];
                            }
                        }

                        if (!kataTemp.isEmpty()) {
                            if (pk.getJumlahSukuKata(kataTemp) == Integer.parseInt(binerArray[ctBiner] + "")) {
                                res = kataTemp;
                            } else {
                                res = dr.findSynonym(kataTemp);
                            }

                            if (res.equalsIgnoreCase("") || res.equalsIgnoreCase("tidak ditemukan") || res.equalsIgnoreCase(" ")) {
                                errLog += kataTemp + " -> " + pk.generateLevel3(pk.generateLevel2(pk.generateLevel1(kataTemp))) + " | Synonym not found in database!\n";
                            } else if (Character.isUpperCase(kataTemp.charAt(0))) {
                                res = res.substring(0, 1).toUpperCase() + res.substring(1);
                            }

                            stegoObject += res;
                            stegoObject += tempTandaBacaAkhir;
                            ctBiner++;
                        }
                    } else {
                        stegoObject += temp[i];
                    }
                    stegoObject += " ";

                }
                stegoObject += "\n";
            }
            line = br.readLine();
        }
        br.close();
        fr.close();

        if (errLog.isEmpty()) {
            return stegoObject;
        } else {
            return errLog;
        }

    }

    public String checkAllSynonym(String stegoFileName) throws IOException {
        this.fr = new FileReader("stegoCover/" + stegoFileName);
        this.br = new BufferedReader(fr);

        String errLog = new String();
        String line = br.readLine();
        int ctBiner = 0;

        while (line != null) {
            if (line.length() > 0) {
                String[] temp = line.split(" ");

                for (int i = 0; i < temp.length; i++) {
                    String res = new String();
                    String kataTemp = "";
                    String tempTandaBacaAkhir = new String();
                    char[] tempArr = temp[i].toCharArray();

                    for (int j = 0; j < tempArr.length; j++) {
                        if (Character.isLetter(tempArr[j]) || tempArr[j] == '-') {
                            kataTemp += tempArr[j];
                        }
                    }

                    if (!kataTemp.isEmpty()) {
                        String tempSynonym = dr.findSynonym(kataTemp);
                        if (tempSynonym.equalsIgnoreCase("") || tempSynonym.equalsIgnoreCase("tidak ditemukan") || tempSynonym.equalsIgnoreCase(" ")) {
                            errLog += kataTemp + " -> " + pk.generateLevel3(pk.generateLevel2(pk.generateLevel1(kataTemp))) + " | Synonym not found in database!\n";
                        } else if (pk.getJumlahSukuKata(kataTemp) == pk.getJumlahSukuKata(tempSynonym)) {
                            errLog += kataTemp + " -> " + pk.generateLevel3(pk.generateLevel2(pk.generateLevel1(kataTemp))) + " | Synonym not found in database!\n";
                        }
                    }
                }
            }
            line = br.readLine();
        }
        br.close();
        fr.close();
        return errLog;
    }

}
