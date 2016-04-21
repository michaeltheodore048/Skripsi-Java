
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Michael
 */
public class PemotongKata {

    public String getPattern(String input) {
        char[] temp = input.toLowerCase().toCharArray();
        String res = "";
        for (int i = 0; i < temp.length; i++) {
            if (temp.length == 2 && ((temp[0] == 'n' && temp[1] == 'g') || (temp[0] == 'n' && temp[1] == 'y'))) {
                res = "kk";
                i = temp.length;
            } else {
                if (temp[i] == 'a' || temp[i] == 'i' || temp[i] == 'u' || temp[i] == 'e' || temp[i] == 'o') {
                    res += "v";
                } else if (temp[i] == 'b' || temp[i] == 'c' || temp[i] == 'd' || temp[i] == 'f' || temp[i] == 'g' || temp[i] == 'h'
                        || temp[i] == 'j' || temp[i] == 'k' || temp[i] == 'l' || temp[i] == 'm' || temp[i] == 'n' || temp[i] == 'p'
                        || temp[i] == 'q' || temp[i] == 'r' || temp[i] == 's' || temp[i] == 't' || temp[i] == 'v' || temp[i] == 'w'
                        || temp[i] == 'x' || temp[i] == 'y' || temp[i] == 'z') {
                    res += "k";
                } else {
                    res += ".";
                }
            }
        }
        return res;
    }
    
//    public String getPattern(String input) {
//        char[] temp = input.toLowerCase().toCharArray();
//        String res = "";
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i] == 'a' || temp[i] == 'i' || temp[i] == 'u' || temp[i] == 'e' || temp[i] == 'o') {
//                res += "v";
//            } else if (temp[i] == 'b' || temp[i] == 'c' || temp[i] == 'd' || temp[i] == 'f' || temp[i] == 'g' || temp[i] == 'h'
//                    || temp[i] == 'j' || temp[i] == 'k' || temp[i] == 'l' || temp[i] == 'm' || temp[i] == 'n' || temp[i] == 'p'
//                    || temp[i] == 'q' || temp[i] == 'r' || temp[i] == 's' || temp[i] == 't' || temp[i] == 'v' || temp[i] == 'w'
//                    || temp[i] == 'x' || temp[i] == 'y' || temp[i] == 'z') {
//                res += "k";
//            } else {
//                res += ".";
//            }
//        }
//        return res;
//    }

    public ArrayList generateLevel1(String text) {
        ArrayList res = new ArrayList();
        String before = "";
        String now = "";
        int state = 0;

        for (int i = 0; i < text.length(); i++) {
            now = text.charAt(i) + "";
            if (state == 0) {
                if (this.getPattern(now).equals("v")) {
                    res.add(now);
                } else if (now.equalsIgnoreCase("N")) {
                    state = 3;
                    before = before.concat(now);
                } else if (now.equalsIgnoreCase("K")) {
                    state = 4;
                    before = before.concat(now);
                } else if (now.equalsIgnoreCase("S")) {
                    state = 5;
                    before = before.concat(now);
                } else if (this.getPattern(now).equalsIgnoreCase("k")) {
                    state = 7;
                    before = before.concat(now);
                } else {
                    res.add(now);
                }
            } else if (state == 3) {
                if (now.equalsIgnoreCase("G") || now.equalsIgnoreCase("Y")) {
                    state = 0;
                    before = before.concat(now);
                    res.add(before);
                    before = "";
                } else if (this.getPattern(now).equals("v")) {
                    state = 0;
                    res.add(before.concat(now));
                    before = "";
                } else {
                    state = 0;
                    res.add(before);
                    before = "";
                    i--;
                }
            } else if (state == 4) {
                if (now.equalsIgnoreCase("H")) {
                    state = 6;
                    before += now;
                } else if (this.getPattern(now).equals("v")) {
                    state = 0;
                    res.add(before.concat(now));
                    before = "";
                } else {
                    state = 0;
                    res.add(before);
                    before = "";
                    i--;
                }
            } else if (state == 5) {
                if (now.equalsIgnoreCase("Y")) {
                    state = 6;
                    before += now;
                } else if (this.getPattern(now).equals("v")) {
                    state = 0;
                    res.add(before.concat(now));
                    before = "";
                } else {
                    state = 0;
                    res.add(before);
                    before = "";
                    i--;
                }
            } else if (state == 6 || state == 7) {
                if (this.getPattern(now).equals("v")) {
                    state = 0;
                    res.add(before.concat(now));
                    before = "";
                } else {
                    state = 0;
                    res.add(before);
                    before = "";
                    i--;
                }
            }
        }
        if (!before.equals("")) {
            res.add(before);
        }
        return res;
    }

    public ArrayList generateLevel2(ArrayList lv1) {
        ArrayList res = new ArrayList();
        String before = "";
        String now = "";
        int state = 0;

        for (int i = 0; i < lv1.size(); i++) {
            now = lv1.get(i) + "";
            if (state == 0) {
                if (this.getPattern(now).equals("v")) {
                    state = 1;
                    before = now;
                } else if (this.getPattern(now).equals("k")) {
                    state = 3;
                    before = now;
                } else if (this.getPattern(now).equals("kv")) {
                    state = 6;
                    before = now;
                } else if (this.getPattern(now).equals("kk")) {
                    state = 7;
                    before = now;
                }else{
                    res.add(now);
                }
            } else if (state == 1) {
                if (this.getPattern(now).equals("k")) {
                    state = 0;
                    res.add(before.concat(now));
                    before = "";
                } else {
                    state = 0;
                    i--;
                    res.add(before);
                    before = "";
                }
            } else if (state == 3) {
                if (this.getPattern(now).equals("k")) {
                    state = 5;
                    before = before.concat(now);
                } else if (this.getPattern(now).equals("kv")) {
                    state = 4;
                    before = before.concat(now);
                } else {
                    state = 0;
                    i--;
                    res.add(before); //res.add(before.concat(now));
                    before = "";
                }
            } else if (state == 4) {
                if (this.getPattern(now).equals("k")) {
                    state = 0;
                    res.add(before.concat(now));
                    before = "";
                } else {
                    state = 0;
                    i--;
                    res.add(before);
                    before = "";
                }
            } else if (state == 5) {
                if (this.getPattern(now).equals("kv")) {
                    state = 4;
                    before = before.concat(now);
                }
            } else if (state == 6) {
                if (this.getPattern(now).equals("k")) {
                    state = 0;
                    res.add(before.concat(now));
                    before = "";
                } else {
                    state = 0;
                    i--;
                    res.add(before);
                    before = "";
                }
            } else if (state == 7) {
                if (this.getPattern(now).equals("v")) {
                    state = 6;
                    before = before.concat(now);
                }else if (this.getPattern(now).equals("k")) {
                    before = before.concat(now);
                }else{
                    state = 0;
                    i--;
                    res.add(before);
                    before = "";
                }
            }
        }

        if (!before.isEmpty()) {
            res.add(before);
        }

        return res;
    }

    public ArrayList generateLevel3(ArrayList lv2) {
        ArrayList res = new ArrayList();
        String now = "";
        String before = "";
        int state = 0;

        for (int i = 0; i < lv2.size(); i++) {
            now = lv2.get(i) + "";

            if (state == 0) {
                if (this.getPattern(now).equals(".")) {
                    res.add(now);
                } else if (this.getPattern(now).equals("v") || this.getPattern(now).equals("kkkvk")) {
                    res.add(now);
                } else if (this.getPattern(now).equals("vk") || this.getPattern(now).equals("kvk") || this.getPattern(now).equals("kkvk")) {
                    state = 3;
                    before = now;
                } else if (this.getPattern(now).equals("kv") || this.getPattern(now).equals("kkv") || this.getPattern(now).equals("kkkv")) {
                    state = 5;
                    before = now;
                }else{
                    res.add(now);
                }
            } else if (state == 3) {
                if (this.getPattern(now).equals("k")) {
                    res.add(before.concat(now));
                    before = "";
                    state = 0;
                } else {
                    res.add(before);
                    before = "";
                    i--;
                    state = 0;
                }
            } else if (state == 5) {
                if (this.getPattern(now).equalsIgnoreCase("v")) {
                    if (before.charAt(before.length() - 1) == 'a') {
                        if (now.equalsIgnoreCase("i") || now.equalsIgnoreCase("u")) {
                            res.add(before.concat(now));
                            before = "";
                            state = 0;
                        } else {
                            res.add(before);
                            before = "";
                            i--;
                            state = 0;
                        }
                    } else if (before.charAt(before.length() - 1) == 'o') {
                        if (now.equals("i")) {
                            res.add(before.concat(now));
                            before = "";
                            state = 0;
                        } else {
                            res.add(before);
                            before = "";
                            i--;
                            state = 0;
                        }
                    } else {
                        res.add(before);
                        before = "";
                        i--;
                        state = 0;
                    }
//                } else if (this.getPattern(now).equals("kk")) {
//                    res.add(before.concat(now));
//                    before = "";
//                    state = 0;
                } else {
                    res.add(before);
                    before = "";
                    i--;
                    state = 0;
                }
            }
        }
        if (before != "") {
            res.add(before);
        }

        return res;
    }
    
    public int getJumlahSukuKata(String in){
        ArrayList input = new ArrayList();
        input = this.generateLevel3(this.generateLevel2(this.generateLevel1(in)));
        int ct = 0;
        for (int i = 0; i < input.size(); i++) {
            if (!(input.get(i).equals(""))) {
                ct++;
            }
        }
        return ct%2;
    }

}
