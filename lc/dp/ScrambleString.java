package lc.dp;

import java.util.Arrays;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null || s1.length() == 0 && s2.length() == 0) return true;
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        if(!isSortedSame(s1, s2)) return false;
        
        for(int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            String s23 = s2.substring(0, s2.length()-i);
            String s24 = s2.substring(s2.length()-i);
            
            boolean b1= (isScramble(s11,s21) && isScramble(s12,s22));
            boolean b2 = (isScramble(s11,s24) && isScramble(s12,s23));
            if(b1 || b2) return true;
            
        }
        return false;
    }
    private boolean isSortedSame(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        return new String(c1).equals(new String(c2));
    }
}
