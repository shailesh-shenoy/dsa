package me.shailesh.algorithms.basic;

import java.util.ArrayList;

public class EncodeDecode {
    public String encode(String[] strs) {
        var sb = new StringBuilder();
        for(var s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }
    public String[] decode(String s) {
        var strList = new ArrayList<String>();
        int i = 0;
        int j = 0;
        while(i < s.length()) {
            while(s.charAt(j) != '#') {
                j += 1;
            }
            int len = Integer.parseInt(s.substring(i, j));
            strList.add(s.substring(j + 1, j + len + 1));
            i = j + len + 1;
            j = j + len + 1;
        }
        return strList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        var ed = new EncodeDecode();
        var encoded = ed.encode(new String[]{"Hello", "#W0rld!", "?How", "are", "you?"});
        System.out.println(encoded);
        var decoded = ed.decode(encoded);
        for(var s : decoded) {
            System.out.println(s);
        }
    }
}
