package lc.backtracking;

import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
        List<String> rs = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12) return rs;
        List<String> ls = new ArrayList<>();
        restore(rs, ls, s, 0);
        return rs;
    }
    
    private void restore(List<String> rs, List<String> ls, String s, int start) {
        if(ls.size() == 4) {
            if(start != s.length()) return;
            
            StringBuilder sb = new StringBuilder();
            for(String str : ls) {
                
                sb.append(str + ".");
            }
            sb.deleteCharAt(sb.length()-1);
            rs.add(sb.toString());
        }
        
        for(int i = start; i < s.length() && i < start+3; i++) {
            String sub = s.substring(start, i+1);
            if(isValid(sub)) {
                ls.add(sub);
                restore(rs, ls, s, i+1);
                ls.remove(ls.size()-1);
            }
        }
    }
    
    private boolean isValid(String s) {
        if(s.charAt(0) == '0') {
            return s.equals("0");
        }
        
        int digit = Integer.parseInt(s);
        return digit >= 0 && digit <= 255;
    }
}
