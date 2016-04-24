
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Scanner sc = new Scanner(System.in);
//        FileReader fr = new FileReader("stegoCover/cerpen.txt");
//        BufferedReader br = new BufferedReader(fr);
//
//        PemotongKata pk = new PemotongKata();
//        TesaurusReader tr = new TesaurusReader();
//        String in = sc.nextLine();
//        ArrayList res = new ArrayList();
//        res = pk.generateLevel3(pk.generateLevel2(pk.generateLevel1(in)));
//        res = pk.generateLevel2(pk.generateLevel1(in));
//        res = pk.generateLevel1(in);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.print(res.get(i) + " ");
//        }
//        System.out.println(pk.getPattern(in));

//        System.out.println(pk.getJumlahSukuKata(in));
//        System.out.println(tr.findSynonym(in));
//         String line = br.readLine();
//         while(line != null){
//             String[] linearr = line.split(" ");
//             for (int i = 0; i < linearr.length; i++) {
//                 bw.write(pk.getJumlahSukuKata(linearr[i])+"");
//                 bw.write(" ");
//             }
//             line = br.readLine();
//             bw.newLine();
//         }
//         
//        String line = br.readLine();
//        int ctBiner = 0;
//
//        while (line != null) {
//            String[] temp = line.split(" ");
//            for (int i = 0; i < temp.length; i++) {
//                String kataTemp = new String();
//                String tempTandaBacaAkhir = new String();
//                char[] tempArr = temp[i].toCharArray();
//
//                for (int j = 0; j < tempArr.length; j++) {
//                    if (Character.isLetter(tempArr[j]) || tempArr[j] == '-') {
//                        kataTemp += tempArr[j];
//                    } else if ((!Character.isLetter(tempArr[j]) && kataTemp.isEmpty())) {
//                        bw.write(tempArr[j]);
//                    } else if (!kataTemp.isEmpty() && !Character.isLetter(tempArr[j])) {
//                        tempTandaBacaAkhir += tempArr[j];
//                    }
//                }
//                
//                bw.write(kataTemp);
//                bw.write(tempTandaBacaAkhir);
//                bw.write(" ");
//
//            }
//            bw.newLine();
//            line = br.readLine();
//        }
//
//         bw.close();
//         br.close();
//         fw.close();
//         fr.close();
        
//        Embedder emb = new Embedder(in);
//        emb.embedSecret();
//        
//        Extractor ext = new Extractor();
//        System.out.println(ext.extract());
        
//        System.out.println(Integer.toBinaryString((int) 'e'));
//        System.out.println(emb.toBinaryString('e'));
        
//        System.out.println(pk.generateLevel1("transmigrasi"));
//        System.out.println(pk.generateLevel2(pk.generateLevel1("transmigrasi")));
//        System.out.println(pk.generateLevel3(pk.generateLevel2(pk.generateLevel1("ahsjdg"))));
//        System.out.println(pk.getPattern("ng"));
//    }

}
